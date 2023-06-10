package com.example.playmaker.web.recruitspc.controller;


import com.example.playmaker.service.recruitspc.RecruitSpcService;
import com.example.playmaker.web.recruitspc.dto.RecruitSpcForm;
import com.example.playmaker.web.recruitspc.dto.RecruitSpcInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recruitSpc")
public class RecruitSpcController {

    private final RecruitSpcService recruitSpcService;

    @PostMapping()
    public ResponseEntity<?> insertRecruitSpc(@RequestBody RecruitSpcForm recruitSpcForm)
    {
        log.info("insert : recruitSpcDto", recruitSpcForm);
        recruitSpcService.insertRecruitSpc(recruitSpcForm);
        return ResponseEntity.ok("success");
    }

    @GetMapping()
    public ResponseEntity<?> selectRecruitSpc(){
        List<RecruitSpcInfo> info = recruitSpcService.selectAll();
        log.info("select : recruitSpc");
        return ResponseEntity.ok(info);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateRecruitSpc(@PathVariable Long id, @RequestBody RecruitSpcForm recruitSpcForm){
        recruitSpcService.updateRecruitSpc(id,recruitSpcForm);
        log.info("delete : recruitSpcDto");
        return ResponseEntity.ok("success");
    }
}
