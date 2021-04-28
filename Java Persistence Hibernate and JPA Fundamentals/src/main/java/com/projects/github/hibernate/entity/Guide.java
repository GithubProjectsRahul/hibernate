package com.projects.github.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "guide")
@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String staffId;
    private String name;
    private String salary;

    @OneToMany(mappedBy = "guide", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setGuide(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setGuide(null);
    }
}
