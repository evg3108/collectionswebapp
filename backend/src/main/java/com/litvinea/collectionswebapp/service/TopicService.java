package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Topic;
import com.litvinea.collectionswebapp.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic createNewTopic(String title){
        Topic createdTopic = new Topic();
        createdTopic.setTitle(title);
        return topicRepository.save(createdTopic);
    }

    public Topic editTopicTitle(long id, String newTitle){
        Optional<Topic> topic = topicRepository.findById(id);
        if(!topic.isPresent()){
            throw new IllegalArgumentException("No topic with id="+id+" found");
        }
        Topic editedTopic = topic.get();
        editedTopic.setTitle(newTitle);
        return topicRepository.save(editedTopic);
    }

    public Topic getTopicById(long id){
        Optional<Topic> found = topicRepository.findById(id);
        if(!found.isPresent()){
            throw new IllegalArgumentException("No Topic with id="+id);
        }
        return found.get();
    }

    public List<Topic> findAll(){
        return topicRepository.findAll();
    }

    public void deleteTopicById(long id){
        topicRepository.deleteById(id);
    }
}
