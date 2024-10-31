<%-- 
    Document   : resultadoMedico
    Created on : 31 de out. de 2024, 14:35:43
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr> 
                <td>Nome</td> 
                <td>${nome}</td> 
            </tr> 
            <tr> 
                <td>Sexo</td> 
                <td>${(sexo=="M"? "Masculino" : "Feminino")}</td> 
            </tr>
            <tr> 
                <td>CPF</td> 
                <td>${cpf}</td> 
            </tr>
            <tr> 
                <td>CRM</td> 
                <td>${crm}</td> 
            </tr>
            <tr> 
                <td>Telefone</td> 
                <td>${telefone}</td> 
            </tr>
        </table>

    </body>
</html>
