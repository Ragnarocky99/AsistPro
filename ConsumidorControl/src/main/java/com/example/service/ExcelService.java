package com.example.service;

import com.example.model.Alumno;
import com.example.model.Especialidad;
import com.example.repository.AlumnoRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Service
public class ExcelService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public void cargarAlumnosDesdeExcel(MultipartFile file, int idEspecialidad, String curso, int seccion)
            throws IOException {
        List<Alumno> alumnos = new ArrayList<>();

        try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int rowIndex = 3; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                if (row != null) {
                    Alumno alumno = new Alumno();

                    // Lee la celda de CD
                    Cell cdiCell = row.getCell(1);
                    if (cdiCell != null) {
                        alumno.setCdi(cdiCell.toString()); // Convertir el valor a string
                    }

                    // Lee el nombre y apellido
                    Cell nombreYApellidoCell = row.getCell(2);
                    if (nombreYApellidoCell != null) {
                        String nombreYApellido = nombreYApellidoCell.toString();
                        String[] partes = nombreYApellido.split(" ", 3);
                        String apellido = partes[0] + " " + partes[1]; // Asumiendo que los dos primeros elementos son los apellidos
                        String nombre = partes.length > 2 ? partes[2] : "";
                        alumno.setNombre(nombre);
                        alumno.setApellido(apellido);
                    }

                    Especialidad especialidad = new Especialidad();
                    especialidad.setId_especialidad(idEspecialidad);
                    alumno.setEspecialidad(especialidad);

                    alumno.setCurso(curso);
                    alumno.setSeccion(seccion);
                    alumno.setEstado("activo");

                    alumnos.add(alumno);
                }
            }
        }

        alumnoRepository.saveAll(alumnos);
    }

}
