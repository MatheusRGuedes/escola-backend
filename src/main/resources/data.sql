-- ====== Carga Disciplinas
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (1, '006', 'Algorítimos');
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (2, '008', 'Banco de Dados');
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (3, '005', 'Arquitetura');
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (4, '004', 'POO');
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (5, '003', 'POO2');
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (6, '001', 'Estrutura de Dados');
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (7, '007', 'Sistemas Operacionais');
INSERT INTO DISCIPLINAS (id, codigo, nome ) VALUES (8, '002', 'Redes de Computadores');

-- ====== Carga Endereços
INSERT INTO ENDERECOS (id, cep, logradouro, bairro, cidade, uf) 
	VALUES (1, 20973019, 'Avenida Nossa Senhora de Compacabana', 'Copacabanca', 'Rio de Janeiro', 'RJ');
INSERT INTO ENDERECOS (id, cep, logradouro, bairro, cidade, uf) 
	VALUES (2, 72548516, 'Quadra QR 218 Conjunto P', 'Santa Maria', 'Brasília', 'DF');
INSERT INTO ENDERECOS (id, cep, logradouro, bairro, cidade, uf) 
	VALUES (3, 13502000, 'Avenida Visconde de Rio Claro', 'Jardim INOCOOP', 'Rio Claro', 'SP');
INSERT INTO ENDERECOS (id, cep, logradouro, bairro, cidade, uf) 
	VALUES (4, 88107323, 'Rua Coruja', 'Forquilhas', 'São José', 'SC');


-- ====== Carga Professores
INSERT INTO PROFESSORES (id, data_nascimento, nome, endereco_id, sexo) VALUES (1, '2000-01-25','Matheus', 1, 'MASCULINO');
INSERT INTO PROFESSORES (id, data_nascimento, nome, endereco_id, sexo) VALUES (2, '2005-02-20', 'JuninHA', 2, 'FEMININO');
INSERT INTO PROFESSORES (id, data_nascimento, nome, endereco_id, sexo) VALUES (3, '2010-01-25', 'Cabeça de gelo', 3, 'MASCULINO');
INSERT INTO PROFESSORES (id, data_nascimento, nome, endereco_id, sexo) VALUES (4, '2000-01-10', 'Fahur', 4, 'MASCULINO');

-- ====== Carga Formações
INSERT INTO FORMACOES (id, nome, tipo, professor_id) VALUES (1, 'Sistemas de Informação', 'LICENCIATURA', 4);
INSERT INTO FORMACOES (id, nome, tipo, professor_id) VALUES (2, 'Matemática', 'GRADUACAO', 4);