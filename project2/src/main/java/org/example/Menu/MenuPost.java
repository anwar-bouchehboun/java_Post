package org.example.Menu;


import org.example.dto.PostDto;
import org.example.dto.RespDTO.PostDtoResp;
import org.example.services.impl.PostServicesImpl;

import java.util.Scanner;

public class MenuPost {
  private  final PostServicesImpl postServices;
  private  final Scanner scanner;

    public MenuPost(PostServicesImpl postServices) {
        this.postServices = postServices;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nChoose an operation: create, update, delete, display, or exit:");
            String operation = scanner.nextLine().trim().toLowerCase();

            switch (operation) {
                case "create":
                    CreatePost();
                    break;
                case "update":
                    UpdatePost();
                    break;
                case "delete":
                    DeletePost();
                    break;
                case "display":
                    postServices.DisplayData();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid operation. Please try again.");
                    break;
            }
        }
    }
    private void CreatePost() {
        PostDto postDto = new PostDto();

        System.out.print("Enter post title: ");
        postDto.setTitle(scanner.nextLine());

        System.out.print("Enter post description: ");
        postDto.setDesc(scanner.nextLine());

        postServices.CreatePost(postDto);
    }

    private void UpdatePost() {
        PostDtoResp postDtoResp = new PostDtoResp();

        System.out.print("Enter post ID to update: ");
        postDtoResp.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter new post title: ");
        postDtoResp.setTitle(scanner.nextLine());

        System.out.print("Enter new post description: ");
        postDtoResp.setDesc(scanner.nextLine());

        postServices.UpdatePost(postDtoResp);
    }

    private void DeletePost() {
        PostDtoResp postDtoResp = new PostDtoResp();

        System.out.print("Enter post ID to delete: ");
        postDtoResp.setId(Integer.parseInt(scanner.nextLine()));

        postServices.DeletePost(postDtoResp);
    }
}
