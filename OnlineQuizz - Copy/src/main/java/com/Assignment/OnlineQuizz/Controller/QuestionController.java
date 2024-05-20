package com.Assignment.OnlineQuizz.Controller;

import com.Assignment.OnlineQuizz.Model.Question;
import com.Assignment.OnlineQuizz.Service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    @PostMapping("/createquestion")
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question){
        Question createdQuestion = questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }
    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }
    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Question> theQuestion = questionService.getQuestionById(id);
        if (theQuestion.isPresent()){
            return ResponseEntity.ok(theQuestion.get());
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @GetMapping("/questionByTopic/{topic}")
    public ResponseEntity<List<Question>> getQuestionByTopic(@PathVariable String topic) throws ChangeSetPersister.NotFoundException {
        List<Question> theQuestion = questionService.getQuestionByTopic(topic);
        if (theQuestion != null){
            return ResponseEntity.ok(theQuestion);
        }else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
    @PutMapping("/{id}/update")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        Question updatedQestion = questionService.updateQestion(id, question);
        return ResponseEntity.ok(updatedQestion);
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
//    @GetMapping("fetch-questions-for-user")
//    public ResponseEntity<List<Question>> getQuestionsForUser(@RequestParam Integer numOfQuestions, @RequestParam String subject){
//        List<Question> allQuestions = questionService.getQuestionsForUser(numOfQuestions, subject);
//        List<Question> mutableQuestions = new ArrayList<>(allQuestions);
//        Collections.shuffle(mutableQuestions);
//
//        int availableQuestions = Math.min(numOfQuestions,mutableQuestions.size());
//        List<Question> randomQuestions = mutableQuestions.subList(0, availableQuestions);
//        return ResponseEntity.ok(randomQuestions);
//    }


}
