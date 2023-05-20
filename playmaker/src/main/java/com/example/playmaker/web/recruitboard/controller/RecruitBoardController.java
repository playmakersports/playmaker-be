package com.example.playmaker.web.recruitboard.controller;


import com.example.playmaker.service.recruitboard.RecruitBoardService;
import com.example.playmaker.web.recruitboard.dto.RecruitBoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RecruitBoardController {

    private final RecruitBoardService recruitBoardService;

    @PostMapping("/recruitBoard/insert")
    public ResponseEntity<?> insertRecruitBoard (@RequestPart(value = "recruitInfo") RecruitBoardDto recruitBoardDto){

        log.info("teamDto",recruitBoardDto);
        recruitBoardService.insertRecruitBoard(recruitBoardDto);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/recruitBoard/select")
    public ResponseEntity<?> selectRecruitBoard(){
        List<RecruitBoardDto> info = recruitBoardService.selectAll();
        return ResponseEntity.ok(info);
    }

}
