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
import com.juanJoseRondon.app.entity.comentariosForo;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.comentarioForoRepository;


@RestController
@RequestMapping(value = "/api/comentariosForo")
public class comentariosForoController {

	@Autowired
	private comentarioForoRepository comentariosForoR;
	
	@GetMapping("/")
	public List<comentariosForo> getAllComentariosForo() {
		return comentariosForoR.findAll();
	}
	
    @GetMapping("/{id}")
    public comentariosForo getComentariosForoById(@PathVariable String id) {
        return comentariosForoR.findById(id).orElseThrow(() -> new NotFoundException("Foro no encontrado"));
    }
    
    @PostMapping("/")
    public comentariosForo guardarComentariosForoR(@RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        comentariosForo comentariosForo = mapper.convertValue(body, comentariosForo.class);
        return comentariosForoR.save(comentariosForo);
    }
    
    @PutMapping("/{id}")
    public comentariosForo actualizarComentariosForoR(@PathVariable String id, @RequestBody Map<String, Object> body) {
        ObjectMapper mapper = new ObjectMapper();
        comentariosForo comentariosForo = mapper.convertValue(body, comentariosForo.class);
        comentariosForo.setId(id);
        return comentariosForoR.save(comentariosForo);
    }
    
    @DeleteMapping("/{id}")
    public comentariosForo eliminarComentarios(@PathVariable String id) {
    	comentariosForo comentariosForo = comentariosForoR.findById(id).orElseThrow(() -> new NotFoundException("Comentarios no encontrado"));
    	comentariosForoR.deleteById(id);
        return comentariosForo;
    }
}
