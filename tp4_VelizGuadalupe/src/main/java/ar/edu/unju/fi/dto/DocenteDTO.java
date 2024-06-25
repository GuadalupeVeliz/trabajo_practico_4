package ar.edu.unju.fi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTO {
	
	private Long id;
	private String legajo;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
}
