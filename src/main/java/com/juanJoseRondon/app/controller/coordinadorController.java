package com.juanJoseRondon.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juanJoseRondon.app.entity.coordinador;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.coordinadorRepository;

@RestController
@RequestMapping(value = "/api/coordinador")
public class coordinadorController {

	private coordinadorRepository coordinadorR;
	
	@GetMapping("/")
	public List<coordinador> getAllcoordinador() {
		return coordinadorR.findAll();
	}
	
    @GetMapping("/{id}")
    public coordinador getcoordinadorById(@PathVariable String id) {
        return coordinadorR.findById(id).orElseThrow(() -> new NotFoundException("coordinador no encontrado"));
    }
    
    @PostMapping("/")
    public coordinador guardarcoordinador(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        coordinador coordinador = mapper.convertValue(body, coordinador.class);
        return coordinadorR.save(coordinador);
    }
    
    @PutMapping("/{id}")
    public coordinador actualizarcoordinador(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        coordinador coordinador = mapper.convertValue(body, coordinador.class);
        coordinador.setId(id);
        return coordinadorR.save(coordinador);
    }
    
    @DeleteMapping("/{id}")
    public coordinador eliminarcoordinador(@PathVariable String id) {
    	coordinador coordinador = coordinadorR.findById(id).orElseThrow(() -> new NotFoundException("coordinador no encontrado"));
    	coordinadorR.deleteById(id);
        return coordinador;
    }
}
