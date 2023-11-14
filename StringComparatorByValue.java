package sorting;

import java.util.Collections;
import java.util.Comparator;

public class StringComparatorByValue implements Comparator<StringClass> {

    @Override
    public int compare(StringClass str1, StringClass str2) {
        return str1.getValue().compareTo(str2.getValue());
    }
}
