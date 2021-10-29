import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.BeforeEach;

        import static org.junit.jupiter.api.Assertions.*;

        import java.util.ArrayList;

public class StudentTest {

    @Test
    public void test() throws Exception {
        createHashTable();
        smallHashTable();
    }

    @Test
    public void createHashTable() throws Exception {
        HashTable<Integer, Integer> bob = new HashTable<>(5);
        bob.put(10, 5);
        bob.put(10, 6);
        bob.put(10, 8);
        bob.put(8,1);
        bob.put(8,4);
        bob.put(8,5);
        assertFalse(bob.containsKey(13));
        bob.put(13, 10);
        bob.put(18, 3);

        assertThrows(Exception.class, () -> {bob.get(2);});
        assertEquals(5, bob.get(8));
        assertEquals(8, bob.get(10));
        assertEquals(10, bob.get(13));
        assertTrue(bob.containsKey(10));
        assertTrue(bob.containsKey(13));

        bob.remove(10);
        bob.remove(14);
        bob.remove(13);

        assertFalse(bob.containsKey(13));
    }

    @Test
    public void smallHashTable() throws Exception{
        HashTable<String, Integer> table = new HashTable<>(10);
        table.put("anna", 19);
        table.put("claire", 21);
        table.put("kate", 18);
        table.put("kristine", 45);
        table.put("kristine", 48);

        assertEquals(18, table.get("kate"));
        assertTrue(table.containsKey("anna"));
        assertFalse(table.containsKey("bob"));
        assertFalse(table.containsKey("anne"));
        assertThrows(Exception.class, () ->{table.get("anne");});

        table.remove("kristine");
        table.remove("kris");
        assertThrows(Exception.class, ()->{table.get("kristine");});
    }


}
