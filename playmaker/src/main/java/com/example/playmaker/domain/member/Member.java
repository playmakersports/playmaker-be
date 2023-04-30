package com.example.playmaker.domain.member;

import com.example.playmaker.TimeEntity;
import com.example.playmaker.code.Area;
import com.example.playmaker.code.Role;
import com.example.playmaker.code.Sex;
import com.example.playmaker.code.Time;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String contact; //연락처
    private String birth;
    @Enumerated(value = EnumType.STRING)
    private Sex sex;
    private String email;
    private String position;
    @Enumerated(value = EnumType.STRING)
    private Area activeArea;
    @Enumerated(value = EnumType.STRING)
    private Time activeTime;
    private String mercenaryYn;
    private String proposalYn;
    private String gameStyle;
    private String selfIntro;
    private String preferredSoccerTeam;
    private String pfUrl;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Builder
    public Member(String username, String password, String nickname, String contact, String birth, Sex sex, String email,
                  String position, Area activeArea, Time activeTime, String mercenaryYn, String proposalYn, String gameStyle,
                  String selfIntro, String preferredSoccerTeam, String pfUrl, Role role) {

        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.contact = contact;
        this.birth = birth;
        this.sex = sex;
        this.email = email;
        this.position = position;
        this.activeArea = activeArea;
        this.activeTime = activeTime;
        this.mercenaryYn = mercenaryYn;
        this.proposalYn = proposalYn;
        this.gameStyle = gameStyle;
        this.selfIntro = selfIntro;
        this.preferredSoccerTeam = preferredSoccerTeam;
        this.pfUrl = pfUrl;
        this.role = role;
    }

}
