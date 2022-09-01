package com.litvinea.collectionswebapp.service;

import com.litvinea.collectionswebapp.entity.Tag;
import com.litvinea.collectionswebapp.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags(List<String> tags){

        return tags
                .stream()
                .map(this::mapTag)
                .collect(Collectors.toList());
    }

    private Tag mapTag(String title){
        Optional<Tag> found = tagRepository.findByTitle(title);
        if(!found.isPresent()){
            Tag newTag = new Tag();
            newTag.setTitle(title);
            return tagRepository.save(newTag);
        }
        return found.get();
    }
}
