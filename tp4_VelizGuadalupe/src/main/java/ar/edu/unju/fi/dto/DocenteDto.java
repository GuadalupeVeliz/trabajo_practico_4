package ar.edu.unju.fi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DocenteDto {
	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
}
