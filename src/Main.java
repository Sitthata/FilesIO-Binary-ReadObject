import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    private static String FILE_PATH = "data.dat";

    public static void main(String[] args) {

    }

    public static void objectOutput(List<Student> studentList, Teacher teacher) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(studentList);
            oos.writeObject(teacher);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void objectInput() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj1 = ois.readObject();
            if(obj1 instanceof List<?>) {
                List<Student> studentList = (List<Student>) obj1;
                studentList.forEach(System.out::println);
            }

            Object obj2 = ois.readObject();
            if(obj2 instanceof Teacher) {
                Teacher teacher = (Teacher) obj2;
                System.out.println(teacher);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}