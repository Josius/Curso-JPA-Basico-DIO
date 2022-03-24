drop database digital_innovation_one;
create database digital_innovation_one;
use digital_innovation_one;

create table Aluno(
	id_aluno integer primary key auto_increment,
    nome varchar(80) not null,
    idade integer not null,
    estado_id integer
);

alter table Aluno
add foreign key (estado_id) references Estado(id_estado);

create table Estado(
	id_estado integer primary key auto_increment,
    nome varchar(80) not null,
    sigla varchar(2) not null,
    aluno_id integer
);

alter table Estado 
add foreign key (aluno_id) references Aluno(id_aluno);

describe Aluno;
describe Estado;

insert into Estado(nome, sigla) values ('Rio de Janeiro', 'RJ');
insert into Estado(nome, sigla) values ('São Paulo', 'SP');
insert into Aluno(nome, idade) values ('Pedro', 30);
insert into Aluno(nome, idade) values ('Joao', 29);
insert into Aluno(nome, idade) values ('Daniel', 25);

select * from Estado;
select * from Aluno;

update Aluno set estado_id = '1' where id_aluno = '2';
UPDATE `digital_innovation_one`.`Aluno` SET `estado_id` = '2' WHERE (`id_aluno` = '3');
UPDATE `digital_innovation_one`.`Aluno` SET `estado_id` = '1' WHERE (`id_aluno` = '4');

