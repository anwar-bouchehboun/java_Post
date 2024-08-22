package org.example.dto.RespDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDtoResp {
    private  Integer id;
    private  String title;
    private  String desc;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }
    public String getTitle(){
        return title;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
