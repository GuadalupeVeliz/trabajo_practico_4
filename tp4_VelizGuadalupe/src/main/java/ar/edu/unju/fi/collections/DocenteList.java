package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Docente;

public class DocenteList {

	private ArrayList<Docente> docentes;

	public DocenteList() {
		docentes = new ArrayList<>();
		docentes.add(new Docente("001", "Juan", "Perez", "juan@unju.fi.com", "3881234567"));
		docentes.add(new Docente("002", "María", "Gómez", "maria@unju.fi.com", "3882345678"));
		docentes.add(new Docente("003", "Carlos", "López", "carlos@unju.fi.com", "3883456789"));
		docentes.add(new Docente("004", "Laura", "Martinez", "laura@unju.fi.com", "3884567890"));
		docentes.add(new Docente("005", "Pedro", "Rodriguez", "pedro@unju.fi.com", "3885678901"));
		docentes.add(new Docente("006", "Ana", "Sánchez", "ana@unju.fi.com", "3886789012"));
		docentes.add(new Docente("007", "Diego", "Fernández", "diego@unju.fi.com", "3887890123"));
		docentes.add(new Docente("008", "Sofía", "González", "sofia@unju.fi.com", "3888901234"));
	}

	public ArrayList<Docente> listarDocentes() {
		return docentes;
	}

	public Docente buscarDocente(String legajo) {
		for (Docente docente : docentes) {
			if (docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}

	public void modificarDocente(Docente docente) {
		Iterator<Docente> docentesIterator = docentes.iterator();
		boolean encontrado = false;
		while (docentesIterator.hasNext() && !encontrado) {
			Docente doc = docentesIterator.next();
			if (doc.getLegajo().equals(docente.getLegajo())) {
				encontrado = true;
				doc.setLegajo(docente.getLegajo());
				doc.setNombre(docente.getNombre());
				doc.setApellido(docente.getApellido());
				doc.setEmail(docente.getEmail());
				doc.setTelefono(docente.getTelefono());
			}
		}
	}

	public void eliminarDocente(Docente docente) {
		Iterator<Docente> docentesIterator = docentes.iterator();
		boolean encontrado = false;
		while (docentesIterator.hasNext() && !encontrado) {
			if (docentesIterator.next().getLegajo().equals(docente.getLegajo())) {
				encontrado = true;
				docentesIterator.remove();
			}
		}
	}
}
