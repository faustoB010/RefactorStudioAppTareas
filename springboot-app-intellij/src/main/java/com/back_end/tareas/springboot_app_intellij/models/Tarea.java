package com.back_end.tareas.springboot_app_intellij.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="El título debe ser completado!")
    @Column(nullable=false)
    private String titulo;

    private String descripcion;

    @Column(nullable=false)
    private boolean completado;


}
