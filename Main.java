package sorting;

import java.util.*;

public class Main {

    private static void mergeSort(Integer[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        Integer[] leftHalf = new Integer[midIndex];
        Integer[] rightHalf = new Integer[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);

    }
    private static void merge (Integer[] inputArray, Integer[] leftHalf, Integer[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            }
            else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (Arrays.asList(args).contains("-sortIntegers")) {
            List<Integer> integerList = new ArrayList<>();
            while (scanner.hasNextInt()) {

                integerList.add(scanner.nextInt());
            }
            Integer[] integerArray = new Integer[integerList.size()];
            integerArray = integerList.toArray(integerArray);
            mergeSort(integerArray);

            System.out.printf("Total numbers: %d%n" +
                            "Sorted data: %s", integerList.size(), Arrays.toString(integerArray)
                            .replace(",", "")
                    .replace("[", "")
                    .replace("]", ""));

        } else {

            String dataType = "word";

            if (args.length == 2) {
                dataType = args[1];
            }

            Max<?> max;

            switch (dataType) {

                case "long" -> {
                    LongMax longMax = new LongMax();
                    while (scanner.hasNext()) {

                        longMax.process(scanner.nextLong());
                    }
                    max = longMax;
                    System.out.println(max);
                }
                case "word" -> {
                    WordMax wordMax = new WordMax();
                    while (scanner.hasNext()) {

                        wordMax.process(scanner.next());
                    }
                    max = wordMax;
                    System.out.println(max);
                }
                case "line" -> {
                    LineMax lineMax = new LineMax();
                    while (scanner.hasNextLine()) {

                        lineMax.process(scanner.nextLine());
                    }
                    max = lineMax;
                    System.out.println(max);
                }
            }
        }
    }
}