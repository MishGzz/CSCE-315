package Engine;

import IO.RelationReader;
import IO.RelationWriter;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;

public class Database {

    public Map<String, Relation> mapOfRelations;
    private ArrayList<String> relations;

    public Database () {
        mapOfRelations = new HashMap<>();
        relations = new ArrayList<>();
    }

    /******************************************************************/
    //                      DATABASE FUNCTIONS
    /******************************************************************/

    public void open(String fileName) throws Exception {
        //open_cmd
        //: 'OPEN' relation_name;

        RelationReader relationReader = new RelationReader(fileName);
        Relation relation = relationReader.get();
        mapOfRelations.put(relation.getTableName(), relation);
    }

    public void close(String relation) {
        //close_cmd
        //: 'CLOSE' relation_name;

        mapOfRelations.remove(relation);
    }

    public void write(String passedRelation) throws Exception {
        //write_cmd
        //: 'WRITE' relation_name;

        RelationWriter relationWriter = new RelationWriter(mapOfRelations.get(passedRelation));
    }

    public void exit() throws Exception {
        //exit_cmd
        //: 'EXIT';

        for (String relation : mapOfRelations.keySet())
            write(relation);
        relations.clear();
    }

    public void show(Relation relation) {
        //show_cmd
        //: 'SHOW' atomic_expr;


        System.out.printf("%-20.20s", relation.getTableName());
        System.out.print("\n");
        for (int i = 0; i <relation.getDomains().size(); i++)
            System.out.printf("%-20.20s", "--------------------");
        System.out.print("\n");
        for (String attributes : relation.getDomains().keySet()) {
            System.out.printf("%-20.20s", attributes);
        }
        System.out.print("\n");
        for (int i = 0; i <relation.getDomains().size(); i++)
            System.out.printf("%-20.20s", "--------------------");
        System.out.print("\n");
        for (Map.Entry<Attribute, Tuple> col : relation.getTuplesInRelation().entrySet()) {
            for (Map.Entry<String, Attribute> row : col.getValue().getTupleAttributes().entrySet()) {
                System.out.printf("%-20.20s", row.getValue().getValue());
            }
            System.out.print("\n");
        }
    }

    //create (String relationName, ArrayList<Domain<?>> typedAttrList, String key)
    public void create(String relationName, ArrayList<Domain<?>> headers, String key) throws Exception {
        //create_cmd
        //: 'CREATE TABLE' relation_name '(' typed_attribute_list ')' 'PRIMARY KEY' '(' attribute_list')';

        Domain<?> relationKey = null;
        if (mapOfRelations.containsKey(relationName))
            throw new Exception("Error: Table already exists");
        for (Domain domain : headers) {
            if (domain.getName().equals(key))
                relationKey = domain;
        }

        Relation newRelation = new Relation(relationName, relationKey, headers.toArray(new Domain<?>[headers.size()]));

        this.mapOfRelations.put(relationName, newRelation);

    }

    public void update (String relationName, ArrayList<String> attributeNames, ArrayList<String> newValues, ArrayList<String> condition) throws Exception {
        //update_cmd
        //: 'UPDATE' relation_name 'SET' attribute_name '=' Literal '(' ',' attribute_name')'* 'WHERE' condition;

        Relation relation = this.mapOfRelations.get(relationName);
        if (relation == null) {
            throw new Exception("Error: Null relation");
        } else {
            boolean exists = false;
            for (Map.Entry<Attribute, Tuple> tuple : relation.getTuplesInRelation().entrySet()) {
                for (Map.Entry<String, Attribute> attribute : tuple.getValue().getTupleAttributes().entrySet()) {
                    for (int i = 0; i < attributeNames.size(); i++) {
                        if (attributeNames.get(i) == attribute.getKey() && comparison(attribute.getValue(), condition)) {
                            tuple.getValue().change(attributeNames, newValues);
                        }
                    }
                }
                if (!exists) {
                    System.out.println("Error: Attribute does not exist in the relation");
                }
            }
            this.mapOfRelations.put(relation.getTableName(), relation);
        }
    }

