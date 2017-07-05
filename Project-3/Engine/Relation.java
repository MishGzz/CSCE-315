package Engine;

import java.util.ArrayList;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by jaredwheeler on 6/28/17.
 */
public class Relation {

    private String tableName;
    private Domain<?> relationKey;
    private Map<String, Domain> relationDomainMap = new LinkedHashMap<>();
    HashMap<Attribute, Tuple> tuplesInRelation;
    private int tupleCount;

    public Relation (String name, Domain<?> key, Domain<?> ... domains) {
        tableName = name;
        relationKey = key;
        for (Domain<?> domain : domains)
            this.relationDomainMap.put(domain.getName(), domain);
        tuplesInRelation = new HashMap<>();
    }

    public Relation (String name, Domain<?> key, Map<Attribute, Tuple> map) {
        tableName = name;
        relationKey = key;
        for (Map.Entry<Attribute, Tuple> tuple : map.entrySet()) {
            tuplesInRelation.put(tuple.getKey(), tuple.getValue());
        }
    }

    public void set (Attribute relationKey, Attribute ... listOfAttributes) {
        if (tuplesInRelation.containsKey(relationKey))
            System.out.println("Error: Key already taken");
        else {
            tuplesInRelation.put(relationKey, new Tuple(listOfAttributes));
            tupleCount++;
        }
    }

    public void reset (String oldName, String newName) {
        LinkedHashMap<String, Domain> newDomainNames = new LinkedHashMap<>();
        for (Map.Entry<String, Domain> domain : relationDomainMap.entrySet()) {
            if (domain.getKey() != oldName) {
                newDomainNames.put(domain.getKey(), domain.getValue());
            } else {
                relationDomainMap.get(oldName).resetName(newName);
                newDomainNames.put(newName, relationDomainMap.get(oldName));
            }
        }
        relationDomainMap = newDomainNames;
    }

    public void delete (Attribute attribute) {
        tuplesInRelation.remove(attribute);
        tupleCount--;
    }

    public ArrayList<Tuple> selectAll (Predicate<Attribute> tuplePredicate) {

        ArrayList<Tuple> tuples = new ArrayList<>();

        for (Map.Entry<Attribute, Tuple> tuple : tuplesInRelation.entrySet()) {
            for (Map.Entry<String, Attribute> attribute : tuple.getValue().getTupleAttributes().entrySet()) {
                if (tuplePredicate.test(attribute.getValue()))
                    tuples.add(tuple.getValue());
            }
        }
        return tuples;
    }

    public void resetName (String newTableName) { tableName = newTableName; }
    public String getTableName() {
        return tableName;
    }
    public Domain<?> getRelationKey() {
        return relationKey;
    }
    public Domain<?> getDomain (String domain) {
        return relationDomainMap.get(domain);
    }
    public int getNumberOfTuples() {
        return tupleCount;
    }
    public Map<String, Domain> getDomains () {
        return relationDomainMap;
    }
    public HashMap<Attribute, Tuple> getTuplesInRelation () {
        return tuplesInRelation;
    }
}
