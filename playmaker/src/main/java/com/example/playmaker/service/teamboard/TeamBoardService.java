package com.example.playmaker.service.teamboard;

import com.example.playmaker.domain.teamboard.TeamBoard;
import com.example.playmaker.web.teamboard.dto.BoardDto;
import com.example.playmaker.web.teamboard.dto.BoardInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public interface TeamBoardService{

    void insertBoard(BoardDto boardDto, MultipartFile file) throws IOException;
    List<BoardDto> selectAll();
    BoardInfo findById(Long id);
    void editBoard(Long id, BoardDto boardDto, MultipartFile file) throws IOException;
    void deleteBoard(Long id);
}
