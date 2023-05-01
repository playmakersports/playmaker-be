package com.example.playmaker.domain.team;


import com.example.playmaker.TimeEntity;
import com.example.playmaker.code.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Team extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long id;
    private String teamName;
    private String engName;
    private String teamColor;
    @Enumerated(value = EnumType.STRING)
    private Item item;
    private String activeArea;
    private String logoUrl;
    private String teamIntro;
    private String joinYn;
    private String message;

    @Builder
    public Team(String teamName, String engName, String teamColor, Item item,
                String activeArea, String logoUrl, String teamIntro, String joinYn, String message){
        this.teamName = teamName;
        this.engName = engName;
        this.teamColor = teamColor;
        this.item = item;
        this.activeArea = activeArea;
        this.logoUrl = logoUrl;
        this.teamIntro = teamIntro;
        this.joinYn = joinYn;
        this.message = message;
    }

}
