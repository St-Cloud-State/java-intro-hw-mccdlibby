import java.io.*;
import java.util.LinkedList;

public class PersonList {
    private LinkedList<Person> list;

    public PersonList() {
        list = new LinkedList<>();
    }

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

    public void display(PrintStream outputStream) {
        for (Person person : list) {
            outputStream.println(person);
        }
    }

    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}
