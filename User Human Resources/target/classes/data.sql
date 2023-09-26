
-- Injeção de Dados na Tabela tb_usuarios (User)
INSERT INTO tb_usuarios (name, email, password) VALUES ('Nina ', 'nina@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Maggie', 'maggie@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Frederico', 'fred@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Malu', 'malu@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Snoopy', 'snoopy@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Snow', 'snow@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Miguel', 'miguel@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');

-- Administrador Geral do Sistema
INSERT INTO tb_usuarios (name, email, password) VALUES ('Administrador Geral', 'admin@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');


-- Injeção de Dados na Tabela tb_perfil (Role)
INSERT INTO tb_perfil (role_name) VALUES ('PERFIL_OPERATOR');       -- Perfil de Operador ##1
INSERT INTO tb_perfil (role_name) VALUES ('PERFIL_ADMIN');          -- Perfil de Administrador ##2
INSERT INTO tb_perfil (role_name) VALUES ('OPERATOR');              -- Perfil de Operador ##3
INSERT INTO tb_perfil (role_name) VALUES ('ADMIN');                 -- Perfil de Administrador ##4

-- Injeção de Dados na Tabela tb_perfil_usuario (User_Role)

INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (1, 1); -- Nina
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (1, 3); -- Nina

INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (2, 1); -- Maggie
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (2, 2); -- Maggie
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (2, 3); -- Maggie
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (2, 4); -- Maggie

INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (3, 1); -- Frederico
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (3, 3); -- Frederico

INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (4, 1); -- Maggie
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (4, 3); -- Maggie

insert into tb_perfil_usuario (usuario_id, perfil_id) values (5, 1); -- Snoopy
insert into tb_perfil_usuario (usuario_id, perfil_id) values (5, 3); -- Snoopy

insert into tb_perfil_usuario (usuario_id, perfil_id) values (6, 1); -- Snow
insert into tb_perfil_usuario (usuario_id, perfil_id) values (6, 3); -- Snow

insert into tb_perfil_usuario (usuario_id, perfil_id) values (7, 1); -- Miguel
insert into tb_perfil_usuario (usuario_id, perfil_id) values (7, 2); -- Miguel
insert into tb_perfil_usuario (usuario_id, perfil_id) values (7, 3); -- Miguel
insert into tb_perfil_usuario (usuario_id, perfil_id) values (7, 4); -- Miguel



INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (8, 1); -- Administrador Geral
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (8, 2); -- Administrador Geral
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (8, 3); -- Administrador Geral
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (8, 4); -- Administrador Geral


