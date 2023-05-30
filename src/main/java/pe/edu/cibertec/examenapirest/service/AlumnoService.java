package pe.edu.cibertec.examenapirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.examenapirest.model.db.Alumno;
import pe.edu.cibertec.examenapirest.repository.AlumnoRepository;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarAlumnos(){
        return alumnoRepository.findAll();

    }

    public Optional<Alumno> buscarAlumnoxId(String id){
        Optional<Alumno> alumno = alumnoRepository.findById(id);

        if(alumno.isEmpty()){
            return Optional.empty();
        }else {
            return alumno;
        }
    }

    public Alumno registrar(Alumno alumno){
        return alumnoRepository.save(alumno);
    }

    public HashMap<String, String> eliminarxId(String id){
        HashMap<String, String> respuesta = new HashMap<String, String>();
        alumnoRepository.deleteById(id);
        respuesta.put("mensaje","Elemento eliminado correctamente");
        return respuesta;
    }
}
