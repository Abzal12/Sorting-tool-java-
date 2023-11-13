package sorting;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        if (Arrays.asList(args).contains("-sortIntegers")) {
            List<Integer> integerList = new ArrayList<>();
            while (scanner.hasNextInt()) {

                integerList.add(scanner.nextInt());
            }
            Collections.sort(integerList);

            System.out.printf("Total numbers: %d%n" +
                            "Sorted data: %s", integerList.size(), integerList.toString()
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", " "));

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