import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Objects;

class Streams {

    public static <E> List<E> triplicate (List<E> xs) {
        // TODO
        return xs.stream().flatMap(x-> Stream.of(x,x,x)).collect(Collectors.toList());
    }

    public static List<Integer> square (List<Integer> xs) {
        // TODO
        return xs.stream().map(x->x*x).collect(Collectors.toList());
    }

    public static boolean allEven (List<Integer> xs) {
        // TODO
        return xs.stream().allMatch(x -> (x%2==0));
    }

    public static List<Integer> evens (List<Integer> xs) {
        // TODO
        return xs.stream().filter(x -> (x%2==0)).collect(Collectors.toList());
    }

    public static int product(List<Integer> xs) {
        // TODO
        int result = xs.stream().reduce(1, (x,y)->x*y); //default value is 1, takes 1 and multiplies by next value
        return result;
    }

    static <E1, E2, R> Stream<R> zip(Stream<E1> s1, Stream<E2> s2, BiFunction<E1, E2, R> combiner) {
        final var i2 = s2.iterator();
        return s1.map(x1 -> i2.hasNext() ? combiner.apply(x1, i2.next()) : null)
                .takeWhile(Objects::nonNull);
    }

    public static int dot_product(List<Integer> xs, List<Integer> ys) {
	// TODO
        BiFunction<Integer, Integer, Integer> combiner = (a,b) -> a*b;
        return zip(xs.stream(), ys.stream(), combiner).reduce(0, (x,y)->x+y);
        //return result.reduce(0, (x,y)->x+y);
    }

    public static List<Integer> matrix_vector_multiply(List<List<Integer>> mat, List<Integer> vec) {
	// TODO
        BiFunction<Integer, Integer, Integer> combiner = (a,b) -> a*b;
        //mat.stream().forEach(x-> System.out.print(x));
        int result;
        List<Integer> returnList = new ArrayList<Integer>();
        for(List<Integer> list: mat){
            result=zip(list.stream(),vec.stream(),combiner).reduce(0, (x,y)->x+y);
            returnList.add(result);
        }
	    return returnList;
    }

    public static int lengths (List<String> xs) {
        // TODO
        return xs.stream().flatMapToInt(str-> IntStream.of(str.length())).reduce(0, (x,y)->x+y);
        /*int sum = 0;
        List<Integer> ints=new ArrayList<Integer>();
        xs.stream().forEach(x -> ints.add(x.length()));
        return ints.stream().reduce(0, (x,y)->x+y);*/
    }
}