    public void insert (String relation, ArrayList<String> attributeNames) throws Exception {
        //insert_cmd
        //: 'INSERT INTO' relation_name 'VALUES FROM' '('Literal ( ',' Literal)* ')'

        Relation insertRelation = null;
        ArrayList<Attribute> newTuple = new ArrayList<>();
        if (mapOfRelations.get(relation) != null)
            insertRelation = mapOfRelations.get(relation);
        int iterator = 0;
        for (Map.Entry<String, Domain> header : insertRelation.getDomains().entrySet()) {
            Attribute attribute = null;
            if (header.getValue().getType() == Integer.class) {
                try {
                    Integer integer = Integer.parseInt(attributeNames.get(iterator));
                    attribute = new Attribute(header.getValue(), integer);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Attributes do not match the domain type");
                }
            } else if (header.getValue().getType() == String.class) {
                try {
                    attribute = new Attribute(header.getValue(), attributeNames.get(iterator));
                } catch (NumberFormatException e) {
                    System.out.println("Error: Attributes do not match the domain type");
                }
            } else {
                throw new Exception("Error: Invalid syntax");
            }
            newTuple.add(attribute);
            iterator++;
        }
        Tuple tuple = new Tuple(newTuple.toArray(new Attribute[newTuple.size()]));
        insertRelation.tuplesInRelation.put(tuple.makeKey(), tuple);
        mapOfRelations.put(relation, insertRelation);
    }

    public void insert (String relationName, Relation relationMemory) {
        // | 'INSERT INTO' relation_name 'VALUES FROM RELATION' expr;

        Relation relation = null;
        ArrayList<Tuple> tuples = new ArrayList<>();

        if (mapOfRelations.get(relationName) != null)
            relation = mapOfRelations.get(relationName);
        for (Map.Entry<String, Domain> domain : relation.getDomains().entrySet()) {
            if (relationMemory.getDomain(domain.getKey()) == null) {
                System.out.println("Error: Detected incompatible domains");
                return;
            }
        }
        for (Map.Entry<Attribute, Tuple> tuple : relationMemory.tuplesInRelation.entrySet())
            tuples.add(tuple.getValue());
        for (int i = 0; i < tuples.size(); i++)
            relation.tuplesInRelation.put(tuples.get(i).makeKey(), tuples.get(i));
        mapOfRelations.put(relationName, relation);

    }

    public void delete(String relationName, ArrayList<String> condition) throws Exception {
        //  delete_cmd
        //  : 'DELETE FROM' relation_name 'WHERE' condition;

        String tuplesToDelete = new String(condition.get(0));
        Relation relation = this.mapOfRelations.get(relationName);
        if (relation == null) {
            throw new Exception("Error: Null relation");
        } else {
            for (Map.Entry<Attribute, Tuple> tuple : relation.tuplesInRelation.entrySet()) {
                if (comparison(tuple.getValue().getTupleAttributes().get(tuplesToDelete), condition)) {
                    relation.delete(tuple.getKey());
                }
            }
            this.mapOfRelations.put(relationName, relation);
        }
    }


    /******************************************************************/
    //                      RELATIONAL ALGEBRA
    /******************************************************************/

    public Relation selection (ArrayList<String> condition, Relation relation) {
    // selection
    // : 'select' '('condition')' atomic_expr;

        Relation newRelation = relation;
        String attributeToTest = new String(condition.get(0));
        //base case: the attribute doesn't exist
        boolean exists = false;
        for (Map.Entry<String, Domain> domain : newRelation.getDomains().entrySet()) {
            if (domain.getValue().getName().equals(attributeToTest))
                exists = true;
        }
        if (!exists)
            return null;

        //only getting the tuples that pass the condition test
        ArrayList<Attribute> tuplesEliminated = new ArrayList<>();
        //check all the tuples in the relation
        for (Map.Entry<Attribute, Tuple> tupleEntry : newRelation.getTuplesInRelation().entrySet()) {
            //get the associated attribute in the tuple and test it
            //if it passes, add it to the list.
            if (!comparison(tupleEntry.getValue().getTupleAttributes().get(attributeToTest), condition))
                tuplesEliminated.add(tupleEntry.getKey());
        }

        newRelation.tuplesInRelation.keySet().removeAll(Collections.synchronizedList(tuplesEliminated));

        return newRelation;
    }

