package net.amirrazmjou.decisiontree;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    // Q.2
    // The Restaurant data set in Fig. 18.3 (3/2Ed) is the training
    // set. No test set for this data set. Your implementation should
    // reproduce the tree in Fig. 18.6 (3/2Ed).
    // The functions (stated in Java) include:
    //

    /** given a tree and a data set, return the accuracy (%) of the tree on
     * the dataset
     * @param tree the tree
     * @param dataSet the dataset
     * @return the accuracy
     */
    public static float evalDecisionTree(DecisionTreeNode tree,
                                         List<Record> dataSet) {
        return (float) tree.evaluate(dataSet) / dataSet.size() * 100;
    }

    public static void testDecisionTree(String attrFileName,
                                        String trainFileName,
                                        String testFileName) {
        System.out.println();
        System.out.println("Training Set: " + trainFileName);
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

        Attribute.ResetIndex();

        assert attrData != null;
        int classIndex = attrData.size() - 1;
        Attribute classes = new Attribute(attrData.get(classIndex));
        attrData.remove(classIndex);

        List<Attribute> attributeSet = attrData
                .stream()
                .map(Attribute::new)
                .collect(Collectors.toList());

        assert trainData != null;
        List<Record> trainingSet = trainData
                .stream()
                .map(Record::new)
                .collect(Collectors.toList());

        List<Record> testSet = null;
        if (testData != null) {
            testSet = testData
                    .stream()
                    .map(Record::new)
                    .collect(Collectors.toList());
        }


        // train a decision tree from the training data
        DecisionTreeNode decisionTree = DecisionTreeAlgorithm.train(trainingSet,
                attributeSet, classes, "");

        // print the decision tree
        System.out.println(decisionTree);

        // print the accuracy of decision tree on the training set
        float accuracy;
        accuracy = evalDecisionTree(decisionTree, trainingSet);
        System.out.println("Accuracy of decision tree on the training set : " + accuracy);

        // print the accuracy of decision tree on the test set [could be null]
        if (testFileName != null) {
            accuracy = evalDecisionTree(decisionTree, testSet);
            System.out.println("Accuracy of decision tree on the test set : " + accuracy);
        }
    }

    /**
     * test the restaurant data set
     */
    public static void testRestaurant() {

        testDecisionTree("restaurant-attr.txt", "restaurant-train.txt", null);
    }

    /**
     * test the IDS data set
     */
    public static void testIds() {

        testDecisionTree("ids-attr.txt", "ids-train.txt", "ids-test.txt");
    }

    /**
     * test the Tic Tac Tow data set
     */
    public static void testTtt() {

        testDecisionTree("ttt-attr.txt", "ttt-train.txt", "ttt-test.txt");
    }

    // Q.4
    // We would like the program to learn how to make a move in the tic-tac-toe game.
    // The nine (target) classes are: top-left, top-middle, ...
    // The initial nine attributes are the nine squares with x, o, b as values

    /**
     * given the sizes and file names of the training set and test sets
     * train2-fname and test2-fname have records with additional attributes
     * generate a random legal board configuration, assuming x is next to move
     * the user/teacher enters the "correct" move for x
     * attributes and class of each record are written to the file
     * each record should be unique
     * @param trainSize
     * @param trainFileName
     * @param train2FileName
     * @param testSize
     * @param testFileName
     * @param test2FileName
     */
    public static void genTttMoveData(int trainSize, String trainFileName, String train2FileName,
                                      int testSize, String testFileName, String test2FileName)
    {

    }

    /**
     * test the ttt data set with initial attributes,
     * and additional attributes
     */
    public static void testTttMove() {
        testDecisionTree("ttt-move-attr.txt", "ttt-move-train.txt", "ttt-move-test.txt");
        testDecisionTree("ttt-move-attr2.txt", "ttt-move-train2.txt", "ttt-move-test2.txt");
    }

    public static void main(String[] args) {
        testRestaurant();
        testIds();
        testTtt();
    }
}
