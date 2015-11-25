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
    public static DecisionTreeNode learn(List<Record> examples, List<Attribute> attributes, String defaultClass) {
        // if examples is empty then return default
        if (examples.isEmpty()) {
            return new DecisionTreeNode(defaultClass);
        }

        // if all examples have the same classification
        // then return the classification
        String classification = examples.get(0).getClassification();
        boolean sameClassification = true;
        for (Record example: examples) {
            if (!classification.equals(example.getClassification()))
                sameClassification = false;
        }
        if (sameClassification)
            return new DecisionTreeNode(classification);

        // if attributes is empty then return Mode(examples)
        if (attributes.isEmpty())
            return new DecisionTreeNode(mode(examples));

        // choose best attribute
        Attribute best = chooseAttribute(attributes, examples);

        DecisionTreeNode tree = new DecisionTreeNode(best.getName());

        for (String value: best.getValues()) {
            List<Record> examplesValue = examples
                    .stream()
                    .filter(p -> p.getValue(best) == value)
                    .collect(Collectors.toList());

            attributes.remove(best);
            DecisionTreeNode subTree = learn(examplesValue, attributes, mode(examples));
            tree.addBranch(value, subTree);
        }

        return tree;
    }

    private static Attribute chooseAttribute(List<Attribute> attributes, List<Record> examples) {
        return null;
    }

    private static String mode(List<Record> examples) {
        String mode = examples
                .stream()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Long::compareTo))
                .get()
                .getKey()
                .getClassification();

        return mode;
    }

    public static float evaluate(DecisionTreeNode decisionTree, List<Record> dataset) {
        return 0;

    }
}
