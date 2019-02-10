import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIndexerTest {
    @Test
    void it_enqueues_an_item_onto_the_data_structure() {
        ArrayIndexer indexer = new ArrayIndexer();
        indexer.enqueue("foo");
    }

    @Test
    void it_dequeues_an_item() {
        String expected = "foo";
        ArrayIndexer indexer = new ArrayIndexer();

        indexer.enqueue(expected);
        String result = indexer.dequeue();

        assertSame(expected, result);
    }

    @Test
    void it_maintains_an_item_count() {
        String expected1 = "foo";
        String expected2 = "fiz";
        ArrayIndexer indexer = new ArrayIndexer();

        int c0 = indexer.count();
        assertSame(0, c0);

        indexer.enqueue(expected1);
        int c1 = indexer.count();
        assertSame(1, c1);

        indexer.enqueue(expected2);
        int c2 = indexer.count();
        assertSame(2, c2);

        String result = indexer.dequeue();
        int c3 = indexer.count();
        assertSame(1, c3);
    }

    @Test
    void it_returns_a_random_array_item() {
        ArrayIndexer indexer = new ArrayIndexer();
        String[] strings = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        for (int i = 0; i < strings.length; i++) {
            indexer.enqueue(strings[i]);
        }

        String result = indexer.dequeue();
        Logger.getAnonymousLogger().info(result);
        assertNotSame(result, "k");
    }

    @Test
    void it_maintains_a_sequential_array_index() {
        String string1 = "foo";
        String string2 = "fiz";
        String string3 = "baz";
        ArrayIndexer indexer = new ArrayIndexer();

        assertSame(0, indexer.count());

        indexer.enqueue(string1);
        assertSame(1, indexer.count());

        indexer.enqueue(string2);
        assertSame(2, indexer.count());

        String result = indexer.dequeue();
        assertSame(1, indexer.count());
        assertNotNull(result);

        indexer.enqueue(string3);
        assertSame(2, indexer.count());

        indexer.enqueue(result);
        assertSame(3, indexer.count());

        result = indexer.dequeue();
        assertSame(2, indexer.count());
        assertNotNull(result);

        indexer.enqueue(result);
        assertSame(3, indexer.count());

        result = indexer.dequeue();
        assertSame(2, indexer.count());
        assertNotNull(result);

        indexer.enqueue(result);
        assertSame(3, indexer.count());

        String[] array = indexer.getArray();
        for (int i = 0; i < indexer.count(); i++) {
            assertNotNull(array[i]);
        }
    }


}