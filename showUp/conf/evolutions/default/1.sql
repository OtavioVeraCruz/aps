# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table agenda (
  id                            integer auto_increment not null,
  data                          timestamp,
  hora_inicio                   varchar(255),
  hora_fim                      varchar(255),
  evento_id                     integer,
  constraint uq_agenda_evento_id unique (evento_id),
  constraint pk_agenda primary key (id)
);

create table artista (
  cpf                           varchar(255) not null,
  nome                          varchar(255),
  email                         varchar(255),
  senha                         varchar(255),
  date                          timestamp,
  genero_musical                varchar(255),
  preco_show                    double not null,
  photo                         longvarbinary,
  endereco_id                   integer,
  constraint uq_artista_endereco_id unique (endereco_id),
  constraint pk_artista primary key (cpf)
);

create table artista_evento (
  artista_cpf                   varchar(255) not null,
  evento_id                     integer not null,
  constraint pk_artista_evento primary key (artista_cpf,evento_id)
);

create table contratante (
  cpf                           varchar(255) not null,
  nome                          varchar(255),
  email                         varchar(255),
  senha                         varchar(255),
  date                          timestamp,
  endereco_id                   integer,
  constraint uq_contratante_endereco_id unique (endereco_id),
  constraint pk_contratante primary key (cpf)
);

create table endereco (
  id                            integer auto_increment not null,
  cep                           varchar(255),
  rua                           varchar(255),
  complemento                   varchar(255),
  numero                        integer not null,
  cidade                        varchar(255),
  estado                        varchar(255),
  pais                          varchar(255),
  constraint pk_endereco primary key (id)
);

create table evento (
  id                            integer auto_increment not null,
  nome                          varchar(255),
  endereco_id                   integer,
  preco                         double not null,
  descricao                     varchar(255),
  contratante_cpf               varchar(255),
  constraint uq_evento_endereco_id unique (endereco_id),
  constraint pk_evento primary key (id)
);

alter table agenda add constraint fk_agenda_evento_id foreign key (evento_id) references evento (id) on delete restrict on update restrict;

alter table artista add constraint fk_artista_endereco_id foreign key (endereco_id) references endereco (id) on delete restrict on update restrict;

create index ix_artista_evento_artista on artista_evento (artista_cpf);
alter table artista_evento add constraint fk_artista_evento_artista foreign key (artista_cpf) references artista (cpf) on delete restrict on update restrict;

create index ix_artista_evento_evento on artista_evento (evento_id);
alter table artista_evento add constraint fk_artista_evento_evento foreign key (evento_id) references evento (id) on delete restrict on update restrict;

alter table contratante add constraint fk_contratante_endereco_id foreign key (endereco_id) references endereco (id) on delete restrict on update restrict;

alter table evento add constraint fk_evento_endereco_id foreign key (endereco_id) references endereco (id) on delete restrict on update restrict;

create index ix_evento_contratante_cpf on evento (contratante_cpf);
alter table evento add constraint fk_evento_contratante_cpf foreign key (contratante_cpf) references contratante (cpf) on delete restrict on update restrict;


# --- !Downs

alter table agenda drop constraint if exists fk_agenda_evento_id;

alter table artista drop constraint if exists fk_artista_endereco_id;

alter table artista_evento drop constraint if exists fk_artista_evento_artista;
drop index if exists ix_artista_evento_artista;

alter table artista_evento drop constraint if exists fk_artista_evento_evento;
drop index if exists ix_artista_evento_evento;

alter table contratante drop constraint if exists fk_contratante_endereco_id;

alter table evento drop constraint if exists fk_evento_endereco_id;

alter table evento drop constraint if exists fk_evento_contratante_cpf;
drop index if exists ix_evento_contratante_cpf;

drop table if exists agenda;

drop table if exists artista;

drop table if exists artista_evento;

drop table if exists contratante;

drop table if exists endereco;

drop table if exists evento;

