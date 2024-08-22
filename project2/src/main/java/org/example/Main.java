package org.example;

import org.example.Menu.MenuPost;
import org.example.controller.PostController;

import java.sql.SQLException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner choixMenu = new Scanner(System.in);

        while (true){
            System.out.println("\n--------------Main Menu-------------------");
            System.out.println("1. Gestion Post");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            String mainOption = choixMenu.nextLine().trim();
            switch (mainOption){
                case "1": // Gestion Post Menu
                    PostController Menu = new PostController();
                    Menu.start();
                    break;
                case "2": // Exit
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }









    }
}