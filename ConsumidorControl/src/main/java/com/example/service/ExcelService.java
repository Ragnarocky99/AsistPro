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

        try (InputStream is = file.getInputStream();
                Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                if (row != null && row.getCell(0) != null) { // Ensure the row and first cell are not null
                    Alumno alumno = new Alumno();
                    alumno.setNombre(row.getCell(0).getStringCellValue());
                    alumno.setApellido(row.getCell(1).getStringCellValue());
                    alumno.setCdi(String.valueOf((int) row.getCell(2).getNumericCellValue()));

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
