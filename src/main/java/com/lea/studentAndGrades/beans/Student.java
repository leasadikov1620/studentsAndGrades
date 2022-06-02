package com.lea.studentAndGrades.beans;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date birthday;

    private boolean isActive;

    @JoinColumn(name = "student_id" , referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Grade> grades;
}
