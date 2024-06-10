package ar.edu.unju.fi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.collections.AlumnoList;
import ar.edu.unju.fi.model.Alumno;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private Alumno unAlumno;

	@GetMapping("/lista")
	public String getListaAlumno(Model model) {
		ArrayList<Alumno> listaAlumnos = AlumnoList.getListaAlumnos();
		model.addAttribute("alumnos", listaAlumnos);
		return "listaAlumnos";
	}

	@GetMapping("/nuevo")
	public String getNuevoAlumno(Model model) {
		unAlumno = new Alumno();
		model.addAttribute("unAlumno", unAlumno);
		model.addAttribute("edicion", false);
		return "formAlumno";
	}

	@PostMapping("/guardar")
	public String guardarAlumno(@ModelAttribute("unAlumno") Alumno alumno, Model model,
			RedirectAttributes redirectAttributes) {
		if (AlumnoList.addAlumno(alumno)) {
			String msg = "Se agregó al alumno " + alumno.getNombre() + " " + alumno.getApellido() + " con éxito.";
			redirectAttributes.addFlashAttribute("msgAdd", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr",
					"Error al agregar alumno (el DNI '" + alumno.getDni() + "' o LU '" + alumno.getLu() + "' ya existen).");
		}
		return "redirect:/alumnos/lista";
	}

	@GetMapping("/modificar/{dni}")
	public String getModificarAlumno(@PathVariable("dni") String dni, Model model) {
		unAlumno = AlumnoList.findAlumnoByDni(dni);
		if (unAlumno != null) {
			model.addAttribute("unAlumno", unAlumno);
			model.addAttribute("edicion", true);
			return "formAlumno";
		} else {
			return "redirect:/alumnos/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("unAlumno") Alumno alumno, Model model,
			RedirectAttributes redirectAttributes) {
		if (AlumnoList.updateAlumno(alumno)) {
			String msg = "Se modificó al alumno " + alumno.getNombre() + " " + alumno.getApellido() + " con éxito.";
			redirectAttributes.addFlashAttribute("msgEdit", msg);
		} else {
			redirectAttributes.addFlashAttribute("msgErr",
					"Error al modificar alumno (el LU '" + alumno.getLu() + "' ya existe).");
		}
		return "redirect:/alumnos/lista";
	}

	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable("dni") String dni, RedirectAttributes redirectAttributes) {
		Alumno alumno = AlumnoList.findAlumnoByDni(dni);
		if (alumno != null) {
			String msg = "Se eliminó a " + alumno.getNombre() + " " + alumno.getApellido() + " con éxito.";
			redirectAttributes.addFlashAttribute("msgRem", msg);
			AlumnoList.removeAlumno(alumno);
		} else {
			redirectAttributes.addFlashAttribute("msgErr", "Error al eliminar alumno (el alumno no existe).");
		}
		return "redirect:/alumnos/lista";
	}

}
