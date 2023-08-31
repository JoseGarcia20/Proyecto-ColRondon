package com.juanJoseRondon.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juanJoseRondon.app.entity.acudiente;
import com.juanJoseRondon.app.entity.comentariosForo;
import com.juanJoseRondon.app.entity.coordinador;
import com.juanJoseRondon.app.entity.docente;
import com.juanJoseRondon.app.entity.estudiantes;
import com.juanJoseRondon.app.entity.foroAcademico;
import com.juanJoseRondon.app.entity.grado;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.acudienteRepository;
import com.juanJoseRondon.app.repository.comentarioForoRepository;
import com.juanJoseRondon.app.repository.docenteRepository;
import com.juanJoseRondon.app.repository.estudiantesRepository;
import com.juanJoseRondon.app.repository.foroAcademicoRepository;
import com.juanJoseRondon.app.repository.gradoRepository;

@Controller
@RequestMapping("/admin")
public class coordinadorTemplatesController {

	@Autowired
	private docenteRepository docenteR;
	@Autowired
	private gradoRepository gradoR;
	@Autowired
	private acudienteRepository acudienteR;
	@Autowired
	private estudiantesRepository estudiantesR;
	@Autowired
	private foroAcademicoRepository foroAcademicoR;
	@Autowired
	private comentarioForoRepository comentariosForoR;


	
	//INICIO
	@GetMapping("/inicioCoordinacion/{id}")
	public String inicioCoordinacion(Model model, @ModelAttribute coordinador coordinador) {
		model.addAttribute("coordinador", coordinador);
		return "/inicio/inicioCoordinacion";
	}
	
	@GetMapping("/inicioCoordinacion")
	public String inicioCoordinacion2(Model model, @ModelAttribute coordinador coordinador) {
		model.addAttribute("coordinador", coordinador);
		return "/inicio/inicioCoordinacion";
	}
	
	//DOCENTES
    @GetMapping("/adminDocente/")
    public String listaDocentes(Model model) {
        model.addAttribute("docente", docenteR.findAll());
        return "/admin/adminDocente";
    }
    
    @GetMapping("/adminDocente/nuevo")
    public String nuevoDocente(Model model) {
        model.addAttribute("docente", new docente());
        return "/form/formDocente";
    }
    
    @GetMapping("/adminDocente/editar/{id}")
    public String editarDocente(@PathVariable("id") String id, Model model) {
        model.addAttribute("docente", docenteR.findById(id).orElseThrow(() -> new NotFoundException("Docente no encontrado")));
        return "/form/formDocente";
    }
    
    @GetMapping("/adminDocente/ver/{id}")
    public String verDocentes(@PathVariable("id") String id, Model model) {
        model.addAttribute("docente", docenteR.findById(id).orElseThrow(() -> new NotFoundException("Docente no encontrado")));
        return "/form/VerDocente";
    }
    
    @PostMapping("/adminDocente/guardar")
    public String guardarDocente(@ModelAttribute("docente") docente docente) {
        if (docente.getId().isEmpty()) {
        	docente.setId(null);
        }
        docenteR.save(docente);
        return "redirect:/admin/adminDocente/";
    }
    
    @GetMapping("/adminDocente/eliminar/{id}")
    public String eliminarDocente(@PathVariable("id") String id) {
        docenteR.deleteById(id);
        return "redirect:/admin/adminDocente/";
    }
    
    
    //GRADOS
    @GetMapping("/adminGrados/")
    public String listaGrados(Model model) {
        model.addAttribute("grado", gradoR.findAll());
        return "/admin/adminGrados";
    }
    @GetMapping("/adminGrados/nuevo")
    public String nuevoGrado(Model model) {
        model.addAttribute("grado", new grado());
        model.addAttribute("docente", docenteR.findAll());
        return "/form/formGrado";
    }
    @GetMapping("/adminGrados/editar/{id}")
    public String editarGrados(Model model, @PathVariable("id") String id) {
        grado grado = gradoR.findById(id).orElseThrow(() -> new NotFoundException("Grado no encontrado"));
        model.addAttribute("grado", grado);
        model.addAttribute("docente", docenteR.findAll());
        return "/form/formGrado";
    }
    @PostMapping("/adminGrados/guardar")
    public String guardarGrados(@ModelAttribute("grado") grado grado) {
        if (grado.getId().isEmpty()) {
            grado.setId(null);
        }
        gradoR.save(grado);
        return "redirect:/admin/adminGrados/";
    }
    @GetMapping("/adminGrados/eliminar/{id}")
    public String eliminarGrados(@PathVariable("id") String id) {
        gradoR.deleteById(id);
        return "redirect:/admin/adminGrados/";
    }
    
    
    //ACUDIENTES
    @GetMapping("/adminAcudiente/")
    public String listaAcudiente(Model model) {
        model.addAttribute("acudiente", acudienteR.findAll());
        return "/admin/adminAcudiente";
    }
    
    @GetMapping("/adminAcudiente/nuevo")
    public String nuevoAcudiente(Model model) {
        model.addAttribute("acudiente", new acudiente());
        return "/form/formAcudiente";
    }
    
    @GetMapping("/adminAcudiente/editar/{id}")
    public String editarAcudiente(@PathVariable("id") String id, Model model) {
        model.addAttribute("acudiente", acudienteR.findById(id).orElseThrow(() -> new NotFoundException("Acudiente no encontrado")));
        return "/form/formAcudiente";
    }
    
