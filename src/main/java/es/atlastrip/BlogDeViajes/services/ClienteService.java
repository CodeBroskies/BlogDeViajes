package es.atlastrip.BlogDeViajes.services;

import es.atlastrip.BlogDeViajes.ConnectionMySql;
import es.atlastrip.BlogDeViajes.models.Cliente;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements UserDetailsService {

        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        ConnectionMySql MYSQL = ConnectionMySql.getInstance();

        public ArrayList<Cliente> listarClientes() throws SQLException {
            ArrayList<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM cliente";
            Statement consulta = MYSQL.connect().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nick"),
                        resultSet.getString("password"),
                        resultSet.getString("avatar"),
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

        public ArrayList<Cliente> listarClientes(int pagina) throws SQLException {
            ArrayList<Cliente> clientes = new ArrayList<>();
            int offset = (pagina - 1) * 5;
            int limit = 5;
            String sql = "SELECT * FROM cliente LIMIT " + limit + " OFFSET " + offset + ";";
            Statement consulta = MYSQL.connect().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nick"),
                        resultSet.getString("password"),
                        resultSet.getString("avatar"),
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

            cliente.setPassword(passwordEncoder().encode(cliente.getPassword()));

            String sql = "INSERT INTO cliente(nick, password, avatar, nombre, apellido1, apellido2, email, telefono) VALUES ('"
                    + cliente.getNick() + "', '" + cliente.getPassword() + "', '" + cliente.getAvatar() + "', '" + cliente.getNombre() + "', '" + cliente.getApellido1() + "', '" + cliente.getApellido2() + "', '" + cliente.getEmail() + "', '" + cliente.getTelefono() + "');";

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
            String sql = "UPDATE cliente SET avatar = '" + clienteSeleccionado.getAvatar() + "', nombre = '" + clienteSeleccionado.getNombre() + "', apellido1 = '" + clienteSeleccionado.getApellido1()+ "', apellido2 = '" + clienteSeleccionado.getApellido2() + "', telefono = '" + clienteSeleccionado.getTelefono() + "', email = '" + clienteSeleccionado.getEmail() + "' WHERE id = " + clienteSeleccionado.getId();

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
                        resultSet.getString("password"),
                        resultSet.getString("avatar"),
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

        public Cliente obtenerCliente(String nick) throws SQLException {
            String sql = "SELECT * FROM cliente WHERE nick = '" + nick + "'";
            Statement consulta = MYSQL.connect().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            if (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nick"),
                        resultSet.getString("password"),
                        resultSet.getString("avatar"),
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

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            String sql = "SELECT * FROM cliente WHERE nick = '" + username +"'";
            try {
                Statement consulta = MYSQL.connect().createStatement();
                ResultSet resultSet = consulta.executeQuery(sql);
                if (resultSet.next()) {
                    Cliente cliente = new Cliente(
                            resultSet.getInt("id"),
                            resultSet.getString("nick"),
                            resultSet.getString("password"),
                            resultSet.getString("avatar"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido1"),
                            resultSet.getString("apellido2"),
                            resultSet.getString("email"),
                            resultSet.getString("telefono")
                    );

                    sql = "SELECT r.name FROM roles r INNER JOIN user_roles ur ON r.id = ur.role_id WHERE ur.user_id = " + cliente.getId();
                    try (ResultSet rolesResultSet = consulta.executeQuery(sql)) {
                        ArrayList<String> roles = new ArrayList<>();
                        while (rolesResultSet.next()) {
                            roles.add(rolesResultSet.getString("name"));
                        }
                        cliente.setRoles(roles);
                    }

                    return cliente;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        public ArrayList<Cliente> ordenarClientes(int pagina, String columna, String orden) throws SQLException {
            ArrayList<Cliente> usuarios = new ArrayList<>();
            int offset = (pagina - 1) * 5;
            int limit = 5;
            String sql = "SELECT * FROM cliente ORDER BY " + columna + " " + orden + " LIMIT " + limit + " OFFSET " + offset;
            Statement consulta = MYSQL.connect().createStatement();
            ResultSet resultSet = consulta.executeQuery(sql);
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nick"),
                        resultSet.getString("password"),
                        resultSet.getString("avatar"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido1"),
                        resultSet.getString("apellido2"),
                        resultSet.getString("email"),
                        resultSet.getString("telefono")
                );
                usuarios.add(cliente);
            }
            return usuarios;
        }

    public ArrayList<Cliente> filtrarUsuarios(String busqueda, String filtro) throws SQLException {
        ArrayList<Cliente> usuarios = new ArrayList<>();
        String sql = (filtro.equals("todo")) ? "SELECT * FROM cliente WHERE nombre LIKE " + "'%" + busqueda + "%' OR apellido1 LIKE " + "'%" + busqueda + "%' OR apellido2 LIKE" + "'%" + busqueda + "%' OR telefono LIKE " + "'%" + busqueda + "%' OR email LIKE " + "'%" + busqueda + "%'" : "SELECT * FROM cliente WHERE " + filtro + " LIKE " + "'%" + busqueda + "%'";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        while (resultSet.next()) {
            Cliente usuario = new Cliente(
                    resultSet.getInt("id"),
                    resultSet.getString("nick"),
                    resultSet.getString("password"),
                    resultSet.getString("avatar"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido1"),
                    resultSet.getString("apellido2"),
                    resultSet.getString("email"),
                    resultSet.getString("telefono")
            );
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public int contarClientes() throws SQLException {
        int count = 0;
        String sql = "SELECT COUNT(*) AS count FROM cliente";
        Statement consulta = MYSQL.connect().createStatement();
        ResultSet resultSet = consulta.executeQuery(sql);
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        return count;
    }
}
