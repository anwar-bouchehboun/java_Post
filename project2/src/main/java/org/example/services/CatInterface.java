package org.example.services;

import org.example.dto.CatDto;

import org.example.dto.RespDTO.CateDtoResp;


import java.sql.SQLException;
import java.util.HashMap;

public interface CatInterface {

HashMap<Integer, CateDtoResp> GetDataCate();
void DisplayDataCat();
 void CreateCat(CatDto Cateog) throws SQLException;
 int getPostCount(int id);
 void UpdateCat(CatDto Cateog);
 void DeleteCat(CatDto Cateog);
}
