package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.edu.unju.fi.dto.AlumnoDTO;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.CarreraDTO.Estado;
import ar.edu.unju.fi.service.AlumnoService;
import ar.edu.unju.fi.service.CarreraService;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;
	private CarreraDTO unaCarreraDTO;

	@GetMapping("/lista")
	public String getListaCarrera(Model model) {
		model.addAttribute("carreras", carreraService.getCarreras());
		return "carreras/listaCarreras";
	}
	

	@GetMapping("/nuevo")
	public String getNuevoCarrera(Model model) {
		CarreraDTO unaCarreraDTO = new CarreraDTO();
		model.addAttribute("unaCarrera", unaCarreraDTO);
		model.addAttribute("estados", Estado.values());
		model.addAttribute("edicion", false);
		return "carreras/formCarrera";
	}

	@PostMapping("/guardar")
	public String guardarCarrera(@ModelAttribute("unaCarrera") CarreraDTO carreraDTO, Model model,
			RedirectAttributes redirectAttributes) {
		
		carreraService.saveCarrera(carreraDTO);
		return "redirect:/carreras/lista";
	}

	@GetMapping("/modificar/{id}")
	public String getModificarCarrera(@PathVariable("id") Long id, Model model) {
		unaCarreraDTO = carreraService.getCarrera(id);
		if (unaCarreraDTO != null) {
			model.addAttribute("unaCarrera", unaCarreraDTO);
			model.addAttribute("estados", Estado.values());
			model.addAttribute("edicion", true);
			return "carreras/formCarrera";
		} else {
			return "redirect:/carreras/lista";
		}
	}

	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("unaCarrera") CarreraDTO carreraDTO, Model model,
			RedirectAttributes redirectAttributes) {
		carreraService.editCarrera(carreraDTO);
		return "redirect:/carreras/lista";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarCarrera(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		carreraService.deleteCarrera(id);
		return "redirect:/carreras/lista";
	}
	
	@GetMapping("/{id}/alumnos")
	public String getCarreraAlumnos(@PathVariable("id") Long id, Model model) {
	    CarreraDTO carreraDTO = carreraService.getCarrera(id);
	    if (carreraDTO != null) {
	        model.addAttribute("carrera", carreraDTO);
	        return "carreras/CarreraAlumno";
	    } else {
	        return "redirect:/carreras/lista";
	    }
	}
 
}
