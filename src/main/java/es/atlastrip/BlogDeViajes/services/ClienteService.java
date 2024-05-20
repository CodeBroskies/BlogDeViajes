package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Cliente;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
public class ClienteService {

        ConnectionMySql MYSQL = new ConnectionMySql();

        public ArrayList<Cliente> listarClientes() throws SQLException {
            ArrayList<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM cliente";
            Statement consulta = MYSQL.connect().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nick"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido1"),
                        resultSet.getString("apellido2"),
                        resultSet.getString("email"),
                        resultSet.getString("telefono")
                        );
                clientes.add(cliente);
            }
            return clientes;
        }


        public void crearCliente(Cliente cliente) throws SQLException {
            Statement consulta = MYSQL.connect().createStatement();

            String sql = "INSERT INTO cliente(nombre, apellido, telefono, email, edad) VALUES ('"
                    + cliente.getNombre() + "','" + cliente.getApellido1() + "','" + cliente.getApellido2() + "','"+ cliente.getTelefono() + "','" + cliente.getEmail() + "');";

            consulta.executeUpdate(sql);
            consulta.close();
        }

        public void eliminarCliente(int id) throws SQLException {
            Statement consulta = MYSQL.connect().createStatement();

            String sql = "DELETE FROM cliente WHERE id = " + id;
            consulta.executeUpdate(sql);
            consulta.close();
        }

        public void actualizarCliente(Cliente clienteSeleccionado) throws SQLException {
            Statement consulta = MYSQL.connect().createStatement();
            String sql = "UPDATE cliente SET nombre = '" + clienteSeleccionado.getNombre() + "', apellido1 = '" + clienteSeleccionado.getApellido1()+ "', apellido2 = '" + clienteSeleccionado.getApellido2() + "', telefono = '" + clienteSeleccionado.getTelefono() + "', email = '" + clienteSeleccionado.getEmail() + "' WHERE id = " + clienteSeleccionado.getId();

            consulta.executeUpdate(sql);
            consulta.close();
        }

        public Cliente obtenerCliente(int id) throws SQLException {
            String sql = "SELECT * FROM cliente WHERE id = " + id;
            Statement consulta = MYSQL.connect().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            if (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nick"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido1"),
                        resultSet.getString("apellido2"),
                        resultSet.getString("email"),
                        resultSet.getString("telefono")
                );
                return cliente;
            }
            return null;
        }


}
