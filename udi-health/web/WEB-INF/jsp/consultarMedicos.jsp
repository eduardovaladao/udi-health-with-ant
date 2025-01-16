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
    <!-- Bootstrap 5 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <style>

    </style>
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