    @GetMapping("/adminAcudiente/ver/{id}")
    public String verAcudiente(@PathVariable("id") String id, Model model) {
        model.addAttribute("acudiente", acudienteR.findById(id).orElseThrow(() -> new NotFoundException("Acudiente no encontrado")));
        return "/form/VerAcudiente";
    }
    
    @PostMapping("/adminAcudiente/guardar")
    public String guardarAcudiente(@ModelAttribute("acudiente") acudiente acudiente) {
        if (acudiente.getId().isEmpty()) {
        	acudiente.setId(null);
        }
        acudienteR.save(acudiente);
        return "redirect:/admin/adminAcudiente/";
    }
    
    @GetMapping("/adminAcudiente/eliminar/{id}")
    public String eliminarAcudiente(@PathVariable("id") String id) {
    	acudienteR.deleteById(id);
        return "redirect:/admin/adminAcudiente/";
    }
    
    
    //ESTUDIANTES
    
    @GetMapping("/adminEstudiante/")
    public String listaEstudiantes(Model model) {
    	model.addAttribute("grado", gradoR.findAll());
        return "/admin/adminEstudiantesGrados";
    }
    
    @GetMapping("/verEstudiantes/{id}")
    public String listaEstudiantess(Model model, @PathVariable("id") String id) {
    	model.addAttribute("estudiantes", estudiantesR.findByEstudiantesGrado(id));
		grado grado = gradoR.findById(id).orElseThrow(() -> new NotFoundException("Grado no encontrado"));
		model.addAttribute("grado", grado);
        return "/admin/adminEstudiante";
    }
    @GetMapping("/adminEstudiante/nuevo")
    public String nuevoEstudiantes(Model model) {
        model.addAttribute("estudiantes", new estudiantes());
        model.addAttribute("grado", gradoR.findAll());
        model.addAttribute("acudiente", acudienteR.findAll());
        return "/form/formEstudiante";
    }
    @GetMapping("/adminEstudiante/editar/{id}")
    public String editarEstu(Model model, @PathVariable("id") String id) {
    	estudiantes estudiantes = estudiantesR.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("grado", gradoR.findAll());
        model.addAttribute("acudiente", acudienteR.findAll());
        return "/form/formEstudiante";
    }
    @GetMapping("/adminEstudiante/ver/{id}")
    public String verEstu(Model model, @PathVariable("id") String id) {
    	estudiantes estudiantes = estudiantesR.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("grado", gradoR.findAll());
        model.addAttribute("acudiente", acudienteR.findAll());
        return "/form/verEstudiantes";
    }
    @PostMapping("/adminEstudiante/guardar")
    public String guardarEst(@ModelAttribute("estudiantes") estudiantes estudiantes) {
        if (estudiantes.getId().isEmpty()) {
        	estudiantes.setId(null);
        }
        estudiantesR.save(estudiantes);
        return "redirect:/admin/adminEstudiante/";
    }
    @GetMapping("/adminEstudiante/eliminar/{id}")
    public String eliminarEstu(@PathVariable("id") String id) {
    	estudiantesR.deleteById(id);
        return "redirect:/admin/adminEstudiante/";
    }
    
    
    //FORO ACADEMICO
    @GetMapping("/adminForo/")
    public String listaForos(Model model) {
        model.addAttribute("foroAcademico", foroAcademicoR.findAll());
        return "/admin/inicioForo";
    }
    
    @GetMapping("/adminForo/nuevo")
    public String nuevoForo(Model model) {
        model.addAttribute("foroAcademico", new foroAcademico());
        return "/form/formForo";
    }
    
    @GetMapping("/adminForo/editar/{id}")
    public String editarForo(Model model, @PathVariable("id") String id) {
    	foroAcademico foroAcademico = foroAcademicoR.findById(id).orElseThrow(() -> new NotFoundException("Foro no encontrado"));
        model.addAttribute("foroAcademico", foroAcademico);
        return "/form/formForo";
    }
    
    @GetMapping("/adminForo/ver/{id}")
    public String verForo(Model model, @PathVariable("id") String id) {
    	foroAcademico foroAcademico = foroAcademicoR.findById(id).orElseThrow(() -> new NotFoundException("Foro no encontrado"));
    	model.addAttribute("comentariosForo", comentariosForoR.findByComentariosForo(id));
    	model.addAttribute("foroAcademico", foroAcademico);
        
        return "/form/verForo";
    }
    
    @PostMapping("/adminForo/guardar")
    public String guardarForo(@ModelAttribute("foroAcademico") foroAcademico foroAcademico) {
        if (foroAcademico.getId().isEmpty()) {
        	foroAcademico.setId(null);
        }
        foroAcademicoR.save(foroAcademico);
        return "redirect:/admin/adminForo/";
    }
    
    @GetMapping("/adminForo/eliminar/{id}")
    public String eliminarForo(@PathVariable("id") String id) {
    	foroAcademicoR.deleteById(id);
        return "redirect:/admin/adminForo/";
    }
    
    
    //Comentarios
    @GetMapping("/adminForo/nuevoComentario")
    public String nuevoComent(Model model) {
        model.addAttribute("comentariosForo", new comentariosForo());
        model.addAttribute("foroAcademico", foroAcademicoR.findAll());
        return "/form/formComentariosForo";
    }
    @PostMapping("/adminForo/guardarComentario")
    public String guardarComent(@ModelAttribute("comentariosForo") comentariosForo comentariosForo) {
        if (comentariosForo.getId().isEmpty()) {
        	comentariosForo.setId(null);
        }
        comentariosForoR.save(comentariosForo);
        return "redirect:/admin/adminForo/";
    }
    
	
	
}
