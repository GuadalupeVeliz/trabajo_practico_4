package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.collections.DocenteList;
import ar.edu.unju.fi.model.Docente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

	@Autowired
	private static Docente unDocente;

	@GetMapping("/lista")
	public String getListaDocente(Model model) {
		model.addAttribute("docentes", DocenteList.getListaDocentes());
		return "listaDocentes";
	}

	@GetMapping("/nuevo")
	public String getNuevoDocente(Model model) {
		unDocente = new Docente();
		model.addAttribute("unDocente", unDocente);
		model.addAttribute("edicion", false);
		return "formDocente";
	}

	@PostMapping("/guardar")
	public String guardarDocente(@ModelAttribute("unDocente") Docente docente, Model model,
			RedirectAttributes redirectAttributes) {
		if (DocenteList.addDocente(docente)) {
			String msg = "Se agregó al docente " + docente.getNombre() + " " + docente.getApellido() + " con éxito.";
			redirectAttributes.addFlashAttribute("msgAdd", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al agregar docente (el Legajo '" + docente.getLegajo() + "' ya existe).");
		}
		return "redirect:/docentes/lista";
	}

	@GetMapping("/modificar/{legajo}")
	public String getModificarDocente(@PathVariable("legajo") String legajo, Model model) {
		unDocente = DocenteList.findDocenteByLegajo(legajo);
		if (unDocente != null) {
			model.addAttribute("unDocente", unDocente);
			model.addAttribute("edicion", true);
			return "formDocente";
		} else {
			return "redirect:/docentes/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("unDocente") Docente docente, Model model, RedirectAttributes redirectAttributes) {
		if (DocenteList.updateDocente(docente)) {
			String msg = "Se modificó al docente " + docente.getNombre() + " " + docente.getApellido() + " con éxito.";
			redirectAttributes.addFlashAttribute("msgEdit", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al modificar docente (el Legajo '" + docente.getLegajo() + "' ya existe).");
		}
		return "redirect:/docentes/lista";
	}

	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable("legajo") String legajo, RedirectAttributes redirectAttributes) {
		Docente docente = DocenteList.findDocenteByLegajo(legajo);
		if (docente != null) {
			String msg = "Se eliminó al docente " + docente.getNombre() + " " + docente.getApellido() + " con éxito.";
			if (DocenteList.removeDocente(docente)) {
				redirectAttributes.addFlashAttribute("msgRem", msg);				
			} else {
				redirectAttributes.addFlashAttribute("msgErr", "Error al eliminar docente (el docente no exite).");
			}
		}
		return "redirect:/docentes/lista";
	}

}
