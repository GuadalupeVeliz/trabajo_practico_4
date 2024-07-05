package ar.edu.unju.fi.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp = "^[a-zA-Z][0-9]{0,4}$", message = "Debe comenzar con una letra seguida de 4 números")
	private String legajo;
	
	@NotEmpty(message = "Debe ingresar un nombre.")
	private String nombre;
	
	@NotEmpty(message = "Debe ingresar un apellido.")
	private String apellido;
	
	@NotEmpty(message = "Debe ingresar un email.")
	@Email(message = "Debe ser un email válido")
	private String email;
	
	@NotEmpty(message = "Debe ingresar un telefono.")
	@Size(min=10,max=10, message="El telefono debe ser 388XXXXXXX.") 
	private String telefono;
}
