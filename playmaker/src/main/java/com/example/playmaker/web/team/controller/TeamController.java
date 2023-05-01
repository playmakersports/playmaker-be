package com.example.playmaker.web.team.controller;


import com.example.playmaker.service.team.TeamService;
import com.example.playmaker.web.team.dto.TeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/team/insert")
    public ResponseEntity<?> insertTeam (@RequestPart(value = "teamInfo") TeamDto teamDto,
                                         @RequestPart(value = "image") MultipartFile file) throws IOException {

        log.info("teamDto",teamDto);
        teamService.insertTeam(teamDto, file);

        return ResponseEntity.ok("success");
    }
    @GetMapping("/team/select")
    public ResponseEntity<?> selectTeam (){
        List<TeamDto> info = teamService.selectAll();
        return ResponseEntity.ok(info);
    }
}
