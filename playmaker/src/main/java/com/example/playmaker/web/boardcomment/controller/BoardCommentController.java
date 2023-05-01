package com.example.playmaker.web.boardcomment.controller;


import com.example.playmaker.service.boardcomment.BoardCommentService;
import com.example.playmaker.web.boardcomment.dto.CommentDto;
import com.example.playmaker.web.teamboard.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
@Slf4j
public class BoardCommentController {

    private final BoardCommentService boardCommentService;

    @PostMapping()
    public ResponseEntity<?> insertComment(@RequestPart(value = "commentInfo")CommentDto commentDto){
        boardCommentService.insertComment(commentDto);
        return ResponseEntity.ok("success");
    }

    @GetMapping()
    public ResponseEntity<?> selectComment(){
        List<CommentDto> info = boardCommentService.selectAll();
        return ResponseEntity.ok(info);
    }
}
