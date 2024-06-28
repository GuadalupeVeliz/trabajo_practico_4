package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.repository.MateriaRepository;
import ar.edu.unju.fi.service.MateriaService;

@Service
public class MateriaServiceImp implements MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;

	@Autowired
	private MateriaMapper materiaMapper;

	@Override
	public MateriaDTO getMateria(Long id) {
		Materia materia = materiaRepository.findById(id).orElse(null);
		if (materia != null) {
			MateriaDTO materiaDTO = materiaMapper.materiaToMateriaDTO(materia);
			return materiaDTO;
		}
		return null;
	}

	@Override
	public List<MateriaDTO> getMaterias() {
		List<Materia> materias = materiaRepository.findAll();
		return materias.stream().map(materia -> {
			return materiaMapper.materiaToMateriaDTO(materia);
		}).collect(Collectors.toList());
	}

	@Override
	public void saveMateria(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.materiaDTOToMateria(materiaDTO);
		materiaRepository.save(materia);

	}

	@Override
	public void editMateria(MateriaDTO materiaDTO) {
		Materia materia = materiaMapper.materiaDTOToMateria(materiaDTO);
		materiaRepository.save(materia);
	}

	@Override
	public void deleteMateria(Long id) {
		materiaRepository.deleteById(id);

	}

}
