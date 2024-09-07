package com.example.service;

import com.example.model.Alumno;
import com.example.model.Asistencia;
import com.example.model.DetalleAsistencia;
import com.example.model.DetalleAsistenciaId;
import com.example.repository.AlumnoRepository;
import com.example.repository.AsistenciaRepository;
import com.example.repository.DetalleAsistenciaRepository;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleAsistenciaServiceImplement implements IDetalleAsistenciaService {

    @Autowired
    private ReportGenerator petReportGenerator;

    @Autowired
    private DetalleAsistenciaRepository detalleRepo;
    @Autowired
    private AlumnoRepository alumnoRepo;
    @Autowired
    private AsistenciaRepository asisRepo;

    @Override
    public List<DetalleAsistencia> listarDetalles() {
        return detalleRepo.findAll();
    }

    @Override
    public void guardarDetalle(DetalleAsistencia detalle) {
        detalleRepo.save(detalle);
    }

    @Override
    public void borrarDetalle(DetalleAsistenciaId id) {
        detalleRepo.deleteById(id);
    }

    @Override
    public DetalleAsistencia localizarDetalleporId(DetalleAsistenciaId id) {
        return detalleRepo.findById(id).orElse(null);
    }

    @Override
    public List<DetalleAsistencia> listarDetallesPorAsistencia(int idAsistencia) {
        return detalleRepo.findDetallesAsistencia(idAsistencia);
    }

    @Override
    public DetalleAsistencia buscarAsistenciaDeAlumno(int idalumno, int idasis) {
        return detalleRepo.findByAlumnoAndAsistencia(idalumno, idasis);
    }

    @Override
    public List<DetalleAsistencia> buscarDetallesPorAsistencia(int idasis) {
        Asistencia asis = asisRepo.findById(idasis).orElse(null);
        return detalleRepo.findDetalleAsistenciaByAsistencia(asis);

    }

    @Override
    public DetalleAsistencia buscarDetalleAlumno(int idasistencia, int idalumno) {
        Asistencia a = asisRepo.findById(idasistencia).orElse(null);
        Alumno al = alumnoRepo.findById(idalumno).orElse(null);
        return detalleRepo.findByAsistenciaAndAlumno(a, al);
    }

    @Override
    public Optional<DetalleAsistencia> localizarDetalleporIdd(DetalleAsistenciaId id) {
        return detalleRepo.findById(id);
    }

    @Override
    public byte[] exportPdf(int idAsistencia) throws JRException, FileNotFoundException {
        Asistencia a = asisRepo.findById(idAsistencia).orElse(null);
        List<DetalleAsistencia> detalles = detalleRepo.findDetalleAsistenciaByAsistencia(a);
        return petReportGenerator.exportToPdf(detalles, idAsistencia);
    }

}


