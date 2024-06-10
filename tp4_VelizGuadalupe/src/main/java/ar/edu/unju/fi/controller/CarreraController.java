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
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

	@Autowired
	private Carrera unaCarrera;

	@GetMapping("/lista")
	public String getListaCarrera(Model model) {
		model.addAttribute("carreras", CarreraList.getListaCarreras());
		return "listaCarreras";
	}

	@GetMapping("/nuevo")
	public String getNuevoCarrera(Model model) {
		unaCarrera = new Carrera();
		model.addAttribute("unaCarrera", unaCarrera);
		model.addAttribute("edicion", false);
		return "formCarrera";
	}

	@PostMapping("/guardar")
	public String guardarCarrera(@ModelAttribute("unDocente") Carrera carrera, Model model,
			RedirectAttributes redirectAttributes) {
		if (CarreraList.addCarrera(carrera)) {
			String msg = "Se ha agregado la carrera '" + carrera.getNombre() + "' con codigo '" + carrera.getCodigo()
					+ "' con éxito.";
			redirectAttributes.addFlashAttribute("msgAdd", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al agregar carrera (el Codigo '" + carrera.getCodigo() + "' ya existe).");
		}
		return "redirect:/carreras/lista";
	}

	@GetMapping("/modificar/{codigo}")
	public String getModificarCarrera(@PathVariable("codigo") String codigo, Model model) {
		unaCarrera = CarreraList.findCarreraByCodigo(codigo);
		if (unaCarrera != null) {
			model.addAttribute("unaCarrera", unaCarrera);
			model.addAttribute("edicion", true);
			return "formCarrera";
		} else {
			return "redirect:/carreras/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("unaCarrera") Carrera carrera, Model model,
			RedirectAttributes redirectAttributes) {
		if (CarreraList.updateCarrera(carrera)) {
			String msg = "Se ha modificado la carrera '" + carrera.getNombre() + "' con éxito.";
			redirectAttributes.addFlashAttribute("msgEdit", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al modificar la carrera (el Codigo '" + carrera.getCodigo() + "' ya existe).");
		}
		return "redirect:/carreras/lista";
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable("codigo") String codigo, RedirectAttributes redirectAttributes) {
		Carrera carrera = CarreraList.findCarreraByCodigo(codigo);
		if (carrera != null) {
			String msg = "Se ha eliminado la carrera '" + carrera.getNombre() + "' con codigo '" + carrera.getCodigo() + "' con éxito.";
			if (CarreraList.removeCarrera(carrera)) {
				redirectAttributes.addFlashAttribute("msgRem", msg);
			} else {
				redirectAttributes.addFlashAttribute("msgErr", "Error al eliminar la carrera (la carrera no existe).");
			}
		}
		return "redirect:/carreras/lista";
	}

}
