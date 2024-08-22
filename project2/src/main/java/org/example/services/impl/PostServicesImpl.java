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

    public void CreatePost(PostDto post) {
        try {
            String sql = "INSERT INTO post (`title`, `desc`) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setString(2, post.getDesc());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Post created successfully.");
            } else {
                System.out.println("Failed to create post.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error creating post", e);
        }
    }
}
