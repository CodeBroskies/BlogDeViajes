package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Post;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    ConnectionMySql MYSQL = new ConnectionMySql();

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
        String sql = "UPDATE post SET id = '" + postSeleccionado.getId() + "', titulo = '"  + "' WHERE id = " + postSeleccionado.getId();

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

}
