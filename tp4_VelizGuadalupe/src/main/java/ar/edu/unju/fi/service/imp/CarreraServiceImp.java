package ar.edu.unju.fi.service.imp;

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
	
	private static List<Carrera> Carreras;
	private static List<Alumno> Alumnos;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private CarreraMapper carreraMapper;

	static {
		Carrera carrera1 = new Carrera(null, "INF", "Ingeniería Informática", 5, Estado.ACTIVO, null, Alumnos);
		Carreras = new ArrayList<>();
		Carreras.add(carrera1);
		
		Alumno alumno1 = new Alumno(1L, "12345678", "Juan", "Pérez", "juan.perez@example.com", "3884567890", LocalDate.of(1995, 5, 20), "Calle Falsa 123", "1234", carrera1);
		Alumnos = new ArrayList<>();
		Alumnos.add(alumno1);
		
		carrera1.setAlumnos(Alumnos);
	}
    
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

