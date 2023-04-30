package com.example.playmaker.web.member.dto;

import com.example.playmaker.code.Sex;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MemberForm {

    @NotBlank(message = "아이디는 필수값입니다.")
    private String username;
    @NotBlank(message = "비밀번호는 필수값입니다.")
    private String password;
    @NotBlank(message =  "닉네임은 필수값입니다.")
    private String nickname;
    private String contact;
    private String birth;

}
