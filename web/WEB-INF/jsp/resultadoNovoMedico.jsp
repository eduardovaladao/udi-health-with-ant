<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Concluído</title>
    </head>
    <body>
        <h1>Médico Adicionado</h1>
        <table border="1">
            <tr>
                <td>Nome</td>
                <td>${nome}</td>
            </tr>
            <tr>
                <td>Data nasc.</td>
                <td>${dataNascimento}</td>
            </tr>
            <tr>
                <td>Sexo</td>
                <td>${sexo}</td>
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
            
        <a href="/udi-health">Voltar</a>

    </body>
</html>