    //change to projection (Relation relation, ArrayList<String>)
    public Relation projection (Relation relation, String ... names) throws Exception {
        // projection
        // : 'project' '('attribute_list')' atomic_expr;

        Domain<?>[] domains = new Domain<?>[names.length];
        //base case: ensure at least one tuple exists in the relation
        if (relation.tuplesInRelation == null)
            throw new Exception("Error: Empty relation, cannot project");
        //base case: ensure the names passed exist, if they do, create a new relation
        for (int i = 0; i < names.length; i++) {
            if (relation.getDomains().containsKey(names[i]))
                domains[i] = relation.getDomain(names[i]);
            else
                throw new Exception("Error: One or more attributes does not exist in the selected relation");
        }

        Relation newRelation = new Relation(new String("PROJECT " + relation.getTableName()),
                domains[0], domains);

        //check through all tuple in the relation
        for (Map.Entry<Attribute, Tuple> tuple : relation.tuplesInRelation.entrySet()) {
            ArrayList<Attribute> attributeCollection = new ArrayList<>();
            //check each attribute in the tuple for a match, if matched, add to collection
            for (String name : names) {
                Attribute attribute = tuple.getValue().getTupleAttributes().get(name);
                attributeCollection.add(attribute);
            }
            newRelation.set(attributeCollection.get(0), //key
                    attributeCollection.toArray(new Attribute[attributeCollection.size()])); //attributes in tuple
        }
        return newRelation;
    }

    //change to renaming (Relation relation, String originalName, String newName)
    public Relation renaming (Relation relation, String domainName, String newDomainName) throws Exception {
        //renaming
        //: 'rename' '('attribute_list')' atomic_expr;

        Relation newRelation = relation;

        //base case: if domain exists, change it. If not, throw error
        if (newRelation.getDomain(domainName) != null) {
            newRelation.reset(domainName, newDomainName);
        } else {
            throw new Exception("Error: Domain doesn't exist");
        }
        //replace attributes in tuple with new name and the new domain
        //search through all of the tuples in the relation
        for (Map.Entry<Attribute, Tuple> tuple : newRelation.tuplesInRelation.entrySet()) {
            //search each tuple for the old value
            tuple.getValue().resetName(domainName, newDomainName);
        }
        newRelation.resetName(new String(relation.getTableName()));
        return newRelation;
    }

    //should be done, check logic
    public Relation unions (Relation relation1, Relation relation2) throws Exception {
        // unions
        // : atomic_expr '+' atomic_expr;

        Relation relationBase = relation1;
        Relation relationOp = relation2;
        //base case: make sure both relations are union compatible
        for (Map.Entry<String, Domain> domain : relationBase.getDomains().entrySet()) {
            if (relationOp.getDomains().get(domain.getKey()) == null) {
                System.out.println("Error: Relations not union compatible");
                return null;
            }
        }
        //base case passed, now preform union
        //parse through the relations to ensure no duplicate tuples are added
        boolean found = false;
        for (Map.Entry<Attribute, Tuple> tuple2 : relationOp.tuplesInRelation.entrySet()) {
            found = false;
            for (Map.Entry<Attribute, Tuple> tuple1 : relationBase.tuplesInRelation.entrySet()) {
        //if a tuple in relation2 does not match anything in relation1, add the tuple to relation1
                if (tuple2.getValue().matching(tuple1.getValue()))
                    found = true;
            }
            if (!found)
                relationBase.tuplesInRelation.put(tuple2.getKey(), tuple2.getValue());
        }
        relationBase.resetName(new String(relation1.getTableName() + "+" + relation2.getTableName()));
        return relation1;
    }

