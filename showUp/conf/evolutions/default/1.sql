# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agenda (
  data                          timestamp,
  hora_inicio                   varchar(255),
  hora_fim                      varchar(255),
  descricao                     varchar(255)
);

create table artista (
  cpf                           varchar(255) not null,
  nome                          varchar(255),
  senha                         varchar(255),
  date                          timestamp,
  genero_musical                varchar(255),
  preco_show                    double not null,
  photo                         longvarbinary,
  constraint pk_artista primary key (cpf)
);

create table contratante (
  cpf                           varchar(255) not null,
  nome                          varchar(255),
  senha                         varchar(255),
  date                          timestamp,
  constraint pk_contratante primary key (cpf)
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


# --- !Downs

drop table if exists agenda;

drop table if exists artista;

drop table if exists contratante;

drop table if exists endereco;

drop table if exists evento;

