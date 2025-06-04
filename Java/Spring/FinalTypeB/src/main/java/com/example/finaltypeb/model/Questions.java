package com.example.finaltypeb.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="testId", referencedColumnName="id")
    private Test test;
    private String question;
    private String type;

    @ElementCollection
    private List<String> possibleAnswers;

    private String correctAnswer;
    private int userId;
    private String userChoice;
}
