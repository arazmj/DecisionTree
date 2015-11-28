package net.amirrazmjou.decisiontree;

import net.amirrazmjou.tictactoe.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    // Q.2
    // The Restaurant data set in Fig. 18.3 (3/2Ed) is the training
    // set. No test set for this data set. Your implementation should
    // reproduce the tree in Fig. 18.6 (3/2Ed).
    // The functions (stated in Java) include:
    //

    /**
     * given a tree and a data set, return the accuracy (%) of the tree on
     * the dataset
     *
     * @param tree    the tree
     * @param dataSet the data set
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

    public static void testTttPlay() {
        testDecisionTree("ttt-play-attr.txt", "ttt-play-train.txt", "ttt-play-test.txt");
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
     * each record should be unique.
     *
     * @param trainSize
     * @param trainFileName
     * @param train2FileName
     * @param testSize
     * @param testFileName
     * @param test2FileName
     */
    public static void genTttMoveData(int trainSize, String trainFileName, String train2FileName,
                                      int testSize, String testFileName, String test2FileName) throws IOException {

        String[] positions = new String[]
                {"top-left", "top-middle", "top-right",
                 "middle-left", "center", "middle-right",
                 "bottom-left", "bottom-middle", "bottom-right"};

        System.out.print("Generating examples...");

        // put all training set and test set in a single hash set
        // so we can make sure we have distinct examples
        HashSet<String> examplesData = new HashSet<>();
        int examplesCount = trainSize + testSize;
        int c = 0;
        while (examplesData.size() < examplesCount) {
            c++;
            Board2D board = new Board2D(3);
            StringBuilder sb = new StringBuilder();
            putRandomMoves(board, c % 8, c);
            String beforeMove = board.toSingleLineString();
            sb.append(beforeMove);

            Player player = new SimpleMaxMinPlayer(board, Seed.CROSS);
            player.move();
            String afterMove = board.toSingleLineString();

            String[] splitBeforeMove = beforeMove.split(" ");
            String[] splitAfterMove = afterMove.split(" ");

            int i = 0;
            for (; i < splitAfterMove.length; i++) {
                if (!splitAfterMove[i].equals(splitBeforeMove[i]))
                    break;
            }

            sb.append(positions[i]);
            examplesData.add(sb.toString());

            if (c % 20 == 0)
                System.out.print(".");
        }

        ArrayList<String> arrayList = new ArrayList<>(examplesData);
        List<String> trainData = arrayList.subList(0, trainSize);
        List<String> testData = arrayList.subList(trainSize, trainSize + testSize);

        try {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(trainFileName), "utf-8"))) {
                for (String s : trainData) {
                    writer.write(s);
                    writer.write("\n");
                }
            }

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(testFileName), "utf-8"))) {
                for (String s : testData) {
                    writer.write(s);
                    writer.write("\n");
                }
            }
        } catch (IOException ex) {
            System.out.println("Cannot write the file "  + ex.getMessage());
        }
    }

    public static void putRandomMoves(Board board, int n, int seed) {
        Random random = new Random();
        random.setSeed(seed);
        boolean b = true;
        for (int x = 0; x < n; x++) {
            List<Point> availableMoves = board.getAvailableMoves();
            int size = availableMoves.size();
            int r = random.nextInt(size);
            board.setCell(availableMoves.get(r), b ? Seed.NOUGHT : Seed.CROSS);
            if (board.winner() != null) {
                board.setCell(availableMoves.get(r), Seed.EMPTY);
            } else {
                b = !b;
            }
        }
    }

    /**
     * test the ttt data set with initial attributes,
     * and additional attributes
     */
    public static void testTttMove() {
        testDecisionTree("ttt-move-attr.txt", "ttt-move-train.txt", "ttt-move-test.txt");
        testDecisionTree("ttt-move-attr2.txt", "ttt-move-train2.txt", "ttt-move-test2.txt");
    }

    public static void main(String[] args) throws IOException {
        genTttMoveData(10, "ttt-play-train.txt", "",
                      200, "ttt-play-test.txt", "");
//        testRestaurant();
//        testIds();
//        testTtt();
        testTttPlay();
    }
}
