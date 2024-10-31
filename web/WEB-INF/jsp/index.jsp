<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml" 
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core" 
      xmlns:cc="http://java.sun.com/jsf/composite" 
      xmlns:p="http://primefaces.org/ui">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1><%= "Welcome, to home"%></h1>
        <hr>
        <h2>Selecione uma ação para médico</h2>
        
        <a href="${pageContext.request.contextPath}/consultarMedicos">Buscar medico</a>
        <a href="${pageContext.request.contextPath}/atualizarMedico">Atualizar médico</a>
        <a href="${pageContext.request.contextPath}/adicionarMedico">Adicionar médico</a>
        <a>Inativar médico</a>
        
    </body>
</html>
