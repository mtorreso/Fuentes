/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Categoria;
import Modelo.Conexion;
import Modelo.Departamento;
import Modelo.Inventario;
import Modelo.Inventarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel
 */
public class InventarioDAO {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conex = new Conexion();
    int res;
    String msj;
    Inventario i = new Inventario();
    Inventarios in = new Inventarios();
    Categoria ca = new Categoria();

    public Inventario BuscarInventario(int id_inv) {
        String sql = "select * from inventario where id_inv =" + id_inv;
        i = new Inventario();
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                i.setId_inv(rs.getInt("id_inv"));
                i.setId_depto(rs.getString("id_depto"));
                i.setProducto(rs.getString("producto"));
                i.setCantidad(rs.getString("cantidad"));
                i.setEstado(rs.getString("estado"));
                i.setDescripcion(rs.getString("descripcion"));
                i.setCategoria(rs.getString("categoria"));
            }
        } catch (Exception e) {
        }
        return i;
    }

    public String addInventario(String id_depto, String producto, String cantidad, String estado, String descripcion, String categoria) {
        String sql = "insert into inventario(id_depto,producto,cantidad,estado,descripcion,categoria)values(?,?,?,?,?,?)";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id_depto);
            ps.setString(2, producto);
            ps.setString(3, cantidad);
            ps.setString(4, estado);
            ps.setString(5, descripcion);
            ps.setString(6, categoria);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "inventario registrado correctamente ";
            } else {
                msj = "Error en el registro";
            }
        } catch (Exception e) {
        }
        return msj;
    }

    public String editInventario(int id_inv,String producto, String cantidad, String estado, String descripcion, String categoria) {
        String sql = "update inventario set producto=?,cantidad=?,estado=?,descripcion=?,categoria=? where id_inv =" + id_inv;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto);
            ps.setString(2, cantidad);
            ps.setString(3, estado);
            ps.setString(4, descripcion);
            ps.setString(5, categoria);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Inventario actualizado correctamente";
            } else {
                msj = "Error en la actualización";
            }
        } catch (Exception e) {
        }
        return msj;
    }

    public String deleteInventario(int id) {
        String sql = "delete from inventario where id_inv =" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            res = ps.executeUpdate();
            if (res == 1) {
                msj = "Producto ha sido eliminado correctamente del inventario";
            } else {
                msj = "Error en la eliminación";
            }

        } catch (Exception e) {
        }
        return msj;
    }

    public List listarInventario(int id) {
        System.out.println("id departamento" + id);
        List<Inventarios> datos = new ArrayList<>();
        String sql = "select inv.id_inv,inv.id_depto,inv.producto,inv.cantidad,inv.estado,inv.categoria,inv.descripcion,d.id as codigo,d.nombre,d.ubicacion from inventario inv inner join departamento d on\n"
                + "                inv.id_depto=d.id where d.id =" + id;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Inventarios in = new Inventarios();
                in.setId_inv(rs.getInt("id_inv"));
                in.setId_depto(rs.getString("id_depto"));
                in.setProducto(rs.getString("producto"));
                in.setCantidad(rs.getString("cantidad"));
                in.setEstado(rs.getString("estado"));
                in.setCategoria(rs.getString("categoria"));
                in.setDescripcion(rs.getString("descripcion"));
                in.setCodigo(rs.getInt("codigo"));
                in.setNombre(rs.getString("nombre"));
                in.setUbicacion(rs.getString("ubicacion"));
                datos.add(in);
            }
        } catch (Exception e) {
            System.err.println("ERROR AL LISTAR INVENTARIO POR DEPARTAMENTO" + e.getMessage());
        }
        System.out.println("datos" + datos.toString());
        return datos;
    }

    public List listarcategorias() {
        List<Categoria> datos = new ArrayList<>();
        String sql = "select * from categoria";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ca = new Categoria();
                ca.setId(rs.getInt("id"));
                ca.setCategoria(rs.getString("categoria"));
                datos.add(ca);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}
