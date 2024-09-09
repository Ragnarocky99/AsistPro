package com.example.controllers;

import com.example.model.Especialidad;
import com.example.model.Horario;
import com.example.model.Materia;
import com.example.model.Profesor;
import com.example.model.Sala;
import com.example.service.IEspecialidadService;
import com.example.service.IHorarioService;
import com.example.service.IMateriaService;
import com.example.service.IProfesorService;
import com.example.service.ISalaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "horarios")
public class HorarioController {
    
    @Autowired
    private IHorarioService horarioService;
    
    @Autowired
    private IEspecialidadService especialidadService;

    @Autowired
    private ISalaService salaService;

    @Autowired
    private IProfesorService profesorService;
    
    @Autowired
    private IMateriaService materiaService;
    
    @GetMapping("/")
    public String verHorarios(Model model){
        List<Horario> horarios = horarioService.listarHorarios();
        model.addAttribute("horarios", horarios);
        return "verHorarios";
    }
    
    @GetMapping("/nuevoHorario")
   public String mostrarFormularioDeHorario(Model model) {
        Horario horario = new Horario();
        List<Especialidad> especialidades = especialidadService.listarEspecialidades();
        List<Sala> salas = salaService.listarSalas();
        List<Profesor> profesores = profesorService.listarProfesores();
        List<Materia> materias = materiaService.listarMaterias();
        model.addAttribute("horario", horario);
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("salas", salas);
        model.addAttribute("profesores", profesores);
        model.addAttribute("materias", materias);

        return "formularios/formularioHorario";
    }
    
    @PostMapping("/guardarHorario")
    public String guardarHorario(@ModelAttribute("horario") Horario horario, BindingResult result, Model model) {
        if (horario.getHora_fin().isBefore(horario.getHora_inicio()) || horario.getHora_fin().equals(horario.getHora_inicio())) {
            result.rejectValue("hora_fin", "error.horario", "La hora de fin debe ser después de la hora de inicio.");
        }

        if (result.hasErrors()) {
            List<Especialidad> especialidades = especialidadService.listarEspecialidades();
            List<Sala> salas = salaService.listarSalas();
            List<Profesor> profesores = profesorService.listarProfesores();
            List<Materia> materias = materiaService.listarMaterias();
            model.addAttribute("especialidades", especialidades);
            model.addAttribute("salas", salas);
            model.addAttribute("profesores", profesores);
            model.addAttribute("materias", materias);
            return "formularios/formularioHorario";
        }
        
        horarioService.guardarHorario(horario);
        return "redirect:/horarios/";
    }
    
    @GetMapping("/editarHorario/{idhorario}")
    public String editarHorario(@PathVariable("idhorario") int idHorario, Model model) {
        Horario horario = horarioService.buscarHorarioPorId(idHorario);
        List<Especialidad> especialidades = especialidadService.listarEspecialidades();
        List<Sala> salas = salaService.listarSalas();
        List<Profesor> profesores = profesorService.listarProfesores();
        List<Materia> materias = materiaService.listarMaterias();

        model.addAttribute("horario", horario);
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("salas", salas);
        model.addAttribute("profesores", profesores);
        model.addAttribute("materias", materias);

        return "formularios/formularioHorario";
    }
    
    @GetMapping("/eliminarHorario/{idhorario}")
    public String eliminarHorario (@PathVariable("idhorario") int id) {
        horarioService.eliminarHorario(id);
        return "redirect:/horarios/";
    }
    
}
