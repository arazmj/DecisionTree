package net.amirrazmjou.decisiontree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class DecisionTreeNode {
    private List<DecisionTreeNode> branches = new LinkedList<>();

    private String branchLabel;
    private final String label;

    /**
     * Constructor for root
     * @param label root label
     */
    public DecisionTreeNode(String label) {
        this.label = label;
        this.branchLabel = null;
    }

    public void addBranch(String branchLabel, DecisionTreeNode branch) {
        branch.branchLabel = branchLabel;
        branches.add(branch);
    }
}
