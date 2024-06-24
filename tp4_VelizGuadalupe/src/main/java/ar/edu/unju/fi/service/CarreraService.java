package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface CarreraService {
	
	public CarreraDTO getCarrera(Long id);
	
	public List<CarreraDTO> getCarreras();
	
	public void saveCarrera(CarreraDTO carreraDTO);
	
	public void editCarrera(CarreraDTO carreraDTO);

	public void deleteCarrera(Long id);

}
