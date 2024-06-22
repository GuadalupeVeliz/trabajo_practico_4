package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.service.AlumnoService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;
	
	private AlumnoDTO unAlumnoDTO;

	@GetMapping("/lista")
	public String getListaAlumno(Model model) {
		model.addAttribute("alumnos", alumnoService.getAlumnos());
		return "listaAlumnos";
	}

	@GetMapping("/nuevo")
	public String getNuevoAlumno(Model model) {
		AlumnoDTO unAlumnoDTO = new AlumnoDTO();
		model.addAttribute("unAlumno", unAlumnoDTO);
		model.addAttribute("edicion", false);
		return "formAlumno";
	}

	@PostMapping("/guardar")
	public String guardarAlumno(@ModelAttribute("unAlumno") AlumnoDTO alumnoDTO, Model model,
			RedirectAttributes redirectAttributes) {
		
		alumnoService.saveAlumno(alumnoDTO);
		return "redirect:/alumnos/lista";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarAlumno(@PathVariable("id") Long id, Model model) {
		unAlumnoDTO = alumnoService.getAlumno(id);
		if (unAlumnoDTO != null) {
			model.addAttribute("unAlumno", unAlumnoDTO);
			model.addAttribute("edicion", true);
			return "formAlumno";
		} else {
			return "redirect:/alumnos/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("unAlumno") AlumnoDTO alumnoDTO, Model model,
			RedirectAttributes redirectAttributes) {
		
		alumnoService.editAlumno(alumnoDTO);
		return "redirect:/alumnos/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarAlumno(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		
		alumnoService.deleteAlumno(id);
		return "redirect:/alumnos/lista";
	}

}
