package com.example.service;

import com.example.model.Asistencia;
import com.example.model.Horario;
import java.time.LocalDate;
import java.util.List;

public interface IAsistenciaService {
    List<Asistencia> listarAsistencias();
    void guardarAsistencia(Asistencia asistencia);
    void eliminarAsistencia(int id);
    Asistencia buscarAsistenciaPorId(int id);
    Asistencia buscarAsistenciaPorFechaYHorario(LocalDate fecha, Horario horario);
    List<Asistencia> buscarAsistenciasDelCurso(LocalDate fecha, int idespecialidad, String curso, int seccion);
}
