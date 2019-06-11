/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import phuctt.dtos.AccessoriesDTO;
import phuctt.dtos.AccessoriesError;
import phuctt.process.ProcessBean;

/**
 *
 * @author Thien Phuc
 */
public class UpdateController extends HttpServlet {
    public static final String ERROR ="error.jsp";
    public static final String SUCCESS ="SearchController";
    public static final String INVALID ="detail.jsp";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("txtID");
            String name = request.getParameter("txtName");
            String brand = request.getParameter("txtBrand");
            String description = request.getParameter("txtDes");
            String priceStr = request.getParameter("txtPrice");
            float price = 0;

            boolean valid = true;
            AccessoriesError errorObj = new AccessoriesError();

            if (id.isEmpty()) {
                errorObj.setErrorID("ID is not null");
                valid = false;
            }

            if (name.isEmpty()) {
                errorObj.setErrorName("Name is not null");
                valid = false;
            }

            if (brand.isEmpty()) {
                errorObj.setErrorBrand("Brand is not null");
                valid = false;
            }

            if (description.isEmpty()) {
                errorObj.setErrorDes("Description is not null");
                valid = false;
            }

            if (priceStr.isEmpty()) {
                errorObj.setErrorPrice("Price is not null");
                valid = false;
            } else {
                try {
                    price = Float.parseFloat(priceStr);
                } catch (NumberFormatException e) {
                    errorObj.setErrorPrice("Price must be in number format");
                    valid = false;
                }
            }

            AccessoriesDTO dto = new AccessoriesDTO(id, name, brand, description, price);
            
            if (valid) {
                ProcessBean bean = new ProcessBean();
                bean.setDto(dto);
                
                if (bean.update()) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Update failed");
                }
            } else {
                request.setAttribute("INVALID", errorObj);
                request.setAttribute("DTO", dto);
                url = INVALID;
            }
        } catch (Exception e) {
            log("Error at UpdateController " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
