package com.example.playmaker.web.team.controller;


import com.example.playmaker.service.team.TeamService;
import com.example.playmaker.web.team.dto.TeamForm;
import com.example.playmaker.web.team.dto.TeamInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping()
    public ResponseEntity<?>insertTeam(@RequestPart(value = "teamInfo") TeamForm teamDto,
                                         @RequestPart(value = "image") MultipartFile file) throws IOException {
        log.info("insert : teamDto",teamDto);
        teamService.insertTeam(teamDto, file);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> selectTeam (@PathVariable String id){
        log.info("select : team");
        List<TeamInfo> info = teamService.selectTeam(id);
        return ResponseEntity.ok(info);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editTeam(@PathVariable Long id,
                                      @RequestPart(value = "teamInfo") TeamForm teamDto,
                                      @RequestPart(value = "image") MultipartFile file) throws IOException{
        log.info("update : teamDto",teamDto);
        teamService.editTeam(id, teamDto, file);
        return ResponseEntity.ok("success");
    }

}
