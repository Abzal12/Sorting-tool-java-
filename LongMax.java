package sorting;

public class LongMax extends Max<Long>{
    @Override
    void process(Long value) {

        total++;

        if (this.value == null) {

            times = 1;
            this.value = value;
            return;
        }

        int c = value.compareTo(this.value);

        if (c == 0) {

            times++;
            return;
        }

        if (c > 0) {

            times = 1;
            this.value = value;
        }
    }

    @Override
    public String toString() {

        return "Total lines: " + total + "\n"
                + "The greatest number: " + value + "\n(" + times + " time(s), "
                + percentage() + "%.)" + "\n";
    }
}
