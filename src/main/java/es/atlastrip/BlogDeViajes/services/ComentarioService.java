package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Comentario;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    ConnectionMySql MYSQL = new ConnectionMySql();

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
                    resultSet.getInt("id_seccion")
            );
            comentarios.add(comentario);
        }
        return comentarios;
    }


    public void crearComentario(Comentario comentario) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO comentario(id, comentario, fecha_comentario, id_seccion) VALUES ('"
                + comentario.getId() + "','" + comentario.getComentario() + "','" + comentario.getFecha_comentario() + "','"+ comentario.getId_cliente() + "','" + comentario.getId_seccion() + "');";

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
        String sql = "UPDATE comentario SET nombre = '" + comentarioSeleccionado.getId() + "', id = '" + comentarioSeleccionado.getComentario()+ "', comentario = '" + comentarioSeleccionado.getFecha_comentario() + "', fecha = '" + comentarioSeleccionado.getId_cliente() + "', id_cliente = '" + comentarioSeleccionado.getId_seccion() + "' WHERE id = " + comentarioSeleccionado.getId();

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
                    resultSet.getInt("id_seccion")
            );
            return comentario;
        }
        return null;
    }
    
}
