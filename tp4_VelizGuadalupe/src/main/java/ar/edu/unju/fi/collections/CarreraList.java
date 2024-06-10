package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Carrera;

public class CarreraList {

	private static ArrayList<Carrera> lista = new ArrayList<>();
	
	public static ArrayList<Carrera> getListaCarreras() {
		if (lista.isEmpty()) {
			lista.add(new Carrera("INF", "Ingeniería Informática", 5, "Activa"));
			lista.add(new Carrera("APU", "Analista Programador Universitario", 3, "Activa"));
			lista.add(new Carrera("ADM", "Administración de Empresas", 4, "Inactiva"));
			lista.add(new Carrera("DER", "Derecho", 5, "Activa"));
			lista.add(new Carrera("MED", "Medicina", 6, "Activa"));
			lista.add(new Carrera("PSI", "Psicología", 5, "Inactiva"));
			lista.add(new Carrera("COM", "Comunicación Social", 4, "Activa"));
			lista.add(new Carrera("ARQ", "Arquitectura", 5, "Inactiva"));
			lista.add(new Carrera("CON", "Contabilidad", 4, "Activa"));
			lista.add(new Carrera("ECO", "Economía", 4, "Inactiva"));
			lista.add(new Carrera("ING", "Ingeniería Civil", 5, "Activa"));
		}
		return lista;
	}
	
	public static Carrera findCarreraByCodigo(String codigo) {
		for (Carrera carrera : lista) {
			if (carrera.getCodigo().equals(codigo)) {
				return carrera;
			}
		}
		return null;
	}
	
	public static boolean addCarrera(Carrera carrera) {
		for (Carrera c : lista) {
			if (c.getCodigo().equals(carrera.getCodigo())) {
				return false;
			}
		}
		lista.add(carrera);
		return true;
	}
	
	public static boolean updateCarrera(Carrera carrera) {
		Iterator<Carrera> carrerasIterator = lista.iterator();
		boolean encontrado = false;
		boolean modificado = false;
		while (carrerasIterator.hasNext() && !encontrado) {
			Carrera car = carrerasIterator.next();
			if (car.getCodigo().equals(carrera.getCodigo())) {
				encontrado = true;
				car.setCantidadAnios(carrera.getCantidadAnios());
				car.setNombre(carrera.getNombre());
				car.setEstado(carrera.getEstado());
				modificado = true;
			}
		}
		return modificado;
	}
	
	public static boolean removeCarrera(Carrera carrera) {
		Iterator<Carrera> carrerasIterator = lista.iterator();
		boolean encontrado = false;
		boolean eliminado = false;
		while (carrerasIterator.hasNext() && !encontrado) {
			if (carrerasIterator.next().getCodigo().equals(carrera.getCodigo())) {
				encontrado = true;
				carrerasIterator.remove();
				eliminado = true;
			}
		}
		return eliminado;
	}
	
}
