package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Materia.Modalidad;

public class MateriaList {

	private static ArrayList<Materia> lista = new ArrayList<>();

	/*
	public static ArrayList<Materia> getListaMateria() {
		if (lista.isEmpty()) {
			Docente brizuela = DocenteList.getListaDocentes().get(0);
			Docente canizares = DocenteList.getListaDocentes().get(1);
			Docente perez = DocenteList.getListaDocentes().get(2);
			Docente liberatori = DocenteList.getListaDocentes().get(3);
			Docente battezzati = DocenteList.getListaDocentes().get(4);
			Docente cornell = DocenteList.getListaDocentes().get(5);
			Docente tarifa = DocenteList.getListaDocentes().get(6);
			Docente vega = DocenteList.getListaDocentes().get(7);

			Carrera apu = CarreraList.getListaCarreras().get(1);

			lista.add(new Materia("AP001", "Ingles I", 1, 75, Modalidad.PRESENCIAL, brizuela, apu));
			lista.add(new Materia("AP002", "Herramientas Informaticas I", 1, 90, Modalidad.VIRTUAL, canizares, apu));
			lista.add(new Materia("AP003", "Programación Estructurada", 1, 90, Modalidad.VIRTUAL, perez, apu));
			lista.add(new Materia("AP004", "Ingles II", 1, 60, Modalidad.PRESENCIAL, brizuela, apu));
			lista.add(new Materia("AP005", "Herramientas Informaticas II", 1, 90, Modalidad.VIRTUAL, canizares, apu));
			lista.add(new Materia("AP006", "Estructura de Datos", 1, 90, Modalidad.VIRTUAL, perez, apu));
			lista.add(new Materia("AP007", "Base de Datos I", 1, 75, Modalidad.VIRTUAL, liberatori, apu));
			lista.add(new Materia("AP008", "Lab. de Sist. Operativos I", 1, 75, Modalidad.VIRTUAL, battezzati, apu));

			lista.add(new Materia("AP009", "Ingles III", 2, 60, Modalidad.PRESENCIAL, cornell, apu));
			lista.add(new Materia("AP010", "Algebra I", 2, 60, Modalidad.PRESENCIAL, tarifa, apu));
			lista.add(new Materia("AP011", "Base de Datos II", 2, 75, Modalidad.PRESENCIAL, liberatori, apu));
			lista.add(new Materia("AP012", "Programacion Visual", 2, 50, Modalidad.VIRTUAL, vega, apu));
			lista.add(new Materia("AP013", "Lab. de Sist. Operativos II", 2, 75, Modalidad.VIRTUAL, battezzati, apu));

		}
		return lista;
	}*/

	public static Materia findMateriaByCodigo(String codigo) {
		for (Materia materia : lista) {
			if (materia.getCodigo().equals(codigo)) {
				return materia;
			}
		}
		return null;
	}

	public static boolean addMateria(Materia materia) {
		for (Materia m : lista) {
			if (m.getCodigo().equals(materia.getCodigo())) {
				return false;
			}
		}
		lista.add(materia);
		return true;
	}

	public static boolean updateMateria(Materia materia) {
		Iterator<Materia> materiasIterator = lista.iterator();
		boolean encontrado = false;
		boolean modificado = false;
		while (materiasIterator.hasNext() && !encontrado) {
			Materia mat = materiasIterator.next();
			if (mat.getCodigo().equals(materia.getCodigo())) {
				encontrado = true;
				mat.setNombre(materia.getNombre());
				mat.setCurso(materia.getCurso());
				mat.setCantidadHoras(materia.getCantidadHoras());
				mat.setModalidad(materia.getModalidad());
				mat.setDocente(materia.getDocente());
				mat.setCarrera(materia.getCarrera());
				modificado = true;
			}
		}
		return modificado;
	}

	public static boolean removeMateria(Materia materia) {
		Iterator<Materia> materiasIterator = lista.iterator();
		boolean encontrado = false;
		boolean eliminado = false;
		while (materiasIterator.hasNext() && !encontrado) {
			if (materiasIterator.next().getCodigo().equals(materia.getCodigo())) {
				encontrado = true;
				materiasIterator.remove();
				eliminado = true;
			}
		}
		return eliminado;
	}

}
