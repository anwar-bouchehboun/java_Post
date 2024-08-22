package org.example.dto;

import lombok.Data;

@Data
public class PostDto {

    private  String title;
    private  String desc;

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
