package com.Assignment.OnlineQuizz.Repository;

import com.Assignment.OnlineQuizz.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    @Query("SELECT DISTINCT t.name FROM Topic t")
    List<String> findDistinctTopic();
}
