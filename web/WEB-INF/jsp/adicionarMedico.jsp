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
            <h1>Cadastro de Cliente</h1>
            <form:form method="POST" action="${pageContext.request.contextPath}/adicionarCliente" commandName="cliente" name="formulario" id="formulario">

                <tr><td>
                        <form:label path= "nome">Nome</form:label>
                        <form:input path = "nome" />
                    </td></tr>
                <tr><td>
                        <form:label path= "crm">CRM</form:label>
                        <form:input path = "crm" />
                    </td></tr>
                <tr><td>
                        <form:label path= "cpf">CPF</form:label>
                        <form:input path = "cpf" />
                    </td></tr>
                <tr><td>
                        <form:label path= "dataNascimento">Idade</form:label>
                        <form:textarea path = "dataNascimento" id="texto" />
                    </td></tr>
                <tr><td>
                        <form:label path= "sexo">Sexo</form:label>
                        <form:textarea path = "sexo">
                            
                    </td></tr>
                <tr><td>
                        <form:label path= "cliEspecial">Especial</form:label>
                        <form:checkbox path = "cliEspecial" id="newsletter"/>
                    </td></tr>
                <tr><td>
                        <form:label path= "cliLinguagens">Linguas</form:label>
                        <form:checkboxes  items = "${webLinguagensLista}" path = "cliLinguagens" id="newsletter"/>
                    </td></tr>
                <tr><td>
                        <form:label path = "cliSexo">Sexo</form:label>
                        <form:radiobutton path = "cliSexo" value = "0" label = "Masculino"  /> 
                        <form:radiobutton path = "cliSexo" value = "1" label = "Feminio" /> 
                    </td></tr>
                <tr><td>
                        <form:label path= "cliGeneroFilme">Genero Filmes:</form:label>
                        <form:radiobuttons  items = "${webGeneroFilmes}" path = "cliGeneroFilme" />
                    </td></tr>
                <tr><td>
                        <form:label path= "cliDesejos" >Desejos</form:label>
                        <form:select path = "cliDesejos" items = "${webListaDesejos}" multiple="true" />
                    </td></tr>
                <tr><td>
                        <form:hidden path = "cliPerfil" value="administrador" />
                        <input type = "submit" value = "::. Inserir .::"/> 
                    </td></tr>
                </form:form>
        </table>

    </body>
</html>
