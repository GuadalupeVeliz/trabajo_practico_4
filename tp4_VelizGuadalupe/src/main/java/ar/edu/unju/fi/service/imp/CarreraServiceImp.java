package ar.edu.unju.fi.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.dto.CarreraDTO.Estado;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService {

	private static final Logger logger = LoggerFactory.getLogger(CarreraServiceImp.class);

	@Autowired
	private CarreraRepository carreraRepository;

	@Autowired
	private CarreraMapper carreraMapper;

	@Override
	public CarreraDTO getCarrera(Long id) {
		Carrera carrera = carreraRepository.findById(id).orElse(null);
		if (carrera != null) {
			CarreraDTO carreraDTO = carreraMapper.carreraToCarreraDTO(carrera);
			logger.info("Carrera encontrada con id: {}", id);
			return carreraDTO;
		}
		logger.warn("Carrera con id: {} no encontrada", id);
		return null;
	}

	@Override
	public List<CarreraDTO> getCarreras() {
		List<Carrera> carreras = carreraRepository.findAll();
		logger.info("Se obtuvieron {} carreras", carreras.size());
		return carreras.stream().map(carrera -> {
			return carreraMapper.carreraToCarreraDTO(carrera);
		}).collect(Collectors.toList());
	}

	@Override
	public void saveCarrera(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.carreraDTOToCarrera(carreraDTO);
		carreraRepository.save(carrera);
		logger.info("Carrera guardada con éxito: {}", carreraDTO);
	}

	@Override
	public void editCarrera(CarreraDTO carreraDTO) {
		Carrera carrera = carreraMapper.carreraDTOToCarrera(carreraDTO);
		carreraRepository.save(carrera);
		logger.info("Carrera editada con éxito: {}", carreraDTO.getNombre());
	}

	@Override
	public void deleteCarrera(Long id) {
		if (carreraRepository.existsById(id)) {
			carreraRepository.deleteById(id);
			logger.info("Carrera con id: {} eliminada con éxito", id);
		} else {
			logger.warn("Carrera con id: {} no encontrada para eliminar", id);
		}
	}
}
