package es.atlastrip.BlogDeViajes.models;

public class Tipo {
    private int id;
    private String nombre;
    private String texto;
    private String urlImagen;

    public Tipo() {
        this.nombre = nombre;
    }

    public Tipo(int id, String nombre, String texto, String urlImagen) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
