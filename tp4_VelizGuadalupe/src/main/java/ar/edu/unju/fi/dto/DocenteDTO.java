package ar.edu.unju.fi.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
	
	@NotEmpty(message = "Debe ingresar un legajo.")
	private String legajo;
	
	@NotEmpty(message = "Debe ingresar un nombre.")
	private String nombre;
	
	@NotEmpty(message = "Debe ingresar un apellido.")
	private String apellido;
	
	@NotBlank(message = "Debe ingresar un email.")
	@Email(message = "Debe ser un email válido")
	private String email;
	
	@NotBlank(message = "Debe ingresar un telefono.")
	@Size(min=10,max=10, message="El telefono debe ser 388XXXXXXX.") 
	private String telefono;
}
