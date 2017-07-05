package Engine;

import java.io.Serializable;

/*************************************************************************



 ************************************************************************/


public class Domain<E extends Serializable> implements Serializable{
    private Class<E> type;      //String/VARCHAR or Integer/INTEGER, the type
    private int maximumNumber;  //Only for VARCHAR, might not need this value
    private String keyName;     //Name of the correlating Attribute

    public Domain(Class<E> type, String name){
        this(type, name, -1);   //  For INTEGER
    }

    public Domain(Class<E> type, String keyName, int maximumNumber){
        this.type = type;
        this.keyName = keyName;                 //  For VARCHAR
        this.maximumNumber = maximumNumber;
    }

    public void resetName (String newName) {
        this.keyName = newName;
    }

    public Class<E> getType(){ return this.type; }
    public String getName(){ return this.keyName; }
    public int getLimit(){ return this.maximumNumber; }

}