package ar.edu.unju.fi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.AlumnoList;
import ar.edu.unju.fi.model.Alumno;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	
	@Autowired
	private Alumno unAlumno;
	
	@GetMapping("/lista")
	public String getPaginaAlumnos(Model model) {
		ArrayList<Alumno> listaAlumnos = AlumnoList.getListaAlumnos();
		model.addAttribute("alumnos", listaAlumnos);
		return "listaAlumnos";
	}
	
	@GetMapping("/formulario")
	public String getPaginaFormAlumnos(Model model) {
		unAlumno = new Alumno();
		model.addAttribute("unAlumno", unAlumno);
		model.addAttribute("edicion", false);
		return "formAlumno";
	}
	
	@PostMapping("/guardar")
	public String guardarAlumno(@ModelAttribute("unAlumno") Alumno alumno, Model model) {
		AlumnoList.addAlumno(alumno);
		return "redirect:/alumnos/lista";
	}
	
	
	@GetMapping("/modificar/{dni}")
	public String getPaginaFormModifyAlumnos(@PathVariable("dni") String dni, Model model) {
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
	public String modificarAlumno(@ModelAttribute("unAlumno") Alumno alumno, Model model) {
		AlumnoList.updateAlumno(alumno);
		return "redirect:/alumnos/lista";
	}
	
	@GetMapping("/eliminar/{dni}")
	public String eliminarAlumno(@PathVariable("dni") String dni) {
		Alumno alumnoBuscado = AlumnoList.findAlumnoByDni(dni);
		if (alumnoBuscado != null) {
			AlumnoList.removeAlumno(alumnoBuscado);
		}
		return "redirect:/alumnos/lista";
	}
	
	
}
