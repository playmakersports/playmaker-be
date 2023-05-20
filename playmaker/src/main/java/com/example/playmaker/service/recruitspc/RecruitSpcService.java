package com.example.playmaker.service.recruitspc;

import com.example.playmaker.web.recruitspc.dto.RecruitSpcDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecruitSpcService {

    void insertRecruitSpc(RecruitSpcDto recruitSpcDto);
    List<RecruitSpcDto> selectAll();
}
