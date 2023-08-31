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
import com.juanJoseRondon.app.entity.estudiantes;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.estudiantesRepository;

@RestController
@RequestMapping(value = "/api/estudiantes")
public class estudianteController {

	@Autowired
	private estudiantesRepository estudiantesR;
	
	@GetMapping("/")
	public List<estudiantes> getAllEstudiantes() {
		return estudiantesR.findAll();
	}
	
    @GetMapping("/{id}")
    public estudiantes getEstudiantesById(@PathVariable String id) {
        return estudiantesR.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
    }
    
    @PostMapping("/")
    public estudiantes guardarEstudiantes(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        estudiantes estudiantes = mapper.convertValue(body, estudiantes.class);
        return estudiantesR.save(estudiantes);
    }
    
    @PutMapping("/{id}")
    public estudiantes actualizarEstudiantes(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        estudiantes estudiantes = mapper.convertValue(body, estudiantes.class);
        estudiantes.setId(id);
        return estudiantesR.save(estudiantes);
    }
    
    @DeleteMapping("/{id}")
    public estudiantes eliminarEstudiantes(@PathVariable String id) {
    	estudiantes estudiantes = estudiantesR.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
    	estudiantesR.deleteById(id);
        return estudiantes;
    }
}
