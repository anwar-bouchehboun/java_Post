package org.example.controller;

import org.example.dto.CatDto;
import org.example.dto.RespDTO.CateDtoResp;
import org.example.dto.RespDTO.PostDtoResp;
import org.example.services.impl.CatServiceImp;

import java.util.Scanner;

public class CateController {

    private final CatServiceImp catServiceImp;
    private  final Scanner choixCategorie;


    public CateController(){
        this.catServiceImp=new CatServiceImp();
        this.choixCategorie=new Scanner(System.in);
    }

    public void startCat(){
        while (true) {
            System.out.println("\nChoose an operation: create, update, delete, display, or exitcate:");
            String operation = choixCategorie.nextLine().trim().toLowerCase();

            switch (operation) {
                case "create":
                    CreateCate();
                    break;
                case "update":
                    UpdateCate();
                    break;
                case "delete":
                   DeleteCat();
                    break;
                case "display":
                    catServiceImp.DisplayDataCat();
                    break;
                case "exit":
                    System.out.println("Exiting Cate...");
                    return;
                default:
                    System.out.println("Invalid operation. Please try again.");
                    break;
            }
        }


    }
    private void CreateCate() {
        CatDto catDto = new CatDto();

        System.out.print("Enter  Categorie: ");
        catDto.setCategory(choixCategorie.nextLine());

        System.out.print("Enter post ID: ");
        catDto.setPostid(Integer.parseInt(choixCategorie.nextLine()));

        catServiceImp.CreateCat(catDto);
    }
    private  void UpdateCate(){
        CatDto cateDto= new CatDto();
        System.out.print("Enter  Categorie: ");
        cateDto.setCategory(choixCategorie.nextLine());
        System.out.print("Enter post ID: ");
        cateDto.setPostid(Integer.parseInt(choixCategorie.nextLine()));
        System.out.print("Enter where Categorie ID: ");
        cateDto.setId(Integer.parseInt(choixCategorie.nextLine()));
        catServiceImp.UpdateCat(cateDto);

    }
    public void DeleteCat(){
        CatDto cateDto = new CatDto();

        System.out.print("Enter Cate ID to delete: ");
        cateDto.setId(Integer.parseInt(choixCategorie.nextLine()));

        catServiceImp.DeleteCat(cateDto);
    }

}
