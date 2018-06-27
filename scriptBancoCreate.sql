drop database tcc_virtual;
create database tcc_virtual;
use tcc_virtual;
drop table cursos;
create table cursos (
  id int not null auto_increment,
  nome varchar(100),
  descricao varchar(255),
  periodo_integralizacao int,
  carga_horaria int,
  situacao varchar(1),
  primary key(id)
);
insert into cursos (nome, descricao, periodo_integralizacao, carga_horaria, situacao) values ('Análise e Desenvolvimento de Sistemas', 'Bla bla bla bla', 6, 2400, 'A');
insert into cursos (nome, descricao, periodo_integralizacao, carga_horaria, situacao) values ('Eletrônica Industrial', 'Bla bla bla bla', 7, 2800, 'A');
drop table usuarios;
create table usuarios (
  matricula int not null,
  nome varchar(100),
  sexo varchar(1),
  endereco_residencial varchar(200),
  email varchar(100),
  telefone_residencial varchar(20),
  telefone_profissional varchar(20),
  telefone_celular varchar(20),
  senha varchar(255),
  situacao varchar(1),
  perfil varchar(15),
  id_curso int,
  observacoes text,
  primary key (matricula),
  foreign key (id_curso) references cursos(id)
);
use tcc_virtual;
select * from usuarios;
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (1669375, 'Gleison Nascimento', 'M', 'gleison.nascimento@restinga.ifrs.edu.br', '123', 'A', 'ADMINISTRADOR', 1);
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (2009876, 'Rafael Esteves', 'M', 'rafael.esteves@restinga.ifrs.edu.br', '123', 'A', 'COORDENADOR', 1);
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (2098659, 'Alexsandro Bonatto', 'M', 'alexsandro.bonatto@restinga.ifrs.edu.br', '123', 'A', 'COORDENADOR', 2);
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (1234567, 'Pedro Chaves da Rocha', 'M', 'pedro.rocha@restinga.ifrs.edu.br', '123', 'A', 'PROFESSOR', 1);
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (1234568, 'Eliana Pereira', 'F', 'eliana.pereira@restinga.ifrs.edu.br', '123', 'A', 'PROFESSOR', 1);
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (1234569, 'Rodrigo Lange', 'M', 'rodrigo.lange@restinga.ifrs.edu.br', '123', 'A', 'PROFESSOR', 1);
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (10019089, 'Jonas Carvalho', 'M', 'jonas.carvalho@restinga.ifrs.edu.br', '123', 'A', 'ESTUDANTE', 1);
insert into usuarios (matricula, nome, sexo, email, senha, situacao, perfil, id_curso) values (10019087, 'Beatriz Castro', 'F', 'beatriz.castro@restinga.ifrs.edu.br', '123', 'A', 'ESTUDANTE', 1);
drop table tccs;
create table tccs (
  id int not null auto_increment,
  titulo varchar(200),
  palavras_chaves varchar(150),
  area_principal varchar(100),
  area_secundaria varchar(100),
  resumo text,
  situacao varchar(1),
  versao_final boolean,
  versao_banca boolean,
  estudante int,
  orientador int,
  primary key (id),
  foreign key (estudante) references usuarios(matricula),
  foreign key (orientador) references usuarios(matricula)
);
insert into tccs (titulo, palavras_chaves, area_principal, area_secundaria, resumo, situacao, estudante, orientador) values ('Agora vai!!!', 'Programação, java', 'Ciências Exatas e da Terra', 'Computação', 'Bla bla bla', 'A', 10019087, 1234567);
insert into tccs (titulo, palavras_chaves, area_principal, area_secundaria, resumo, situacao, estudante, orientador) values ('Jesus me abana!!', 'Sistemas Operacionais, desespero', 'Ciências Exatas e da Terra', 'Computação', 'Bla bla bla', 'A', 10019089, 1234569);
drop table notificacoes;
create table notificacoes (
  id int not null auto_increment,
  usuario_origem int,
  usuario_destino int,
  tcc int,
  mensagem text,
  primary key (id),
  foreign key (usuario_origem) references usuarios(matricula),
  foreign key (usuario_destino) references usuarios(matricula),
  foreign key (tcc) references tccs(id)
);
insert into notificacoes (usuario_origem, usuario_destino, tcc, mensagem) values (10019089, 2009876, 1, 'Banca Parcial liberada');;
insert into notificacoes (usuario_origem, usuario_destino, tcc, mensagem) values (10019089, 1234567, 1, 'Banca Parcial liberada');
drop table bancas;
create table bancas (
  id int not null auto_increment,
  tcc int,
  data_banca date,
  horario_banca time,
  modalidade_banca varchar(10),
  numero_sala int,
  situacao varchar(1),
  primary key (id),
  foreign key (tcc) references tccs(id)
);
insert into bancas (tcc, data_banca, horario_banca, modalidade_banca, numero_sala, situacao) values (1, '2018-07-20', '20:00:00', 'PARCIAL', 412, 'A');
insert into bancas (tcc, data_banca, horario_banca, modalidade_banca, numero_sala, situacao) values (2, '2018-07-15', '10:00:00', 'PARCIAL', 411, 'A');
drop table avaliadores_banca;
create table avaliadores_banca (
  banca int not null,
  professor int not null,
  avaliacao text,
  data_avaliacao datetime,
  situacao varchar(1),
  primary key (banca, professor),
  foreign key (banca) references bancas(id),
  foreign key (professor) references usuarios(matricula)
);
insert into avaliadores_banca values (1, 1234568, 'Bal bla bla', '2018-07-21', 'A');
insert into avaliadores_banca values (1, 1669375, 'Bal bla bla', '2018-07-21', 'A');
insert into avaliadores_banca values (1, 1234569, 'Bal bla bla', '2018-07-21', 'A');
insert into avaliadores_banca values (2, 1234567, 'Bal bla bla', '2018-07-21', 'A');
insert into avaliadores_banca values (2, 2009876, 'Bal bla bla', '2018-07-21', 'A');
insert into avaliadores_banca values (2, 1234568, 'Bal bla bla', '2018-07-21', 'A');



use tcc_virtual;




SELECT * FROM bancas b JOIN tccs t ON (b.tcc = t.id) 
                        JOIN usuarios u ON (u.matricula = t.estudante) 
                        JOIN cursos c ON (u.id_curso = c.id) 
                        WHERE c.nome = 'Análise e Desenvolvimento de Sistemas';


SELECT * FROM bancas b JOIN tccs t ON (b.tcc = t.id) WHERE t.titulo = 'Agora vai!!!';