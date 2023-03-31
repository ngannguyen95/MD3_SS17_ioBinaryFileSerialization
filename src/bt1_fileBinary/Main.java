package bt1_fileBinary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import static java.io.File.*;

public class Main {

    private static void copyFileUsingJava7File(File souce, File dest) throws IOException {
        Files.copy(souce.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int lenght;
            while ((lenght = is.read(buffer)) > 0) {
                os.write(buffer, 0, lenght);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Đường dẫn file đầu:: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Đường dẫn file cuối");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            copyFileUsingJava7File(sourceFile, destFile);
            System.out.println("Hoàn tất sao chép");
        } catch (IOException e) {
            System.out.println("Không thể sao chép tập tin");
            System.out.println(e.getMessage());
        }
    }
}
