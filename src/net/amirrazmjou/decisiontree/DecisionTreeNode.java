package net.amirrazmjou.decisiontree;

import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class DecisionTreeNode {
    private List<DecisionTreeNode> branches = new LinkedList<>();

    private String branchLabel;
    private final String label;
    private boolean leaf = true;
    private int level;

    /**
     * Constructor for root
     *
     * @param label root label
     */
    public DecisionTreeNode(String label) {
        this.label = label;
        this.branchLabel = null;
    }

    public DecisionTreeNode(String label, boolean leaf) {
        this.label = label;
        this.leaf = leaf;
        this.branchLabel = null;
    }



    public void addBranch(String branchLabel, DecisionTreeNode branch) {
        branch.branchLabel = branchLabel;
        branches.add(branch);
    }


    @Override
    public String toString() {
        return toString(0);
    }
    public String toString(int indent) {
        StringBuilder sbIndent = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sbIndent.append("\t");
        }
        StringBuilder subTree = new StringBuilder();
        for (DecisionTreeNode branch: branches) {
            subTree.append(sbIndent + label + " = " + branch.branchLabel +
                    (branch.leaf ? " : " + branch.label : "") +  "\n");
            subTree.append(branch.toString(indent + 1));
        }
        return subTree.toString();

    }

    public void setLevel(int level) {
        this.level = level;
    }
}