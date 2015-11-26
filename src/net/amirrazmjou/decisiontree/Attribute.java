package net.amirrazmjou.decisiontree;

import java.util.List;

/**
 * Created by Amir Razmjou on 11/21/15.
 */

class Attribute {

    private final List<String> data;
    private final int index;
    private static int lastIndex = -1;

    /**
     * @param data the raw data including the attribute name and its possible values
     */
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

    /**
     * @return the attribute index inside the attributes set
     */
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

    /**
     * This static method must be called before a new dataset is going to be loaded
     * In fact this is a good indication of a new class for Attributes Data Set is
     * needed but that would make the design complicated for now.
     */
    public static void ResetIndex() {
        lastIndex = -1;
    }
}
