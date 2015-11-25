package net.amirrazmjou.decisiontree;

import java.util.List;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class Record {
    private List<String> data;

    public Record(List<String> data) {
        this.data = data;
    }

    public String getClassification() {
        return data.get(data.size() - 1);
    }

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
