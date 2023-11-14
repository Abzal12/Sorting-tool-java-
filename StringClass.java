package sorting;

import org.jetbrains.annotations.NotNull;

public class StringClass{

    private final String value;
    private final String counter;


    public StringClass(String value, String counter) {
        this.value = value;
        this.counter = counter;
    }

    public String getValue() {
        return value;
    }

    public String getCounter() {
        return counter;
    }
}
