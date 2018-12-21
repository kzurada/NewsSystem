package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService implements ServiceInterface {

    public CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List getObj() {
        List<Comment> commentList = commentRepository.findAll();
        return convertToDTOs(commentList);
    }

    private List<Comment> convertToDTOs(List<Comment> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private Comment convertToDTO(Comment comment) {
        Comment dto = new Comment();
        dto.setId(comment.getId());
        dto.setData(comment.getData());
        dto.setAuthor(comment.getAuthor());
        dto.setNewsId(comment.getNewsId());

        return dto;
    }

    @Override
    public Object create(Object obj) {
        return null;
    }

    @Override
    public Object findById(String id) {
        return null;
    }

    @Override
    public Object update(Object obj) {
        return null;
    }
}
