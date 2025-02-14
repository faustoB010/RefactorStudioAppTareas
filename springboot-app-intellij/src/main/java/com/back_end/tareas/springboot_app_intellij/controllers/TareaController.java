package com.back_end.tareas.springboot_app_intellij.controllers;

import com.back_end.tareas.springboot_app_intellij.models.Tarea;
import com.back_end.tareas.springboot_app_intellij.services.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tareas")
@CrossOrigin(origins="*")
public class TareaController {

    @Autowired
    private TareaService tareaService;


    @GetMapping
    public List<Tarea> getAllTareas() {return tareaService.getAllTareas();}

    @PostMapping
    public Tarea createTarea(@Valid @RequestBody Tarea tarea) {return tareaService.createTarea(tarea);}

    @PutMapping("/{id}")
    public Tarea updateTarea(@PathVariable Long id,@Valid @RequestBody Tarea tarea) {
        return tareaService.updateTarea(id,tarea);
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Long id) {tareaService.deleteTarea(id);}


}
