package ar.edu.unju.fi.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO {

	private Long id;
	
	@NotEmpty(message = "Debe ingresar un dni.")
	@Size(min=8,max=8, message="El DNI debe contener 8 dígitos.") 
	private String dni;
	
	@NotEmpty(message = "Debe ingresar un nombre.")
	private String nombre;
	
	@NotEmpty(message = "Debe ingresar un apellido.")
	private String apellido;
	
	@NotBlank(message = "Debe ingresar un email.")
	@Email(message = "el email no es valido.")
	private String email;
	
	@NotBlank(message = "Debe ingresar un telefono.")
	@Size(min=10,max=10, message="El numero de telefono debe contener 10 dígitos.") 
	private String telefono;
	
	@NotNull(message = "Debe ingresar una fecha de nacimiento.")
	@Past(message="La fecha de nacimiento debe ser anterior a la fecha actual")
	private LocalDate fechaNacimiento;
	
	@NotBlank(message = "Debe ingresar un domicilio.")
	private String domicilio;
	
	@NotBlank(message = "Debe ingresar una libreta universitaria.")
	@Size(min=4,max=4, message="El LU debe contener 4 dígitos.") 
	private String lu;
	
	private List<MateriaDTO> materias;
	
	private CarreraDTO carrera; 

}
