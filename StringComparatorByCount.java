package sorting;

import java.util.Comparator;

public class StringComparatorByCount implements Comparator<StringClass> {
    @Override
    public int compare(StringClass str1, StringClass str2) {
        return str1.getCounter().compareTo(str2.getCounter());
    }
}
