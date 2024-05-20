package com.Assignment.OnlineQuizz.Service;

import com.Assignment.OnlineQuizz.Model.Topic;

import java.util.List;

public interface TopicService {
    Topic createTopic(Topic topic);
    List<Topic> getTopics();
}
