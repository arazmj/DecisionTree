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

    public static DecisionTreeNode train(List<Record> examples,
                                         List<Attribute> attributes,
                                         Attribute classes,
                                         String defaultClass)
    {
        // if examples is empty then return default
        if (examples.isEmpty()) {
            return new DecisionTreeNode(defaultClass);
        }

        // if all examples have the same classification
        // then return the classification
        String classification = examples.get(0).getClassification();
        boolean sameClassification = true;
        for (Record example: examples) {
            if (!classification.equals(example.getClassification())) {
                sameClassification = false;
                break;
            }
        }
        if (sameClassification)
            return new DecisionTreeNode(classification);

        // if attributes is empty then return Mode(examples)
        if (attributes.isEmpty())
            return new DecisionTreeNode(mode(examples));

        // choose best attribute
        Attribute best = chooseAttribute(attributes, classes, examples);

        assert best != null;
        DecisionTreeNode tree = new DecisionTreeNode(best.getName(), false);

        for (String value: best.getValues()) {
            List<Record> filteredExamples = examples
                    .stream()
                    .filter(p -> p.getValue(best).equals(value))
                    .collect(Collectors.toList());

            attributes.remove(best);

            //TODO: we don't need to calculate mode if examples are not empty
            DecisionTreeNode subTree = train(filteredExamples, attributes, classes, mode(examples));
            tree.addBranch(value, subTree);
        }

        return tree;
    }

    private static float entropy(List<Record> examples, Attribute classes)
    {
        long examplesCount = examples.size();
        float result = 0;
        for (String _class: classes.getValues()) {
            long count = examples
                    .stream()
                    .filter(p -> p.getClassification().equals(_class))
                    .count();
            float p = ((float) count / examplesCount);
            if (p != 0)
                result += -1 * p * (Math.log(p) / Math.log(2));
        }
        return result;
    }

    private static Attribute chooseAttribute(List<Attribute> attributes,
                                             Attribute classes,
                                             List<Record> examples)
    {
        float attributeEntropy;
        float bestEntroy = Float.MAX_VALUE;
        Attribute bestAttribute = null;

        for (Attribute attribute: attributes) {
            attributeEntropy = 0;
            for (String value: attribute.getValues()) {
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
            if (attributeEntropy < bestEntroy) {
                bestEntroy = attributeEntropy;
                bestAttribute = attribute;
            }
        }

        return bestAttribute;
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
