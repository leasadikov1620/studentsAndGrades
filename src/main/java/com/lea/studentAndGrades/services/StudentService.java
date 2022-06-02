package com.lea.studentAndGrades.services;

import com.lea.studentAndGrades.beans.Grade;
import com.lea.studentAndGrades.beans.Student;
import com.lea.studentAndGrades.exceptions.SchoolSystemException;
import com.lea.studentAndGrades.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void addGrade(long id,Grade grade) throws SchoolSystemException {
        if (!studentRepository.existsById(id)){
            throw new SchoolSystemException("id not found");
        }
        Student student = studentRepository.findById(id).get();
        List<Grade> gradeList=student.getGrades();
        gradeList.add(grade);
        studentRepository.save(student);
    }

    public void deleteStudent(long id) throws SchoolSystemException {
        if (!studentRepository.existsById(id)){
            throw new SchoolSystemException("id not found");
        }
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) throws SchoolSystemException {
        if (!studentRepository.existsById(id)){
            throw new SchoolSystemException("id not found");
        }
        return studentRepository.findById(id).get();
    }

    public List<Student> getStudentsByName(String name){
        return studentRepository.findAllByName(name);
    }

    public double getStudentGradesAvg(long id){
        List<Grade> grades = studentRepository.findById(id).get().getGrades();
       return grades.stream().mapToDouble(Grade::getScore).average().getAsDouble();
    }
}
