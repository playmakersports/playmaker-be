package com.example.playmaker.web.teamboard.controller;


import com.example.playmaker.service.teamboard.TeamBoardService;
import com.example.playmaker.web.teamboard.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teamboard")
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
}
