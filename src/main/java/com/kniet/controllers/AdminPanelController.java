package com.kniet.controllers;

import com.kniet.entity.Student;
import com.kniet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/AdminPanel")
public class AdminPanelController {

    @Autowired //this will inject object which implements that interface
    private StudentService studentService;
    private String oldStudentBook;

    @GetMapping("/")
    public String adminPanel(Model model) {

        List<Student> students = studentService.getStudents();
        //we need to send our list of students to page
        model.addAttribute("students",students);

        return "adminPanel";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Student student = new Student();
        //clear object for saving data
        model.addAttribute("student",student);

        return "addStudent";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id,
                                    Model model) {

        Student student = studentService.getStudent(id);
        //we are adding student by id here for pre-populate inputs
        model.addAttribute("student",student);
        oldStudentBook = student.getStudentBook();
        return "updateStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult, Model model) {

        //if any errors just show error, if not then save
        if (bindingResult.hasErrors() && studentService.ifExists(student.getStudentBook())) {
            model.addAttribute("error","There already is a student book assigned to a student!");
            return "addStudent";
        } else if (bindingResult.hasErrors()) {
            return "addStudent";
        } else if (studentService.ifExists(student.getStudentBook())) {
            model.addAttribute("addError","There already is a student book assigned to a student!");
            return "addStudent";
        } else {
            studentService.saveStudent(student);
            return "redirect:/AdminPanel/";
        }
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {

        //if any errors just show error, if not then save
        if (bindingResult.hasErrors() && !oldStudentBook.equals(student.getStudentBook()) && studentService.ifExists(student.getStudentBook())) {
            model.addAttribute("updateError","There already is a student book assigned to a student!");
            return "updateStudent";
        } else if (bindingResult.hasErrors()) {
            return "updateStudent";
        } else if (!oldStudentBook.equals(student.getStudentBook()) && studentService.ifExists(student.getStudentBook())) {
            model.addAttribute("updateError","There already is a student book assigned to a student!");
            return "updateStudent";
        } else {
            studentService.saveStudent(student);
            return "redirect:/AdminPanel/";
        }
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@ModelAttribute("studentId") int id) {

        Student student = studentService.getStudent(id);
        studentService.deleteStudent(student);

        return "redirect:/AdminPanel/";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam("searchedValue") String searchedValue,
                                 Model model) {

        List<Student> students = studentService.searchStudents(searchedValue);
        model.addAttribute("students", students);

        return "adminPanel";
    }
}
