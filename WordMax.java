package sorting;

public class WordMax extends StringMax{

    @Override
    public String toString() {
        return "Total words: " +
                total +
                '.' +
                '\n' +
                "The longest word: " +
                value +
                " (" +
                times +
                " time(s), " +
                percentage() +
                "%.)" +
                '\n';
    }
}
