package sorting;

import java.util.Comparator;

public class LongComparatorByCount implements Comparator<LongClass> {

    @Override
    public int compare(LongClass counter1, LongClass counter2) {
        return Long.compare(counter1.getCounter(), counter2.getCounter());
    }
}
