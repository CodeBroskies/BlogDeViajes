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

    ConnectionMySql MYSQL = ConnectionMySql.getInstance();

    public ArrayList<Tipo> listarTipos() throws SQLException {
        ArrayList<Tipo> tipos = new ArrayList<>();
        String sql = "SELECT * FROM `vista_tipo_seccion`";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Tipo tipo = new Tipo(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("texto"),
                    resultSet.getString("urlImagen"),
                    resultSet.getInt("seccion_id")
            );

            tipos.add(tipo);
        }
        return tipos;
    }

    public int crearTipo(Tipo tipo) throws SQLException {
        int nuevoTipoId;

        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO tipo(nombre, texto, url_imagen) VALUES ('"
                + tipo.getNombre() + "','" + tipo.getTexto() + "','" + tipo.getUrlImagen() + "');";

        consulta.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet idsGeneradas = consulta.getGeneratedKeys();
        if (idsGeneradas.next()) {
            nuevoTipoId = idsGeneradas.getInt(1);
        } else {
            throw new SQLException("No se pudo crear el post");
        }

        consulta.close();

        return nuevoTipoId;
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

    public void crearTipoSeccion(int seccionId, int tipoId) throws SQLException {
        Statement consulta = MYSQL.connect().createStatement();

        String sql = "INSERT INTO seccion_tipo(id_seccion, id_tipo) VALUES ('"
                + seccionId + "','" + tipoId + "');";

        consulta.executeUpdate(sql);
        consulta.close();
    }

}