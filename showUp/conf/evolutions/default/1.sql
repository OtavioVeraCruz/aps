# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- init script create procs
-- Inital script to create stored procedures etc for mysql platform
DROP PROCEDURE IF EXISTS usp_ebean_drop_foreign_keys;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_foreign_keys TABLE, COLUMN
-- deletes all constraints and foreign keys referring to TABLE.COLUMN
--
CREATE PROCEDURE usp_ebean_drop_foreign_keys(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE c_fk_name CHAR(255);
  DECLARE curs CURSOR FOR SELECT CONSTRAINT_NAME from information_schema.KEY_COLUMN_USAGE
    WHERE TABLE_SCHEMA = DATABASE() and TABLE_NAME = p_table_name and COLUMN_NAME = p_column_name
      AND REFERENCED_TABLE_NAME IS NOT NULL;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN curs;

  read_loop: LOOP
    FETCH curs INTO c_fk_name;
    IF done THEN
      LEAVE read_loop;
    END IF;
    SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP FOREIGN KEY ', c_fk_name);
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
  END LOOP;

  CLOSE curs;
END
$$

DROP PROCEDURE IF EXISTS usp_ebean_drop_column;

delimiter $$
--
-- PROCEDURE: usp_ebean_drop_column TABLE, COLUMN
-- deletes the column and ensures that all indices and constraints are dropped first
--
CREATE PROCEDURE usp_ebean_drop_column(IN p_table_name VARCHAR(255), IN p_column_name VARCHAR(255))
BEGIN
  CALL usp_ebean_drop_foreign_keys(p_table_name, p_column_name);
  SET @sql = CONCAT('ALTER TABLE ', p_table_name, ' DROP COLUMN ', p_column_name);
  PREPARE stmt FROM @sql;
  EXECUTE stmt;
END
$$
create table agenda (
  id                            integer auto_increment not null,
  data                          datetime(6),
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
  date                          datetime(6),
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
  date                          datetime(6),
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
  contratante_id                varchar(255),
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

create index ix_evento_contratante_id on evento (contratante_id);
alter table evento add constraint fk_evento_contratante_id foreign key (contratante_id) references contratante (cpf) on delete restrict on update restrict;


# --- !Downs

alter table agenda drop foreign key fk_agenda_evento_id;

alter table artista drop foreign key fk_artista_endereco_id;

alter table artista_evento drop foreign key fk_artista_evento_artista;
drop index ix_artista_evento_artista on artista_evento;

alter table artista_evento drop foreign key fk_artista_evento_evento;
drop index ix_artista_evento_evento on artista_evento;

alter table contratante drop foreign key fk_contratante_endereco_id;

alter table evento drop foreign key fk_evento_endereco_id;

alter table evento drop foreign key fk_evento_contratante_id;
drop index ix_evento_contratante_id on evento;

drop table if exists agenda;

drop table if exists artista;

drop table if exists artista_evento;

drop table if exists contratante;

drop table if exists endereco;

drop table if exists evento;

