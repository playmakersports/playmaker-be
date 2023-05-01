package com.example.playmaker.service.team;


import com.example.playmaker.web.team.dto.TeamDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface TeamService {

    void insertTeam(TeamDto teamDto, MultipartFile file) throws IOException;
    List<TeamDto> selectAll();

}
