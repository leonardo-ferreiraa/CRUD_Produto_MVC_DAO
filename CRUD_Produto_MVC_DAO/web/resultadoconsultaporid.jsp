<%-- 
    Document   : resultadoconsultaporid
    Created on : 14/04/2023, 19:37:43
    Author     : alunos
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <h2>Resultado da Consulta</h2>
        <% Produto obj2 = (Produto) request.getAttribute("produto");%>
        Id......:  <%out.println(obj2.getId());%><hr></hr>
        Descricao...:  <%out.println(obj2.getDescricao());%><br>
        <hr>Valor.......:  R$</hr> <%out.println(obj2.getPreco());%><hr></hr>
        
    

