package com.Assignment.OnlineQuizz.ServiceImpl;

import com.Assignment.OnlineQuizz.Model.Topic;
import com.Assignment.OnlineQuizz.Repository.TopicRepository;
import com.Assignment.OnlineQuizz.Service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TopicServiceImpl  implements TopicService {
    private final TopicRepository topicRepository;


    @Override
    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }
}
