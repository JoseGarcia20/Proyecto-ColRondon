package com.juanJoseRondon.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juanJoseRondon.app.entity.foroAcademico;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.foroAcademicoRepository;

@RestController
@RequestMapping(value = "/api/foroAcademico")
public class foroAcademicoController {

	@Autowired
	private foroAcademicoRepository foroR;
	
	@GetMapping("/")
	public List<foroAcademico> getAllForoAcademico() {
		return foroR.findAll();
	}
	
    @GetMapping("/{id}")
    public foroAcademico getForoAcademicoById(@PathVariable String id) {
        return foroR.findById(id).orElseThrow(() -> new NotFoundException("Foro no encontrado"));
    }
    
    @PostMapping("/")
    public foroAcademico guardarforoAcademico(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        foroAcademico foroAcademico = mapper.convertValue(body, foroAcademico.class);
        return foroR.save(foroAcademico);
    }
    
    @PutMapping("/{id}")
    public foroAcademico actualizarforoAcademico(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        foroAcademico foroAcademico = mapper.convertValue(body, foroAcademico.class);
        foroAcademico.setId(id);
        return foroR.save(foroAcademico);
    }
    
    @DeleteMapping("/{id}")
    public foroAcademico eliminarforoAcademico(@PathVariable String id) {
    	foroAcademico foroAcademico = foroR.findById(id).orElseThrow(() -> new NotFoundException("Foro no encontrado"));
    	foroR.deleteById(id);
        return foroAcademico;
    }
	
}
