package es.atlastrip.BlogDeViajes.services;


import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Seccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class SeccionService {

    ConnectionMySql MYSQL = ConnectionMySql.getInstance();

    public ArrayList<Seccion> listarSecciones() throws SQLException {
        ArrayList<Seccion> secciones = new ArrayList<>();
        String sql = "SELECT * FROM seccion";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Seccion seccion = new Seccion(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_post")
            );
            secciones.add(seccion);
        }
        return secciones;
    }

    public ArrayList<Seccion> listarContenidoPorPost(int id_post) throws SQLException {
        ArrayList<Seccion> secciones = new ArrayList<>();
        String sql = "SELECT * FROM seccion_contenido WHERE id_post = " + id_post;
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Seccion seccion = new Seccion(
                    resultSet.getInt("id_seccion"),
                    resultSet.getString("titulo_seccion"),
                    resultSet.getInt("id_post"),
                    resultSet.getString("contenido"),
                    resultSet.getString("url_imagen")
            );
            secciones.add(seccion);
        }
        return secciones;
    }

    public int crearSeccion(Seccion seccion) throws SQLException {
        int nuevaSeccionId;

        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO seccion(id, titulo, id_post) VALUES ('"
                + seccion.getId() + "','" + seccion.getTitulo() + "','" + seccion.getId_post() + "');";

        consulta.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet idsGeneradas = consulta.getGeneratedKeys();
        if (idsGeneradas.next()) {
            nuevaSeccionId = idsGeneradas.getInt(1);
        } else {
            throw new SQLException("No se pudo crear el post");
        }

        consulta.close();

        return nuevaSeccionId;
    }

    public void eliminarSeccion(int id) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "DELETE FROM seccion WHERE id = " + id;
        consulta.executeUpdate(sql);
        consulta.close();
    }

    public void actualizarSeccion(Seccion seccionSeleccionado) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();
        String sql = "UPDATE seccion SET id = '" + seccionSeleccionado.getId() + "', titulo = '" + seccionSeleccionado.getTitulo()+ "', id_post = '" + seccionSeleccionado.getId_post() + "' WHERE id = " + seccionSeleccionado.getId();

        consulta.executeUpdate(sql);
        consulta.close();
    }

    public Seccion obtenerSeccion(int id) throws SQLException {
        String sql = "SELECT * FROM seccion WHERE id = " + id;
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        if (resultSet.next()) {
            Seccion seccion = new Seccion(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_post")
            );
            return seccion;
        }
        return null;
    }
}
