package assignment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Methods {

    String nameOfPath;
    String oldNameFile;
    String newNameFile;
    String forCopy;
    String newCopy;
    String destinationFolder;

    public void listOfElementsMethod(String nameOfPath) {
        this.nameOfPath = nameOfPath;
        File path = new File(nameOfPath);
        System.out.println(" ");
        System.out.println("Folder contents : ");
        System.out.println(" ");
        if (path.exists() && path.isDirectory()) {
            String[] elements = path.list();
            for (String element : elements) {
                System.out.println(element);
            }
        }
    }

    public void informationsMethod(String nameOfPath) throws IOException {
        this.nameOfPath = nameOfPath;
        File path = new File(nameOfPath);
        System.out.println("Name = " + path.getName());
        System.out.println("Absolute Path = " + path.getAbsolutePath());
        System.out.println("Size = " + path.length() + "B");
        System.out.println("Date of creation = " + Files.readAttributes(path.toPath(), BasicFileAttributes.class).creationTime());
        Instant instant = Instant.ofEpochMilli(path.lastModified());
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy. HH:mm:ss");
        System.out.println("Date of last change = " + dateTime.format(dateTimeFormatter));

    }

    public void makeDirMethod(String nameOfPath) {
        this.nameOfPath = nameOfPath;
        File testDirectory = new File(nameOfPath);
        try {
            if (!testDirectory.exists()) {
                testDirectory.mkdir();
                System.out.println("Created a directory called " + testDirectory.getName());
            } else {
                System.out.println("Directory called " + testDirectory.getName() + " already exists.");
            }

        } catch (Exception e) {
            System.out.println("Couldn't create a directory called "
                    + testDirectory.getName());
        }

    }

    public void renameMethod(String oldNameFile, String newNameFile) {

        this.oldNameFile = oldNameFile;
        this.newNameFile = newNameFile;

        File oldfile = new File(oldNameFile);
        File newfile = new File(newNameFile);
        if (!oldfile.exists()) {
            System.out.println("File doesn't exists!");

        }
        if (newfile.exists()) {
            System.out.println("File with desired name already exists!");

        }
        if (oldfile.renameTo(newfile)) {
            System.out.println("Rename succesful");
        } else {
            System.out.println("Rename failed");
        }

    }

    public void copyMethod(String forCopy, String newCopy) {
        this.forCopy = forCopy;
        this.newCopy = newCopy;
        File forCopyFile = new File(forCopy);
        File copiedFile = new File(newCopy);

        try (FileInputStream inStream = new FileInputStream(forCopyFile);
                FileOutputStream outStream = new FileOutputStream(copiedFile);) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File is copied successfuly!");
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }

    public void moveMethod(String nameOfPath, String destinationFolder) {
        this.nameOfPath = nameOfPath;
        this.destinationFolder = destinationFolder;

        File afile = new File(nameOfPath);
        File bfile = new File(destinationFolder + "\\" + afile.getName());

        try (FileInputStream inStream = new FileInputStream(afile);
                FileOutputStream outStream = new FileOutputStream(bfile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File is moved successfuly!");

            inStream.close();
            outStream.close();

            afile.delete();
        } catch (IOException exc) {
            System.out.println(exc);
        }

    }

    public void deleteMethod(String nameOfPath) {
        this.nameOfPath = nameOfPath;
        File file = new File(nameOfPath);
        if (file.exists()) {
            file.delete();
            System.out.println("File successfully deleted!");
        } else {
            System.out.println("Cannot delete " + file.getName() + " because " + file.getName() + " does not exist.");
        }
    }

}
