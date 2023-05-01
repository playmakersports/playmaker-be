package com.example.playmaker.web.teamboard.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class BoardDto {

    private String BoardName;
    private String userName;
    private String makeDt;
    private String email;
    private String picUrl;
    private Long teamId;
}
