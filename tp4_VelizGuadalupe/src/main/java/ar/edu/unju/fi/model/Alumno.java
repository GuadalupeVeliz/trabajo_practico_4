package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "alumnos_materias",
			joinColumns = @JoinColumn(name = "id_alumno"),
			inverseJoinColumns = @JoinColumn(name = "id_materia")
	)
	private List<Materia> materias;

	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "carrera_id")
	 private Carrera carrera;
} 

