// Hw1Q2/MyMain.java
package Hw1Q2;

import model.Person;  // Correct import statement
import java.io.*;
import java.util.LinkedList;

public class MyMain {

    // Static method to store persons from input stream into the linked list.
    public static void store(Reader inputStream, LinkedList<Person> list) {
        try (BufferedReader reader = new BufferedReader(inputStream)) {
            String line;
            // Read each line from the input stream and add Person objects to the list.
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    Person person = new Person(data[0], data[1], data[2]);
                    list.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Static method to display all persons in the linked list on the output stream.
    public static void display(PrintStream outputStream, LinkedList<Person> list) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    // Static method to find the index of a person by ID in the linked list.
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i; // Return the index if found.
            }
        }
        return -1; // Return -1 if not found.
    }

    public static void main(String[] args) {
        LinkedList<Person> persons = new LinkedList<>();

        // Read data from the existing file and store it in the list.
        try (FileReader fr = new FileReader("persons.txt")) { // Ensure "persons_v1.txt" exists.
            store(fr, persons);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display all persons and test finding functionality.
        display(System.out, persons);
        System.out.println("Finding ID 002: " + find("002", persons)); // Expected index 1
        System.out.println("Finding ID 005: " + find("005", persons)); // Expected -1 (not found)
    }
}
