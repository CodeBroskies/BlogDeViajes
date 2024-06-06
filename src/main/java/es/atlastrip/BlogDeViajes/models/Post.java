package es.atlastrip.BlogDeViajes.models;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private String titulo;
    private int id_cliente;
    private String username;
    private String avatar;
    private String descripcion;
    private List<Seccion> secciones = new ArrayList<>();

    public Post(int id, String titulo, int id_cliente, String username, String avatar, String descripcion, List<Seccion> secciones) {
        this.id = id;
        this.titulo = titulo;
        this.id_cliente = id_cliente;
        this.username = username;
        this.avatar = avatar;
        this.descripcion = descripcion;
        this.secciones = secciones;
    }

    public Post(int id, String titulo, int id_cliente, String username, String avatar, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.id_cliente = id_cliente;
        this.username = username;
        this.avatar = avatar;
        this.descripcion = descripcion;
    }

    public Post(int id, String titulo, int id_cliente) {
        this.id = id;
        this.titulo = titulo;
        this.id_cliente = id_cliente;
    }

    public Post() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }
}
