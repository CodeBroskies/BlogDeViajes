package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Comentario;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    ConnectionMySql MYSQL = ConnectionMySql.getInstance();

    public ArrayList<Comentario> listarComentarios() throws SQLException {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM comentario";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Comentario comentario = new Comentario(
                    resultSet.getInt("id"),
                    resultSet.getString("comentario"),
                    resultSet.getDate("fecha_comentario"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getInt("id_post")
            );
            comentarios.add(comentario);
        }
        return comentarios;
    }

    public ArrayList<Comentario> listarComentariosPorPost(int id_post) throws SQLException {
        ArrayList<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT * FROM vista_comentarios WHERE id_post = " + id_post;
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Comentario comentario = new Comentario(
                    resultSet.getInt("id"),
                    resultSet.getString("comentario"),
                    resultSet.getDate("fecha_comentario"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getInt("id_post"),
                    resultSet.getString("nick"),
                    resultSet.getString("avatar")
            );
            comentarios.add(comentario);
        }
        return comentarios;
    }

    public void crearComentario(@AuthenticationPrincipal UserDetails userDetails, Comentario comentario) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO comentario(comentario, id_cliente, id_post) VALUES ('"
                + comentario.getComentario() + "','" + new ClienteService().obtenerCliente(userDetails.getUsername()).getId() + "','" + comentario.getId_post() + "');";

        consulta.executeUpdate(sql);
        consulta.close();
    }

    public void eliminarComentario(int id) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "DELETE FROM comentario WHERE id = " + id;
        consulta.executeUpdate(sql);
        consulta.close();
    }

    public void actualizarComentario(Comentario comentarioSeleccionado) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();
        String sql = "UPDATE comentario SET nombre = '" + comentarioSeleccionado.getId() + "', id = '" + comentarioSeleccionado.getComentario()+ "', comentario = '" + comentarioSeleccionado.getFecha_comentario() + "', fecha = '" + comentarioSeleccionado.getId_cliente() + "', id_cliente = '" + comentarioSeleccionado.getId_post() + "' WHERE id = " + comentarioSeleccionado.getId();

        consulta.executeUpdate(sql);
        consulta.close();
    }

    public Comentario obtenerComentario(int id) throws SQLException {
        String sql = "SELECT * FROM comentario WHERE id = " + id;
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        if (resultSet.next()) {
            Comentario comentario = new Comentario(
                    resultSet.getInt("id"),
                    resultSet.getString("comentario"),
                    resultSet.getDate("fecha_comentario"),
                    resultSet.getInt("id_cliente"),
                    resultSet.getInt("id_post")
            );
            return comentario;
        }
        return null;
    }
    
}
