package com.juanJoseRondon.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juanJoseRondon.app.entity.estudiantes;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.acudienteRepository;
import com.juanJoseRondon.app.repository.estudiantesRepository;
import com.juanJoseRondon.app.repository.gradoRepository;


@Controller
@RequestMapping("/inicioEstudiantes")
public class estudianteTemplateController {

    @Autowired
    private gradoRepository gradoR;
    @Autowired
    private acudienteRepository acudienteR;
    @Autowired
    private estudiantesRepository estudiantesR;
	
	//Mostrar Datos Estudiante
    @GetMapping("/{id}")
    public String mostrarDatosEstu(Model model, @PathVariable("id") String id) {
    	estudiantes estudiantes = estudiantesR.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("grado", gradoR.findAll());
        model.addAttribute("acudiente", acudienteR.findAll());
		return "/inicio/inicioEstudiantes";
    }
    
	
}
