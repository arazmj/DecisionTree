package net.amirrazmjou.decisiontree;

import java.util.List;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class Attribute {

    private List<String> data;
    private int index;
    private static int lastIndex = -1;

    public Attribute(List<String> data) {
        this.data = data;
        index = lastIndex;
        lastIndex++;
    }


    public String getName() {
        return data.get(0);
    }
    public List<String> getValues() {
        return data.subList(1, data.size());
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Attribute {" +
                "index=" + index +
                ", name=" + getName() +
                ", values=" + getValues() +
                '}';
    }
}
