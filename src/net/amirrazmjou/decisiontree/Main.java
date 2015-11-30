package net.amirrazmjou.decisiontree;

import net.amirrazmjou.tictactoe.*;

import java.io.*;
import java.util.*;
import java.util.function.Function;
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
     * @param tree the tree
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

    public static void testTttPlayExtra() {
        testDecisionTree("ttt-play-extra-attr.txt", "ttt-play-extra-train.txt", "ttt-play-extra-test.txt");
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
                                      int testSize, String testFileName, String test2FileName)
    {


        System.out.print("Generating examples...");

        // put all training set and test set in a single hash set
        // so we can make sure we have distinct examples
        HashMap<String, String> examplesData = new HashMap<>();
        HashMap<String, String> opponentMoves = new HashMap<>();

        int examplesCount = trainSize + testSize;
        int c = 0;
        while (examplesData.size() < examplesCount) {
            c++;
            Board2D board = new Board2D(3);
            StringBuilder sb = new StringBuilder();

            // we want odd numbers of 1, 3, 5, 7
            // these are the number of moves that
            // makes the turn to x on the next move
            // assuming that it starts with o
            int n = 2 * (c % 4);

            String beforeMove, afterMove;
            putRandomMoves(board, n, c);
            beforeMove = board.toSingleLineString();
            putRandomMoves(board, 1, c);
            afterMove = board.toSingleLineString();
            String opponentMove = findMove(beforeMove, afterMove);

            beforeMove = board.toSingleLineString();

            sb.append(board.toSingleLineString());

            Player player = new SimpleMaxMinPlayer(board, Seed.CROSS);
            player.move();
            afterMove = board.toSingleLineString();

            String move = findMove(beforeMove, afterMove);

            examplesData.put(sb.toString(), move);
            opponentMoves.put(sb.toString(), opponentMove);

            if (c % 20 == 0)
                System.out.print(".");
        }
        List<Map.Entry<String, String>> examplesEntries = new ArrayList<>(examplesData.entrySet());

        Collections.shuffle(examplesEntries, new Random(1));

        List<String> lineExamples = examplesEntries
                .stream()
                .map(p -> p.getKey()  + p.getValue())
                .collect(Collectors.toList());

        List<String> trainLines = lineExamples.subList(0, trainSize);
        List<String> testLines = lineExamples.subList(trainSize, trainSize + testSize);

        Function<String, String> countCross = s -> opponentMoves.get(s); //s.chars().filter(p -> p == 'o' || p == 'x').count();

        List<String> lineExamplesExtra = examplesEntries
                .stream()
                .map(p-> p.getKey() + countCross.apply(p.getKey()) + " " + p.getValue())
                .collect(Collectors.toList());

        List<String> extraValues = examplesEntries
                .stream()
                .map(p -> countCross.apply(p.getKey()).toString())
                .distinct()
                .collect(Collectors.toList());

        String join = String.join(" ", extraValues);
        System.out.println();
        System.out.println(join);


        List<String> trainDataExtra = lineExamplesExtra.subList(0, trainSize);
        List<String> testDataExtra = lineExamplesExtra.subList(trainSize, trainSize + testSize);

        try {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(train2FileName), "utf-8"))) {
                for (String s : trainDataExtra) {
                    writer.write(s);
                    writer.write("\n");
                }
            }

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(test2FileName), "utf-8"))) {
                for (String s : testDataExtra) {
                    writer.write(s);
                    writer.write("\n");
                }
            }

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(trainFileName), "utf-8"))) {
                for (String s : trainLines) {
                    writer.write(s);
                    writer.write("\n");
                }
            }

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(testFileName), "utf-8"))) {
                for (String s : testLines) {
                    writer.write(s);
                    writer.write("\n");
                }
            }

        } catch (IOException ex) {
            System.out.println("Cannot write the file named " + ex.getMessage());
        }
    }

    private static String findMove(String beforeMove, String afterMove) {
        String[] positions = new String[]
                {"top-left", "top-middle", "top-right",
                        "middle-left", "center", "middle-right",
                        "bottom-left", "bottom-middle", "bottom-right"};

        String[] splitBeforeMove = beforeMove.split(" ");
        String[] splitAfterMove = afterMove.split(" ");

        int i = 0;
        for (; i < splitAfterMove.length; i++) {
            if (!splitAfterMove[i].equals(splitBeforeMove[i]))
                break;
        }
        return positions[i % positions.length];
    }

    private static void putRandomMoves(Board board, int n, int seed)
    {
        Random random = new Random();
        random.setSeed(seed);
        // start with cross
        boolean b = true;
        int size1 = board.getAvailableMoves().size();
        int tries = 0;
        while (board.getAvailableMoves().size() > size1 - n && tries < 10)
        {
            List<Point> availableMoves = board.getAvailableMoves();
            int size = availableMoves.size();
            int r = random.nextInt(size);
            board.setCell(availableMoves.get(r), b ? Seed.NOUGHT : Seed.CROSS);
            if (board.winner() != null) {
                board.setCell(availableMoves.get(r), Seed.EMPTY);
                tries++;
            } else {
                b = !b;
            }
        }
    }

    public static void main(String[] args)  {
        genTttMoveData(200, "ttt-play-train.txt", "ttt-play-extra-train.txt",
                       50, "ttt-play-test.txt", "ttt-play-extra-test.txt");
//        testRestaurant();
//        testIds();
//        testTtt();
        testTttPlay();
        testTttPlayExtra();
    }
}
