
-- Injeção de Dados na Tabela tb_usuarios (User)
INSERT INTO tb_usuarios (name, email, password) VALUES ('Nina ', 'nina@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Maggie', 'maggie@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Frederico', 'fred@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');
INSERT INTO tb_usuarios (name, email, password) VALUES ('Malu', 'malu@gmail.com', '$2a$12$frLmnTfTYDzVQKrHgkDGxON3jS2uFzQyeqx4Hh5Np52NBpmi2D7d.');

-- Injeção de Dados na Tabela tb_perfil (Role)
INSERT INTO tb_perfil (role_name) VALUES ('PERFIL_OPERATOR');
INSERT INTO tb_perfil (role_name) VALUES ('PERFIL_ADMIN');

-- Injeção de Dados na Tabela tb_perfil_usuario (User_Role)
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (1, 1);
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (2, 1);
INSERT INTO tb_perfil_usuario (usuario_id, perfil_id) VALUES (2, 2);