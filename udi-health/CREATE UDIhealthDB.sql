-- DROP DATABASE UDI_HEALTH;

CREATE DATABASE UDI_HEALTH;
USE UDI_HEALTH;

CREATE TABLE USUARIO (
    cod_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60),
    senha VARCHAR(15),
    data_nascimento DATE,
    sexo CHAR(1),
    cpf CHAR(11),
    cep CHAR(8),
    telefone CHAR(11),
    email VARCHAR(60),
    status varchar(20)
);

CREATE TABLE PACIENTE (
    cod_paciente INT PRIMARY KEY AUTO_INCREMENT,
    observacoes VARCHAR(255),
    cod_usuario INT,
    FOREIGN KEY (cod_usuario)
        REFERENCES USUARIO (cod_usuario)
);

CREATE TABLE MEDICO (
    cod_medico INT PRIMARY KEY AUTO_INCREMENT,
    crm CHAR(8) NOT NULL,
    cod_usuario INT,
    FOREIGN KEY (cod_usuario)
        REFERENCES USUARIO (cod_usuario)
);

CREATE TABLE CONSULTA (
    cod_consulta INT PRIMARY KEY AUTO_INCREMENT,
    data DATE,
    horario TIME,
    diagnostico VARCHAR(200),
    indicacao VARCHAR(300),
    cod_paciente INT,
    cod_medico INT,
    FOREIGN KEY (cod_paciente)
        REFERENCES PACIENTE (cod_paciente),
    FOREIGN KEY (cod_medico)
        REFERENCES MEDICO (cod_medico)
);

CREATE TABLE EXAME (
    cod_exame INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60)
);

CREATE TABLE MEDICAMENTO (
    cod_medicamento INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60)
);

CREATE TABLE EXAME_PRESCRITO (
    cod_exame_prescrito INT PRIMARY KEY AUTO_INCREMENT,
    cod_consulta INT,
    cod_exame INT,
    data_realizacao DATE,
    horario_realizacao TIME,
    resultado VARCHAR(500),
    FOREIGN KEY (cod_consulta)
        REFERENCES CONSULTA (cod_consulta),
    FOREIGN KEY (cod_exame)
        REFERENCES EXAME (cod_exame)
);

CREATE TABLE MEDICAMENTO_PRESCRITO (
    cod_medicamento_prescrito INT PRIMARY KEY AUTO_INCREMENT,
    cod_consulta INT,
    cod_medicamento INT,
    posologia VARCHAR(300),
    FOREIGN KEY (cod_consulta)
        REFERENCES CONSULTA (cod_consulta),
	FOREIGN KEY (cod_medicamento)
        REFERENCES MEDICAMENTO (cod_medicamento)
);
