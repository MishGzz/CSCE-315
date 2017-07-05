package Engine;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created by jaredwheeler on 6/30/17.
 */
public class Tester {

    public static Database database = new Database();

    public static void main(String[] args) {

        ArrayList<Tuple> tuples = new ArrayList<Tuple>();

        Relation relation1 = new Relation(new String("Reddit"),//name
                new Domain<Integer>(Integer.class, "Karma"), //key
                new Domain<Integer>(Integer.class, "Karma"),//attributes
                new Domain<String>(String.class, "UserName"),
                new Domain<Integer>(Integer.class, "PostCount"));
        //
        relation1.set(new Attribute(new Domain<Integer>(Integer.class, "Karma"), 666),
                new Attribute(new Domain<String>(String.class, "UserName"), "deleteSystem32"),
                new Attribute(new Domain<Integer>(Integer.class, "PostCount"), 420));

        Attribute key1 = new Attribute(new Domain<Integer>(Integer.class, "Karma"), 69);
        tuples.add(new Tuple(key1,
                new Attribute(new Domain<String>(String.class, "UserName"), "Windows7Sux"),
                new Attribute(new Domain<Integer>(Integer.class, "PostCount"), 3)));
        relation1.getTuplesInRelation().put(key1, tuples.get(0));



        Relation relation2 = new Relation(new String("FaceBook"),
                new Domain<Integer>(Integer.class, "Likes"),//key
                new Domain<Integer>(Integer.class, "Likes"),
                new Domain<String>(String.class, "UserName"),
                new Domain<Integer>(Integer.class, "Friends"));
        relation2.set(new Attribute(new Domain<Integer>(Integer.class, "Likes"), 1337),
                new Attribute(new Domain<String>(String.class, "UserName"), "Jonny Dipshit"),
                new Attribute(new Domain<Integer>(Integer.class, "Friends"), 222));
        Attribute key2 = new Attribute(new Domain<Integer>(Integer.class, "Likes"), 398);
        tuples.add(new Tuple(key1,
                new Attribute(new Domain<String>(String.class, "UserName"), "Connor Ukraine Montana"),
                new Attribute(new Domain<Integer>(Integer.class, "Friends"), 3)));
        relation1.getTuplesInRelation().put(key2, tuples.get(1));

        Relation relation3 = new Relation(new String("GameFAQs"),
                new Domain<Integer>(Integer.class, "Karma"), //key
                new Domain<Integer>(Integer.class, "Karma"),
                new Domain<String>(String.class, "UserName"),
                new Domain<Integer>(Integer.class, "Level"));
        relation3.set(new Attribute(new Domain<Integer>(Integer.class, "Karma"), 69),
                new Attribute(new Domain<String>(String.class, "UserName"), "rm-rf--no-preserve-root"),
                new Attribute(new Domain<Integer>(Integer.class, "Level"), 33));

        Attribute key3 = new Attribute(new Domain<Integer>(Integer.class, "Karma"), 9001);
        tuples.add(new Tuple(key3,
                new Attribute(new Domain<String>(String.class, "UserName"), "LinuxIsMessiah"),
                new Attribute(new Domain<Integer>(Integer.class, "Level"), 13377)));
        relation3.getTuplesInRelation().put(key3, tuples.get(2));

        Attribute key4 = new Attribute(new Domain<Integer>(Integer.class, "Karma"), 2);
        tuples.add(new Tuple(key4,
                new Attribute(new Domain<String>(String.class, "UserName"), "n00bWindowsLover"),
                new Attribute(new Domain<Integer>(Integer.class, "Level"), 0)));
        relation3.getTuplesInRelation().put(key4, tuples.get(3));

        File file = new File("test2.txt");
        if (file.exists())
            file.delete();

        database.mapOfRelations.put("Reddit", relation1);
        database.mapOfRelations.put("FaceBook", relation2);
        database.mapOfRelations.put("GameFAQs", relation3);

//
//        //test projection
//        ArrayList<Tuple> testProjection = database.projection(
//                new ArrayList<Tuple>(database.mapOfRelations.get("Reddit").getTuplesInRelation().values()),
//                "Karma", "UserName");
//        for (Tuple r: testProjection){
//            for(Attribute attr: r.getTupleAttributes().values()){
//                System.out.print(attr.getValue()+ " ");
//            }
//            System.out.print("\n");
//        }

        //test selection


        //test open
        File fileOpen = new File("GameFAQs.txt");
        if (fileOpen.exists())
            fileOpen.delete();
        try {
            database.open("GameFAQs");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            database.write("GameFAQs");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
