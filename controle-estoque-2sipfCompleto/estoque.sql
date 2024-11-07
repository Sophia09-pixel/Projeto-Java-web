-- criação da sequence para a tabela java_usuario
create sequence sequencia_usuario
    START WITH 1000
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE
    CACHE 10
    
-- criação da sequence para a tabela java_usuario
create sequence sequencia_perfil
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE
    NOCYCLE
    CACHE 10
    
-- criação da tabela java_perfil
create table java_perfil(
    id_perfil number,
    nome varchar2(50),
    primary key(id_perfil)
);
commit;

-- criação da tabela java_usuario
create table java_usuario(
    id_usuario number,
    nome varchar2(50),
    email varchar2(50),
    senha varchar2(50),
    ativo number(1) check(ativo in (0, 1)),
    primary key(id_usuario)
);
commit;

-- tabela associativa entre java_usuario e java_perfil
create table java_usuario_perfil (
    id_usuario number,
    id_perfil number,
    primary key(id_usuario, id_perfil),
    foreign key(id_usuario) references java_usuario(id_usuario),
    foreign key(id_perfil) references java_perfil(id_perfil)
);
commit;

select u.nome, p.perfil from java_usuario u
join java_usuario_perfil up on u.id_usuario = up.id_usuario
join java_perfil p on p.id_perfil = up.id_perfil
where u.email = 'patricia@fiap' and u.senha = 'patricia1234';

select * from java_perfil;
select * from java_usuario;
select * from java_usuario_perfil;
    
    
    