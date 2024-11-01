/* Etapa 1*/

create database academico;
use academico;

create table turma(
cod_turma int primary key,
ano int,
nome_turma varchar(50)
);

create table curso(
cod_curso int primary key,
nome_curso varchar(100),
cargah_horaria int
);

create table funcionario(
cod_func int primary key,
nome_func varchar(100),
email_func varchar(100),
senha_func varchar(30),
sexo_func varchar(3),
area_func varchar(100)
);

create table professor(
cod_prof int primary key,
salario_prof numeric,
cod_func int,
foreign key(cod_func) references funcionario(cod_func)
);

create table secretario(
cod_sec int primary key,
salario_sec numeric,
cod_func int,
foreign key(cod_func) references funcionario(cod_func)
);

create table coordenador(
cod_coord int primary key,
salario_coord numeric,
cod_func int,
foreign key(cod_func) references funcionario(cod_func)
);

create table aluno(
cod_aluno int primary key,
nome_aluno varchar(100),
rg varchar(14),
cpf_aluno varchar(11),
sexo varchar(3),
data_nasc date,
email_aluno varchar(80),
senha_aluno varchar(30),
cod_curso int,
foreign key(cod_curso) references curso(cod_curso)
);

create table matricula(
cod_mat int primary key,
dt_mat date,
cod_aluno int,
cod_turma int,
foreign key(cod_aluno) references aluno(cod_aluno),
foreign key(cod_turma) references turma(cod_turma)
);

create table disciplina(
cod_disc int primary key,
nome_disc varchar(80),
situacao varchar(20),
carga_horaria_disc int,
cod_prof int,
cod_turma int,
cod_curso int,
foreign key(cod_prof) references professor(cod_prof),
foreign key(cod_turma) references turma (cod_turma),
foreign key (cod_curso) references curso (cod_curso)
);


create table projeto(
cod_projeto int primary key,
descricao varchar(500),
titulo varchar (80),
carga_horaria int,
valor_bolsa float,
cod_aluno int,
cod_prof int,
foreign key(cod_aluno) references aluno(cod_aluno),
foreign key(cod_prof) references professor(cod_prof)
);

create table historico(
cod_historico int primary key,
nota float,
cod_disc int,
cod_turma int,
cod_aluno int,
foreign key(cod_disc) references disciplina(cod_disc),
foreign key(cod_turma) references turma(cod_turma),
foreign key(cod_aluno) references aluno(cod_aluno)
);

/* Etapa 2*/

insert into turma(cod_turma, ano, nome_turma)
values (1, 2020, "2DS"),
(2, 2022, "1PJD"),
(3, 2023, "3Comercio B"),
(4, 2019, "1DS A"),
(5, 2018, "3 DS B");

insert into curso(cod_curso, nome_curso, cargah_horaria)
values (1, "Cultivo de Algas", 1500),
(2, "Programação de Jogos Digitais", 1500),
(3, "Comercio", 1500),
(4, "Enfermagem", 1500),
(5, "Desenvolvimento de Sistemas", 1500);

insert into funcionario(cod_func,nome_func, email_func, senha_func, sexo_func,area_func)
values(1, "Jurandir André de Oliveira", "jurandir.oliveira@gmail.com",  "jurajuracinho2258", "M","Matemática"),
(2, "Josefina de Paula SIlva",  "josefina.silva@gmail.com", "josezinha2483", "F","Língua Inglesa"),
(3,"Manuel Pereira", "manuel.pereira@gmail.com", "manupera0911", "M","Geografia"),
(4, "Lucas Silva", "lucas.silva@email.com", "lucas123", "M","Administrativo"),
(5, "Ana Oliveira", "ana.oliveira@email.com", "ana456", "F","Administrativo"),
(6,  "Carla Mendes", "carla.mendes@email.com", "carla789", "F","Secretaria"),
(7 , "João Pereira", "joao.pereira@email.com", "joao123", "M","Secretaria");


insert into professor(cod_prof, salario_prof, cod_func)
values(1, 2500, 1),
(2, 2500, 2),
(3, 2500, 3);

insert into coordenador(cod_coord, salario_coord, cod_func) 
values(1, 4500, 4),
(2, 4500, 5);

insert into secretario(cod_sec, salario_sec,cod_func)
values(1, 1500,6),
(2, 1500, 7);

insert into aluno(cod_aluno, nome_aluno, rg, cpf_aluno, sexo, data_nasc, email_aluno, senha_aluno,  cod_curso)
values(1, "Yuri Gomes de Oliveira", 123456789, 12345678900, "M", "2005-05-14", "yuri.oliveira@gmail.com"," yurisayajin4320", 1),
(2, "Mariana Lopes de Oliveira", 234567890, 23456789011, "F", "2003-11-09", "mariana.oliveira@gmail.com", "marilindona321", 4),
(3, "Bernardo Gabriel Teixeira Simões", 345678901, 34567890122, "M", "2000-09-21", "bernardo.simoes@gmail.com", "berlindo12345", 5),
(4, "Charlon Rodrigues Silva", 456789012, 45678901233, "M", "1978-07-22", "charlon.silva@gmail.com", "charlon5432", 2),
(5, "Jair Bolsonaro Inácio da Silva", 012345678, 01234567899, "M", "1981-04-22", "jair.silva@gmail.com", "jairlula1322", 1);


insert into matricula(cod_mat, cod_aluno,dt_mat, cod_turma)
values(1, 1, "2020-10-24", 1),
(2, 2, "2023-08-01", 4),
(3, 3, "2021-05-10",5),
(4, 4, "2019-02-08",2),
(5, 5, "2020-05-14", 1);

insert into disciplina(cod_disc, nome_disc, situacao, carga_horaria_disc, cod_prof,cod_turma, cod_curso)
values (1, "Química ", "Disponível", 120, 1, 4, 4),
(2, "Física ", "Indisponível", 200, 2, 2, 2),
(3,"Metodologia Científica","Disponível",120, 3, 3, 3),
(4, "Biomecânica", "Disponível", 50, 2, 5, 5),
(5, "Cálculo ", "Disponível", 200, 3, 2, 2);


insert into projeto(cod_projeto, descricao, titulo, carga_horaria, cod_prof,cod_aluno)
values (1, "Mulheres na STEAM", "Sim, Elas Podem", 12,  2, 3 ),
(2, "Escritoras negras", "Pretas Entre Linhas", 6, 3, 1),
(3, "Valorização do bioma cerrado", "Cerrado na Vida",12,  2, 2),
(4, "Importância da literatura", "Livro Todo Dia", 6, 1, 2),
(5, "Valorização do trabalho doméstico", "Trabalho Não Reconhecido", 6, 3, 4);


insert into historico(cod_historico, nota, cod_disc, cod_turma, cod_aluno)
values(1, 80.5, 2 , 1, 1),
(2, 78.3, 3, 4, 2), 
(3, 65.4, 5, 5, 3), 
(4, 39.8, 4, 2, 4), 
(5, 100.0, 2, 1, 5);



