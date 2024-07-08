package ar.edu.unju.fi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.MateriaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@Autowired
	private MateriaService materiaService;

	private AlumnoDTO unAlumnoDTO;
	private MateriaDTO unaMateriaDTO;

	@GetMapping("/lista")
	public String getListaAlumno(Model model) {
		model.addAttribute("alumnos", alumnoService.getAlumnos());
		return "alumnos/listaAlumnos";
	}

	@GetMapping("/nuevo")
	public String getNuevoAlumno(Model model) {
		AlumnoDTO unAlumnoDTO = new AlumnoDTO();
		model.addAttribute("unAlumno", unAlumnoDTO);
		model.addAttribute("edicion", false);
		return "alumnos/formAlumno";
	}

	@PostMapping("/guardar")
	public String guardarAlumno(@Valid @ModelAttribute("unAlumno") AlumnoDTO alumnoDTO, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("unAlumno", alumnoDTO);
			model.addAttribute("edicion", false);
			return "alumnos/formAlumno";
		}
		alumnoService.saveAlumno(alumnoDTO);
		return "redirect:/alumnos/lista";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarAlumno(@PathVariable("id") Long id, Model model) {
		unAlumnoDTO = alumnoService.getAlumno(id);
		if (unAlumnoDTO != null) {
			model.addAttribute("unAlumno", unAlumnoDTO);
			model.addAttribute("edicion", true);
			return "alumnos/formAlumno";
		} else {
			return "redirect:/alumnos/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarAlumno(@Valid @ModelAttribute("unAlumno") AlumnoDTO alumnoDTO, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("unAlumno", alumnoDTO);
			model.addAttribute("edicion", true);
			return "alumnos/formAlumno";
		}
		alumnoService.editAlumno(alumnoDTO);
		return "redirect:/alumnos/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarAlumno(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		alumnoService.deleteAlumno(id);
		return "redirect:/alumnos/lista";
	}

	@GetMapping("/{id}/incripcion-a-materia")
	public String getInscripcionMateria(@PathVariable("id") Long id, Model model) {
		unAlumnoDTO = alumnoService.getAlumno(id);
		List<MateriaDTO> materiasDelAlumno = unAlumnoDTO.getMaterias();
		List<MateriaDTO> materiasNoInscriptas = materiaService.getMaterias().stream()
				.filter((materia) -> {
					for (MateriaDTO materiaDelAlumno : materiasDelAlumno) {
						if (materiaDelAlumno.getCodigo().equals(materia.getCodigo())) {
							return false;
						}
					}
					return true;
				}).collect(Collectors.toList());
		
		model.addAttribute("alumno", unAlumnoDTO);
		model.addAttribute("materias", materiasNoInscriptas);
		
		return "alumnos/inscripcionAlumno";
	}

	@PostMapping("/guardar-inscripcion-a-materia")
	public String guardarInscripcionMateria(@RequestParam("idAlumno") Long idAlumno,
			@RequestParam("idMateria") Long idMateria, Model model) {
		
		unAlumnoDTO = alumnoService.getAlumno(idAlumno);
		unaMateriaDTO = materiaService.getMateria(idMateria);
		
		unAlumnoDTO.getMaterias().add(unaMateriaDTO);
		alumnoService.saveAlumno(unAlumnoDTO);
		
		return "redirect:/alumnos/detalles/" + idAlumno;
	}
	
	
	@GetMapping("/detalles/{id}")
	public String getDetallesAlumno(@PathVariable("id") Long id, Model model) {
		model.addAttribute("alumno", alumnoService.getAlumno(id));
		return "alumnos/detallesAlumno";
	}

}
