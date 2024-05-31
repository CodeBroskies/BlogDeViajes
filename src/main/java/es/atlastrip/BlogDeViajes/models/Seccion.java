package es.atlastrip.BlogDeViajes.models;

public class Seccion {
    private int id;
    private String titulo;
    private int id_post;
    private String contenido;
    private String url_image;

    public Seccion(int id, String titulo, int id_post) {
        this.id = id;
        this.titulo = titulo;
        this.id_post = id_post;
    }

    public Seccion(int id, String titulo, int id_post, String contenido, String url_image) {
        this.id = id;
        this.titulo = titulo;
        this.id_post = id_post;
        this.contenido = contenido;
        this.url_image = url_image;
    }

    public Seccion() {

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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
