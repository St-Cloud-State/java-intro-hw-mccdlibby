// Hw1Q3/PersonList.java
package Hw1Q3;

import model.Person;  // Correct import statement
import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> list;

    // Constructor initializes the linked list.
    public PersonList() {
        list = new LinkedList<>();
    }

    // Method to store persons from input stream into the list.
    public void store(Reader inputStream) {
        try (BufferedReader reader = new BufferedReader(inputStream)) {
            String line;
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

    // Method to display all persons in the list on the output stream.
    public void display(PrintStream outputStream) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    // Method to find the index of a person by ID in the list.
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
