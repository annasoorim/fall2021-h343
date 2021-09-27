import java.util.*;

public class StreamTester {
    public static void main(String[] args) {
        Streams test = new Streams();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> input = new ArrayList<Integer>();
        //input.add(1);
        input.add(4);
        input.add(5);
        input.add(10);
        result.add(3);
        result.add(2);
        result.add(4);
        List<String> blah = new ArrayList<String>();
        blah.add("hello");
        blah.add("h");

        List<Integer> vector = new ArrayList<>();
        vector.add(2);
        vector.add(4);
        vector.add(1);

        List<List<Integer>> a = new ArrayList<>();
        a.add(input);
        a.add(result);
        //System.out.println(test.matrix_vector_multiply(a, vector));


        //input=test.square(input);
        //System.out.println(input);
        System.out.println(test.lengths(blah));
        //System.out.println(test.triplicate(input));
        //System.out.println(test.dot_product(result, input));
        //System.out.println(input);


    }
}
