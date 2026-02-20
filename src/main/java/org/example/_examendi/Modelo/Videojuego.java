package org.example._examendi.Modelo;

import java.util.Date;

public class Videojuego {
    public String titulo;
    public boolean completado;
    public Date fechaLanzamiento;

    public Videojuego(){}

    public Videojuego(String titulo, boolean completado, Date fechaLanzamiento) {
        this.titulo = titulo;
        this.completado = completado;
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public boolean isCompletado() {
        return completado;
    }
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }


}
