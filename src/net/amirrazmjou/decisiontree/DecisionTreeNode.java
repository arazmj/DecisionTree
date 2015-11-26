package net.amirrazmjou.decisiontree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Amir Razmjou on 11/21/15.
 */
public class DecisionTreeNode {
    private final Attribute attribute;
    private List<DecisionTreeNode> branches = new LinkedList<>();

    private String branchLabel;
    private final String label;
    private final String extraInfo;
    private final boolean leaf;

    /**
     * @param label     label that is shown as node label in the tree representation
     * @param classes   the classes in the example set
     * @param extraInfo arbitrary extra information, shown inside parenthesis
     *                  in the tree representation
     */
    public DecisionTreeNode(String label, Attribute classes, String extraInfo) {
        this.label = label;
        this.attribute = classes;
        this.extraInfo = extraInfo;
        this.branchLabel = null;
        this.leaf = true;
    }

    public DecisionTreeNode(Attribute attribute, String extraInfo) {
        this.attribute = attribute;
        this.label = attribute.getName();
        this.leaf = false;
        this.extraInfo = extraInfo;
        this.branchLabel = null;
    }

    /**
     * Adds a new branch to the node
     *
     * @param branchLabel branch label
     * @param branch      the DecisionTreeNode to be attached to the tree
     */
    public void addBranch(String branchLabel, DecisionTreeNode branch) {
        branch.branchLabel = branchLabel;
        branches.add(branch);
    }

    /**
     * given a tree, print the tree using pre-order traversal
     * with more indentation for nodes at deeper levels
     *
     * @return the structured printable decision tree
     */
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
        for (DecisionTreeNode branch : branches) {
            subTree.append(sbIndent);
            subTree.append(label);
            subTree.append(" = ");
            subTree.append(branch.branchLabel);
            subTree.append(branch.leaf ? " : " + branch.label : "");
            subTree.append(branch.extraInfo.isEmpty() ? "" : " (" + branch.extraInfo + ")");
            subTree.append("\n");
            subTree.append(branch.toString(indent + 1));
        }
        return subTree.toString();

    }

    /**
     * Simple evaluation function
     *
     * @param dataSet The data set that the evaluation tree can be evaluated to.
     * @return The number of correctly matched records
     */
    public int evaluate(List<Record> dataSet) {
        int sum = 0;

        for (DecisionTreeNode branch : branches) {
            if (branch.leaf) {
                List<Record> filtered = dataSet
                        .stream()
                        .filter(p -> p.getValue(attribute).equals(branch.branchLabel))
                        .filter(p -> p.getClassification().equals(branch.label))
                        .collect(Collectors.toList());
                sum += filtered.size();
            } else {
                List<Record> filtered = dataSet
                        .stream()
                        .filter(p -> p.getValue(attribute).equals(branch.branchLabel))
                        .collect(Collectors.toList());
                sum += branch.evaluate(filtered);
            }
        }
        return sum;
    }
}