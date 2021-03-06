package com.newssystem.server.NewsSystem.service;

import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class NewsService implements ServiceInterface<News> {

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getObj() {
        List<News> newsList = newsRepository.findAll();
        return convertToDTOs(newsList);
    }

    private List<News> convertToDTOs(List<News> models) {
        return models.stream().map(this::convertToDTO).collect(toList());
    }

    private News convertToDTO(News model) {
        News dto = new News();
        dto.setId(model.getId());
        dto.setData(model.getData());
        dto.setText(model.getText());
        dto.setTitle(model.getTitle());
        return dto;
    }

    @Override
    public News create(News obj) {
        return newsRepository.save(obj);
    }

    @Override
    public News findById(String id) {
        return null;
    }

    @Override
    public News update(News obj) {
        return null;
    }
}
