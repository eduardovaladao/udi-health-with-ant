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

    <form:form method="POST" action="${pageContext.request.contextPath}/atualizarMedico"  modelAttribute="medico">
        <form:label path="nome">Nome</form:label>
        <form:input path="nome" />

        <form:label path="senha">Senha</form:label>
        <form:input path="senha" />

        <form:label path="crm">CRM</form:label>
        <form:input path="crm" />

        <form:label path="cpf">CPF</form:label>
        <form:input path="cpf" />

        <!-- Não funciona
        <form:label path="dataNascimento">Data nascimento</form:label>
        <form:input path="dataNascimento" type="text" placeholder="yyyy-mm-dd" />
        -->
        
        <form:label path="sexo">Sexo</form:label>
        <form:radiobutton path="sexo" value="M" label = "Masculino"  /> 
        <form:radiobutton path="sexo" value="F" label = "Feminino" /> 

        <form:label path="cep">CEP</form:label>
        <form:input path="cep" />

        <form:label path="telefone">Telefone</form:label>
        <form:input path="telefone" />

        <form:label path="email">Email</form:label>
        <form:input path="email" />
        
        <button type="submit">Atualizar</button>
    </form:form>


    

</body>
</html>
