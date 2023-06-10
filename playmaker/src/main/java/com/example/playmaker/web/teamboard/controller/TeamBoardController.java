package com.example.playmaker.web.teamboard.controller;


import com.example.playmaker.service.teamboard.TeamBoardService;
import com.example.playmaker.web.teamboard.dto.BoardForm;
import com.example.playmaker.web.teamboard.dto.BoardInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teamBoard")
@Slf4j
public class TeamBoardController {

    private final TeamBoardService teamBoardService;

    @PostMapping()
    public ResponseEntity<?> insertTeamBoard(@RequestPart(value = "boardInfo") BoardForm boardForm,
                                             @RequestPart(value = "image") MultipartFile file) throws IOException{
        log.info("insert : boardDto", boardForm);
        teamBoardService.insertBoard(boardForm, file);
        return ResponseEntity.ok("success");
    }
    @GetMapping()
    public ResponseEntity<?> selectTeamBoard(){
        log.info("select : teamBoard");
        List<BoardForm> info = teamBoardService.selectAll();
        return ResponseEntity.ok(info);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> selectTeamBoard(@PathVariable Long id)
    {
        log.info("select : teamBoard");
        BoardInfo info = teamBoardService.findById(id);
        return ResponseEntity.ok(info);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editTeamBoard(@PathVariable Long id,
                                           @RequestPart(value = "boardInfo") BoardForm boardForm,
                                           @RequestPart(value = "image") MultipartFile file) throws IOException{
        log.info("update : boardDto", boardForm);
        teamBoardService.editBoard(id, boardForm, file);
        return ResponseEntity.ok("success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeamBoard(@PathVariable Long id)
    {
        log.info("delete : TeamBoard", id);
        teamBoardService.deleteBoard(id);
        return ResponseEntity.ok("success");
    }

}
