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
import com.juanJoseRondon.app.entity.acudiente;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.acudienteRepository;

@RestController
@RequestMapping(value = "/api/acudiente")
public class acudienteController {

	@Autowired
	private acudienteRepository acudienteR;
	
	@GetMapping("/")
	public List<acudiente> getAllAcudiente() {
		return acudienteR.findAll();
	}
	
    @GetMapping("/{id}")
    public acudiente getAcudienteById(@PathVariable String id) {
        return acudienteR.findById(id).orElseThrow(() -> new NotFoundException("Acudiente no encontrado"));
    }
    
    @PostMapping("/")
    public acudiente guardarAcudiente(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        acudiente acudiente = mapper.convertValue(body, acudiente.class);
        return acudienteR.save(acudiente);
    }
    
    @PutMapping("/{id}")
    public acudiente actualizarAcudiente(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        acudiente acudiente = mapper.convertValue(body, acudiente.class);
        acudiente.setId(id);
        return acudienteR.save(acudiente);
    }
    
    @DeleteMapping("/{id}")
    public acudiente eliminarAcudiente(@PathVariable String id) {
    	acudiente acudiente = acudienteR.findById(id).orElseThrow(() -> new NotFoundException("Acudiente no encontrado"));
    	acudienteR.deleteById(id);
        return acudiente;
    }
    
}
