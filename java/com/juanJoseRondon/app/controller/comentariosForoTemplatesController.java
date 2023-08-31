package com.juanJoseRondon.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.juanJoseRondon.app.entity.comentariosForo;
import com.juanJoseRondon.app.repository.comentarioForoRepository;
import com.juanJoseRondon.app.repository.foroAcademicoRepository;

@Controller
public class comentariosForoTemplatesController {

	@Autowired
	private comentarioForoRepository comentariosForoR;
	@Autowired
	private foroAcademicoRepository foroAcademicoR;
	
    @GetMapping("/comentarios/")
    public String listaComentarios(Model model) {
        model.addAttribute("comentariosForo", comentariosForoR.findAll());
        return "/admin/adminComentarios";
    }
    
    @GetMapping("/comentarios/nuevo")
    public String nuevoComentario(Model model) {
        model.addAttribute("comentariosForo", new comentariosForo());
        model.addAttribute("foroAcademico", foroAcademicoR.findAll());
        return "/form/formComentarios";
    }
    
    
    @PostMapping("/comentarios/guardar")
    public String guardarAcudiente(@ModelAttribute("comentariosForo") comentariosForo comentariosForo) {
        if (comentariosForo.getId().isEmpty()) {
        	comentariosForo.setId(null);
        }
        comentariosForoR.save(comentariosForo);
        return "redirect:/comentarios/";
    }
    
    
}
