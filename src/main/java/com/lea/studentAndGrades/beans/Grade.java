package com.lea.studentAndGrades.beans;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "grades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Topic topic;

    private int score;
}
