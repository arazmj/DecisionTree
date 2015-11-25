package net.amirrazmjou.decisiontree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // Q.2
    // The Restaurant data set in Fig. 18.3 (3/2Ed) is the training
    // set. No test set for this data set. Your implementation should
    // reproduce the tree in Fig. 18.6 (3/2Ed).
    // The functions (stated in Java) include:

    // given examples, attributes, and default class
    // return a decision tree
    public static DecisionTreeNode learnDecisionTree(List<Record> examples,
                                                     List<Attribute> attributes,
                                                     Attribute classes, String defaultClass)
    {
        DecisionTreeNode decisionTree = DecisionTreeAlgorithm.train(examples,
                attributes, classes, defaultClass);

        return decisionTree;
    }

    // given a tree, print the tree using pre-order traversal
    // with more indentation for nodes at deeper levels
    public static void printDecisionTree (DecisionTreeNode tree)
    {

        System.out.println(tree);
    }

    // given a tree and a data set, return the accuracy (%)
    // of the tree on the dataset
    public static float evalDecisionTree (DecisionTreeNode tree,
                                         List<Record> dataset)
    {
        //TODO: must return percentage
        return DecisionTreeAlgorithm.evaluate(tree, dataset);
    }


    public static void testDecisionTree (String attrFileName,
                                         String trainFileName,
                                         String testFileName)
    {
        // given the file names for attributes, training set, and test set
        // read in the attributes, training set, and test set
        List<List<String>> attrData = null,
                trainData = null, testData = null;
        try {
            attrData = DataSetFile.read(attrFileName, " ");
            trainData = DataSetFile.read(trainFileName, " ");
            if (testFileName != null) {
                testData = DataSetFile.read(testFileName, " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Attribute> attributeSet = new LinkedList<>();
        List<Record> traininSet = new LinkedList<>();
        List<Record> testSet = new LinkedList<>();

        int classIndex = attrData.size() - 1;
        Attribute classes = new Attribute(attrData.get(classIndex));
        attrData.remove(classIndex);

        assert attrData != null;
        attributeSet.addAll(attrData.stream().map(Attribute::new).collect(Collectors.toList()));

        assert trainData != null;
        traininSet.addAll(trainData.stream().map(Record::new).collect(Collectors.toList()));

        if (testData != null) {
            testSet.addAll(testData.stream().map(Record::new).collect(Collectors.toList()));
        }


        // train a decision tree from the training data
        DecisionTreeNode decisionTree = learnDecisionTree(traininSet, attributeSet, classes, "");

        // print the decision tree
        printDecisionTree(decisionTree);

        // print the accuracy of decision tree on the training set
        float accuracy;
        accuracy = evalDecisionTree(decisionTree, traininSet);
        System.out.println(accuracy);

        // print the accuracy of decision tree on the test set [could be null]
        if (testFileName != null) {
            accuracy = evalDecisionTree(decisionTree, traininSet);
            System.out.println(accuracy);
        }
    }

    // test the restaurant data set
    public static void testRestaurant () {
        testDecisionTree ("restaurant-attr.txt", "restaurant-train.txt", null);
    }


    // Q.4
    // given the sizes and filenames of the training set and test sets
    // train2-fname and test2-fname have records with additional attributes
    // generate a random legal board configuration, assuming x is next to move
    // the user/teacher enters the "correct" move for x
    // attributes and class of each record are written to the file
    // each record should be unique

//    public static void genTttMoveData (train-size train-fname train2-fname
//                    test-size test-fname test2-fname) ...)
//    ; test the ttt data set with initial attributes, and additional attributes (defun test-ttt-move ()
//    (test-decision-tree ’ttt-move-attr.txt ’ttt-move-train.txt ’ttt-move-test.txt)
//            (test-decision-tree ’ttt-move-attr2.txt ’ttt-move-train2.txt
//    ’ttt-move-test2.txt)
//            ’done

    public static void main(String[] args) {
        testRestaurant();
    }
}
