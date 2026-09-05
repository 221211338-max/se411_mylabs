import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Exercise 1
        System.out.println("Exercise 1:");

        String[] words = {"Java", "Generics", "SE411"};

        PrintableList<String> printableList =
                new PrintableList<>(words);

        printableList.printItems();


        // Exercise 2
        System.out.println("\nExercise 2:");

        NumberBox<Integer> integerBox = new NumberBox<>();
        integerBox.setItem(10);

        System.out.println("Integer item: "
                + integerBox.getItem());

        System.out.println("10 + 5 = "
                + integerBox.add(5));

        List<Integer> integerNumbers =
                List.of(1, 2, 3, 4, 5);

        System.out.println("Integer sum: "
                + NumberBox.sumNumbers(integerNumbers));


        NumberBox<Double> doubleBox = new NumberBox<>();
        doubleBox.setItem(10.5);

        System.out.println("Double item: "
                + doubleBox.getItem());

        System.out.println("10.5 + 5.5 = "
                + doubleBox.add(5.5));

        List<Double> doubleNumbers =
                List.of(1.5, 2.5, 3.5);

        System.out.println("Double sum: "
                + NumberBox.sumNumbers(doubleNumbers));


        // Exercise 3
        System.out.println("\nExercise 3:");

        PipeLine<String, String> textPipeline =
                PipeLine.<String>start()
                        .addTransformer(String::trim)
                        .addTransformer(String::toUpperCase);

        String textResult =
                textPipeline.execute("   hello generics   ");

        System.out.println(textResult);


        PipeLine<String, Integer> lengthPipeline =
                PipeLine.<String>start()
                        .addTransformer(String::trim)
                        .addTransformer(String::length);

        int length =
                lengthPipeline.execute("   SE411   ");

        System.out.println("Length: " + length);


        PipeLine<String, String> changingPipeline =
                PipeLine.<String>start()
                        .addTransformer(String::trim)
                        .addTransformer(String::length)
                        .addTransformer(
                                value -> "Length = " + value);

        System.out.println(
                changingPipeline.execute("   Generics   "));


        // Exercise 4
        System.out.println("\nExercise 4:");

        List<String> names =
                List.of("Ali", "Sara", "Faisal");

        printList(names);

        List<Integer> numbers =
                List.of(10, 20, 30);

        System.out.println(
                "Sum: " + sumNumbers(numbers));
    }

    public static void printList(List<?> list) {

        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static double sumNumbers(
            List<? extends Number> numbers) {

        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }
}