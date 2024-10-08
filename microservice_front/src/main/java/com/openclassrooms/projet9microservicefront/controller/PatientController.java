package com.openclassrooms.projet9microservicefront.controller;



import com.openclassrooms.projet9microservicefront.model.Patient;
import com.openclassrooms.projet9microservicefront.service.AssessmentService;
import com.openclassrooms.projet9microservicefront.service.NoteService;
import com.openclassrooms.projet9microservicefront.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    NoteService noteService;

    @Autowired
    AssessmentService assessmentService;

    @GetMapping("/login")
    String login() {

        return "login";
    }


    @GetMapping("/")
    public String getAllPatients(Model model){
        model.addAttribute("patients", patientService.getAllPatients());

        return "patients_list";
    }

    @GetMapping("/{id}")
    public String getPatient(@PathVariable int id, Model model){
        model.addAttribute("patient", patientService.getPatient(id));
        model.addAttribute("notes", noteService.getAllNotes(id));
        model.addAttribute("assessment", assessmentService.getAssessment(id));

        return "patient";
    }

    @GetMapping("/add")
    public String addPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient_form";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("patient") Patient patient) {
        patientService.addPatient(patient);
        return "redirect:/patient/";
    }

    @GetMapping("edit/{id}")
    public String updatePatientForm(@PathVariable int id, Model model){
        model.addAttribute("patient", patientService.getPatient(id));

        return "patient_form";
    }

    @PostMapping("edit/{id}")
    public String updatePatient(@PathVariable("id") int id, Model model, @ModelAttribute("patient") Patient patient){
        patientService.updatePatient(id, patient);

        return "redirect:/patient/";
    }

    @GetMapping("delete/{id}")
    public String deletePatient(@PathVariable("id") int id){
        patientService.deletePatient(id);

        return "redirect:/patient/";
    }

}
