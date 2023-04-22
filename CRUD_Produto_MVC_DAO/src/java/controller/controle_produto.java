/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import model.ProdutoDAO;

/**
 *
 * @author alunos
 */
@WebServlet(name = "controle_produto", urlPatterns = {"/controle_produto"})
public class controle_produto extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String op = request.getParameter("btnoperacao");
            String message = "Operação não realizada";
            if (op.equals("CADASTRAR")) {
                Produto p = new Produto();
                p.setDescricao(request.getParameter("txtdescricao"));
                p.setPreco(Double.parseDouble(request.getParameter("txtpreco")));
                ProdutoDAO pdao = new ProdutoDAO();
                try {
                    pdao.cadastrar(p);
                    message = "Cadastro com sucesso!!";
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("DELETAR")) {
                Produto p = new Produto();
                p.setId(Integer.parseInt(request.getParameter("txtid")));
                ProdutoDAO pdao = new ProdutoDAO();
                try {
                    pdao.deletar(p);
                    message = "Deletado com sucesso!!";
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());
                }
            } else if (op.equals("Consultar por ID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                Produto prod = new Produto();
                prod.setId(id);
                ProdutoDAO pdao = new ProdutoDAO();
                try {
                    
                    prod = pdao.consultarById(prod);
                    
                    request.setAttribute("produto", prod);
                    
                    request.getRequestDispatcher("/resultadoconsultaporid.jsp").forward(request, response);
                    
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());

                }

            } else if (op.equals("Consultar Todos")) {
                ProdutoDAO pdao = new ProdutoDAO();
                try {
                    List<Produto> listproduto = pdao.consultarTodos();
                    request.setAttribute("listproduto",listproduto);
                    request.getRequestDispatcher("resultadoconsultatodos.jsp").forward(request,response);
                } catch (ClassNotFoundException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                } catch (SQLException ex) {
                    System.out.println("Erro SQL: " + ex.getMessage());

                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>controle produto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Produto" + message + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
