package sorting;

import java.util.Comparator;

public class LongComparatorByValue implements Comparator<LongClass> {
    @Override
    public int compare(LongClass long1, LongClass long2) {
        return Long.compare(long1.getValue(), long2.getValue());
    }
}
