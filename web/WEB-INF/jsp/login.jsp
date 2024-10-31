<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
    <h1>teste</h1>

<form method="POST" action="${pageContext.request.contextPath}/verificarLogin">
    <label for="cpf">CPF:</label>
    <input type="text" name="cpf">
    <label for="senha">SENHA:</label>
    <input type="text" name="senha">
    
    <input type="submit" value="Logar">
</form>

</body>
</html>
