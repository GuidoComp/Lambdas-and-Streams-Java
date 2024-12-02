package com.debuggeando_ideas.util_function;

import java.io.*;
import java.util.Arrays;
import java.util.function.Function;

public class FunctionExample2 {
    static Function<Person, ByteArrayOutputStream> serializer = p -> {
        ByteArrayOutputStream inMemoryBytes = new ByteArrayOutputStream();
        try(ObjectOutputStream oos = new ObjectOutputStream(inMemoryBytes)) {
            oos.writeObject(p);
            oos.flush();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
        return inMemoryBytes;
    };

    static Function<ByteArrayInputStream, Person> deserializer = bais -> {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(bais)) {
            return (Person) objectInputStream.readObject();
        } catch(IOException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    };

    public static void main(String[] args) {
        ByteArrayOutputStream objectSerialized = serializer.apply(new Person("John", 30));
        System.out.println(Arrays.toString(objectSerialized.toByteArray()));

        Person objectDeserialized = deserializer.apply(new ByteArrayInputStream(objectSerialized.toByteArray()));

        System.out.println(objectDeserialized);
    }
}
