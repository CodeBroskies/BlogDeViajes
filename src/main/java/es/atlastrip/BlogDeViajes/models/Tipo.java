package es.atlastrip.BlogDeViajes.models;

public class Tipo {
    private int id;
    private String nombre;
    private String texto;
    private String urlImagen;
    private int seccion_id;

    public Tipo() {

    }

    public Tipo(int id, String nombre, String texto, String urlImagen) {
        this.id = id;
        this.nombre = nombre;
        this.texto = texto;
        this.urlImagen = urlImagen;
    }

    public Tipo(int id, String nombre, String texto, String urlImagen, int seccion_id) {
        this.id = id;
        this.nombre = nombre;
        this.texto = texto;
        this.urlImagen = urlImagen;
        this.seccion_id = seccion_id;
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

    public int getSeccion_id() {
        return seccion_id;
    }

    public void setSeccion_id(int seccion_id) {
        this.seccion_id = seccion_id;
    }
}
