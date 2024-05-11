package es.atlastrip.BlogDeViajes.models;

public class Seccion {
    private int id;
    private String titulo;
    private int id_post;

    public Seccion(String titulo, int id_post) {
        this.titulo = titulo;
        this.id_post = id_post;
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

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }
}
