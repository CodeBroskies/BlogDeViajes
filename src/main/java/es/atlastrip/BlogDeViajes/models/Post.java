package es.atlastrip.BlogDeViajes.models;

public class Post {
    private int id;
    private String titulo;
    private int id_cliente;
    private String username;
    private String descripcion;

    public Post(int id, String titulo, int id_cliente, String username, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.id_cliente = id_cliente;
        this.username = username;
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
}
