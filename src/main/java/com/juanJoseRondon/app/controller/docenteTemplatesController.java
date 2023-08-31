package com.juanJoseRondon.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juanJoseRondon.app.entity.docente;
import com.juanJoseRondon.app.entity.estudiantes;
import com.juanJoseRondon.app.entity.grado;
import com.juanJoseRondon.app.repository.acudienteRepository;
import com.juanJoseRondon.app.repository.estudiantesRepository;
import com.juanJoseRondon.app.repository.gradoRepository;
import com.juanJoseRondon.app.exception.*;

@Controller
@RequestMapping("/inicioDocentes")
public class docenteTemplatesController {

	@Autowired
	private estudiantesRepository estudianteR;
	@Autowired
	private gradoRepository gradoR;
	@Autowired
	private acudienteRepository acudienteR;
	
	
	//LISTA DE ESTUDIANTES
	
	@GetMapping("/{id}")
	public String inicioDoc(Model model, @ModelAttribute docente docente) {
		model.addAttribute("docente", docente);
        model.addAttribute("grado", gradoR.findAll());
		return "/inicio/inicioDocentes";
	}
	
	@GetMapping("/")
	public String inicioDoce(Model model, @ModelAttribute docente docente) {
		model.addAttribute("docente", docente);
		model.addAttribute("grado", gradoR.findAll());
		return "/inicio/inicioDocentes";
	}
	
	@GetMapping("/verEstudiantes/{id}")
	public String inicioverestu(Model model, @PathVariable("id") String id) {
		grado grado = gradoR.findById(id).orElseThrow(() -> new NotFoundException("Grado no encontrado"));
		model.addAttribute("grado", grado);
		model.addAttribute("estudiantes", estudianteR.findByEstudiantesGrado(id));
		return "/inicio/listaEstudiantesGrado";
	}
	
	

    @GetMapping("/verEstudiantes/subirNotas/{id}")
    public String editarEstu(Model model, @PathVariable("id") String id) {
    	estudiantes estudiantes = estudianteR.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("grado", gradoR.findAll());
        model.addAttribute("acudiente", acudienteR.findAll());
        return "/form/subirNotas";
    }
    
    @PostMapping("/verEstudiantes/subirNotas/guardar")
    public String guardarEst(@ModelAttribute("estudiantes") estudiantes estudiantes) {
        if (estudiantes.getId().isEmpty()) {
        	estudiantes.setId(null);
        }
        estudianteR.save(estudiantes);
        return "redirect:/inicioDocentes/";
    }
    
    
    
    
    
//    @GetMapping("/inicioDocentes/verDocente/{id}")
//    public String verDocente(@PathVariable("id") String id, Model model) {
//        model.addAttribute("docente", docenteR.findById(id).orElseThrow(() -> new NotFoundException("Docente no encontrado")));
//        return "/form/VerDocente";
//    }
//    
//    @PostMapping("/inicioDocentes/actualizar")
//    public String actualizarDocentes(@ModelAttribute("docente") docente docente) {
//        if (docente.getId().isEmpty()) {
//        	docente.setId(null);
//        }
//        docenteR.save(docente);
//        return "redirect:/adminDocente/" + docente.getId();
//    }

	
}
