package es.atlastrip.BlogDeViajes.models;

import java.sql.Date;

public class Comentario {
    private int id;
    private String comentario;
    private Date fecha_comentario;
    private int id_cliente;
    private int id_post;
    private String username;
    private String avatar;

    public Comentario(int id, String comentario, Date fecha_comentario, int id_post, int id_cliente) {
        this.id = id;
        this.comentario = comentario;
        this.fecha_comentario = fecha_comentario;
        this.id_post = id_post;
        this.id_cliente = id_cliente;
    }

    public Comentario(int id, String comentario, Date fecha_comentario, int id_post, int id_cliente, String username, String avatar) {
        this.id = id;
        this.comentario = comentario;
        this.fecha_comentario = fecha_comentario;
        this.id_post = id_post;
        this.id_cliente = id_cliente;
        this.username = username;
        this.avatar = avatar;
    }

    public Comentario() {

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

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
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
}
