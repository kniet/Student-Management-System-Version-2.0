package com.kniet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "id")
    private int id;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "^[a-zA-Z]{1,20}", message = "must contain only letters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "^[a-zA-Z]{1,20}", message = "must contain only letters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "00\\d{4}", message = "must be 6 digits with two '0' at the beginning")
    @Column(name = "student_book")
    private String studentBook;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp = "^[0-9][a-zA-Z]{3,5}", message = "must start with digit and be between 3 and 6 letters")
    @Column(name = "class_group")
    private String classGroup;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentBook() {
        return studentBook;
    }

    public void setStudentBook(String studentBook) {
        this.studentBook = studentBook;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentBook='" + studentBook + '\'' +
                ", classGroup='" + classGroup + '\'' +
                '}';
    }
}
