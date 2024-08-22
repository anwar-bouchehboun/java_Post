package org.example.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//data (geeter/setteres)
@Data
// constructore param
@AllArgsConstructor
// constructore vide sans param
@NoArgsConstructor
public class Post {

    private  Integer id;
    private  String title;
    private  String desc;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
       this.id=id;
    }

}
