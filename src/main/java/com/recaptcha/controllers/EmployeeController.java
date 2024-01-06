package com.recaptcha.controllers;

import com.recaptcha.controllers.dto.EmployeeDTO;
import com.recaptcha.entities.EmployeeEntity;
import com.recaptcha.services.EmployeeService;
import com.recaptcha.services.RecaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RecaptchaService recaptchaService;

    @GetMapping(path = {"/", "/all"})
    public String showAll(Model model){
        List<EmployeeEntity> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "index";
    }

    @GetMapping("/create/form")
    public String createForm(Model model){
        model.addAttribute("employee", new EmployeeEntity());
        return "form";
    }

    @PostMapping("/create/process")
    public String createProcess(
            @ModelAttribute(name = "employee") EmployeeDTO employeeDTO,
            @RequestParam(name = "g-recaptcha-response") String captchaResponse,
            Model model
    ){
        boolean isValid = recaptchaService.validateRecaptcha(captchaResponse);

        if (!isValid) {
            model.addAttribute("message", "Invalid Captcha. Try again.");
            return "error";
        }

        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .birthDate(employeeDTO.getBirthDate())
                .build();
        employeeService.save(employeeEntity);

        return "redirect:/all";
    }
}
