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
import ar.edu.unju.fi.collections.MateriaList;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Materia.Modalidad;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private Materia unaMateria;

	@Autowired
	private Docente unDocente;

	@Autowired
	private Carrera unaCarrera;

	@GetMapping("/lista")
	public String getListaMateria(Model model) {
		model.addAttribute("materias", MateriaList.getListaMateria());
		return "listaMaterias";
	}

	@GetMapping("/nuevo")
	public String getNuevaMateria(Model model) {
		unaMateria = new Materia();
		model.addAttribute("unaMateria", unaMateria);
		model.addAttribute("modalidades", Modalidad.values());
		model.addAttribute("docentes", DocenteList.getListaDocentes());
		model.addAttribute("carreras", CarreraList.getListaCarreras());
		model.addAttribute("edicion", false);
		return "formMateria";
	}

	@PostMapping("/guardar")
	public String guardarMateria(@ModelAttribute("codigo") Materia materia, Model model,
			RedirectAttributes redirectAttributes) {
		unDocente = DocenteList.findDocenteByLegajo(materia.getDocente().getLegajo());
		unaCarrera = CarreraList.findCarreraByCodigo(materia.getCarrera().getCodigo());
		materia.setDocente(unDocente);
		materia.setCarrera(unaCarrera);
		if (MateriaList.addMateria(materia)) {
			String msg = "Se ha agregado la materia '" + materia.getNombre() + "' a la carrera '" + unaCarrera.getNombre()
					+ "' con éxito.";
			redirectAttributes.addFlashAttribute("msgAdd", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al agregar materia (el Codigo '" + materia.getCodigo() + "' ya existe).");
		}
		return "redirect:/materias/lista";
	}

	@GetMapping("/modificar/{codigo}")
	public String getModificarMateria(@PathVariable("codigo") String codigo, Model model) {
		unaMateria = MateriaList.findMateriaByCodigo(codigo);
		if (unaMateria != null) {
			model.addAttribute("unaMateria", unaMateria);
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
	public String modificarMateria(@ModelAttribute("unaMateria") Materia materia, Model model,
			RedirectAttributes redirectAttributes) {
		unDocente = DocenteList.findDocenteByLegajo(materia.getDocente().getLegajo());
		unaCarrera = CarreraList.findCarreraByCodigo(materia.getCarrera().getCodigo());
		materia.setDocente(unDocente);
		materia.setCarrera(unaCarrera);
		if (MateriaList.updateMateria(materia)) {
			String msg = "Se ha modificado la materia '" + materia.getNombre() + "' con éxito.";
			redirectAttributes.addFlashAttribute("msgEdit", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al modificar materia (el Codigo '" + materia.getCodigo() + "' ya existe).");
		}
		return "redirect:/materias/lista";
	}

	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable("codigo") String codigo, RedirectAttributes redirectAttributes) {
		Materia materia = MateriaList.findMateriaByCodigo(codigo);
		if (materia != null) {
			String msg = "Se ha eliminado la materia '" + materia.getNombre() + "' con codigo '" + materia.getCodigo()
					+ "' de la carrera '" + materia.getCarrera().getNombre() + "' con éxito.";
			if (MateriaList.removeMateria(materia)) {
				redirectAttributes.addFlashAttribute("msgRem", msg);	
			} else {
				redirectAttributes.addFlashAttribute("msgErr", "Error al eliminar materia (la materia no existe).");
			}
		}
		return "redirect:/materias/lista";
	}

}
