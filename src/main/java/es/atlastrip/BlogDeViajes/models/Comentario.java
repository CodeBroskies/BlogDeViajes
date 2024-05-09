package es.atlastrip.BlogDeViajes.models;

import java.sql.Date;

public class Comentario {
    private int id;
    private String comentario;
    private Date fecha_comentario;
    private int id_cliente;
    private int id_seccion;

    public Comentario(String comentario, Date fecha_comentario, int id_seccion, int id_cliente) {
        this.comentario = comentario;
        this.fecha_comentario = fecha_comentario;
        this.id_seccion = id_seccion;
        this.id_cliente = id_cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(Date fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }
}
