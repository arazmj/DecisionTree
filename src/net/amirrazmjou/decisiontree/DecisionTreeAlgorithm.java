package net.amirrazmjou.decisiontree;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Amir Razmjou on 11/21/15.
 */

public class DecisionTreeAlgorithm {

    /**
     * Constructs and returns a DecisionTree using algorithm explained in
     * the book, Artificial Intelligence: A Modern Approach, 3rd edition,
     * page 702, Fig 18.6. This is not the most efficient way to implement
     * the algorithm.
     *
     * @param examples     The training set to be used for DT algorithm
     * @param attributes   A set of attributes excluding the class attribute
     * @param classes      Classes as used in the Training Set.
     * @param defaultClass Used for recursion, can be an empty string initially
     * @return The root node of the decision tree
     */
    public static DecisionTreeNode train(List<Record> examples,
                                         List<Attribute> attributes,
                                         Attribute classes,
                                         String defaultClass) {
        // if examples is empty then return default
        if (examples.isEmpty()) {
            return new DecisionTreeNode(defaultClass, classes, "");
        }

        // if all examples have the same classification
        // then return the classification
        String cs = examples.get(0).getClassification();
        if (examples.stream().allMatch(p -> p.getClassification().equals(cs)))
            return new DecisionTreeNode(cs, classes, Integer.toString(examples.size()));

        // if attributes is empty then return Mode(examples)
        if (attributes.isEmpty())
            return new DecisionTreeNode(mode(examples), classes, "");

        // choose best attribute
        Attribute best = chooseAttribute(attributes, classes, examples);

        assert best != null;
        DecisionTreeNode tree = new DecisionTreeNode(best, Integer.toString(examples.size()));

        for (String value : best.getValues()) {
            // filter examples to return only those records that their
            // best attribute value match the value
            List<Record> filteredExamples = examples
                    .stream()
                    .filter(p -> p.getValue(best).equals(value))
                    .collect(Collectors.toList());

            // remove best from attributes
            List<Attribute> filteredAttributes = attributes
                    .stream()
                    .filter(p -> p != best)
                    .collect(Collectors.toList());

            // we don't need to calculate mode if the filtered examples are not empty
            String mode = filteredExamples.isEmpty() ? mode(examples) : defaultClass;
            DecisionTreeNode subTree = train(filteredExamples, filteredAttributes, classes, mode);
            tree.addBranch(value, subTree);
        }

        return tree;
    }

    /**
     * Calculates the information entropy of given examples and classes
     *
     * @param examples examples including the classes
     * @param classes  classes values
     * @return the positive value of information entropy
     */
    private static float entropy(List<Record> examples, Attribute classes) {
        long examplesCount = examples.size();
        float result = 0;
        for (String _class : classes.getValues()) {
            long count = examples
                    .stream()
                    .filter(p -> p.getClassification().equals(_class))
                    .count();
            float p = ((float) count / examplesCount);
            if (p != 0 && !Float.isNaN(p))
                result += -1 * p * (Math.log(p) / Math.log(2));
        }
        return result;
    }

    /**
     * Chooses the best attribute of given attributes based on the information
     * gain that can be obtained by the best attribute.
     *
     * @param attributes attributes in the given example set
     * @param classes    classes in the given example set
     * @param examples   the example set
     * @return one element of attributes as the best attribute for given
     * example set
     */
    private static Attribute chooseAttribute(List<Attribute> attributes,
                                             Attribute classes,
                                             List<Record> examples) {
        float attributeEntropy;
        float bestEntropy = Float.MAX_VALUE;
        Attribute bestAttribute = null;

        for (Attribute attribute : attributes) {
            attributeEntropy = 0;
            for (String value : attribute.getValues()) {
                List<Record> filteredExamples = examples
                        .stream()
                        .filter(p -> p.getValue(attribute).equals(value))
                        .collect(Collectors.toList());
                float p = (float) filteredExamples.size() / examples.size();
                if (filteredExamples.isEmpty()) {
                    p = 0;
                }
                float entropy = entropy(filteredExamples, classes);
                attributeEntropy += p * entropy;
            }
            if (attributeEntropy < bestEntropy) {
                bestEntropy = attributeEntropy;
                bestAttribute = attribute;
            }
        }

        return bestAttribute;
    }

    /**
     * Finds the most frequent class in the given example set
     *
     * @param examples the example set
     * @return the most frequent class
     */
    private static String mode(List<Record> examples) {
        return examples
                .stream()
                .map(Record::getClassification)
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Long::compareTo))
                .get()
                .getKey();
    }

}
