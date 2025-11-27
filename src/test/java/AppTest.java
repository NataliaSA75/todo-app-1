import org.example.ToDoList;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class AppTest {
    @Test
    void addAndList() {
        ToDoList t = new ToDoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }
    @Test
    void remove() {
        ToDoList t = new ToDoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }
    @Test
    void addEmptyIgnored() {
        ToDoList t = new ToDoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    @Test
    void clear() {
        ToDoList t = new ToDoList();
        t.add("task1");
        t.add("task2");
        assertTrue(t.clear());
        assertEquals(0, t.size());
    }

    @Test
    void done() {
        ToDoList t = new ToDoList();
        t.add("Buy milk");
        String result = t.done(0);
        assertEquals("Buy milk -- completed", result);
    }

    @Test
    void search() {
        ToDoList t = new ToDoList();
        t.add("Buy milk");
        t.add("Read book");
        Set<String> result = t.search("Buy");
        assertEquals(1, result.size());
        assertTrue(result.contains("Buy milk"));
    }
}
