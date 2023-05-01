package com.example.playmaker.service.boardcomment;


import com.example.playmaker.domain.boardcomment.BoardComment;
import com.example.playmaker.domain.boardcomment.BoardCommentRepository;
import com.example.playmaker.domain.teamboard.TeamBoard;
import com.example.playmaker.domain.teamboard.TeamBoardRepository;
import com.example.playmaker.web.boardcomment.dto.CommentDto;
import com.example.playmaker.web.teamboard.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardCommentServiceImpl implements BoardCommentService{

    private final BoardCommentRepository boardCommentRepository;
    private final TeamBoardRepository teamBoardRepository;
    @Override
    public void insertComment(CommentDto commentDto) {
        TeamBoard board = teamBoardRepository.findById(commentDto.getBoardId()).orElse(null);
        BoardComment boardComment = BoardComment.builder()
                .userName(commentDto.getUsername())
                .makeDt(commentDto.getMakeDt())
                .content(commentDto.getContent())
                .board(board)
                .build();
        boardCommentRepository.save(boardComment);
    }

    @Override
    public List<CommentDto> selectAll() {
        List<BoardComment> boardInfo = boardCommentRepository.findAll();
        List<CommentDto> info = boardInfo.stream()
                .map(o-> new CommentDto())
                .sorted(Comparator.comparing(CommentDto::getMakeDt).reversed())
                .collect(Collectors.toList());
        return info;
    }
}
