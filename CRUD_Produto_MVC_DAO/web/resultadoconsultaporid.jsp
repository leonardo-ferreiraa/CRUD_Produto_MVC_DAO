<%-- 
    Document   : resultadoconsultaporid
    Created on : 14/04/2023, 19:37:43
    Author     : alunos
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table{
                font-family:Arial, sans-serif;
                border-collapse: collapse;
                width:30%;
            }
            caption{
                border: 1px solid #dddddd;
                padding: 8px;
                background-color: #dddddd;
            }
            td, th {
                border: 1px solid #dddddd;
                text-align: center;
                padding:8px;
            }
            tr:nth-child(even){
                background-color: #dddddd;
            }           
        </style>
    </head>
    <body>
        <table border="1"><%
            %><tr><%
                %><caption>Resultado da Consulta</caption><%
                %><td><% Produto obj2 = (Produto) request.getAttribute("produto");%></td><%
                %><td><%out.println(obj2.getId());%></td><%
                %><td><%out.println(obj2.getDescricao());%></td><%
                %><td><%out.println(p.getPreco());%></td><%
                %><td><%out.println(p.getQuantidade());%></td><%
                %><td><%out.println(p.getFornecedor());%></td><%
                %><td><%out.println(p.getSetor());%></td><%
                %><td><%out.println(p.getData());%></td><%
                %><td><%out.println(p.getTipo());%></td><%
            %></tr><%
        %></table>
        
    </body>
    </html>

