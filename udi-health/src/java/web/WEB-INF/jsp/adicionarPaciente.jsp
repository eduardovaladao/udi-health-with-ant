<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dados do Paciente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 700px;
            margin: 50px auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h3 class="text-center mb-4">Dados do Paciente</h3>
            
            <!-- Exibe os resultados se enviados -->
            <c:if test="${not empty paciente}">
                <div class="alert alert-info">
                    <h5>Dados Submetidos:</h5>
                    <ul>
                        <li><strong>Nome:</strong> ${paciente.nome}</li>
                        <li><strong>Senha:</strong> ${paciente.senha}</li>
                        <li><strong>Observações:</strong> ${paciente.observacoes}</li>
                        <li><strong>CPF:</strong> ${paciente.cpf}</li>
                        <li><strong>Sexo:</strong> ${paciente.sexo}</li>
                        <li><strong>CEP:</strong> ${paciente.cep}</li>
                        <li><strong>Telefone:</strong> ${paciente.telefone}</li>
                        <li><strong>Email:</strong> ${paciente.email}</li>
                    </ul>
                </div>
            </c:if>
            
            <form:form method="POST" action="${pageContext.request.contextPath}/atualizarPaciente" modelAttribute="paciente">
                <div class="mb-3">
                    <form:label path="nome" class="form-label">Nome</form:label>
                    <form:input path="nome" cssClass="form-control" />
                </div>
                <div class="mb-3">
                    <form:label path="senha" class="form-label">Senha</form:label>
                    <form:input path="senha" type="password" cssClass="form-control" />
                </div>
                <div class="mb-3">
                    <form:label path="observacoes" class="form-label">Observações</form:label>
                    <form:textarea path="observacoes" cssClass="form-control"></form:textarea>
                </div>
                <div class="mb-3">
                    <form:label path="cpf" class="form-label">CPF</form:label>
                    <form:input path="cpf" cssClass="form-control" disabled="true" />
                </div>
                <div class="mb-3">
                    <form:label path="sexo" class="form-label">Sexo</form:label>
                    <div>
                        <form:radiobutton path="sexo" value="M" cssClass="form-check-input" id="sexoM" />
                        <label for="sexoM" class="form-check-label">Masculino</label>
                    </div>
                    <div>
                        <form:radiobutton path="sexo" value="F" cssClass="form-check-input" id="sexoF" />
                        <label for="sexoF" class="form-check-label">Feminino</label>
                    </div>
                </div>
                <div class="mb-3">
                    <form:label path="cep" class="form-label">CEP</form:label>
                    <form:input path="cep" cssClass="form-control" />
                </div>
                <div class="mb-3">
                    <form:label path="telefone" class="form-label">Telefone</form:label>
                    <form:input path="telefone" cssClass="form-control" />
                </div>
                <div class="mb-3">
                    <form:label path="email" class="form-label">Email</form:label>
                    <form:input path="email" cssClass="form-control" />
                </div>
                <div class="text-center">
                    <!-- Botão de salvar -->
                    <button type="submit" class="btn btn-primary">Salvar</button>
                    
                    <!-- Botão de alterar -->
                    <button type="button" class="btn btn-warning" onclick="alterarDados()">Alterar</button>
                </div>
            </form:form>
        </div>
    </div>

    <script>
        function alterarDados() {
            alert("Modo de edição ativado. Altere os campos e clique em Salvar.");
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
