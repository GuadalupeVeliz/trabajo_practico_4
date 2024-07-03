package ar.edu.unju.fi.dto;

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
	private String codigo;
	private String nombre;
	private int cantidadAnios;
	private Estado estado;
	
	public enum Estado {
		ACTIVO, INACTIVO;
	}

}
