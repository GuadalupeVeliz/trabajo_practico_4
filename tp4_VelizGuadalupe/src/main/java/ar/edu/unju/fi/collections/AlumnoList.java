package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import ar.edu.unju.fi.model.Alumno;

public class AlumnoList {

	private static ArrayList<Alumno> lista = new ArrayList<>();

	/*public static ArrayList<Alumno> getListaAlumnos() {
		if (lista.isEmpty()) {
			lista.add(new Alumno("43527103", "Guadalupe", "Véliz", "luveliz@gmail.com", "3884334777",
					LocalDate.of(2001, 8, 11), "Gral Savio, Palpala", "4317"));
			lista.add(new Alumno("41123456", "Gabriela", "Rodríguez", "grodriguez@gmail.com", "3881122334",
					LocalDate.of(1986, 5, 14), "Calle Rivadavia 123, San Pedro", "3456"));
			lista.add(new Alumno("41098765", "Miguel", "Sánchez", "msanchez@gmail.com", "3882233445",
					LocalDate.of(1991, 8, 30), "Av. Alvear 456, Fraile Pintado", "5678"));
			lista.add(new Alumno("39912345", "Valeria", "Silva", "vsilva@gmail.com", "3883344556",
					LocalDate.of(1983, 10, 21), "Calle Mitre 789, Calilegua", "7890"));
			lista.add(new Alumno("37876543", "José", "Romero", "jromero@gmail.com", "3884455667",
					LocalDate.of(1994, 4, 17), "Av. Santa Fe 567, Tilcara", "9012"));
			lista.add(new Alumno("42765432", "Patricia", "Ruiz", "pruiz@gmail.com", "3885566778",
					LocalDate.of(1982, 6, 11), "Calle Mendoza 234, Maimará", "3456"));
			lista.add(new Alumno("29654321", "Diego", "Ortiz", "dortiz@gmail.com", "3886677889",
					LocalDate.of(1985, 12, 3), "Av. San Martín 789, Abra Pampa", "5678"));
			lista.add(new Alumno("36543210", "Natalia", "Arias", "narias@gmail.com", "3887788990",
					LocalDate.of(1996, 1, 25), "Calle Buenos Aires 456, San Antonio", "7890"));
			lista.add(new Alumno("39857294", "Gonzalo", "Aguierrez", "gaguierrez@gmail.com", "3885977892",
					LocalDate.of(1974, 10, 29), "Av. Martigena 69, Palpala", "4566"));
			lista.add(new Alumno("38234567", "Ana", "López", "alopez@gmail.com", "3881234567",
					LocalDate.of(1990, 1, 15), "Av. Belgrano 123, San Salvador", "2345"));
			lista.add(new Alumno("37987654", "Javier", "Gómez", "jgomez@gmail.com", "3887654321",
					LocalDate.of(1988, 6, 22), "Calle Independencia 456, Perico", "6789"));
			lista.add(new Alumno("35567890", "María", "Pérez", "mperez@gmail.com", "3883456789",
					LocalDate.of(1992, 9, 10), "Av. 19 de Abril 789, El Carmen", "1122"));
			lista.add(new Alumno("28823456", "Luis", "Martínez", "lmartinez@gmail.com", "3888765432",
					LocalDate.of(1985, 12, 25), "Calle Güemes 567, Monterrico", "3344"));
			lista.add(new Alumno("36789012", "Laura", "González", "lgonzalez@gmail.com", "3882345678",
					LocalDate.of(1987, 3, 5), "Av. Córdoba 891, La Quiaca", "5566"));
			lista.add(new Alumno("39678901", "Pedro", "Ramírez", "pramirez@gmail.com", "3889876543",
					LocalDate.of(1995, 7, 19), "Calle San Martín 123, Humahuaca", "7788"));
			lista.add(new Alumno("29456789", "Elena", "Fernández", "efernandez@gmail.com", "3884567890",
					LocalDate.of(1989, 2, 28), "Av. Uruguay 456, Libertador", "9900"));
			lista.add(new Alumno("41345678", "Andrés", "Mendoza", "amendoza@gmail.com", "3885678901",
					LocalDate.of(1993, 11, 13), "Calle Sarmiento 789, Yuto", "1234"));
			lista.add(new Alumno("31567890", "Laura", "Gómez", "lgomez@gmail.com", "3886789012",
					LocalDate.of(1991, 5, 17), "Calle Belgrano 123, San Pedro", "5678"));
			lista.add(new Alumno("42678901", "Diego", "Martínez", "dmartinez@gmail.com", "3887890123",
					LocalDate.of(1995, 8, 25), "Av. Rivadavia 456, Palpalá", "9101"));
			lista.add(new Alumno("33456789", "María", "López", "mlopez@gmail.com", "3888901234",
					LocalDate.of(1988, 9, 12), "Calle San Martín 789, Perico", "2345"));
			lista.add(new Alumno("44567890", "Pablo", "Rodríguez", "prodriguez@gmail.com", "3889012345",
					LocalDate.of(1994, 12, 3), "Av. Independencia 321, El Carmen", "6789"));
			lista.add(new Alumno("35345678", "Cecilia", "Pérez", "cperez@gmail.com", "3880123456",
					LocalDate.of(1992, 4, 20), "Calle Libertad 654, Humahuaca", "3456"));
			lista.add(new Alumno("46678901", "Fernando", "Sánchez", "fsanchez@gmail.com", "3881234567",
					LocalDate.of(1996, 7, 14), "Av. 9 de Julio 987, Tilcara", "7890"));
			lista.add(new Alumno("37345678", "Ana", "García", "agarcia@gmail.com", "3882345678",
					LocalDate.of(1990, 1, 30), "Calle Las Heras 432, San Salvador", "4567"));
			lista.add(new Alumno("48789012", "Luis", "Ramírez", "lramirez@gmail.com", "3883456789",
					LocalDate.of(1997, 10, 18), "Av. Entre Ríos 876, La Quiaca", "8901"));

		}
		return lista;
	}*/

	public static Alumno findAlumnoByDni(String dni) {
		for (Alumno alumno : lista) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}

	public static boolean addAlumno(Alumno alumno) {
		for (Alumno a : lista) {
			if (a.getDni().equals(alumno.getDni()) || a.getLu().equals(alumno.getLu())) {
				return false;
			}
		}
		lista.add(alumno);
		return true;
	}

	public static boolean updateAlumno(Alumno alumno) {
		Iterator<Alumno> alumnosIterator = lista.iterator();
		boolean encontrado = false;
		boolean modificado = false;
		while (alumnosIterator.hasNext() && !encontrado) {
			Alumno alu = alumnosIterator.next();
			if (alu.getDni().equals(alumno.getDni())) {
				encontrado = true;
				alu.setNombre(alumno.getNombre());
				alu.setApellido(alumno.getApellido());
				alu.setEmail(alumno.getEmail());
				alu.setTelefono(alumno.getTelefono());
				alu.setFechaNacimiento(alumno.getFechaNacimiento());
				alu.setDomicilio(alumno.getDomicilio());
				alu.setLu(alumno.getLu());
				modificado = true;
			}
		}
		return modificado;
	}

	public static boolean removeAlumno(Alumno alumno) {
		Iterator<Alumno> alumnoIterator = lista.iterator();
		boolean encontrado = false;
		boolean eliminado = false;
		while (alumnoIterator.hasNext() && !encontrado) {
			if (alumnoIterator.next().getDni().equals(alumno.getDni())) {
				encontrado = true;
				alumnoIterator.remove();
				eliminado = true;
			}
		}
		return eliminado;
	}

}
