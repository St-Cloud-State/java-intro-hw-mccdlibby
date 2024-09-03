// Hw1Q3/MyMainV2.java
package Hw1Q3;

import java.io.*;

public class MyMainV2 {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        // Read data from the existing file and store it in the PersonList.
        try (FileReader fr = new FileReader("persons.txt")) { // Ensure "persons_v2.txt" exists.
            personList.store(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display all persons and test finding functionality.
        personList.display(System.out);
        System.out.println("Finding ID 002: " + personList.find("002")); // Expected index 1
        System.out.println("Finding ID 005: " + personList.find("005")); // Expected -1 (not found)
    }
}
