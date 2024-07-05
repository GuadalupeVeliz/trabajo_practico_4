package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia.Modalidad;
import ar.edu.unju.fi.service.CarreraService;
import ar.edu.unju.fi.service.DocenteService;
import ar.edu.unju.fi.service.MateriaService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private DocenteService docenteService;

	@Autowired
	private CarreraService carreraService;

	@GetMapping("/lista")
	public String getListaMateria(Model model) {
		model.addAttribute("materias", materiaService.getMaterias());
		return "materias/listaMaterias";
	}

	@GetMapping("/nuevo")
	public String getNuevaMateria(Model model) {
		MateriaDTO unaMateriaDTO = new MateriaDTO();
		model.addAttribute("unaMateria", unaMateriaDTO);
		model.addAttribute("modalidades", Modalidad.values());
		model.addAttribute("docentes", docenteService.getDocentes());
		model.addAttribute("carreras", carreraService.getCarreras());
		model.addAttribute("edicion", false);
		return "materias/formMateria";
	}

	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute("unaMateria") MateriaDTO materiaDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("unaMateria", materiaDTO);
			model.addAttribute("modalidades", Modalidad.values());
			model.addAttribute("docentes", docenteService.getDocentes());
			model.addAttribute("carreras", carreraService.getCarreras());
			model.addAttribute("edicion", false);
			return "materias/formMateria";
		}
		DocenteDTO unDocenteDTO = docenteService.getDocente(materiaDTO.getDocenteDTO().getId());
		CarreraDTO unaCarreraDTO = carreraService.getCarrera(materiaDTO.getCarreraDTO().getId());
		materiaDTO.setDocenteDTO(unDocenteDTO);
		materiaDTO.setCarreraDTO(unaCarreraDTO);
		materiaService.saveMateria(materiaDTO);
		return "redirect:/materias/lista";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarMateria(@PathVariable("id") Long id, Model model) {
		MateriaDTO unaMateriaDTO = materiaService.getMateria(id);
		if (unaMateriaDTO != null) {
			model.addAttribute("unaMateria", unaMateriaDTO);
			model.addAttribute("modalidades", Modalidad.values());
			model.addAttribute("docentes", docenteService.getDocentes());
			model.addAttribute("carreras", carreraService.getCarreras());
			model.addAttribute("edicion", true);
			return "materias/formMateria";
		} else {
			return "redirect:/materias/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("unaMateria") MateriaDTO materiaDTO, BindingResult result,
			Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("unaMateria", materiaDTO);
			model.addAttribute("modalidades", Modalidad.values());
			model.addAttribute("docentes", docenteService.getDocentes());
			model.addAttribute("carreras", carreraService.getCarreras());
			model.addAttribute("edicion", true);
			return "materias/formMateria";
		}
		materiaService.editMateria(materiaDTO);
		return "redirect:/materias/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarMateria(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		materiaService.deleteMateria(id);
		return "redirect:/materias/lista";
	}

}
