import java.io.*;

public class MyMain {
    public static void main(String[] args) {
        PersonList personList = new PersonList();

        try (PrintWriter writer = new PrintWriter(new FileWriter("persons.txt"))) {
            writer.println("John,Doe,001");
            writer.println("Jane,Smith,002");
            writer.println("Emily,Jones,003");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader("persons.txt")) {
            personList.store(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        personList.display(System.out);

        System.out.println("Finding ID 002: " + personList.find("002"));
        System.out.println("Finding ID 005: " + personList.find("005"));
    }
}
