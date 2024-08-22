package org.example;

import org.example.dto.PostDto;
import org.example.dto.RespDTO.PostDtoResp;
import org.example.services.impl.PostServicesImpl;

import java.sql.SQLException;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

    PostServicesImpl imp = new PostServicesImpl();

      PostDto create = new PostDto();
      create.setTitle("tezrtyui");
      create.setDesc("azertyuiop sdfghjk sdfghj");
      imp.CreatePost(create);
    //update
       PostDtoResp updatedPost = new PostDtoResp();
        updatedPost.setId(2);
        updatedPost.setTitle("Updated Post Title");
        updatedPost.setDesc("This is the updated description for the post.");
   imp.UpdatePost(updatedPost);







    }
}