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

import com.juanJoseRondon.app.repository.docenteRepository;

import com.juanJoseRondon.app.exception.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.juanJoseRondon.app.entity.docente;

@RestController
@RequestMapping(value = "/api/docente")
public class docenteController {
	
	@Autowired
	private docenteRepository docenteR;
	
	@GetMapping("/")
	public List<docente> getAllDocente() {
		return docenteR.findAll();
	}
	
    @GetMapping("/{id}")
    public docente getDocenteById(@PathVariable String id) {
        return docenteR.findById(id).orElseThrow(() -> new NotFoundException("Docente no encontrado"));
    }
    
    @PostMapping("/")
    public docente guardarDocente(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        docente docente = mapper.convertValue(body, docente.class);
        return docenteR.save(docente);
    }
    
    @PutMapping("/{id}")
    public docente actualizarDocente(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        docente docente = mapper.convertValue(body, docente.class);
        docente.setId(id);
        return docenteR.save(docente);
    }
    
    @DeleteMapping("/{id}")
    public docente eliminarDocente(@PathVariable String id) {
        docente docente = docenteR.findById(id).orElseThrow(() -> new NotFoundException("Docente no encontrado"));
        docenteR.deleteById(id);
        return docente;
    }
    
}
