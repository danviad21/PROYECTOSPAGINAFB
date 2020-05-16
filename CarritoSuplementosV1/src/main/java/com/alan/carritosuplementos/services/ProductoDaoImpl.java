package com.alan.carritosuplementos.services;

import com.alan.carritosuplementos.conexion.Conexion;
import com.alan.carritosuplementos.model.entity.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDaoImpl implements ProductoDao {

    @Override
    public List<Producto> findAll() {
        List<Producto> listaProducto = new ArrayList();
        try {
            int contador = 1;
            String sql = "SELECT * FROM producto;";
            try (PreparedStatement ps = Conexion.getConnection().prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Producto p = new Producto();
                    p.setId(rs.getInt(contador++));
                    p.setNombres(rs.getString(contador++));
                    p.setFoto(rs.getString(contador++));
                    p.setDescripcion(rs.getString(contador++));
                    p.setPrecio(rs.getDouble(contador++));
                    p.setStock(rs.getInt(contador++));
                    listaProducto.add(p);
                }
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println("NO SE PUDO OBTENER LA INFORMACION "+ex);
        } finally{
            try {
                Conexion.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return listaProducto;
    }
}
