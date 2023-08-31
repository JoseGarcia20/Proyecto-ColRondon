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
import com.juanJoseRondon.app.entity.grado;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.gradoRepository;

@RestController
@RequestMapping(value = "/api/grado")
public class gradoController {
	
	@Autowired
	private gradoRepository gradoR;
	
	@GetMapping("/")
	public List<grado> getAllGrado() {
		return gradoR.findAll();
	}
	
    @GetMapping("/{id}")
    public grado getGradoById(@PathVariable String id) {
        return gradoR.findById(id).orElseThrow(() -> new NotFoundException("Grado no encontrado"));
    }
    
    @PostMapping("/")
    public grado guardarGrado(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        grado grado = mapper.convertValue(body, grado.class);
        return gradoR.save(grado);
    }
    
    @PutMapping("/{id}")
    public grado actualizarGrado(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        grado grado = mapper.convertValue(body, grado.class);
        grado.setId(id);
        return gradoR.save(grado);
    }
    
    @DeleteMapping("/{id}")
    public grado eliminarGrado(@PathVariable String id) {
    	grado grado = gradoR.findById(id).orElseThrow(() -> new NotFoundException("Grado no encontrado"));
    	gradoR.deleteById(id);
        return grado;
    }
}
