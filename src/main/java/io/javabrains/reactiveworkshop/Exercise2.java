package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e));

        Flux<Integer> integerFlux = ReactiveSources.intNumbersFlux();
        integerFlux.subscribe(e -> System.out.println("Another one " + e));

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));
        // To keep the main program from exiting before the stream ends its operations
        System.out.println("Press a key to end");
        System.in.read();
    }

}
