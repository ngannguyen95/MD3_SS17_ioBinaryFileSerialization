import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    //ghi file
    public static void writeToFile(String path, List<Student> students) {
        File file = null;
        try {
            file=new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String PATH_FILE = "C:\\Users\\Admin\\Desktop\\rikkei_data\\Java\\A.Test\\ioBinaryFile_Serializetion\\src\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Trịnh Đức Toàn", "Hà Nội"));
        students.add(new Student(2, "Lê Việt Dũng", "Phú Thọ"));
        students.add(new Student(3, "Phùng Trung Dũng", "Hà Nội"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Đồng Chính", "Hải Dương"));
        writeToFile(PATH_FILE, students);
        List<Student> studentDataFromFile = readDataFromFile(PATH_FILE);
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        File file=null;
        try {
            file=new File(path);
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                students = (List<Student>) ois.readObject();
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}
