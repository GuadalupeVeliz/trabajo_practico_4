package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Docente;

public class DocenteList {

	private static ArrayList<Docente> lista = new ArrayList<>();
	
	/*

	public static ArrayList<Docente> getListaDocentes() {
		if (lista.isEmpty()) {
			lista.add(new Docente("001", "Graciela", "Brizuela", "gbrizuela@unju.fi.com", "3884567890"));
			lista.add(new Docente("002", "Norma", "Cañizares", "ncanizares@unju.fi.com", "3883456789"));
			lista.add(new Docente("003", "Marcelo", "Perez Ibarra", "mperezi@unju.fi.com", "3885678901"));
			lista.add(new Docente("004", "Hector", "Liberatori", "hliberatori@unju.fi.com", "3888901234"));
			lista.add(new Docente("005", "Virginia", "Battezzati", "vbattezzati@unju.fi.com", "3887890123"));
			lista.add(new Docente("006", "Agustina", "Cornell", "mcornell@unju.fi.com", "3884567890"));
			lista.add(new Docente("007", "Hector", "Tarifa", "htarifa@unju.fi.com", "3884567890"));
			lista.add(new Docente("008", "Ariel", "Vega", "arielvega@unju.fi.com", "3882345678"));
			lista.add(new Docente("009", "Juan Carlos", "Rodriguez", "jcrodriguez@unju.fi.com", "3881234567"));
			lista.add(new Docente("010", "Jose", "Zapana", "josezapana@unju.fi.com", "3884567890"));
			lista.add(new Docente("011", "Cristina", "Ayusa", "mayusa@unju.fi.com", "3884567890"));
			lista.add(new Docente("012", "Cesar", "Castillo", "ccastillo@unju.fi.com", "3884567890"));
			lista.add(new Docente("013", "Virginia", "Valenzuela", "vvalenzuela@unju.fi.com", "3883456789"));
			lista.add(new Docente("014", "Consuelo", "Gomez", "cgomez@unju.fi.com", "3884567890"));
			lista.add(new Docente("015", "Alfredo", "Espinosa", "alfredespinosa@unju.fi.com", "3884567890"));
			lista.add(new Docente("016", "Nelida", "Caseres", "caseres@unju.fi.com", "3884567890"));
			lista.add(new Docente("017", "Sofia", "Aragon", "saragon@unju.fi.com", "3884567890"));
			lista.add(new Docente("018", "Carolina", "Apaza", "carolinaapaza@unju.fi.com", "3882345678"));
			lista.add(new Docente("019", "Veronica", "Torres", "veronicatorres@unju.fi.com", "3886789012"));
			lista.add(new Docente("020", "Carolina", "Rodriguez", "crodrigueza@unju.fi.com", "3880123456"));
			lista.add(new Docente("021", "Fernanda", "Villarrubia", "fvillarrubia@unju.fi.com", "3881234567"));
			lista.add(new Docente("022", "Graciela", "Garnica", "ggarnica@unju.fi.com", "3882345678"));

		}
		return lista;
	}
	*/
	
	public static Docente findDocenteByLegajo(String legajo) {
		for (Docente docente : lista) {
			if (docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}

	public static boolean addDocente(Docente docente) {
		for (Docente d : lista) {
			if (d.getLegajo().equals(docente.getLegajo())) {
				return false;
			}
		}
		lista.add(docente);
		return true;
	}

	public static boolean updateDocente(Docente docente) {
		Iterator<Docente> docentesIterator = lista.iterator();
		boolean encontrado = false;
		boolean modificado = false;
		while (docentesIterator.hasNext() && !encontrado) {
			Docente doc = docentesIterator.next();
			if (doc.getLegajo().equals(docente.getLegajo())) {
				encontrado = true;
				doc.setNombre(docente.getNombre());
				doc.setApellido(docente.getApellido());
				doc.setEmail(docente.getEmail());
				doc.setTelefono(docente.getTelefono());
				modificado = true;
			}
		}
		return modificado;
	}

	public static boolean removeDocente(Docente docente) {
		Iterator<Docente> docentesIterator = lista.iterator();
		boolean encontrado = false;
		boolean eliminado = false;
		while (docentesIterator.hasNext() && !encontrado) {
			if (docentesIterator.next().getLegajo().equals(docente.getLegajo())) {
				encontrado = true;
				docentesIterator.remove();
				eliminado = true;
			}
		}
		return eliminado;
	}
}
