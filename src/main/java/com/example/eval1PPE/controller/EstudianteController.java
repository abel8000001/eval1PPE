package com.example.eval1PPE.controller;

import com.example.eval1PPE.model.Estudiante;
import com.example.eval1PPE.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EstudianteController {
    private final EstudianteRepository estudianteRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("estudiantes", estudianteRepository.findAll());
        return "index";
    }

    @GetMapping("/estudiantes")
    @ResponseBody
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    @PostMapping("/estudiantes")
    public String createEstudiante(Estudiante estudiante) {
        if (estudianteRepository.existsById(estudiante.getId())) {
            throw new RuntimeException("Estudiante con id " + estudiante.getId() + " ya existe");
        }
        else {
            estudianteRepository.save(estudiante);
            return "redirect:/";
        }
    }
}