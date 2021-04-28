package com.projects.github.hibernate.service;

import com.projects.github.hibernate.entity.Guide;
import com.projects.github.hibernate.entity.Student;
import com.projects.github.hibernate.repository.GuideRepository;
import com.projects.github.hibernate.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;
    private GuideRepository guideRepository;

    public StudentService(StudentRepository studentRepository, GuideRepository guideRepository) {
        this.studentRepository = studentRepository;
        this.guideRepository = guideRepository;
    }

    public void updateStudent() {
        Optional<Guide> guide = guideRepository.findById(2L);
        Optional<Student> student = studentRepository.findById(2L);

        guide.get().addStudent(student.get());
        guideRepository.save(guide.get());
    }
}
