package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.collections.CarreraList;
import ar.edu.unju.fi.collections.DocenteList;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia.Modalidad;
import ar.edu.unju.fi.service.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private MateriaService materiaService;
	
	private MateriaDTO unaMateriaDTO;

	
	@Autowired
	private Docente unDocente;

	@Autowired
	private Carrera unaCarrera;

	@GetMapping("/lista")
	public String getListaMateria(Model model) {
		model.addAttribute("materias", materiaService.getMaterias());
		return "listaMaterias";
	}

	@GetMapping("/nuevo")
	public String getNuevaMateria(Model model) {
		unaMateriaDTO = new MateriaDTO();
		model.addAttribute("unaMateria", unaMateriaDTO);
		model.addAttribute("modalidades", Modalidad.values());
		model.addAttribute("docentes", DocenteList.getListaDocentes());
		model.addAttribute("carreras", CarreraList.getListaCarreras());
		model.addAttribute("edicion", false);
		return "formMateria";
	}

	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute("unaMateria") MateriaDTO materiaDTO, Model model,
			RedirectAttributes redirectAttributes) {
		unDocente = DocenteList.findDocenteByLegajo(materiaDTO.getDocente().getLegajo());
		unaCarrera = CarreraList.findCarreraByCodigo(materiaDTO.getCarrera().getCodigo());
		materiaDTO.setDocente(unDocente);
		materiaDTO.setCarrera(unaCarrera);
		materiaService.saveMateria(unaMateriaDTO);
		return "redirect:/materias/lista";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarMateria(@PathVariable("id") Long id, Model model) {
		unaMateriaDTO = materiaService.getMateria(id);
		if (unaMateriaDTO != null) {
			model.addAttribute("unaMateria", unaMateriaDTO);
			model.addAttribute("modalidades", Modalidad.values());
			model.addAttribute("docentes", DocenteList.getListaDocentes());
			model.addAttribute("carreras", CarreraList.getListaCarreras());
			model.addAttribute("edicion", true);
			return "formMateria";
		} else {
			return "redirect:/materias/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("unaMateria") MateriaDTO materiaDTO, Model model,
			RedirectAttributes redirectAttributes) {
		unDocente = DocenteList.findDocenteByLegajo(materiaDTO.getDocente().getLegajo());
		unaCarrera = CarreraList.findCarreraByCodigo(materiaDTO.getCarrera().getCodigo());
		materiaDTO.setDocente(unDocente);
		materiaDTO.setCarrera(unaCarrera);
		materiaService.editMateria(materiaDTO);
		return "redirect:/materias/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarMateria(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		materiaService.deleteMateria(id);
		return "redirect:/materias/lista";
	}

}
