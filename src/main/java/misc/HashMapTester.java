package misc;

import java.util.HashMap;
import java.util.Map;

public class HashMapTester {

    public static void main(String[] args) {

        Map<CustomKey, String> map = new HashMap<>();
        map.put(new CustomKey("t"), "kranthi");
        map.put(new CustomKey("t"), "kumar");

        System.out.println(map.size());

    }
}

class CustomKey {

    private String name;

    public CustomKey(String name) {
        this.name = name;
    }

    public void setName(String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        System.out.println("CustomKey: hashcode called.");
        return name.hashCode();
//        super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("CustomKey: equals called.");
//        return super.equals(obj);
        return ((CustomKey)obj).name.equals(this.name);
    }
}
