import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    Search tester= new Search();
    @Test
    public void test_find_first_true(){
        boolean[] A = {};
        assertEquals(tester.find_first_true(A, 0, A.length), 0);


    }

}
