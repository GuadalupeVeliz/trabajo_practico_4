package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Carrera;

public class CarreraList {

	private static ArrayList<Carrera> lista = new ArrayList<>();
	
	public static ArrayList<Carrera> getListaCarreras() {
		if (lista.isEmpty()) {
			lista.add(new Carrera("INF", "Ingeniería Informática", 5, "Activa"));
			lista.add(new Carrera("MED", "Medicina", 6, "Activa"));
			lista.add(new Carrera("ADM", "Administración de Empresas", 4, "Inactiva"));
			lista.add(new Carrera("DER", "Derecho", 5, "Activa"));
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
	
	public static void addCarrera(Carrera carrera) {
		lista.add(carrera);
	}
	
	public static void updateCarrera(Carrera carrera) {
		Iterator<Carrera> carrerasIterator = lista.iterator();
		boolean encontrado = false;
		while (carrerasIterator.hasNext() && !encontrado) {
			Carrera car = carrerasIterator.next();
			if (car.getCodigo().equals(carrera.getCodigo())) {
				encontrado = true;
				car.setCantidadAnios(carrera.getCantidadAnios());
				car.setNombre(carrera.getNombre());
				car.setEstado(carrera.getEstado());
			}
		}
	}
	
	public static void removeCarrera(Carrera carrera) {
		Iterator<Carrera> carrerasIterator = lista.iterator();
		boolean encontrado = false;
		while (carrerasIterator.hasNext() && !encontrado) {
			if (carrerasIterator.next().getCodigo().equals(carrera.getCodigo())) {
				encontrado = true;
				carrerasIterator.remove();
			}
		}
	}
	
}
