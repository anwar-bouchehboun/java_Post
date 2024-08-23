package org.example.dto.RespDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CateDtoResp {

    private Integer id;
    private String category;
    private String title;


}
