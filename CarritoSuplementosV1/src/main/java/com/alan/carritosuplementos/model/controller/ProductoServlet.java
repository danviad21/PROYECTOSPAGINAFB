/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alan.carritosuplementos.model.controller;

import com.alan.carritosuplementos.model.entity.Producto;
import com.alan.carritosuplementos.services.ProductoDao;
import com.alan.carritosuplementos.services.ProductoDaoImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danvi
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet{
    
    private ProductoDao productoDao;
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            if(this.productoDao == null){
                this.productoDao = new ProductoDaoImpl();
            }
            List<Producto> listaProductos = this.productoDao.findAll();
            request.setAttribute("listaProductos", listaProductos);
            request.getRequestDispatcher("index.jsp").forward(request, response);            
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
    
}
