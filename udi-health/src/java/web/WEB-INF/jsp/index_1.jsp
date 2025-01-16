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
                    * {
                        box-sizing: border-box;
                        padding: 0;
                    }


                    .card-icon {
                        width: 100%;
                        font-size: 80px;
                        color: red;
                    }
                </style>
                </head>

                <body>
                    <header></header>
                    <main>

                        <div class="container mt-5">

                            <div class="card">
                                <div class="card-title">
                                    <i class="card-icon fa fa-user-md"></i>
                                </div>
                                <div class="card-body">
                                    Opções de médicos
                                </div>
                            </div>
                            <div class="card">
                                <div class="card-title">
                                    <i class="card-icon fa fa-heartbeat"></i>
                                </div>
                                <div class="card-body">
                                    Opções de pacientes
                                </div>
                            </div>

                        </div>
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