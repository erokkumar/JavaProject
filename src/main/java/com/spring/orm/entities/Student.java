package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_details")
public class Student {

    @Id
    @Column(name = "student_id")
    private int id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_city")
    private String studentCity;

    // Constructors, Getters, and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public Student(int id, String studentName, String studentCity) {
        super();
        this.id = id;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }

    public Student() {
        super();
    }
}
