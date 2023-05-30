package pe.edu.cibertec.examenapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.examenapirest.model.db.Alumno;
import pe.edu.cibertec.examenapirest.service.AlumnoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("")
    public ResponseEntity<List <Alumno>> listarAlumnos(){
        List<Alumno> alumnoList =  new ArrayList<>();
        alumnoService.listarAlumnos().forEach(alumnoList::add);
        if(alumnoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alumnoList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Alumno> obtenerAlumnoxId(@PathVariable("id") String id){
        return new ResponseEntity<>(alumnoService.buscarAlumnoxId(id).get(),
                HttpStatus.OK);
    }
    @PostMapping("")
public ResponseEntity <Alumno> crearAlumno(@RequestBody Alumno alumno){
        Alumno newAlumno = new Alumno();
        newAlumno.setNomalumno(alumno.getNomalumno());
        return new ResponseEntity<>(alumnoService.registrar(newAlumno),HttpStatus.CREATED);

}

    @PostMapping("/id")
    public ResponseEntity <Alumno> actualizarEstado(
            @PathVariable("id") String id,
            @RequestBody Alumno alumno){

        Alumno updateAlumno = alumnoService.buscarAlumnoxId(id).get();
        updateAlumno.setNomalumno(alumno.getNomalumno());
        return new ResponseEntity<>(alumnoService.registrar(updateAlumno),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable("id")String id){
        return ResponseEntity.status(HttpStatus.OK).body(alumnoService.eliminarxId(id));
    }
}
