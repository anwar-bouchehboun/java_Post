package org.example;

import org.example.db.DB;
import org.example.dto.PostDto;
import org.example.dto.RespDTO.PostDtoResp;
import org.example.services.impl.PostServicesImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

    PostServicesImpl imp = new PostServicesImpl();

    imp.DisplayData();
          //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //System.out.printf(imp.GetDataPost());


    }
}