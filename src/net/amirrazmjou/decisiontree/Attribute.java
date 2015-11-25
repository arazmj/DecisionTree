package net.amirrazmjou.decisiontree;

import java.util.List;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class Attribute {

    private List<String> data;
    public String getName() {
        return data.get(0);
    }
    public List<String> getValues() {
        // TODO:
        return data.subList(1, data.size() - 1);
    }
}
