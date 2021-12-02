package GenericObject;

import java.util.Objects;

public class GenericObject {
    public String item;

    public static void main(String[] args) {
        GenericObject obj = new GenericObject();
        System.out.println((obj.getItem().getClass()));
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Object getItem() {
        return this.item;
    }

    public boolean isEmpty() {
        return Objects.isNull(this.item);
    }
}
