package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Materia.Modalidad;

public class MateriaList {
	
	private ArrayList<Materia> materias;
	
	public MateriaList() {
		materias = new ArrayList<>();
		
		Docente docente1 = new Docente("001", "Juan", "Perez", "juan@unju.fi.com", "3881234567");
		Docente docente2 = new Docente("002", "María", "Gómez", "maria@unju.fi.com", "3882345678");
		Docente docente3 = new Docente("003", "Carlos", "López", "carlos@unju.fi.com", "3883456789");
		Docente docente4 = new Docente("004", "Laura", "Martinez", "laura@unju.fi.com", "3884567890");
		
		Carrera carrera1 = new Carrera("INF", "Ingeniería Informática", 5, "Activa");
		Carrera carrera2 = new Carrera("APU", "Analista Programador Universitario", 6, "Activa");
		
		materias.add(new Materia("MAT001", "Matemáticas I", "1º", 60, Modalidad.PRESENCIAL, docente1, carrera1));
		materias.add(new Materia("FIS001", "Ingles I", "1º", 50, Modalidad.VIRTUAL, docente2, carrera2));
		materias.add(new Materia("LIT001", "Introduccion a la Programacion", "3º", 45, Modalidad.PRESENCIAL, docente3, carrera1));
		materias.add(new Materia("HIS001", "Programacion Visual", "2º", 40, Modalidad.VIRTUAL, docente4, carrera2));
		materias.add(new Materia("BIO001", "Base de Datos I", "1º", 55, Modalidad.PRESENCIAL, docente1, carrera1));
		materias.add(new Materia("QUI001", "Programacion Estructurada", "3º", 50, Modalidad.VIRTUAL, docente2, carrera2));
		materias.add(new Materia("ING001", "Inglés V", "1º", 40, Modalidad.PRESENCIAL, docente3, carrera1));
		materias.add(new Materia("SOC001", "Programacion Orientada a Objetos", "2º", 45, Modalidad.VIRTUAL, docente4, carrera2));
		materias.add(new Materia("ART001", "Artes Plásticas", "3º", 60, Modalidad.PRESENCIAL, docente1, carrera1));
		materias.add(new Materia("TEC001", "Programacion Web", "3º", 50, Modalidad.VIRTUAL, docente2, carrera2));
	}
	
	public ArrayList<Materia> listarMateria() {
		return materias;
	}
	
	public Materia buscarMateria(String codigo) {
		for (Materia materia : materias) {
			if (materia.getCodigo().equals(codigo)) {
				return materia;
			}
		}
		return null;
	}
	
	
	public void modificarMateria(Materia materia) {
		Iterator<Materia> materiasIterator = materias.iterator();
		boolean encontrado = false;
		while (materiasIterator.hasNext() && !encontrado) {
			Materia mat = materiasIterator.next();
			if (mat.getCodigo().equals(mat.getCodigo())) {
				encontrado = true;
				mat.setCodigo(materia.getCodigo());
				mat.setCantidadHoras(materia.getCantidadHoras());
				mat.setCarrera(materia.getCarrera());
				mat.setCurso(materia.getCurso());
				mat.setDocente(materia.getDocente());
				mat.setModalidad(materia.getModalidad());
				mat.setNombre(materia.getNombre());
			}
		}
	}
	
	public void eliminarMateria(Materia materia) {
		Iterator<Materia> materiasIterator = materias.iterator();
		boolean encontrado = false;
		while (materiasIterator.hasNext() && !encontrado) {
			if (materiasIterator.next().getCodigo().equals(materia.getCodigo())) {
				encontrado = true;
				materiasIterator.remove();
			}
		}
	}
	
}
