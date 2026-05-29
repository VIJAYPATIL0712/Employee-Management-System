package com.vijay.emp_management.controller;

import com.vijay.emp_management.entity.Employe;
import com.vijay.emp_management.service.EmployeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

//    @GetMapping("/")
//    public String home(Model model){
//        model.addAttribute("employes" , employeService.getAllEmploye() );
//        return "index";
//    }

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "1") int page,
                       Model model){

        Page<Employe> employePage =
                employeService.getAllEmployePaginated(page);

        model.addAttribute("currentPage", page);

        model.addAttribute("totalPages",
                employePage.getTotalPages());

        model.addAttribute("totalItems",
                employePage.getTotalElements());

        model.addAttribute("employes",
                employePage.getContent());

        return "index";
    }

    @GetMapping("/employe/new")
    public String createEmployeForm(Model model){
            Employe employe = new Employe();

            model.addAttribute("employe" ,employe);

            return "create_employe_form";

    }

    @PostMapping("/employe")

    public String saveEmployee(@Valid @ModelAttribute("employe") Employe employe,
                               BindingResult result) {

        if(result.hasErrors()) {
            return "create_employe_form";
        }

        employeService.saveEmploye(employe);

        return "redirect:/";
    }

    @GetMapping("/employe/delete/{id}")
    public String deleteEmploye(@PathVariable Long id){
        employeService.deleteEmploye(id);
        return "redirect:/";
    }

    @GetMapping("/employe/edit/{id}")
    public String editForm(@PathVariable Long id , Model model){
        Employe employe = employeService.getEmployeById(id);
        model.addAttribute("employe" , employe);
        return "edit_form";

    }

    @PostMapping("/employe/{id}")
    public String editEmploye(@PathVariable Long id , @ModelAttribute("employe") Employe employe){

        Employe existingEmploye = employeService.getEmployeById(id);

        existingEmploye.setName(employe.getName());
        existingEmploye.setEmail(employe.getEmail());
        existingEmploye.setDesignation(employe.getDesignation());
        existingEmploye.setSalary(employe.getSalary());

        employeService.saveEmploye(existingEmploye);
        return "redirect:/";


    }

    @GetMapping("/search")
    public String searchEmploye(@RequestParam("keyword") String keyword,Model model){
        model.addAttribute("employes",
                employeService.searchEmploye(keyword));

        return "index";
    }


}
