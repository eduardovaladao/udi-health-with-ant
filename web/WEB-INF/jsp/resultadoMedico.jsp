<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Médico</title>
    </head>
    <body>
        
        <p>Nome:</p><c:out value="${nome}"></c:out>

    <form:form method="POST" action="${pageContext.request.contextPath}/atualizarMedico"  modelAttribute="medico">
        <form:label path="nome">Nome</form:label>
        <form:input path="nome" value="${nome}"/>

        <form:label path="senha">Senha</form:label>
        <form:input path="senha" value="${senha}"/>

        <form:label path="crm">CRM</form:label>
        <form:input path="crm" value="${crm}"/>

        <form:label path="cpf">CPF</form:label>
        <form:input path="cpf" value="${cpf}"/>

        <!-- Não funciona
        <form:label path="dataNascimento">Data nascimento</form:label>
        <form:input path="dataNascimento" type="text" placeholder="yyyy-mm-dd" />
        -->
        
        <form:label path="sexo" value="${sexo}">Sexo</form:label>
        <form:radiobutton path="sexo" label = "Masculino"/> 
        <form:radiobutton path="sexo" label = "Feminino"/> 

        <form:label path="cep">CEP</form:label>
        <form:input path="cep" value="${cep}" />

        <form:label path="telefone">Telefone</form:label>
        <form:input path="telefone" value="${telefone}" />

        <form:label path="email">Email</form:label>
        <form:input path="email" value="${email}" />
    </form:form>


    

</body>
</html>
