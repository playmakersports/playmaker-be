package com.example.playmaker.service.teamboard;

import com.example.playmaker.domain.teamboard.TeamBoard;
import com.example.playmaker.web.teamboard.dto.BoardDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface TeamBoardService{

    void insertBoard(BoardDto boardDto, MultipartFile file) throws IOException;
    List<BoardDto> selectAll();
}
