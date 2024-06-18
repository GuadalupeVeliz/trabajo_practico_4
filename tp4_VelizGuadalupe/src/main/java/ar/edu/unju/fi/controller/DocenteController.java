package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.service.DocenteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

	@Autowired
	private static DocenteDto unDocente;
	
	@Autowired
	private DocenteService docenteService; 

	@GetMapping("/lista")
	public String getListaDocente(Model model) {
		model.addAttribute("docentes", docenteService.getListaDocentes());
		return "listaDocentes";
	}

	@GetMapping("/nuevo")
	public String getNuevoDocente(Model model) {
		unDocente = new DocenteDto();
		model.addAttribute("unDocente", unDocente);
		model.addAttribute("edicion", false);
		return "formDocente";
	}

	@PostMapping("/guardar")
	public String guardarDocente(@ModelAttribute("unDocente") DocenteDto docenteDto, Model model,
			RedirectAttributes redirectAttributes) {
		if (docenteService.addDocente(docenteDto)) {
			String msg = "Se agregó al docente " + docenteDto.getNombre() + " " + docenteDto.getApellido() + " con éxito.";
			redirectAttributes.addFlashAttribute("msgAdd", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al agregar docente (el Legajo '" + docenteDto.getLegajo() + "' ya existe).");
		}
		return "redirect:/docentes/lista";
	}

	@GetMapping("/modificar/{legajo}")
	public String getModificarDocente(@PathVariable("legajo") String legajo, Model model) {
		unDocente = docenteService.findDocenteByLegajo(legajo);
		if (unDocente != null) {
			model.addAttribute("unDocente", unDocente);
			model.addAttribute("edicion", true);
			return "formDocente";
		} else {
			return "redirect:/docentes/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("unDocente") DocenteDto docenteDto, Model model, RedirectAttributes redirectAttributes) {
		if (docenteService.updateDocente(docenteDto)) {
			String msg = "Se modificó al docente " + docenteDto.getNombre() + " " + docenteDto.getApellido() + " con éxito.";
			redirectAttributes.addFlashAttribute("msgEdit", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al modificar docente (el Legajo '" + docenteDto.getLegajo() + "' ya existe).");
		}
		return "redirect:/docentes/lista";
	}

	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable("legajo") String legajo, RedirectAttributes redirectAttributes) {
		DocenteDto docenteDto = docenteService.findDocenteByLegajo(legajo);
		if (docenteDto != null) {
			String msg = "Se eliminó al docente " + docenteDto.getNombre() + " " + docenteDto.getApellido() + " con éxito.";
			if (docenteService.removeDocente(docenteDto.getLegajo())) {
				redirectAttributes.addFlashAttribute("msgRem", msg);				
			} else {
				redirectAttributes.addFlashAttribute("msgErr", "Error al eliminar docente (el docente no exite).");
			}
		}
		return "redirect:/docentes/lista";
	}

}
