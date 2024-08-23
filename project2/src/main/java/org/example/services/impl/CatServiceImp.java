package org.example.services.impl;

import org.example.db.DB;
import org.example.dto.CatDto;
import org.example.dto.RespDTO.CateDtoResp;

import org.example.services.CatInterface;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CatServiceImp implements CatInterface {

      private final Connection connection;
      public CatServiceImp(){
       connection= DB.getConnerction();
      }
    public HashMap<Integer, CateDtoResp> GetDataCate() {
        HashMap<Integer, CateDtoResp> CattMap = new HashMap<>();
        String sql = "SELECT categorie.id, categorie.category, post.title FROM categorie JOIN post ON categorie.postid = post.id";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                CateDtoResp p = new CateDtoResp();
                p.setId(resultSet.getInt("id"));
                p.setCategory(resultSet.getString("category"));
                p.setTitle(resultSet.getString("title"));


                CattMap.put(p.getId(), p);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching data from 'categorie' table", e);
        }

        return CattMap;
    }

    public void DisplayDataCat(){
        HashMap<Integer, CateDtoResp> Cat = GetDataCate();

        // Print the table header
        System.out.printf("%-10s | %-20s | %-50s | %n", "ID", "Categorie", "Post");
        System.out.println("-------------------------------------------------------------------------------------");

        // Print each entry in a formatted way
        for (Map.Entry<Integer, CateDtoResp> entry : Cat.entrySet()) {
            CateDtoResp cate = entry.getValue();
            System.out.printf("%-10d | %-20s | %-50s | %n", cate.getId(), cate.getCategory(), cate.getTitle());
        }

    }


public int getPostCount(int id) {
    String checkSql = "SELECT COUNT(*) FROM post WHERE id = ?";
    try (PreparedStatement checkStatement = connection.prepareStatement(checkSql)) {
        checkStatement.setInt(1, id); // Set the parameter value

        try (ResultSet resultSet = checkStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
    } catch (SQLException e) {
        System.out.println("Post id Faild .");
    }
    return 0;
}


    public  void CreateCat(CatDto Cateog)  {
        try {


            int postCount = getPostCount(Cateog.getPostid());
            if (postCount>0){
                String sql = "INSERT INTO categorie (`category`, `postid`)  VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,Cateog.getCategory());
                preparedStatement.setInt(2,Cateog.getPostid());
                int CreateCat= preparedStatement.executeUpdate();
                if(CreateCat>0){
                    System.out.println("Cat created successfully.");
                    this.DisplayDataCat();
                }

            }else{
                System.out.println("Post id Faild .");

            }
        } catch (SQLException e) {
            System.out.println("Failed to create Cat   Failed .");
        }



    }
}
