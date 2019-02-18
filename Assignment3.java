package assignment3;

import java.io.IOException;
import java.util.Scanner;

public class Assignment3 {

    public static void main(String[] args) throws IOException {

        System.out.println("You must enter one of these options with the same number.You have these options :\n" +
"        1 : List of folder contents\n" +
"        2 : Display information about files / folders in a transparent form\n" +
"        3 : Create a folder\n" +
"        4 : Change the name of the file / folder,\n" +
"        5 : Copy files / complete folders\n" +
"        6 : Moving files / complete folders\n" +
"        7 : Delete files / folders ");
        Scanner scanChoice = new Scanner(System.in);
         int choice = scanChoice.nextInt();

        if ((choice > 0) && (choice <= 7)) {
            
            if (choice == 1) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter absolute path : ");
                String path1 = scan.nextLine();
                Methods list = new Methods();
                list.nameOfPath = path1;
                list.listOfElementsMethod(path1);
            }
            if (choice == 2) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter file or folder to get inofmation : ");
                String path2 = scan.nextLine();
                Methods info = new Methods();
                info.nameOfPath = path2;
                info.informationsMethod(path2);
            }
            if (choice == 3) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter absolute path for directory which you want to create : ");
                String path3 = scan.nextLine();
                Methods createDir = new Methods();
                createDir.nameOfPath = path3;
                createDir.makeDirMethod(path3);
            }
            if (choice == 4) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the old filename / folder name : ");
                String path4 = scan.nextLine();
                System.out.println("Enter the new filename / folder name : ");
                String path5 = scan.nextLine();
                Methods renameFileDir = new Methods();
                renameFileDir.oldNameFile = path4;
                renameFileDir.newNameFile = path5;
                renameFileDir.renameMethod(path4, path5);
            }

            if (choice == 5) {
                Scanner scan= new Scanner(System.in);
                System.out.println("Enter the  filename / folder name which you want to copy : ");
                String path6 = scan.nextLine();
                System.out.println("Enter the new filename / folder name  : ");
                String path7 = scan.nextLine();
                Methods copyFileFolders = new Methods();
                copyFileFolders.forCopy = path6;
                copyFileFolders.newCopy = path7;
                copyFileFolders.copyMethod(path6, path7);
            }
            if (choice == 6) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter file path: ");
                String path8 = scan.nextLine();
                System.out.println("Enter destination folder: ");
                String path9 = scan.nextLine();
                Methods moveFileDir = new Methods();
                moveFileDir.nameOfPath = path8;
                moveFileDir.destinationFolder = path9;
                moveFileDir.moveMethod(path8, path9);
            }
            if (choice == 7) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter absolute path which you want to delete : ");
                String path10 = scan.nextLine();
                Methods deleteFileDir = new Methods();
                deleteFileDir.nameOfPath = path10;
                deleteFileDir.deleteMethod(path10);
            }

        } else {
            System.out.println("Enter correct number !");
        }

    }
}
