package com.ridibooks.clone_ridibooks_be.service;

import com.ridibooks.clone_ridibooks_be.dto.CommentRequestDto;
import com.ridibooks.clone_ridibooks_be.model.Comment;
import com.ridibooks.clone_ridibooks_be.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public Comment update(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment;
    }
}