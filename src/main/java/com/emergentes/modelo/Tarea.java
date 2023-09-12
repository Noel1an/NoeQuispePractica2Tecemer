package com.emergentes.modelo;
/**
 * @author ALBERT
 */
public class Tarea {
    private int id;
    private String titulo;

    public Tarea() {
        this.id=0;
        this.titulo="";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}