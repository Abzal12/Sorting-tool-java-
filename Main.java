package sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean isInput = false;
        boolean isOutput = false;
        for (String arg : args) {

            if (arg.equals("-inputFile")) {

                isInput = true;
            }
            if (arg.equals("-outputFile")) {

                isOutput = true;
            }
        }
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = null;

        if (isInput) {
            File file = new File(args[Arrays.asList(args).indexOf("-inputFile")] + 1);
            scanner = new Scanner(file);
        }

        if(isOutput) {
            File file = new File(args[Arrays.asList(args).indexOf("-outputFile")] + 1);
            writer = new FileWriter(file);
        }

        List<String> stringListSortingType = List.of("natural", "byCount");
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-sortingType")) {
                if (i + 1 > args.length - 1 || !stringListSortingType.contains(args[i + 1])) {
                    if (isOutput) {
                        writer.write("No sorting type defined!");
                        return;
                    }

                    System.out.println("No sorting type defined!");
                    return;

                }
            }
        }

        List<String> stringListDataType = List.of("long", "word", "line");
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-dataType")) {
                if (i + 1 > args.length - 1 || !stringListDataType.contains(args[i + 1])) {
                    if (isOutput) {
                        writer.write("No data type defined!");
                    }
                    System.out.println("No data type defined!");
                    return;
                }
            }
        }

        List<String> arrayListAllArgs = List.of("-sortingType", "natural", "byCount", "-dataType", "long", "word", "line");
        boolean mistake = false;
        for (String arg : args) {
            if (!arrayListAllArgs.contains(arg)) {
                if (isOutput) {
                    writer.append(String.valueOf('"')).append(arg).append(String.valueOf('"')).append(" is not a valid parameter. It will be skipped");
                } else {

                    System.out.println('"' + arg + '"' + " is not a valid parameter. It will be skipped");
                }
                mistake = true;
            }
        }
        if (mistake) {
            return;
        }

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
        if (isInput) {
            scanner.close();
        }

        if (isOutput) {
            writer.close();
        }
    }
}