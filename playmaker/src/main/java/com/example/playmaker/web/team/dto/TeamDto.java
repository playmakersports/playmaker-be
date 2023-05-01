package com.example.playmaker.web.team.dto;

import com.example.playmaker.code.Item;
import lombok.Data;

import java.util.Date;

@Data
public class TeamDto {

    private String teamName;
    private String engName;
    private String teamColor;
    private Item item;
    private String create_dt;
    private String activeArea;
    private String logoUrl;
    private String teamIntro;
    private String joinYn;
    private String message;
}
