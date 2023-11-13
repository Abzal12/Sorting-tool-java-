package sorting;

public class LineMax extends StringMax{

    @Override
    public String toString() {

        return "Total lines: " +
                total +
                '.' +
                '\n' +
                "The longest line:\n" +
                value +
                "\n(" +
                times +
                " time(s), " +
                percentage() +
                "%.)" +
                '\n';

    }
}
