package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Docente;

public class DocenteList {

	private static ArrayList<Docente> lista = new ArrayList<>();

	public static ArrayList<Docente> getListaDocentes() {
		if (lista.isEmpty()) {
			lista.add(new Docente("001", "Juan", "Perez", "juan@unju.fi.com", "3881234567"));
			lista.add(new Docente("002", "María", "Gómez", "maria@unju.fi.com", "3882345678"));
			lista.add(new Docente("003", "Carlos", "López", "carlos@unju.fi.com", "3883456789"));
			lista.add(new Docente("004", "Laura", "Martinez", "laura@unju.fi.com", "3884567890"));
			lista.add(new Docente("005", "Pedro", "Rodriguez", "pedro@unju.fi.com", "3885678901"));
			lista.add(new Docente("006", "Ana", "Sánchez", "ana@unju.fi.com", "3886789012"));
			lista.add(new Docente("007", "Diego", "Fernández", "diego@unju.fi.com", "3887890123"));
			lista.add(new Docente("008", "Sofía", "González", "sofia@unju.fi.com", "3888901234"));
		}
		return lista;
	}

	public static Docente findDocenteByLegajo(String legajo) {
		for (Docente docente : lista) {
			if (docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}
	
	public static void addDocente(Docente docente) {
		lista.add(docente);
	}

	public static void updateDocente(Docente docente) {
		Iterator<Docente> docentesIterator = lista.iterator();
		boolean encontrado = false;
		while (docentesIterator.hasNext() && !encontrado) {
			Docente doc = docentesIterator.next();
			if (doc.getLegajo().equals(docente.getLegajo())) {
				encontrado = true;
				doc.setNombre(docente.getNombre());
				doc.setApellido(docente.getApellido());
				doc.setEmail(docente.getEmail());
				doc.setTelefono(docente.getTelefono());
			}
		}
	}

	public static void removeDocente(Docente docente) {
		Iterator<Docente> docentesIterator = lista.iterator();
		boolean encontrado = false;
		while (docentesIterator.hasNext() && !encontrado) {
			if (docentesIterator.next().getLegajo().equals(docente.getLegajo())) {
				encontrado = true;
				docentesIterator.remove();
			}
		}
	}
}
