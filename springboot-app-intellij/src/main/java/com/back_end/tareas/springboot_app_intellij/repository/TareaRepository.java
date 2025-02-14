package com.back_end.tareas.springboot_app_intellij.repository;

import com.back_end.tareas.springboot_app_intellij.models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository <Tarea, Long> {
}
