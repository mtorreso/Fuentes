package DAO;

import Modelo.AccesoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Conexion;
import Modelo.Usuario;
import java.sql.CallableStatement;
import java.sql.Statement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Manuel
 */
public class CuentasDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    static Connection conexion = AccesoBD.getABD().Conectar();

    int res;
    String msj;

    public String validaUsuario(String correo, String clave) {
        try {
            conexion = AccesoBD.getABD().Conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(
                    "SELECT * FROM usuario WHERE correo='" + correo + "' and clave='" + clave + "'");
            if (rs.next()) {
                String rol = obtenerRol(Integer.parseInt(rs.getString(1)));

                return rol;
            } else {
                //conexion.close();
                return "0";
            }
        } catch (Exception e) {
            return "error: " + e.toString();
        }
    }

    public String retornarRut(String correo) {
        String rut;
        conexion = AccesoBD.getABD().Conectar();
        try {

            CallableStatement cst = conexion.prepareCall("{? = call f_retorna_rut(?)}");
            cst.registerOutParameter(1, OracleTypes.VARCHAR);
            cst.setString(2, correo);
            cst.execute();
            rut = cst.getString(1);
            conexion.close();
            return rut;
        } catch (Exception e) {
            return "Error :" + e.toString();
        }
    }

    public String retornarNombre(String correo) {
        String nombre;
        conexion = AccesoBD.getABD().Conectar();
        try {

            CallableStatement cst = conexion.prepareCall("{? = call f_retorna_nombre(?)}");
            cst.registerOutParameter(1, OracleTypes.VARCHAR);
            cst.setString(2, correo);
            cst.execute();
            nombre = cst.getString(1);
            conexion.close();
            return nombre;
        } catch (Exception e) {
            return "Error :" + e.toString();
        }
    }

    private String obtenerRol(int id) {
        try {
            conexion = AccesoBD.getABD().Conectar();
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("Select id_rol from usuario Where id_usuario = " + id);

            if (rs.next()) {

                return rs.getString(1);
            } else {
                return "0";
            }
        } catch (Exception e) {

        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String CrearCuenta(String rut, String nombre,
            String correo, String telefono, String clave, int id_rol) {
        String sql = "insert into usuario(rut,nombre,correo,telefono,clave,id_rol) values(?,?,?,?,?,?)";

        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, correo);
            ps.setString(4, telefono);
            ps.setString(5, clave);
            ps.setInt(6, id_rol);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Cuenta Generada Correctamente";
            } else {
                msj = "Error en el registro";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public String modificarUsuario(int id_usuario, String rut, String nombre, String correo, String telefono) {
        String sql = "update usuario set rut=?,nombre=?,correo=?,telefono=? where id_usuario=" + id_usuario;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            ps.setString(2, nombre);
            ps.setString(3, correo);
            ps.setString(4, telefono);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Cuenta Actualizada Correctamente";
            } else {
                msj = "Error en la actualización";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public String eliminarUsuario(int id) {
        String sql = "delete from usuario where id_usuario =" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Cuenta Eliminada Correctamente";
            } else {
                msj = "Error en la eliminación";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public List listarUsuarios() {
        List<Usuario> datos = new ArrayList<>();
        String sql = "Select id_usuario,rut,nombre,correo,telefono,clave,id_rol from usuario WHERE id_rol IN (1,2)";
        try {

            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setRut(rs.getString("rut"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setClave(rs.getString("clave"));
                u.setId_rol(rs.getInt("id_rol"));
                System.out.println("u" + u);
                datos.add(u);
                System.out.println("datos" + datos);

            }
        } catch (Exception e) {
        }
        return datos;
    }

    public List listarClientes() {
        List<Usuario> datos = new ArrayList<>();
        String sql = "Select id_usuario,rut,nombre,correo,telefono,clave,id_rol from usuario WHERE id_rol IN (3)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setRut(rs.getString("rut"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setClave(rs.getString("clave"));
                u.setId_rol(rs.getInt("id_rol"));
                System.out.println("u" + u);
                datos.add(u);
                System.out.println("datos" + datos);

            }
        } catch (Exception e) {
        }
        return datos;
    }

    public List listarCuentas() {
        List<Usuario> datos = new ArrayList<>();
        String sql = "Select id_usuario,rut,nombre,correo,telefono,clave,id_rol from usuario";
        try {

            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setRut(rs.getString("rut"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setClave(rs.getString("clave"));
                u.setId_rol(rs.getInt("id_rol"));
                System.out.println("u" + u);
                datos.add(u);
                System.out.println("datos" + datos);

            }
        } catch (Exception e) {
        }
        return datos;
    }

    public Usuario Mostrarporrut(String rut) {
        String sql = "select * from usuario where rut = '" + rut + "'";
        Usuario u = new Usuario();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setRut(rs.getString("rut"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setTelefono(rs.getString("telefono"));
                u.setClave(rs.getString("clave"));
                u.setId_rol(rs.getInt("id_rol"));
                System.out.println("u" + u);

            }

        } catch (Exception e) {
        }
        return u;
    }

    public String actualizarperfil(String rut, String nombre, String clave) {
        String sql = "update usuario set nombre=?,clave=? where rut = '" + rut + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, clave);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Perfil Actualizado Correctamente";
            } else {
                msj = "Error en la actualización";
            }

        } catch (Exception e) {
        }
        return msj;
    }

}
