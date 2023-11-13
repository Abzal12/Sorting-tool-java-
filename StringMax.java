package sorting;

public class StringMax extends Max<String> {
    @Override
    void process(String value) {

        total++;

        if (this.value == null) {

            times = 1;
            this.value = value;
            return;
        }

        if (value.length() > this.value.length()) {

            times = 1;
            this.value = value;
            return;
        }

        if (value.length() == this.value.length()) {

            int c = value.compareTo(this.value);

            if (c > 0) {

                times = 1;
                this.value = value;
                return;
            }
            if (c == 0) {

                times++;

            }
        }
    }
}
