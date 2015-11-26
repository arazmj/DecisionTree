package net.amirrazmjou.decisiontree;

import java.util.List;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class Record {
    private List<String> data;

    /**
     * @param data Raw record data including the associated class
     */
    public Record(List<String> data) {
        this.data = data;
    }

    /**
     * @return The associated class record
     */
    public String getClassification() {
        return data.get(data.size() - 1);
    }

    /**
     * Returns the value of given attribute in the record
     *
     * @param attribute The attribute
     * @return the value
     */
    public String getValue(Attribute attribute) {
        return data.get(attribute.getIndex());
    }

    @Override
    public String toString() {
        return "Record {" +
                "values=" + data.subList(0, data.size() - 1) +
                ", class=" + getClassification() +
                '}';
    }
}
