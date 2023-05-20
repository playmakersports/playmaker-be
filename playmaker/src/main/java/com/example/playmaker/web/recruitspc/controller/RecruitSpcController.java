package com.example.playmaker.web.recruitspc.controller;


import com.example.playmaker.service.recruitspc.RecruitSpcService;
import com.example.playmaker.web.recruitspc.dto.RecruitSpcDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecruitSpcController {

    private final RecruitSpcService recruitSpcService;

    @PostMapping("/recruitSpc/insert")
    public ResponseEntity<?> insertRecruitSpc(@RequestPart (value = "recruitSpcInfo")
                                              RecruitSpcDto recruitSpcDto)
    {
        log.info("recritSpcDto",recruitSpcDto);
        recruitSpcService.insertRecruitSpc(recruitSpcDto);
        return ResponseEntity.ok("success");
    }
    @GetMapping("/recruitSpc/select")
    public ResponseEntity<?> selectRecruitSpc(){
        List<RecruitSpcDto> info = recruitSpcService.selectAll();
        return ResponseEntity.ok(info);
    }
}
