package com.example.playmaker.domain.teamboard;

import com.example.playmaker.TimeEntity;
import com.example.playmaker.domain.team.Team;
import com.example.playmaker.domain.boardcomment.BoardComment;
import lombok.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamBoard extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long boardId;
    private String boardName;
    private String userName;
    private String makeDt;
    private String email;
    private String picUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    private Team teamId;
    @OneToMany(mappedBy ="board")
    @Cascade( value = {CascadeType.ALL})
    private List<BoardComment> comments = new ArrayList<>();

    @Builder
    public TeamBoard ( String boardName, String userName, String makeDt,
                        String email, String picUrl, Team teamId){
        this.boardName = boardName;
        this.userName = userName;
        this.makeDt = makeDt;
        this.email = email;
        this.picUrl = picUrl;
        this.teamId = teamId;
    }
}
