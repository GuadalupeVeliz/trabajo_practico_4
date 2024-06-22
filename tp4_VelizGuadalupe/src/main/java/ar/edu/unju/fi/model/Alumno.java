package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "Alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "dni", nullable = false, unique = true)
	private String dni;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "apelido", nullable = false)
	private String apellido;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "telefono", nullable = false)
	private String telefono;
	@Column(name = "fechaNacimiento", nullable = false)
	private LocalDate fechaNacimiento;
	@Column(name = "domicilio", nullable = false)
	private String domicilio;
	@Column(name = "lu", nullable = false)
	private String lu;


}
