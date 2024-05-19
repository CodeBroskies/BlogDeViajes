package es.atlastrip.BlogDeViajes.models;

public class Post {
    private int id;
    private String titulo;
    private int id_cliente;

    public Post(String titulo, int id_cliente) {
        this.titulo = titulo;
        this.id_cliente = id_cliente;
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
}
