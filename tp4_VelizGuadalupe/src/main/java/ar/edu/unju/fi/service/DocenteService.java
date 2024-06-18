package ar.edu.unju.fi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.dto.DocenteDto;
import ar.edu.unju.fi.model.Docente;

@Service
public class DocenteService {
	private static List<Docente> docentes;

	static {
		docentes = new ArrayList<>();
		docentes.add(new Docente("001", "Graciela", "Brizuela", "gbrizuela@unju.fi.com", "3884567890"));
		docentes.add(new Docente("002", "Norma", "Cañizares", "ncanizares@unju.fi.com", "3883456789"));
		docentes.add(new Docente("003", "Marcelo", "Perez Ibarra", "mperezi@unju.fi.com", "3885678901"));
		docentes.add(new Docente("004", "Hector", "Liberatori", "hliberatori@unju.fi.com", "3888901234"));
		docentes.add(new Docente("005", "Virginia", "Battezzati", "vbattezzati@unju.fi.com", "3887890123"));
		docentes.add(new Docente("006", "Agustina", "Cornell", "mcornell@unju.fi.com", "3884567890"));
		docentes.add(new Docente("007", "Hector", "Tarifa", "htarifa@unju.fi.com", "3884567890"));
		docentes.add(new Docente("008", "Ariel", "Vega", "arielvega@unju.fi.com", "3882345678"));
		docentes.add(new Docente("009", "Juan Carlos", "Rodriguez", "jcrodriguez@unju.fi.com", "3881234567"));
		docentes.add(new Docente("010", "Jose", "Zapana", "josezapana@unju.fi.com", "3884567890"));
		docentes.add(new Docente("011", "Cristina", "Ayusa", "mayusa@unju.fi.com", "3884567890"));
		docentes.add(new Docente("012", "Cesar", "Castillo", "ccastillo@unju.fi.com", "3884567890"));
		docentes.add(new Docente("013", "Virginia", "Valenzuela", "vvalenzuela@unju.fi.com", "3883456789"));
		docentes.add(new Docente("014", "Consuelo", "Gomez", "cgomez@unju.fi.com", "3884567890"));
		docentes.add(new Docente("015", "Alfredo", "Espinosa", "alfredespinosa@unju.fi.com", "3884567890"));
		docentes.add(new Docente("016", "Nelida", "Caseres", "caseres@unju.fi.com", "3884567890"));
		docentes.add(new Docente("017", "Sofia", "Aragon", "saragon@unju.fi.com", "3884567890"));
		docentes.add(new Docente("018", "Carolina", "Apaza", "carolinaapaza@unju.fi.com", "3882345678"));
		docentes.add(new Docente("019", "Veronica", "Torres", "veronicatorres@unju.fi.com", "3886789012"));
		docentes.add(new Docente("020", "Carolina", "Rodriguez", "crodrigueza@unju.fi.com", "3880123456"));
		docentes.add(new Docente("021", "Fernanda", "Villarrubia", "fvillarrubia@unju.fi.com", "3881234567"));
		docentes.add(new Docente("022", "Graciela", "Garnica", "ggarnica@unju.fi.com", "3882345678"));
	}

	public List<DocenteDto> getListaDocentes() {
		List<DocenteDto> docentesDto = new ArrayList<>();
		for (Docente docente : docentes) {
			DocenteDto docenteDto = new DocenteDto(docente.getLegajo(), docente.getNombre(), docente.getApellido(), docente.getEmail(), docente.getTelefono());
			docentesDto.add(docenteDto);
		}
		return docentesDto;
	}


	public boolean addDocente(DocenteDto docenteDto) {
		if(findDocenteByLegajo(docenteDto.getLegajo()) == null) {
			return false;
		}
		
		Docente docente = new Docente(docenteDto.getLegajo(), docenteDto.getNombre(), docenteDto.getApellido(), docenteDto.getEmail(), docenteDto.getTelefono());
		docentes.add(docente);
		return true;	
	}
	

	public DocenteDto findDocenteByLegajo(String legajo) {
		for (Docente docente : docentes) {
			if (docente.getLegajo().equals(legajo)) {
				DocenteDto docenteDto = new DocenteDto(docente.getLegajo(), docente.getNombre(), docente.getApellido(), docente.getEmail(), docente.getTelefono());
				return docenteDto;
			}
		}
		return null;
	}
	

	public Integer getIndexFor(DocenteDto docenteDto) {
		for (int i = 0 ; i < docentes.size(); i++) {
			if(docentes.get(i).getLegajo().equals(docenteDto.getLegajo())) {
				return i;
			}
		}
		
		return null;
	}


	  public boolean updateDocente(DocenteDto docenteDtoModificado) {
		  Integer ind = getIndexFor(docenteDtoModificado);
		  if(ind == null) {
			  return false;
		  }
		  Docente docenteModificado = new Docente(docenteDtoModificado.getLegajo(), docenteDtoModificado.getNombre(), docenteDtoModificado.getApellido(), docenteDtoModificado.getEmail(), docenteDtoModificado.getTelefono());
		  docentes.set(ind, docenteModificado);
		  return true;
	  }


	  public boolean removeDocente(String leg) {
		  if(findDocenteByLegajo(leg) == null) {
				return false;
			}
	    docentes.removeIf(docente -> docente.getLegajo().equals(leg));
	    return true;
	  }
}