    //should be done
    public Relation difference (Relation relation1, Relation relation2) throws Exception {
        // difference
        // : atomic_expr '-' atomic_expr;

        Relation relationBase = relation1;
        Relation relationOp = relation2;

        //base case: make sure both relations are union compatible
        for (Map.Entry<String, Domain> domain : relationBase.getDomains().entrySet()) {
            if (relationOp.getDomains().get(domain.getKey()) == null) {
                System.out.println("Error: Relations not union compatible");
                return null;
            }
        }
        //base case passed, now preform difference
        boolean found = false;
        //check through all tuples in relation1
        for (Map.Entry<Attribute, Tuple> tuple1 : relationBase.tuplesInRelation.entrySet()) {
            found = false;
        //check through all tuples in relation2
            for (Map.Entry<Attribute, Tuple> tuple2 : relationOp.tuplesInRelation.entrySet()) {
        //if a match is found...
                if (tuple1.getValue().matching(tuple2.getValue()))
                    found = true;
            }
        //...remove it from the set of tuples
            if (found)
                relationBase.tuplesInRelation.remove(tuple1.getKey());
        }
        relationBase.resetName(new String(relation1.getTableName() + "-" + relation2.getTableName()));
        return relationBase;
    }

    public Relation naturalJoin (Relation relation1, Relation relation2) throws Exception {
        // natural_join
        // : atomic_expr '&' atomic_expr;

        ArrayList<Domain<?>> commonDomains = new ArrayList<>();

        //base case
        if (relation1.tuplesInRelation.isEmpty() || relation2.tuplesInRelation.isEmpty())
            return null;
        //if a domain in domain1 exists in domain2, keep it, otherwise discard
        for (Map.Entry<String, Domain> domains1 : relation1.getDomains().entrySet()) {
            for (Map.Entry<String, Domain> domains2 : relation2.getDomains().entrySet()) {
                if (domains1.getKey() == domains2.getKey())
                    commonDomains.add(domains1.getValue());
            }
        }

        //In order to eliminate the unwanted Attributes,
        //this algorithm will have to do a lot of checking.
        ArrayList<Tuple> newTuples = new ArrayList<>();
        //check the available tuples in relation1
        for (Map.Entry<Attribute, Tuple> tupleEntry : relation1.getTuplesInRelation().entrySet()) {
            ArrayList<Attribute> tupleBuilder = new ArrayList<>();
            //checks for available domains
            for (Domain domain : commonDomains) {
                for (Map.Entry<String, Attribute> attributeEntry : tupleEntry.getValue().getTupleAttributes().entrySet()) {
                    //parse through all tuples in relation1, do not add if it is not an available domain
                    if (attributeEntry.getKey() == domain.getName())
                        //adds if it is an available domain
                        tupleBuilder.add(attributeEntry.getValue());
                }
            }
            //all domains checked, time to create new tuple with only the attributes parsed
            Tuple newTuple = new Tuple(tupleBuilder.toArray(new Attribute[tupleBuilder.size()]));
            //for all tuples in the relation
            newTuples.add(newTuple);
        }
        //same for relation2
        for (Map.Entry<Attribute, Tuple> tupleEntry : relation2.getTuplesInRelation().entrySet()) {
            ArrayList<Attribute> tupleBuilder = new ArrayList<>();
            //checks for available domains
            for (Domain domain : commonDomains) {
                for (Map.Entry<String, Attribute> attributeEntry : tupleEntry.getValue().getTupleAttributes().entrySet()) {
                    //parse through all tuples in relation1, do not add if it is not an available domain
                    if (attributeEntry.getKey() == domain.getName())
                        //adds if it is an available domain
                        tupleBuilder.add(attributeEntry.getValue());
                }
            }
            //all domains checked, time to create new tuple with only the attributes parsed
            Tuple newTuple = new Tuple(tupleBuilder.toArray(new Attribute[tupleBuilder.size()]));
            //for all tuples in the relation
            newTuples.add(newTuple);
        }
        ArrayList<Attribute> newAttributes = new ArrayList<Attribute>(newTuples.get(0).getTupleAttributes().values());
        Relation newRelation = new Relation(new String(commonDomains.get(0).getName()),
                commonDomains.get(0),
                commonDomains.toArray(new Domain<?>[commonDomains.size()]));
        newRelation.set(newAttributes.get(0), newAttributes.toArray(new Attribute[newAttributes.size()]));
        //add the tuples extracted earlier to the new relation tuple map
        for (int i = 0; i < newTuples.size(); i++) {
            //makeKey is in class Tuple. It sends a legitimate key back, which is the first found
            //Attribute in the attributes in tuple map
            newRelation.tuplesInRelation.put(newTuples.get(i).makeKey(), newTuples.get(i));
        }

        return newRelation;
    }

