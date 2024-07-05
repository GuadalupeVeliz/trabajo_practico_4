package ar.edu.unju.fi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
	@NotBlank(message = "El código no puede estar en blanco")
	@Size(min = 2, max = 10, message = "El código debe tener entre 2 y 10 caracteres")
	private String codigo;

	@NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
	private String nombre;

	@Min(value = 1, message = "El curso debe ser al menos 1")
	@Max(value = 7, message = "El curso no puede ser mayor que 7")
	private int curso;

	@Min(value = 1, message = "La cantidad de horas debe ser al menos 1")
	@Max(value = 120, message = "La cantidad de horas no debe ser mayor a 120")
	private int cantidadHoras;

	@NotNull(message = "Debe elegir una modalidad")
	private Modalidad modalidad;

	@NotNull(message = "Debe elegir un docente")
	private DocenteDTO docenteDTO;

	@NotNull(message = "Debe elegir una carrera")
	private CarreraDTO carreraDTO;

	public enum Modalidad {
		VIRTUAL, PRESENCIAL;
	}

}
