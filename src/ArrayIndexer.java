import java.util.Random;

public class ArrayIndexer {

    private final String[] storage;
    private int arrayCount = 0;

    public ArrayIndexer() {
        this.storage = new String[10];
    }

    public void enqueue(String string) {
        this.storage[arrayCount++] = string;
    }

    public String dequeue() {
        int maxKey = arrayCount - 1;
        int randomKey = randomArrayIndex(arrayCount--);
        String string = storage[randomKey];
        storage[randomKey] = storage[maxKey];
        storage[maxKey] = null;
        return string;
    }

    public int count() {
        return arrayCount;
    }

    private int randomArrayIndex(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public String[] getArray() {
        return storage;
    }
}
