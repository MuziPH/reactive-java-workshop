package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        //StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(value -> System.out.print(value + " "));

        System.out.println();

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(value -> value < 5).forEach(value -> System.out.print(value + " "));

        System.out.println();

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(e -> e > 5)
                .skip(1)
                .limit(2)
                .forEach(e -> System.out.println(e + " "));


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        Integer i = StreamSources.intNumbersStream()
                .filter(element -> element > 5)
                .findFirst().orElse(-1);
        System.out.println("First number in intNumbersStream that's greater than 5: " + i);

        // Print first names of all users in userStream
        System.out.println("First Names of all users.");
        StreamSources.userStream().map(user -> user.getFirstName()).forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        // take element from stream
//        System.out.println("First Names of All Users with ID's in the number stream");
//        StreamSources.intNumbersStream()
//                .flatMap(intElement ->
//                        StreamSources.userStream().filter(user -> user.getId() == intElement)
//                )
//                .map(user -> user.getFirstName())
//                .forEach(System.out::println);

        // Better way of doing above
        System.out.println("First Names of all Users with ID's in the int stream.");
        StreamSources.userStream()
                .filter(user ->
                        StreamSources.intNumbersStream().anyMatch(intElement -> intElement == user.getId())
                )
                .forEach(System.out::println);
    }

}
