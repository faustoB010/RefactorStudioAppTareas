package com.back_end.tareas.springboot_app_intellij.services;

import com.back_end.tareas.springboot_app_intellij.models.Tarea;
import com.back_end.tareas.springboot_app_intellij.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class TareaService {


    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getAllTareas (){return tareaRepository.findAll();}

    public Tarea getTareaById(Long id){return tareaRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no fue encontrada!"));}

    public Tarea createTarea(Tarea tarea){return tareaRepository.save(tarea);}

    public Tarea updateTarea(Long id, Tarea tarea){
        Tarea tareaExistente=getTareaById(id);
        tareaExistente.setTitulo(tarea.getTitulo());
        tareaExistente.setDescripcion(tarea.getDescripcion());
        tareaExistente.setCompletado(tarea.isCompletado());
        return tareaRepository.save(tareaExistente);
    }

    public void deleteTarea(Long id){
        if (!tareaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no fue encontrada!");
        }
        tareaRepository.deleteById(id);
    }

}
