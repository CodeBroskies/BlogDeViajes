package es.atlastrip.BlogDeViajes.models;

public class Cliente {
    private int id;
    private String nick;
    private String password;
    private String avatar;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String telefono;

    public Cliente(int id, String nick, String password, String avatar, String nombre, String apellido1, String apellido2, String email, String telefono) {
        this.id = id;
        this.nick = nick;
        this.password = password;
        this.avatar = avatar;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente(int id, String nick, String password) {
        this.id = id;
        this.nick = nick;
        this.password = password;
    }

    public Cliente() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
