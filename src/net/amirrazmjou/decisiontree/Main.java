package net.amirrazmjou.decisiontree;

import java.io.IOException;
import java.util.List;

public class Main {

    // Q.2
    // The Restaurant data set in Fig. 18.3 (3/2Ed) is the training
    // set. No test set for this data set. Your implementation should
    // reproduce the tree in Fig. 18.6 (3/2Ed).
    // The functions (stated in Java) include:

    // given examples, attributes, and default class
    // return a decision tree
    public static DecisionTree learnDecisionTree (List<Record> examples,
                                                  List<Attribute> attributes,
                                                  String defaultClass)
    {
        DecisionTree decisionTree = new DecisionTree(examples, attributes, defaultClass);
        decisionTree.learn();
        return decisionTree;
    }

    // given a tree, print the tree using pre-order traversal
    // with more indentation for nodes at deeper levels
    public static void printDecisionTree (DecisionTree tree)
    {
        System.out.println(tree);
    }

    // given a tree and a data set, return the accuracy (%)
    // of the tree on the dataset
    public static float evalDecisionTree (DecisionTree tree,
                                         List<Record> dataset)
    {
        return tree.evaluate(dataset);
    }

    // given the file names for attributes, training set, and test set
    // read in the attributes, training set, and test set
    // learn a decision tree from the training data
    // print the decision tree
    // print the accuracy of decision tree on the training set
    // print the accuracy of decision tree on the test set [could be null]
    public static void testDecisionTree (String attrFileName,
                                         String trainFileName,
                                         String testFileName)
    {
        try {
            List<List<String>> attributes = DataSetFile.read(attrFileName, " ");
            System.out.println(attributes);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // Attribute attribute = new Attribute(attrFileName);
       // Data attribute = new Attribute(attrFileName);

    }

    // test the restaurant data set
    public static void testRestaurant () {
        testDecisionTree ("restaurant-attr.txt", "restaurant-train.txt", null);
    }

    public static void main(String[] args) {
        testRestaurant();
    }
}
