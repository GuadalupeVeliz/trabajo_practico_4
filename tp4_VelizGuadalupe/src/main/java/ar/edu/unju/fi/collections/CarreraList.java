package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Carrera;

public class CarreraList {

	private ArrayList<Carrera> carreras;
	
	public CarreraList() {
		carreras = new ArrayList<>();
		carreras.add(new Carrera("INF", "Ingeniería Informática", 5, "Activa"));
		carreras.add(new Carrera("MED", "Medicina", 6, "Activa"));
		carreras.add(new Carrera("ADM", "Administración de Empresas", 4, "Inactiva"));
		carreras.add(new Carrera("DER", "Derecho", 5, "Activa"));
	}
	
	public ArrayList<Carrera> listarCarrera() {
		return carreras;
	}
	
	public Carrera buscarCarrera(String codigo) {
		for (Carrera carrera : carreras) {
			if (carrera.getCodigo().equals(codigo)) {
				return carrera;
			}
		}
		return null;
	}
	
	
	public void modificarCarrera(Carrera carrera) {
		Iterator<Carrera> carrerasIterator = carreras.iterator();
		boolean encontrado = false;
		while (carrerasIterator.hasNext() && !encontrado) {
			Carrera car = carrerasIterator.next();
			if (car.getCodigo().equals(carrera.getCodigo())) {
				encontrado = true;
				car.setCodigo(carrera.getCodigo());
				car.setCantidadAnios(carrera.getCantidadAnios());
				car.setNombre(carrera.getNombre());
				car.setEstado(carrera.getEstado());
			}
		}
	}
	
	public void eliminarCarrera(Carrera carrera) {
		Iterator<Carrera> carrerasIterator = carreras.iterator();
		boolean encontrado = false;
		while (carrerasIterator.hasNext() && !encontrado) {
			if (carrerasIterator.next().getCodigo().equals(carrera.getCodigo())) {
				encontrado = true;
				carrerasIterator.remove();
			}
		}
	}
	
}
