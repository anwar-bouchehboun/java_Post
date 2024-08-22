package org.example.services.impl;

import lombok.Data;
import org.example.db.DB;
import org.example.dto.PostDto;
import org.example.dto.RespDTO.PostDtoResp;
import org.example.services.PostInterface;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Data

public class PostServicesImpl implements PostInterface {

   private Connection connection;
    public PostServicesImpl() {
        connection = DB.getConnerction();
    }

    public HashMap<Integer, PostDtoResp> GetDataPost() {
        HashMap<Integer, PostDtoResp> postMap = new HashMap<>();
        try {
            String sql = "SELECT * FROM post";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                PostDtoResp p = new PostDtoResp();
                p.setId(resultSet.getInt("id"));
                p.setTitle(resultSet.getString("title"));
                p.setDesc(resultSet.getString("desc"));
                postMap.put(p.getId(), p);
            }

            return postMap;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DisplayData() {
        HashMap<Integer, PostDtoResp> posts = GetDataPost();

        // Print the table header
        System.out.printf("%-10s | %-20s | %-50s | %n", "ID", "Title", "Description");
        System.out.println("-------------------------------------------------------------------------------");

        // Print each entry in a formatted way
        for (Map.Entry<Integer, PostDtoResp> entry : posts.entrySet()) {
            PostDtoResp post = entry.getValue();
            System.out.printf("%-10d | %-20s | %-50s | %n", post.getId(), post.getTitle(), post.getDesc());
        }
    }
//create post
    public void CreatePost(PostDto post) {
        try {
            String sql = "INSERT INTO post (`title`, `desc`) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getDesc());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Post created successfully.");
                this.DisplayData();

            } else {
                System.out.println("Failed to create post.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error creating post", e);
        }
    }
    // update Poste
   public void UpdatePost(PostDtoResp post){
   try {
       String sql = "UPDATE post SET title = ?, `desc` = ? WHERE id = ?";
       PreparedStatement preparedStatement=connection.prepareStatement(sql);
       preparedStatement.setString(1, post.getTitle());
       preparedStatement.setString(2, post.getDesc());
       preparedStatement.setInt(3, post.getId());
       int update = preparedStatement.executeUpdate();
       if (update > 0) {
           System.out.println("Post update successfully.");
           this.DisplayData();

       } else {
           System.out.println("Failed to update post.");
       }
       } catch (Exception e) {
    throw new RuntimeException(e);
       }
   }

    @Override
    public void DeletePost(PostDtoResp post) {
        try {
            String sql="DELETE FROM `post` WHERE id = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setInt(1,post.getId());
            int delete = preparedStatement.executeUpdate();
            if (delete > 0) {
                System.out.println("Post delete successfully.");
               this.DisplayData();
            } else {
                System.out.println("Failed to delete post.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
