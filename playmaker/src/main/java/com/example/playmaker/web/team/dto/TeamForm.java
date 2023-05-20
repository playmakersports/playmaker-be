package com.example.playmaker.web.team.dto;

import com.example.playmaker.code.Item;
import com.example.playmaker.security.Token;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class TeamForm {

    private String teamName;
    private String engName;
    private String teamColor;
    private Item item;
    private String createDt;
    private String activeArea;
    private String logoUrl;
    private String teamIntro;
    private String joinYn;
    private String message;

}
