package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Tipo;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class TipoService {

    ConnectionMySql MYSQL = new ConnectionMySql();

    public ArrayList<Tipo> listarTipos() throws SQLException {
        ArrayList<Tipo> tipos = new ArrayList<>();
        String sql = "SELECT * FROM tipo";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Tipo tipo = new Tipo(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("texto"),
                    resultSet.getString("urlImagen")
            );

            tipos.add(tipo);
        }
        return tipos;
    }

    public void crearTipo(Tipo tipo) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO tipo(nombre, texto, urlImagen) VALUES ('"
                + tipo.getNombre() + "','" + tipo.getTexto() + "','" + tipo.getUrlImagen() + "');";

        consulta.executeUpdate(sql);
        consulta.close();
    }

    public void eliminarTipo(int id) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "DELETE FROM tipo WHERE id = " + id;
        consulta.executeUpdate(sql);
        consulta.close();
    }

    public void actualizarTipo(Tipo tipoSeleccionado) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();
        String sql = "UPDATE tipo SET nombre = '" + tipoSeleccionado.getNombre() + "', texto = '" + tipoSeleccionado.getTexto()+ "', urlImagen = '" + tipoSeleccionado.getUrlImagen() + "' WHERE id = " + tipoSeleccionado.getId();

        consulta.executeUpdate(sql);
        consulta.close();
    }

    public Tipo obtenerTipo(int id) throws SQLException {
        String sql = "SELECT * FROM tipo WHERE id = " + id;
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        if (resultSet.next()) {
            Tipo tipo = new Tipo(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("texto"),
                    resultSet.getString("urlImagen")
            );
            return tipo;
        }
        return null;
    }


}