    //should be done
    public Relation product (Relation relation1, Relation relation2) throws Exception {
        // product
        // : atomic_expr '*' atomic_expr;

        //the combined tuples for the new relation
        ArrayList<Tuple> newTuples = new ArrayList<>();
        //logic starts here
        //for all tuples in relation1, multiply them by the tuples in relation2
        for(Map.Entry<Attribute, Tuple> tupleEntry1 : relation1.tuplesInRelation.entrySet()){
            for (Map.Entry<Attribute, Tuple> tupleEntry2 : relation2.tuplesInRelation.entrySet()){
                //a tuple is a list of attributes, this list will combine the tuples
                ArrayList<Attribute> attr = new ArrayList<Attribute>();
                attr.addAll(tupleEntry1.getValue().getTupleAttributes().values());
                attr.addAll(tupleEntry2.getValue().getTupleAttributes().values());
                //create new tuple from the combined attribute list
                newTuples.add(new Tuple(attr.toArray(new Attribute[attr.size()])));
            }
        }
        //in order to create a new relation from just tuple, we need the domains for the attribute headers
        ArrayList<Domain<?>> newDomains = new ArrayList<>();
        //extract the domains from the newly created tuple list
        for (Map.Entry<String, Attribute> domain : newTuples.get(0).getTupleAttributes().entrySet()) {
            newDomains.add(domain.getValue().getDomain());
        }
        //first domain in the list is our key
        Domain<?> key = newDomains.get(0);
        Domain<?>[] arrayedNewDomains = newDomains.toArray(new Domain<?>[newDomains.size()]);
        Relation newRelation = new Relation(new String(relation1.getTableName() + " product " + relation2.getTableName()),
                key, arrayedNewDomains);
        //last but not least, add the tuples themselves to the relation
        Map<Attribute, Tuple> newAttrTupleMap = new HashMap<>();
        for (Tuple tuple : newTuples) {
            newAttrTupleMap.put(tuple.makeKey(), tuple);
        }
        newRelation.tuplesInRelation = new HashMap<>(newAttrTupleMap);

        return newRelation;
    }

    /******************************************************************/
    //                      HELPER FUNCTIONS
    /******************************************************************/

    private boolean comparison (Attribute attribute, ArrayList<String> operands) {
        //The comparison works left to right, so that left operators will always have precedence
        boolean comparison = false;
        for (int i = 0; i < operands.size(); i+=3) {
            if (operands.get(i).equals("&&") && comparison == true && i >= 3) {
                i -= 2;
            } else if (operands.get(i).equals("||") && i >= 3) {
                i -= 2;
            } else if (attribute.getValue() instanceof Integer) {
                Integer integer = new Integer( (Integer) attribute.getValue());
                switch (operands.get(i + 1)) {
                    case "==": if (integer == Integer.parseInt(operands.get(i + 2))) comparison = true; break;
                    case "!=": if (integer != Integer.parseInt(operands.get(i + 2))) comparison = true; break;
                    case ">": if (integer > Integer.parseInt(operands.get(i + 2))) comparison = true; break;
                    case ">=": if (integer >= Integer.parseInt(operands.get(i + 2))) comparison = true; break;
                    case "<": if (integer < Integer.parseInt(operands.get(i + 2))) comparison = true; break;
                    case "<=": if (integer <= Integer.parseInt(operands.get(i + 2))) comparison = true; break;
                    default: {
                        System.out.println("Error: Syntax error");
                        return false;
                    }
                }
            } else if (attribute.getValue() instanceof String) {
                String string = new String( (String) attribute.getValue());
                String op = operands.get(i + 1);
                switch (op) {
                    case "==": { if (string.equals(operands.get(i + 2)))
                        comparison = true;
                        break;
                    }
                    case "!=": if (string != operands.get(i + 2)) comparison = true; break;
                    default: {
                        System.out.println("Error: Syntax error");
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return comparison;
    }

}

