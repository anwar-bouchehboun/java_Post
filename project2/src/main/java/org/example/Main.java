package org.example;


import org.example.controller.CateController;
import org.example.controller.PostController;


import java.util.Scanner;



public class Main {
    public static void main(String[] args)  {
        Scanner choixMenu = new Scanner(System.in);

        while (true){
            System.out.println("\n--------------Main Menu-------------------");
            System.out.println("1. Gestion Post");
            System.out.println("2. Gestion Categ");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String mainOption = choixMenu.nextLine().trim();
            switch (mainOption){
                case "1": // Gestion Post Menu
                    PostController Menu = new PostController();
                    Menu.start();
                    break;
                case "2": // Gestion Categ
                    CateController MenuCat= new CateController();
                    MenuCat.startCat();
                    break;
                case "3": // Exit
                    System.out.println("Exiting Application...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }









    }
}