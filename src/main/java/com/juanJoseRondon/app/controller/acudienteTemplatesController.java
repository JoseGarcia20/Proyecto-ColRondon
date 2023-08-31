package com.juanJoseRondon.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juanJoseRondon.app.entity.estudiantes;
import com.juanJoseRondon.app.repository.acudienteRepository;
import com.juanJoseRondon.app.repository.estudiantesRepository;
import com.juanJoseRondon.app.repository.gradoRepository;

@Controller
@RequestMapping("/inicioAcudientes")
public class acudienteTemplatesController {

	@Autowired
	private acudienteRepository acudienteR;
	@Autowired
	private estudiantesRepository estudiantesR;
	@Autowired
	private gradoRepository gradoR;

	
    @GetMapping("/{id}")
    public String mostrarDatosEstu(Model model, @PathVariable("id") String id) {
    	estudiantes estudiantes = estudiantesR.findByAcudienteEstudiante(id);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("grado", gradoR.findAll());
        model.addAttribute("acudiente", acudienteR.findAll());
		return "/inicio/inicioAcudientes";
    }
	
}
