package com.Assignment.OnlineQuizz.Controller;

import com.Assignment.OnlineQuizz.Model.Topic;
import com.Assignment.OnlineQuizz.Service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class TopicController {
    private final TopicService topicService;
    @PostMapping("/createTopic")
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic){
        System.out.println(topic);
        Topic createTopic = topicService.createTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTopic);
    }
    @GetMapping("topics")
    public ResponseEntity<List<Topic>> getATopic(){
        List<Topic> topics = topicService.getTopics();
        return ResponseEntity.ok(topics);

    }
}
