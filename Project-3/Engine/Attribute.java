package Engine;


public class Attribute {
    private Domain<?> domain;
    private Object value;

    public Attribute(Domain<?> Domain, Object value) {
        this.domain = Domain;
        this.value = value;
    }

    public boolean equals(Object o){
        if (!(o instanceof Attribute)){
            return false;
        }
        return this.domain.equals(((Attribute)o).getDomain())
                && this.value.equals(((Attribute)o).getValue());
    }

    public void change (Object object) { value = object; }
    public Domain<?> getDomain(){
        return this.domain;
    }
    public Object getValue(){
        return this.value;
    }
}
