package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class CommentService implements ServiceInterface<Comment>, CustomInterfaceComment {

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

    @Override
    public Comment create(Comment obj) {
        return null;
    }

    @Override
    public Comment findById(String id) {
        return null;
    }

    @Override
    public Comment update(Comment obj) {
        return null;
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
    public List<Comment> findByNewsId(String id) {
        List<Comment> commentList = commentRepository.findByNewsId(id);
        return convertToDTOs(commentList);
    }
}
