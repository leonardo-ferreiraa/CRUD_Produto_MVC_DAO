<%-- 
    Document   : resultadoconsultatodos
    Created on : 14/04/2023, 21:10:48
    Author     : alunos
--%>

<%@page import="java.util.List"%>
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
        <h1>Hello World!</h1>
        <% List<Produto> listproduto = (List<Produto>) request.getAttribute("listproduto");%>
        <%if (listproduto.size() > 0){
        %><table border="1"><%
            %><tr><%
                %><caption>Tabela Produto</caption><%
                for (Produto p : listproduto){
                %><td><%out.println(p.getId());%></td><%
                %><td><%out.println(p.getDescricao());%></td><%
                %><td><%out.println(p.getPreco());%></td><%
                %><td><%out.println(p.getQuantidade());%></td><%
                %><td><%out.println(p.getFornecedor());%></td><%
                %><td><%out.println(p.getSetor());%></td><%
                %><td><%out.println(p.getData());%></td><%
                %><td><%out.println(p.getTipo());%></td><%
                %><td><a href="http://localhost:8084/CRUD_Produto_MVC_DAO/controle_produto?btnoperacao=DELETARtxtid&=<%out.println(p.getId());%>"><img src="images/trash.png" width="25" height="25"></a></td><%
            %></tr><%
                }
                %></table><%
            }   else
                out.println("Consulta sem retorno");%>
        

        
    </body>
</html>
