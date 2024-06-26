package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.repository.CarreraRepository;
import ar.edu.unju.fi.service.CarreraService;

@Service
public class CarreraServiceImp implements CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private CarreraMapper carreraMapper;

    @Override
    public CarreraDTO getCarrera(Long id) {
        Carrera carrera = carreraRepository.findById(id).orElse(null);
        if (carrera != null) {
            CarreraDTO carreraDTO = carreraMapper.carreraToCarreraDTO(carrera);
            return carreraDTO;
        }
        return null;
    }

    @Override
    public List<CarreraDTO> getCarreras() {
        List<Carrera> carreras = carreraRepository.findAll();
        return carreras.stream()
                .map(carrera -> {
                	return carreraMapper.carreraToCarreraDTO(carrera);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void saveCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = carreraMapper.carreraDTOToCarrera(carreraDTO);
        carreraRepository.save(carrera);
    }

    @Override
    public void editCarrera(CarreraDTO carreraDTO) {
        Carrera carrera = carreraMapper.carreraDTOToCarrera(carreraDTO);
        carreraRepository.save(carrera);
    }

    @Override
    public void deleteCarrera(Long id) {
        carreraRepository.deleteById(id);
    }
}

