<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Médico</title>
    </head>
    <body>
        <h1>Cadastro de Cliente</h1>            
        <form:form method="POST" action="${pageContext.request.contextPath}/adicionarNovoMedico" modelAttribute="medico">

            <form:label path="nome">Nome</form:label>
            <form:input path="nome" />
            
            <form:label path="senha">Senha</form:label>
            <form:input path="senha" />

            <form:label path="crm">CRM</form:label>
            <form:input path="crm" />

            <form:label path="cpf">CPF</form:label>
            <form:input path="cpf" />

            <form:label path="dataNascimento">Data nascimento</form:label>
            <form:input path="dataNascimento" type="text" />

            <form:label path="sexo">Sexo</form:label>
            <form:radiobutton path="sexo" value="${'M'}" label = "Masculino"  /> 
            <form:radiobutton path="sexo" value="${'F'}" label = "Feminino" /> 

            <form:label path="cep">CEP</form:label>
            <form:input path="cep" />

            <form:label path="telefone">Telefone</form:label>
            <form:input path="telefone" />
            
            <form:label path="email">Email</form:label>
            <form:input path="email" />
            
            <input type="submit" value="::. Adicionar .::"/> 
        </form:form>
    </body>
</html>
