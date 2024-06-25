package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.DocenteDTO;
import ar.edu.unju.fi.service.DocenteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
	
	@Autowired
	private DocenteService docenteService; 
	
	private DocenteDTO unDocenteDTO;

	@GetMapping("/lista")
	public String getListaDocente(Model model) {
		model.addAttribute("docentes", docenteService.getDocentes());
		return "listaDocentes";
	}

	@GetMapping("/nuevo")
	public String getNuevoDocente(Model model) {
		DocenteDTO unDocenteDTO = new DocenteDTO();
		model.addAttribute("unDocente", unDocenteDTO);
		model.addAttribute("edicion", false);
		return "formDocente";
	}

	@PostMapping("/guardar")
	public String guardarDocente(@ModelAttribute("unDocente") DocenteDTO docenteDTO, Model model,
			RedirectAttributes redirectAttributes) {
		
		docenteService.saveDocente(docenteDTO);
		return "redirect:/docentes/lista";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarDocente(@PathVariable("id") Long id, Model model) {
		unDocenteDTO = docenteService.getDocente(id);
		if (unDocenteDTO != null) {
			model.addAttribute("unDocente", unDocenteDTO);
			model.addAttribute("edicion", true);
			return "formDocente";
		} else {
			return "redirect:/docentes/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("unDocente") DocenteDTO docenteDTO, Model model, RedirectAttributes redirectAttributes) {
		
		docenteService.editDocente(docenteDTO);
		return "redirect:/docentes/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarDocente(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		
		docenteService.deleteDocente(id);
		return "redirect:/docentes/lista";
	}

}
