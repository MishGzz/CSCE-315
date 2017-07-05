package IO;

import Engine.Attribute;
import Engine.Domain;
import Engine.Relation;
import Engine.Tuple;

import java.io.*;
import java.util.ArrayList;

public class RelationReader {

    String relationName = new String("");
    Relation relation = null;

    public RelationReader (String relationName) throws FileNotFoundException {
        this.relationName = relationName;
        this.relation = null;
        read();
    }

    private void read() throws FileNotFoundException {

        String file = new String(relationName + ".txt");
        int iterator = 0;
        boolean caught = false;

        String name = new String("");
        ArrayList<String> createDomains = new ArrayList<>();
        ArrayList<ArrayList<String>> createTuples = new ArrayList<>();
        ArrayList<Object> retrievedTypes = new ArrayList<>();
        ArrayList<Domain<?>> retrievedDomains = new ArrayList<>();
        ArrayList<Tuple> retrievedTuples = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (iterator == 0)
                    name = line;
                else if (iterator == 1) {
                    String[] splitter = line.split("\\s+");
                    for (int i = 0; i < splitter.length; i++)
                        createDomains.add(splitter[i]);
                }
                else {
                    String[] splitter = line.split("\\s+");
                    ArrayList<String> createAttrs = new ArrayList<>();
                    for (int i = 0; i < splitter.length; i++) {
                        createAttrs.add(splitter[i]);
                        if (!caught) {
                            if (splitter[i].matches("^-?\\d+$")) {
                                retrievedTypes.add(Integer.parseInt(splitter[i]));
                            } else
                                retrievedTypes.add(splitter[i]);
                        }
                    }
                    caught = true;
                    createTuples.add(createAttrs);
                }
                iterator++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < createDomains.size(); i++ ) {
            if (retrievedTypes.get(i) instanceof Integer)
                retrievedDomains.add(new Domain<Integer>(Integer.class, createDomains.get(i)));
            else
                retrievedDomains.add(new Domain<String>(String.class, createDomains.get(i), createDomains.get(i).length()));
        }

        relation = new Relation(name, retrievedDomains.get(0), retrievedDomains.toArray(new Domain<?>[retrievedDomains.size()]));

        for (ArrayList<String> strings : createTuples) {
            Attribute[] attributes = new Attribute[strings.size()];
            for (int j = 0; j < strings.size(); j++) {
                if (retrievedDomains.get(j).getType() == Integer.class)
                    attributes[j] = new Attribute(retrievedDomains.get(j), Integer.parseInt(strings.get(j)));
                else
                    attributes[j] = new Attribute(retrievedDomains.get(j), strings.get(j));
            }
            relation.set(attributes[0], attributes);
        }
    }

    public Relation get() { return relation; }
}