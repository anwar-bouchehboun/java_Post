package org.example.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
// constructore vide sans param
@NoArgsConstructor
public class Categorie {
    private Integer id;
    private String category;
    private  Post postid;

}
