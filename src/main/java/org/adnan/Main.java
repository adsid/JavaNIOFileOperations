package org.adnan;

import javax.tools.StandardJavaFileManager;
import java.io.IOException;
import java.nio.*;
import java.nio.file.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        Properties props = System.getProperties();
        String prop = System.getProperty("line.separator");

        // åm.createDirectory("Adnan");
        // åm.createFile("Adnan/data.txt");
        //m.readFile("Adnan/data.txt");
        // m.writeToFile("Adnan/newFile.tst", "Welcome to coding....");
//        m.copyFile("Adnan/poem.txt", "Adnan/newPoem2.txt");
        m.appendToFile("Adnan/data.txt", Main.getLongDataForFile());
    }

    private static String getLongDataForFile() {
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append(date.toString());
        sb.append(System.getProperty("line.separator"));
        sb.append("Bismillah hir Rahman hir Raheem");
        sb.append(System.getProperty("line.separator"));
        sb.append("Full Name: Adnan A. Siddiqui");
        sb.append(System.getProperty("line.separator"));
        sb.append("Address: 4601 Jalbert Drive, VA 23060");
        sb.append(System.getProperty("line.separator"));
        sb.append(System.getProperty("line.separator"));
        return sb.toString();
    }

    public void readFile(String fileName) {
        try {
            Path p = Paths.get(fileName);
            List<String> linesFromFile = Files.readAllLines(p);
            for (String s:linesFromFile) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName1, String fileName2) {
        try {
            Path sPath = Paths.get(fileName1);
            Path dPath = Paths.get(fileName2);
            Files.copy(sPath, dPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createDirectory(String directoryName) {
        try {
            Path p = Paths.get(directoryName);
            if (Files.exists(p)) {
                System.out.println("Directory already exists");
            } else {
                Path donePath = Files.createDirectories(p);
                System.out.println("Directory created at " + donePath.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName) {
        try {
            Path p = Paths.get(fileName);
            if (Files.exists(p)) {
                System.out.println("File already exists");
            } else {
                Path donePath = Files.createFile(p);
                System.out.println("File is created: " + donePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String fileName, String content) {
        try {
            Path p = Paths.get(fileName);
            Path newPath = Files.createFile(p);
            Files.write(newPath, content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendToFile(String fileName, String content) {
        String newLine = System.getProperty("line.separator");
        try {
            Path p = Paths.get(fileName);
            Files.write(p, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.write(p, newLine.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.write(p, System.getProperty("line.separator").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Data written by Byte Array");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}