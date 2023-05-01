package com.example.playmaker.service.boardcomment;


import com.example.playmaker.web.boardcomment.dto.CommentDto;
import com.example.playmaker.web.teamboard.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BoardCommentService {
    void insertComment(CommentDto commentDto);
    List<CommentDto> selectAll();
}
