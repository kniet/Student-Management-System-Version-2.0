package com.kniet.controllers;

import com.kniet.entity.Student;
import com.kniet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/HomePage")
public class HomePageController {

    @Autowired //this will inject object which implements that interface
    private StudentService studentService;

    @GetMapping("/")
    public String homePage(Model model) {

        List<Student> students = studentService.getStudents();
        //we need to send our list of students to page
        model.addAttribute("students", students);

        return "homePage";
    }

    @GetMapping("/search")
    public String searchStudents(@RequestParam("searchedValue") String searchedValue,
                                 Model model) {

        List<Student> students = studentService.searchStudents(searchedValue);
        //we sent found students to page, if none found then show message
        model.addAttribute("students", students);

        return "homePage";
    }

}
