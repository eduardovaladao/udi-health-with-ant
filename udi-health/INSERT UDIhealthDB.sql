use udi_health;

insert into usuario (nome, senha, data_nascimento, sexo, cpf, cep, telefone, email, status)
value ("João Pedro Dias", "1234", "2006-07-13", "M", "12345678910", 38408216, 34987654321, "jp.bilulu@gmail.com", "ATIVO"),
("Thiago Daniel Freitas", "6647", "2006-08-29", "M", "788512436987", 38411335, 34965412287, "thiago.daniel@gmail.com", "ATIVO"),
("Eduardo Carvalho Valadão", "8847", "2006-05-12", "M", "12365498705", 38402336, 34997651234, "edu.calvo@gmail.com", "ATIVO"),
("Ricardo Boaventura", "6630", "1980-08-22", "M", "12453698706", 38412330, 34997658854, "rics.boaventura@gmail.com", "ATIVO"),
("Jair Bolsonaro", "2222", "1955-03-21", "M", "12487503214", 21331250, 22993344875, "ai.bolsonaro@gmail.com", "INATIVO"),
("Vanessa Wolf", "0047", "1989-08-11", "F","04796588745", 37854129, 15991348857, "vanessa.wolf@gmail.com", "ATIVO");

insert into usuario (nome, senha, data_nascimento, sexo, cpf, cep, telefone, email, status)
value ("Vinícius Pires Teixeira", "4880", "2006-07-26", "M", "98755230175", 30147884, 34997742235, "vini.cria@gmail.com", "ATIVO"),
("Gabriel Moura", "4880", "2006-10-23", "M", "22894763150",  38402668, 98931578854, "gabriel.moura@gmail.com", "ATIVO"),
("Cricia Zilda Felicio", "4417", "1979-07-18", "F", "11478536598", 38412558, 34996688745, "cricia.paixao@gmail.com", "ATIVO"),
("Lucas Matheus de Oliveira", "3686", "2007-02-02", "M", "02038494690", 38412376, 34991179921, "luscaoliveer@gmail.com", "ATIVO"),
("Drauzio Varella", "7742", "1943-05-03", "M", "20488796305", 3678452, 11997745563, "drauzio.vares@gmail.com", "INATIVO");


insert into paciente (observacoes, cod_usuario)
value ("Paciente com dor no peito", 5),
("Paciente sentindo os batimentos muito acelerados", 3),
("Paciente sentindo os batimentos muito lentos", 1),
("Paciente com coração acelerado devido ao estresse com os alunos", 4),
("Consulta de rotina", 6),
("Consulta de rotina", 2);

insert into medico (crm, cod_usuario)
value (3874195, 10),
(0215874, 7),
(8742691, 8),
(3078429, 9),
(7410389, 11);

insert into consulta (data, horario, diagnostico, indicacao, cod_paciente, cod_medico)
value ("2024-12-03", "15:15:00", "Infarto tipo 1", "Manter repouso e evitar esforço", 5, 2),
("2024-12-15", "09:25:00","Taquicardia", "Manter repouso e tomar medicação prescrita", 3, 1),
("2024-12-22", "19:10:00", "Bradicardia", "Manter repouso e tomar medicação prescrita", 1, 3),
("2025-03-02", "09:30:00", "Paciente em bom estado geral", "Nada a prescrever", 4, 5),
("2025-01-13", "10:55:00", "Paciente em bom estado geral", "Nada a prescrever", 6,  4);

insert into exame (nome)
value ("Eletrocardiograma (ECG)"),
("Ecocardiograma"),
("Teste de esforço (ergoespirometria)"),
("Holter"),
("Monitoramento ambulatorial da pressão arterial (MAPA)"),
("Angiotomografia coronária (TC coronária)"),
("Cateterismo cardíaco (angiografia coronária)"),
("Ressonância magnética cardíaca (RM cardíaca)"),
("Cintilografia miocárdica");

insert into medicamento (nome)
value ("Enalapril"),
("Losartana"),
("Atenolol"),
("Metoprolol"),
("Furosemida"),
("Amlodipina"),
("Varfarina"),
("Ácido acetilsalicílico (Aspirina)"),
("Clopidogrel"),
("Atorvastatina");

insert into exame_prescrito (cod_consulta, cod_exame, data_realizacao, horario_realizacao, resultado)
values 
(1, 8, "2024-12-15", "09:25:00", "Normal"),
(2, 3, "2024-12-28", "10:00:00", "Alterações leves"),
(3, 5, "2025-05-17", "14:30:00", "Presença de arritmia"),
(4, 1, "2024-10-18", "08:15:00", "Normal"),
(5, 7, "2024-11-05", "11:45:00", "Sem alterações significativas");

insert into medicamento_prescrito (cod_consulta, cod_medicamento, posologia)
values 
(1, 5, "1 comprimido 2x ao dia"),
(2, 8, "1 cápsula por dia antes das refeições"),
(3, 3, "2 comprimidos ao dia, um pela manhã e outro à noite"),
(4, 1, "1 dose por dia após o almoço"),
(5, 7, "2 comprimidos 3x ao dia");