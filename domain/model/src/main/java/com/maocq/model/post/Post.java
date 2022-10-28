package com.maocq.model.post;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Post {

    private Integer id;
    private String title;
}
