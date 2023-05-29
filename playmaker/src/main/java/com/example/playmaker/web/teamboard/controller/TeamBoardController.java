package com.example.playmaker.web.teamboard.controller;


import com.example.playmaker.service.teamboard.TeamBoardService;
import com.example.playmaker.web.teamboard.dto.BoardDto;
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
    public ResponseEntity<?> insertTeamBoard(@RequestPart(value = "boardInfo") BoardDto boardDto,
                                             @RequestPart(value = "image") MultipartFile file) throws IOException{
        log.info("boardDto", boardDto);
        teamBoardService.insertBoard(boardDto, file);
        return ResponseEntity.ok("success");
    }
    @GetMapping()
    public ResponseEntity<?> selectTeamBoard(){
        List<BoardDto> info = teamBoardService.selectAll();
        return ResponseEntity.ok(info);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> selectTeamBoard(@PathVariable Long id)
    {
        BoardInfo info = teamBoardService.findById(id);
        return ResponseEntity.ok(info);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editTeamBoard(@PathVariable Long id,
                                           @RequestPart(value = "boardInfo") BoardDto boardDto,
                                           @RequestPart(value = "image") MultipartFile file) throws IOException{
        log.info("boardDto", boardDto);
        teamBoardService.editBoard(id,boardDto, file);
        return ResponseEntity.ok("success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeamBoard(@PathVariable Long id)
    {
        log.info("deleteTeamBoard", id);
        teamBoardService.deleteBoard(id);
        return ResponseEntity.ok("success");
    }

}
