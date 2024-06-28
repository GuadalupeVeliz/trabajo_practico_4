package ar.edu.unju.fi.dto;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MateriaDTO {

	private Long id;
	private String codigo;
	private String nombre;
	private int curso;
	private int cantidadHoras;
	private Modalidad modalidad;
	private Docente docente;
	private Carrera carrera;

	public enum Modalidad {
		VIRTUAL, PRESENCIAL;
	}

}
