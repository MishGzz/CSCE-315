package Engine;


import java.util.*;

public class Tuple {
    private LinkedHashMap<String, Attribute> tupleAttributes = new LinkedHashMap<>();
    private int tupleSize;

    public Tuple(Attribute... listOfAttributes){
        for (Attribute attribute : listOfAttributes) {
            if (attribute == null)
                continue;
            String name = attribute.getDomain().getName();
            tupleAttributes.put(name, attribute);
        }
        tupleSize = tupleAttributes.size();
    }

    public void change (ArrayList<String> attributeNames, ArrayList<String> newValues) {
        if (attributeNames.size() == newValues.size() || attributeNames.size() > tupleSize) {
            System.out.println("Error: Attributes to update does not match amount of literals");
            return;
        }
        for (int i = 0; i < attributeNames.size(); i++) {
            tupleAttributes.get(attributeNames.get(i)).change((Object) newValues.get(i));
        }
    }

    public void resetName (String oldName, String newName) {
        LinkedHashMap<String, Attribute> newTupleAttriutes = new LinkedHashMap<>();
        for (Map.Entry<String, Attribute> attribute : tupleAttributes.entrySet()) {
            if (attribute.getKey() != oldName) {
                newTupleAttriutes.put(attribute.getKey(), attribute.getValue());
            } else {
                tupleAttributes.get(oldName).getDomain().resetName(newName);
                newTupleAttriutes.put(newName, tupleAttributes.get(oldName));
            }
        }
        tupleAttributes = newTupleAttriutes;
    }

    public boolean matching(Tuple tuple) {
        boolean match = true;
        if (this.tupleSize != tuple.tupleSize){
            return false;
        }
        for(Map.Entry<String, Attribute> attr : this.tupleAttributes.entrySet()){
            if(!attr.getValue().getValue().equals(tuple.tupleAttributes.get(attr.getKey()).getValue())){
                match = false;
            }
        }
        return match;
    }

    public int size(){
        return tupleSize;
    }
    public Attribute get(String att) {
        return tupleAttributes.get(att);
    }
    public LinkedHashMap<String, Attribute> getTupleAttributes () {
        return tupleAttributes;
    }
    public Attribute makeKey () { return tupleAttributes.entrySet().iterator().next().getValue(); }
}