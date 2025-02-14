# Proyecto de Gestión de Tareas

Este proyecto consiste en una aplicación de gestión de tareas, que tiene un backend desarrollado con **Spring Boot** y un frontend desarrollado con **Angular**. A continuación se presentan las instrucciones para ejecutar ambos componentes del proyecto.

## Requisitos

- **Java 17 o superior** (para ejecutar el backend de Spring Boot)
- **Node.js y npm** (para ejecutar el frontend de Angular)
- **IntelliJ IDEA** o cualquier editor de tu elección para trabajar con ambos proyectos.
- **VisualStudioCode** editor del proyecto de frontend


## Backend (Spring Boot)

El backend está desarrollado con **Spring Boot** y utiliza una base de datos en memoria **H2** persistente para almacenar las tareas.

##1. Clonar el repositorio

Primero, clona el repositorio del proyecto en tu máquina local:

git clone https://github.com/tu_usuario/RefactorStudioAppTareas.git](https://github.com/faustoB010/RefactorStudioAppTareas/tree/main
cd springboot-app-intellij

Luego abre el proyecto en Intellij y ejecuta el main de Springboot y se levantará la API en localhost:8080, las operaciones que pueden realizarse con Postman se hacen a través de localhost:8080/api/tareas

## Frontend (Angular)

En la carpeta frontEndTareas, abre con el editor de texto VSCode y ejecuta ng serve para levantar el servidor en la dirección localhost:4200 y ahí se presentará una interfaz para realizar operaciones CRUD sobre la
base de datos H2, a través de la API levantada en localhost:8080
