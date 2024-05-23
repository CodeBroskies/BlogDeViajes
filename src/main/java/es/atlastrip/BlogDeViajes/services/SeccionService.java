package es.atlastrip.BlogDeViajes.services;


import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Seccion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeccionService {
    ConnectionMySql MYSQL = new ConnectionMySql();

    public ArrayList<Seccion> listarSeccions() throws SQLException {
        ArrayList<Seccion> seccions = new ArrayList<>();
        String sql = "SELECT * FROM seccion";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Seccion seccion = new Seccion(
                    resultSet.getInt("id"),
                    resultSet.getString("titulo"),
                    resultSet.getInt("id_post")
            );
            seccions.add(seccion);
        }
        return seccions;
    }

    public void crearSeccion(Seccion seccion) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO seccion(id, titulo, id_post) VALUES ('"
                + seccion.getId() + "','" + seccion.getTitulo() + "','" + seccion.getId_post() + "');";

        consulta.executeUpdate(sql);
        consulta.close();
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
