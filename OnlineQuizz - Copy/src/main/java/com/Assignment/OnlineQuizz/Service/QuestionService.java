package com.Assignment.OnlineQuizz.Service;

import com.Assignment.OnlineQuizz.Model.Question;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question createQuestion(Question question);
    List<Question> getAllQuestions();
    Optional<Question> getQuestionById(Long id);
    Question updateQestion(Long id, Question question) throws ChangeSetPersister.NotFoundException;
    void deleteQuestion(Long id);


    List<Question> getQuestionByTopic(String topic);
}
