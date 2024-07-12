package ar.edu.unju.fi.dto;

import java.util.List;

import ar.edu.unju.fi.model.Alumno;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {
	 
	private Long id;
	@NotEmpty(message = "Debe ingresar un codigo.")
	private String codigo;
	@NotEmpty(message = "Debe ingresar un nombre.")
	private String nombre;
	@NotNull(message = "Debe ingresar una cantidad.")
	@Min(value = 1, message = "El curso debe ser al menos 1")
	@Max(value = 7, message = "El curso no puede ser mayor que 7")
	private int cantidadAnios;
	@NotNull(message="Debe elegir un estado")
	private Estado estado;
	
	private List<Alumno> alumnos;
	
	public enum Estado {
		ACTIVO, INACTIVO;
	}
	
}
