import java.util.Random;

public class ArrayIndexer {

    private final String[] storage;
    private int count = 0;

    public ArrayIndexer() {
        this.storage = new String[10];
    }

    public void enqueue(String string) {
        this.storage[count++] = string;
    }

    public String dequeue() {
        int maxKey = count - 1;
        int randomKey = randomArrayIndex(count--);
        String string = storage[randomKey];
        storage[randomKey] = storage[maxKey];
        storage[maxKey] = null;
        return string;
    }

    public int count() {
        return count;
    }

    private int randomArrayIndex(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public String[] getArray() {
        return storage;
    }
}
