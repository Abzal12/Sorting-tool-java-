package sorting;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // if the -sortingType argument is provided, it should be followed by natural or byCount,
        // which defines the sorting type.
        if ((Arrays.asList(args).contains("-sortingType") && Arrays.asList(args).contains("natural"))
                || args[0].equals("-dataType")) {

            if (Arrays.asList(args).contains("long")) {

                List<Long> longList = new ArrayList<>();
                while (scanner.hasNextLong()) {

                    longList.add(scanner.nextLong());
                }
                Collections.sort(longList);

                System.out.printf("Total numbers: %d%n" +
                        "Sorted data: %s", longList.size(), longList.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", " "));

            } else if (Arrays.asList(args).contains("word")) {

                List<String> wordList = new ArrayList<>();
                while (scanner.hasNext()) {

                    wordList.add(scanner.next());
                }
                Collections.sort(wordList);

                System.out.printf("Total numbers: %d%n" +
                        "Sorted data: %s", wordList.size(), wordList.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", " "));
                
            } else if (Arrays.asList(args).contains("line")) {

                List<String> lineList = new ArrayList<>();
                while (scanner.hasNextLine()) {

                    lineList.add(scanner.nextLine());
                }
                Collections.sort(lineList);

                System.out.println("Total lines: " + lineList.size());
                System.out.println("Sorted data:");
                lineList.forEach(System.out::println);
            }
        } else if (Arrays.asList(args).contains("-sortingType") && Arrays.asList(args).contains("byCount")) {

            if (Arrays.asList(args).contains("long")) {

                List<Long> longList = new ArrayList<>();
                while (scanner.hasNextInt()) {

                    longList.add(scanner.nextLong());
                }

                Set<Long> hashSet = new HashSet<>(longList);
                List<LongClass> longClassList2 = new ArrayList<>();
                for (Long longNum : hashSet) {
                    longClassList2.add(new LongClass(longNum, Collections.frequency(longList, longNum)));
                }

                longClassList2.sort(new LongComparatorByValue());
                longClassList2.sort(new LongComparatorByCount());
                System.out.println("Total number: " + longList.size());
                for (LongClass longClass : longClassList2) {

                    System.out.println(longClass.getValue() + ":" +
                            longClass.getCounter() + " time(s), " +
                            (longClass.getCounter() * 100) / longList.size() + "%");
                }

            } else if (Arrays.asList(args).contains("word")) {

                List<String> stringList = new ArrayList<>();
                while (scanner.hasNext()) {

                    stringList.add(scanner.next());
                }

                Set<String> hashSet = new HashSet<>(stringList);
                List<StringClass> stringClassList2 = new ArrayList<>();
                for (String str : hashSet) {
                    stringClassList2.add(new StringClass(str, Integer.toString(Collections.frequency(stringList, str))));
                }

                stringClassList2.sort(new StringComparatorByValue());
                stringClassList2.sort(new StringComparatorByCount());

                System.out.println("Total number: " + stringList.size());
                for (StringClass stringClass : stringClassList2) {

                    System.out.println(stringClass.getValue() + ":" +
                            stringClass.getCounter() + " time(s), " +
                            (Integer.parseInt(stringClass.getCounter()) * 100) / stringList.size() + "%");
                }
            } else if (Arrays.asList(args).contains("line")) {

                List<String> stringList = new ArrayList<>();
                while (scanner.hasNextLine()) {

                    stringList.add(scanner.nextLine());
                }
                Set<String> hashSet = new HashSet<>(stringList);
                List<StringClass> stringClassList2 = new ArrayList<>();
                for (String str : hashSet) {
                    stringClassList2.add(new StringClass(str, Integer.toString(Collections.frequency(stringList, str))));
                }

                stringClassList2.sort(new StringComparatorByValue());
                stringClassList2.sort(new StringComparatorByCount());
                System.out.println("Total line(s): " + stringList.size());
                for (StringClass stringClass : stringClassList2) {

                    System.out.println(stringClass.getValue() + ":" +
                            stringClass.getCounter() + " time(s), " +
                            (Integer.parseInt(stringClass.getCounter()) * 100) / stringList.size() + "%");
                }
            }
        }
    }
}