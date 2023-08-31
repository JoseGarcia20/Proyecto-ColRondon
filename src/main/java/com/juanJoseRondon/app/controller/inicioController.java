package com.juanJoseRondon.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.juanJoseRondon.app.entity.acudiente;
import com.juanJoseRondon.app.entity.comentariosForo;
import com.juanJoseRondon.app.entity.coordinador;
import com.juanJoseRondon.app.entity.docente;
import com.juanJoseRondon.app.entity.estudiantes;
import com.juanJoseRondon.app.entity.foroAcademico;
import com.juanJoseRondon.app.exception.NotFoundException;
import com.juanJoseRondon.app.repository.acudienteRepository;
import com.juanJoseRondon.app.repository.comentarioForoRepository;
import com.juanJoseRondon.app.repository.coordinadorRepository;
import com.juanJoseRondon.app.repository.docenteRepository;
import com.juanJoseRondon.app.repository.estudiantesRepository;
import com.juanJoseRondon.app.repository.foroAcademicoRepository;

@Controller
public class inicioController {


	@Autowired
	private coordinadorRepository coordinadorR;
	@Autowired
	private docenteRepository docenteR;
	@Autowired
	private estudiantesRepository estudiantesR;
	@Autowired
	private acudienteRepository acudienteR;
	@Autowired
	private foroAcademicoRepository foroAcademicoR;
	@Autowired
	private comentarioForoRepository comentariosForoR;
	
	@GetMapping("/")
	public String index(Model model) {
		return "/paginaGeneral/index";
	}

	@GetMapping("/index")
	public String inicio(Model model) {
		return "/paginaGeneral/index";
	}

	@GetMapping("/quienesSomos")
	public String quienesSomos(Model model) {
		return "/paginaGeneral/quienesSomo";
	}

	@GetMapping("/contacto")
	public String contacto(Model model) {
		return "/paginaGeneral/contacto";
	}

	@GetMapping("/inicioCoordinacion/{id}")
	public String inicioCoordinacion(Model model) {
		return "/inicio/inicioCoordinacion";
	}

	@GetMapping("/foroAcademico")
	public String inicioForo(Model model) {
		model.addAttribute("foroAcademico", foroAcademicoR.findAll());
		return "/inicio/foroAcademico";
	}

	@GetMapping("/foroAcademico/ver/{id}")
	public String verForo(Model model, @PathVariable("id") String id) {
		foroAcademico foroAcademico = foroAcademicoR.findById(id)
				.orElseThrow(() -> new NotFoundException("Foro no encontrado"));
		model.addAttribute("comentariosForo", comentariosForoR.findByComentariosForo(id));
		model.addAttribute("foroAcademico", foroAcademico);

		return "/form/verForoComunidad";
	}

	@GetMapping("/foroAcademico/nuevoComentario")
	public String nuevoComent(Model model) {
		model.addAttribute("comentariosForo", new comentariosForo());
		model.addAttribute("foroAcademico", foroAcademicoR.findAll());
		return "/form/formComentariosComunidad";
	}

	@PostMapping("/foroAcademico/guardarComentario")
	public String guardarComent(@ModelAttribute("comentariosForo") comentariosForo comentariosForo) {
		if (comentariosForo.getId().isEmpty()) {
			comentariosForo.setId(null);
		}
		comentariosForoR.save(comentariosForo);
		return "redirect:/foroAcademico";
	}
    
	@GetMapping("/login")
	public String loginCoordinador(Model model, @ModelAttribute coordinador coordinador) {
		model.addAttribute("coordinador", coordinador);
		return "/paginaGeneral/login";
	}
	
	@GetMapping("/inicioCoordinacion")
	public String inicioCoordinacion(Model model, @ModelAttribute coordinador coordinador) {
		model.addAttribute("coordinador", coordinador);
		return "/inicio/inicioCoordinacion";
	}

	@PostMapping("/login")
	public String loginCoordinador(@ModelAttribute coordinador coordinador) {

		for (coordinador item : coordinadorR.findAll()) {
			if (item.getUsuario().equals(coordinador.getUsuario())) {
				if (item.getClave().equals(coordinador.getClave())) {
					return "redirect:/admin/inicioCoordinacion/" + item.getId();
				}
			}
		}
		return "redirect:/login";
	}
	
	
	
	
	
	
    //LOGIN DOCENTE
	@GetMapping("/loginDocentes")
	public String loginDoce(Model model, @ModelAttribute docente docente) {
		model.addAttribute("docente", docente);
		return "/paginaGeneral/loginDocentes";
	}
	
	@PostMapping("/loginDocentes")
	public String loginDoce(@ModelAttribute docente docente) {

		for (docente item : docenteR.findAll()) {
			if (item.getCorreoElectronico().equals(docente.getCorreoElectronico())) {
				if (item.getClave().equals(docente.getClave())) {
					return "redirect:/inicioDocentes/" + item.getId();
				}
			}
		}
		return "redirect:/loginDocentes";
	}
	
	
    //LOGIN ESTUDIANTE
	@GetMapping("/loginEstudiantes")
	public String loginEstu(Model model, @ModelAttribute estudiantes estudiantes) {
		model.addAttribute("estudiantes", estudiantes);
		return "/paginaGeneral/loginEstudiantes";
	}
	
	@PostMapping("/loginEstudiantes")
	public String loginEstu(@ModelAttribute estudiantes estudiantes) {

		for (estudiantes item : estudiantesR.findAll()) {
			if (item.getCorreoElectronico().equals(estudiantes.getCorreoElectronico())) {
				if (item.getClave().equals(estudiantes.getClave())) {
					return "redirect:/inicioEstudiantes/" + item.getId();
				}
			}
		}
		return "redirect:/loginEstudiantes";
	}
	
	
    //LOGIN ACUDIENTE
	@GetMapping("/loginAcudientes")
	public String loginAcu(Model model, @ModelAttribute acudiente acudiente) {
		model.addAttribute("acudiente", acudiente);
		return "/paginaGeneral/loginAcudientes";
	}
	
	@PostMapping("/loginAcudientes")
	public String loginAcu(@ModelAttribute acudiente acudiente) {

		for (acudiente item : acudienteR.findAll()) {
			if (item.getCorreoElectronico().equals(acudiente.getCorreoElectronico())) {
				if (item.getClave().equals(acudiente.getClave())) {
					return "redirect:/inicioAcudientes/" + item.getId();
				}
			}
		}
		return "redirect:/loginAcudientes";
	}
	
	
}
