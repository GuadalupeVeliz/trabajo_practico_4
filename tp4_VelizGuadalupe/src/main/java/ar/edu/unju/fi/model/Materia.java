package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Column(name="docente",nullable=false)
	@Autowired
	private Docente docente;
	
	@Column(name="carrera",nullable=false)
	@Autowired
	private Carrera carrera;
	
	public enum Modalidad{
		VIRTUAL,PRESENCIAL;
	}
	
}
