package com.example.service;

import com.example.model.DetalleAsistencia;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportGenerator {

    public byte[] exportToPdf(List<DetalleAsistencia> list, int idAsistencia) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list, idAsistencia));
    }

    public byte[] exportToXls(List<DetalleAsistencia> list, int idAsistencia) throws JRException, FileNotFoundException {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        SimpleOutputStreamExporterOutput output = new SimpleOutputStreamExporterOutput(byteArray);
        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(getReport(list, idAsistencia)));
        exporter.setExporterOutput(output);
        exporter.exportReport();
        output.close();
        return byteArray.toByteArray();
    }

    private JasperPrint getReport(List<DetalleAsistencia> list, int idAsistencia) throws FileNotFoundException, JRException {
        Map<String, Object> params = new HashMap<>();
        params.put("dataSource", new JRBeanCollectionDataSource(list));
        params.put("idAsistencia", idAsistencia);  // Asegúrate de que este parámetro existe en el .jrxml

        JasperPrint report = JasperFillManager.fillReport(JasperCompileManager.compileReport(
                ResourceUtils.getFile("classpath:.asistenciasReporte.jrxml")
                        .getAbsolutePath()), params, new JREmptyDataSource());

        return report;
    }
}
