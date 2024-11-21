<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml" 
            xmlns:h="http://java.sun.com/jsf/html"
            xmlns:f="http://java.sun.com/jsf/core" 
            xmlns:cc="http://java.sun.com/jsf/composite" 
            xmlns:p="http://primefaces.org/ui">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultar médicos</title>
</head>
<body>
    <form:form method="POST" action="${pageContext.request.contextPath}/consultarMedico" modelAttribute="medico" name="formulario" id="formulario">
        <form:select path="codigoMedico">
            <form:option value="0" label="Selecionar" />
            <form:options items="${webConsultarMedicos}" />
        </form:select>
        <input type="submit" value ="confirmar">
    </form:form>          
</body>
</html>