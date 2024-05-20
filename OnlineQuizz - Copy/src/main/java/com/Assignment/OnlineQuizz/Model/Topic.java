package com.Assignment.OnlineQuizz.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int waitingTime;
    private int score;
    @OneToMany(mappedBy = "topic" ,cascade = CascadeType.ALL)
    private List<Question> questionList;
}
