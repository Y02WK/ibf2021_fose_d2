package DerivedInstance;

public class DerivedFrom extends DerivedInstance{

    public String name = "DerivedFrom";
    public String type = "Child";
    public static void main(String[] args) {
        DerivedInstance obj = new DerivedFrom();
        System.out.println(obj instanceof DerivedInstance);
        System.out.println(obj.name);
    }

    public String getType() {
        return this.type;
    }
}
