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

            <!-- Bootstrap 5 -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"/>

            <!-- Font Awesome -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

                <style>
                    :root {
                        --lapis-lazuli: #195b7fff;
                        --penn-red: #9d0606ff;
                        --white-smoke: #f5f5f5ff;
                        --black: #000000ff;
                    }

                    * {
                        box-sizing: border-box;
                        padding: 0;
                    }

                    body {
                        font-family: "Palatino Linotype", "Georgia", Times, "Times New Roman",  serif;
                    }

                    nav {
                        background-color: var(--white-smoke)
                    }

                    header {
                        background-color: var(--lapis-lazuli)
                    }

                    li {
                        width: 130px;
                    }

                    .card-icon {
                        width: 100%;
                        font-size: 80px;
                        color: red;
                    }
                    
                    .dropdown {
                        height: 50px;
                        overflow: visible;
                    }

                    .dropdown:hover .dropdown-menu {
                        display: block;
                    }
                </style>
                </head>

                <body>



                    <header class="text-white text-center py-3">
                        <h1>Bem-vindo à Udi Health!</h1>
                    </header>

                    <nav class="navbar navbar-light"> 
                        <div class="container">
                            <a class="navbar-brand" href="#">Minha Marca</a>
                            <ul class="navbar-nav flex-row">
                                <li class="nav-item mx-2">
                                    <a class="nav-link" href="#">Início</a>
                                </li>
                                <li class="nav-item dropdown mx-2">
                                    <button id="hoverDropdown" class="nav-link dropdown-toogle" type="button">
                                        Médicos
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/consultarMedicos">Consultar</a></li>
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/adicionarMedico">Adicionar</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item mx-2">
                                    <a class="nav-link" href="#">Pacientes</a>
                                </li>
                                <li class="nav-item mx-2">
                                    <a class="nav-link" href="#">Consultas</a>
                                </li>
                            </ul>
                        </div>
                    </nav>

                    <main class="container mt-5">
                        
                    </main>

                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
                </body>
                </html>
                <!--
                        <h1><%= "Welcome, to home"%></h1>
                        <hr>
                        <h2>Selecione uma ação para médico</h2>
                        
                        <a href="${pageContext.request.contextPath}/consultarMedicos">Buscar medico</a>
                        <a href="${pageContext.request.contextPath}/adicionarMedico">Adicionar médico</a>
                        <a href="${pageContext.request.contextPath}/consultarPacientes">Buscar paciente</a>
                        <a href="${pageContext.request.contextPath}/adicionarPaciente">Adicionar paciente</a>
                        <a>Inativar médico</a>
                -->