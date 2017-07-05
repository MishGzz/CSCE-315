package IO;

import Engine.Attribute;
import Engine.Domain;
import Engine.Relation;
import Engine.Tuple;

import java.io.*;
import java.util.Map;

public class RelationWriter{

    Relation relation = null;

    public RelationWriter(Relation relation){
        this.relation = relation;
        write(this.relation);
    }

    private void write(Relation relation) {

        String fileName = new String(relation.getTableName() + ".txt");

        try{
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(relation.getTableName());
            for (Map.Entry<String, Domain> domain : relation.getDomains().entrySet()) {
                writer.print(domain.getKey() + "\t");
            }
            writer.print("\n");
            for (Map.Entry<Attribute, Tuple> tuple : relation.getTuplesInRelation().entrySet()) {
                for (Map.Entry<String, Attribute> attribute : tuple.getValue().getTupleAttributes().entrySet()) {
                    writer.print(attribute.getValue().getValue().toString() + "\t");
                }
                writer.print("\n");
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: File error");
        }
    }

}