package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Alumno;

public class AlumnoList {

	private ArrayList<Alumno> alumnos;

	public AlumnoList() {
		alumnos = new ArrayList<>();
		alumnos.add(new Alumno("43527103", "Guadalupe", "Véliz", "luveliz@gmail.com", "3884774333", LocalDate.of(2001, 8, 11), "Gral Savio, Palpala", "4317"));
		alumnos.add(new Alumno("42758692", "Juan", "Mamani", "jmamani@gmail.com", "3884345315", LocalDate.of(2000, 2, 15), "Gral Savio, Palpala", "4212"));
		alumnos.add(new Alumno("40857372", "Jose", "Ortiz", "jortiz@gmail.com", "3885456741", LocalDate.of(2002, 3, 1), "Cuyaya, S. S. Jujuy", "4456"));
		alumnos.add(new Alumno("41857294", "Nicolas", "Quispe", "nquispe@gmail.com", "3886576234", LocalDate.of(1999, 4, 9), "Moreno, S. S. Jujuy", "4452"));
	}

	public ArrayList<Alumno> listarAlumnos() {
		return alumnos;
	}
	
	public Alumno buscarAlumno(String dni) {
		for (Alumno alumno : alumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}
	
	
	public void modificarAlumno(Alumno alumno) {
		Iterator<Alumno> alumnosIterator = alumnos.iterator();
		boolean encontrado = false;
		while (alumnosIterator.hasNext() && !encontrado) {
			Alumno alu = alumnosIterator.next();
			if (alu.getDni().equals(alumno.getDni())) {
				encontrado = true;
				alu.setDni(alumno.getDni());;
				alu.setNombre(alumno.getNombre());
				alu.setApellido(alumno.getApellido());
				alu.setEmail(alumno.getEmail());
				alu.setTelefono(alumno.getTelefono());
				alu.setFechaNacimiento(alumno.getFechaNacimiento());
				alu.setDomicilio(alumno.getDomicilio());
				alu.setLu(alumno.getLu());
			}
		}
	}
	
	public void eliminarAlumno(Alumno alumno) {
		Iterator<Alumno> alumnoIterator = alumnos.iterator();
		boolean encontrado = false;
		while (alumnoIterator.hasNext() && !encontrado) {
			if (alumnoIterator.next().getDni().equals(alumno.getDni())) {
				encontrado = true;
				alumnoIterator.remove();
			}
		}
	}
	
}
