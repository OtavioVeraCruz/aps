# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agenda (
  data                          timestamp,
  hora_inicio                   varchar(255),
  hora_fim                      varchar(255),
  descricao                     varchar(255)
);

create table endereco (
  cep                           varchar(255),
  rua                           varchar(255),
  complemento                   varchar(255),
  numero                        integer not null,
  cidade                        varchar(255),
  estado                        varchar(255),
  pais                          varchar(255)
);

create table evento (
  nome                          varchar(255),
  preco                         double not null
);

create table user (
  cpf                           varchar(255) not null,
  name                          varchar(255),
  constraint pk_user primary key (cpf)
);


# --- !Downs

drop table if exists agenda;

drop table if exists endereco;

drop table if exists evento;

drop table if exists user;

