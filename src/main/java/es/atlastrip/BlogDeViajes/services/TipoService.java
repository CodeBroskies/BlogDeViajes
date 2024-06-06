package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Tipo;

import java.sql.PreparedStatement;
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

        PreparedStatement consulta = MYSQL.connect().prepareStatement(sql);

        ResultSet resultSet = consulta.executeQuery();
        while (resultSet.next()) {
            Tipo tipo = new Tipo(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("texto"),
                    resultSet.getString("url_imagen"),
                    resultSet.getInt("seccion_id")
            );

            tipos.add(tipo);
        }

        consulta.close();
        return tipos;
    }

    public int crearTipo(Tipo tipo) throws SQLException {
        int nuevoTipoId;

        String sql = "INSERT INTO tipo(nombre, texto, url_imagen) VALUES (?, ?, ?);";

        PreparedStatement consulta = MYSQL.connect().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        consulta.setString(1, tipo.getNombre());
        consulta.setString(2, tipo.getTexto());
        consulta.setString(3, tipo.getUrlImagen());

        consulta.executeUpdate();

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
        String sql = "DELETE FROM tipo WHERE id = ?";

        PreparedStatement consulta = MYSQL.connect().prepareStatement(sql);

        consulta.setInt(1, id);
        consulta.executeUpdate();
        consulta.close();
    }

    public void actualizarTipo(Tipo tipoSeleccionado) throws SQLException {
        String sql = "UPDATE tipo SET nombre = ?, texto = ?, url_imagen = ? WHERE id = ?";

        PreparedStatement consulta = MYSQL.connect().prepareStatement(sql);

        consulta.setString(1, tipoSeleccionado.getNombre());
        consulta.setString(2, tipoSeleccionado.getTexto());
        consulta.setString(3, tipoSeleccionado.getUrlImagen());
        consulta.setInt(4, tipoSeleccionado.getId());

        consulta.executeUpdate();
        consulta.close();
    }

    public Tipo obtenerTipo(int id) throws SQLException {
        String sql = "SELECT * FROM tipo WHERE id = ?";

        PreparedStatement consulta = MYSQL.connect().prepareStatement(sql);
        consulta.setInt(1, id);

        ResultSet resultSet = consulta.executeQuery();
        if (resultSet.next()) {
            Tipo tipo = new Tipo(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("texto"),
                    resultSet.getString("url_imagen")
            );
            return tipo;
        }
        return null;
    }

    public Tipo obtenerTipoPorSeccion(int id_seccion) throws SQLException {
        String sql = "SELECT * FROM tipo JOIN seccion_tipo ON tipo.id = seccion_tipo.id_tipo JOIN seccion ON seccion_tipo.id_seccion = seccion.id WHERE seccion.id = ?";

        PreparedStatement consulta = MYSQL.connect().prepareStatement(sql);
        consulta.setInt(1, id_seccion);

        ResultSet resultSet = consulta.executeQuery();
        if (resultSet.next()) {
            Tipo tipo = new Tipo(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("texto"),
                    resultSet.getString("url_imagen")
            );
            return tipo;
        }
        return null;
    }

    public void crearTipoSeccion(int seccionId, int tipoId) throws SQLException {
        String sql = "INSERT INTO seccion_tipo(id_seccion, id_tipo) VALUES (?, ?)";

        PreparedStatement consulta = MYSQL.connect().prepareStatement(sql);

        consulta.setInt(1, seccionId);
        consulta.setInt(2, tipoId);

        consulta.executeUpdate();
        consulta.close();
    }

}