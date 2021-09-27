import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {
    Streams tester = new Streams();
    @Test
    public void testing(){
        //List<E> result - JUnitCore.runClasses(TestJunit.class);
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> input = new ArrayList<Integer>();
        //input.add(1);
        input.add(4);
        input.add(5);
        input.add(10);
        result.add(4); result.add(4); result.add(4);
        result.add(5); result.add(5); result.add(5);
        result.add(10); result.add(10); result.add(10);
        assertEquals(tester.triplicate(input), result);
    }
    /*public void test_find_first_true(){
        //boolean[] A = {};
        //assertEquals(tester.find_first_true(A, 0, A.length), 0);


    }*/

}
