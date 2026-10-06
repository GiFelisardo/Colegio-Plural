create database plural_sql;

create table Responsaveis(
    Id serial primary key,
    Nome varchar(50) not null,
    Email varchar(50) not null unique,
    CPF varchar(50) not null unique,
    Numero varchar(20) not null unique
);

create table Alunos(
    Id serial primary key,
    Nome varchar(50) not null,
    Turma varchar(5) not null,
    Tipo_inclusao varchar(50) not null,
    Responsaveis_id int,
    constraint Responsaveis_id foreign key (ResponsaveisId) references Responsaveis (Id)
);

create table Atendimentos(
    Id serial primary key,
    Data_atendimento datetime not null,
    Tipo_atendimento text not null,
    Responsavel_atendimento varchar(50) not null,
    Aluno_id int,
    constraint Aluno_id foreign key (AlunoId) references Aluno (Id)
);

create table Usuario(
    Id serial primary key,
    Senha varchar(10) not null,
    Nome varchar(50) not null
);

insert into Responsaveis ()
values (1, 'Felippe Nascimento', 'fefe@gmail.com', md5('35568322690'), '24877554687'),
(2, 'Andressa Leal', 'Andressa@gmail.com', md5('67448233648'), '25988556473'),
(3, 'Guilherme Cilente', 'Gui@gmail.com', md5('64483655286'), '24988664537');

insert into Alunos ()
values (1, 'Samuel Nascimento', '510', md5('Autismo nível 3'), 1),
(2, 'Julia Leal', '617', md5('TDAH'), 2),
(3, 'Matheus Cilente', '510', md5('Dislexia'), 3);

insert into Usuario ()
values (1, md5('7249') 'Juliana Costa'),
(2, md5('4567'), 'Raissa Bernardes'),
(3, md5('5432'), 'Juliano Bossa');

insert into Atendimentos ()
values (1, '2026-10-01 09:00:00', 'Acompanhamento contínuo', 'Raissa Bernardes', 1),
(2, '2026-10-02 15:30:00', 'Prova adaptada', 'Juliana Costa', 2),
(3, '2026-10-03 10:15:00', 'Uso de calculadora', 'Juliano Bossa', 3);