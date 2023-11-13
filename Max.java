package sorting;

public abstract class Max<T> {

    public T value;
    public int times;
    public int total;

    public int percentage() {

        return (times * 100) / total;
    }
    abstract void process(T value);
}
