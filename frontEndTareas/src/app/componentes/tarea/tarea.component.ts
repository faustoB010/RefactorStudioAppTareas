import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
import { Observable } from 'rxjs'; 
interface Tarea {
  id?: number;
  titulo: string;
  descripcion?: string;
  completado: boolean;
}

@Component({
  selector: 'app-tarea',
  templateUrl: './tarea.component.html',
  styleUrls: ['./tarea.component.css']
})
export class TareaComponent implements OnInit {
  tareas: Tarea[] = [];
  nuevaTarea: Tarea = { titulo: '', descripcion: '', completado: false };
  cargando: boolean = false;
  errorMensaje: string = '';

  private apiUrl = 'http://localhost:8080/api/tareas'; 
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.obtenerTareas();
  }

  
  obtenerTareas(): void {
    this.cargando = true;
    this.http.get<Tarea[]>(this.apiUrl).subscribe({
      next: (data) => {
        this.tareas = data; 
        this.cargando = false;
      },
      error: (err) => {
       
        console.error('Error al obtener las tareas:', err);
        this.errorMensaje = 'Error al cargar las tareas: ' + (err.message || err);
        this.cargando = false;
      }
    });
  }

 
  agregarTarea(): void {
    if (!this.nuevaTarea.titulo.trim()) {
      this.errorMensaje = 'El título es obligatorio';
      return;
    }

    this.http.post<Tarea>(this.apiUrl, this.nuevaTarea).subscribe({
      next: (tarea) => {
        this.tareas.push(tarea);
        this.nuevaTarea = { titulo: '', descripcion: '', completado: false }; 
        this.errorMensaje = '';
      },
      error: (err) => {
        this.errorMensaje = 'Error al agregar la tarea';
      }
    });
  }

  actualizarTarea(tarea: Tarea, campo: string): void {
    let tareaActualizada = { ...tarea };

    if (campo === 'titulo') {
      tareaActualizada.titulo = tarea.titulo.trim();
    } else if (campo === 'descripcion') {
      tareaActualizada.descripcion = tarea.descripcion?.trim();
    } else if (campo === 'completado') {
   }

    this.http.put<Tarea>(`${this.apiUrl}/${tarea.id}`, tareaActualizada).subscribe({
      next: () => {
        console.log('Tarea actualizada:', tareaActualizada);
      },
      error: (err) => {
        this.errorMensaje = 'Error al actualizar la tarea';
      }
    });
  }

 
  eliminarTarea(id: number): void {
    this.http.delete(`${this.apiUrl}/${id}`).subscribe({
      next: () => {
        this.tareas = this.tareas.filter(t => t.id !== id); 
      },
      error: (err) => {
        this.errorMensaje = 'Error al eliminar la tarea';
      }
    });
  }
}

