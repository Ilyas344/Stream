
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(randomList().toArray(new Integer[0]));


        findMinMax(
                stream,
                Comparator.naturalOrder(),
                (x, y) -> System.out.println("Минимальное число " + x + ", максимальное число " + y)
        );

        System.out.println("Количество четных чисел " + countEvenNumber(randomList()));
    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        ArrayList<T> arrayList = stream
                .sorted(order)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);
        T min = null;
        T max = null;
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }

    public static Integer countEvenNumber(List<Integer> number) {
        return Math.toIntExact(number.stream()
                .filter(x -> x % 2 == 0)
                .peek(System.out::println)
                .count());
    }

    public static List<Integer> randomList() {
        List<Integer> number;
        return number = new Random()
                .ints(0, 100)
                .limit(10)
                .boxed().toList();
    }

}