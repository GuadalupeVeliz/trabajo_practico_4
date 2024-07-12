package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;
import ar.edu.unju.fi.service.MateriaService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService; 
	
	@Autowired
	private MateriaService materiaService;
	
	private DocenteDTO unDocenteDTO;

	@GetMapping("/lista")
	public String getListaDocente(Model model) {
		model.addAttribute("docentes", docenteService.getDocentes());
		return "docentes/listaDocentes";
	}

	@GetMapping("/nuevo")
	public String getNuevoDocente(Model model) {
		DocenteDTO unDocenteDTO = new DocenteDTO();
		model.addAttribute("unDocente", unDocenteDTO);
		model.addAttribute("edicion", false);
		return "docentes/formDocente";
	}

	@PostMapping("/guardar")
	public String guardarDocente(@Valid @ModelAttribute("unDocente") DocenteDTO docenteDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("unDocente", docenteDTO);
			model.addAttribute("edicion", false);
			return "docentes/formDocente";
		}
		docenteService.saveDocente(docenteDTO);
		return "redirect:/docentes/lista";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarDocente(@PathVariable("id") Long id, Model model) {
		unDocenteDTO = docenteService.getDocente(id);
		if (unDocenteDTO != null) {
			model.addAttribute("unDocente", unDocenteDTO);
			model.addAttribute("edicion", true);
			return "docentes/formDocente";
		} else {
			return "redirect:/docentes/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarDocente(@Valid @ModelAttribute("unDocente") DocenteDTO docenteDTO, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("unDocente", docenteDTO);
			model.addAttribute("edicion", true);
			return "docentes/formDocente";
		}
		docenteService.editDocente(docenteDTO);
		return "redirect:/docentes/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarDocente(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		
		docenteService.deleteDocente(id);
		return "redirect:/docentes/lista";
	}

	@GetMapping("/detalles/{id}")
	public String getDetallesDocente(@PathVariable("id") Long id, Model model) {
		model.addAttribute("docente", docenteService.getDocente(id));
		model.addAttribute("materias", materiaService.getMaterias());
		return "docentes/detallesDocente";
	}
}
