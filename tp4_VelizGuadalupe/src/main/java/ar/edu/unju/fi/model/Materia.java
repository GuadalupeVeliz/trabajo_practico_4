package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Entity
@Table(name = "Materias")
@Component
public class Materia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo",nullable = false,unique =true)
	private String codigo;
	
	@Column(name="nombre",nullable=false)
	private String nombre;
	
	@Column(name="curso",nullable=false)
	private int curso;

	@Column(name="cantidadHoras",nullable=false)
	private int cantidadHoras;
	
	@Column(name="modalidad",nullable=false)
	private Modalidad modalidad;
	
	@ManyToOne
	@JoinColumn(name="id_docente")
	private Docente docente;
	
	@ManyToOne
	@JoinColumn(name="id_carrera")
	private Carrera carrera;
	
	@ManyToMany(mappedBy = "materias")
	private List<Alumno> alumnos;
	
	public enum Modalidad{
		VIRTUAL,PRESENCIAL;
	}
	
}
