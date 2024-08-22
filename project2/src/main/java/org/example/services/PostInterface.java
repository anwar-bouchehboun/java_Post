package org.example.services;

import org.example.dto.PostDto;
import org.example.dto.RespDTO.PostDtoResp;

import java.util.HashMap;

public interface PostInterface {
  HashMap<Integer, PostDtoResp> GetDataPost();
  void DisplayData();
  void CreatePost(PostDto post);
  void UpdatePost(PostDtoResp post);
  void DeletePost(PostDtoResp post);

}
