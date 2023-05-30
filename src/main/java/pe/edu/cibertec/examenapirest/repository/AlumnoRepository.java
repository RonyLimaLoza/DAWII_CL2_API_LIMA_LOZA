package pe.edu.cibertec.examenapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.examenapirest.model.db.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {
}
