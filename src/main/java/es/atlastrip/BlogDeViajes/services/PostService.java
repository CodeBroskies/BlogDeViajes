package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.atlastrip.BlogDeViajes.models.Seccion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private SeccionService seccionService = new SeccionService();

    ConnectionMySql MYSQL = ConnectionMySql.getInstance();

    public ArrayList<Post> listarPosts() throws SQLException {
        ArrayList<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM post";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Post post = new Post(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_cliente")
            );
            posts.add(post);
        }
        return posts;
    }

    public ArrayList<Post> listarPostsVista() throws SQLException {
        ArrayList<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM vista_post_cliente";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Post post = new Post(
                    resultSet.getInt("id_post"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nick"),
                    resultSet.getString("avatar"),
                    resultSet.getString("descripcion")
            );
            posts.add(post);
        }
        return posts;
    }

    public ArrayList<Post> listarPostsVista(String busqueda) throws SQLException {
        ArrayList<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM vista_post_cliente WHERE titulo LIKE '%" + busqueda + "%'";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Post post = new Post(
                    resultSet.getInt("id_post"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nick"),
                    resultSet.getString("avatar"),
                    resultSet.getString("descripcion")
            );
            posts.add(post);
        }
        return posts;
    }

    public ArrayList<Post> listarLastPostsVista() throws SQLException {
        ArrayList<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM vista_post_cliente ORDER BY id_post DESC LIMIT 3";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Post post = new Post(
                    resultSet.getInt("id_post"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nick"),
                    resultSet.getString("avatar"),
                    resultSet.getString("descripcion")
            );
            posts.add(post);
        }
        return posts;
    }

    public int crearPost(Post post) throws SQLException {
        int nuevoPostId;

        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO post(titulo, id_cliente) VALUES ('"
                + post.getTitulo() + "','" + post.getId_cliente() + "');";

        consulta.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet idsGeneradas = consulta.getGeneratedKeys();
        if (idsGeneradas.next()) {
            nuevoPostId = idsGeneradas.getInt(1);
        } else {
            throw new SQLException("No se pudo crear el post");
        }

        consulta.close();

        return nuevoPostId;
    }


    public void eliminarPost(int id) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "DELETE FROM post WHERE id = " + id;
        consulta.executeUpdate(sql);
        consulta.close();
    }

    public void actualizarPost(Post postSeleccionado) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();
        String sql = "UPDATE post SET id = '" + postSeleccionado.getId() + "', titulo = '" + postSeleccionado.getTitulo()  + "' WHERE id = " + postSeleccionado.getId();

        consulta.executeUpdate(sql);
        consulta.close();
    }

    public Post obtenerPost(int id) throws SQLException {
        String sql = "SELECT * FROM post WHERE id = " + id;
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        if (resultSet.next()) {
            Post post = new Post(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_cliente")
            );
            return post;
        }
        return null;
    }

    public Post obtenerPostCompleto(int id) throws SQLException {
        String sql = "SELECT * FROM post WHERE id = " + id;
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        if (resultSet.next()) {
            Post post = new Post(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_cliente")
            );
            List<Seccion> secciones = seccionService.listarContenidoPorPost(id);
            post.setSecciones(secciones);
            return post;
        }
        return null;
    }

}
