CREATE TABLE Hospedes(
	id_hospedes SERIAL PRIMARY KEY NOT NULL,
	nome_completo VARCHAR(100) NOT NULL,
	dt_nascimento DATE NOT NULL,
	endereco VARCHAR(100) NOT NULL,
	telefone VARCHAR(15) NOT NULL,
	email VARCHAR(50),
	cpf VARCHAR(15) NOT NULL

);

CREATE TABLE Funcionarios(
	id_funcionario SERIAL PRIMARY KEY NOT NULL,
	nome_completo VARCHAR(100) NOT NULL,
	cargo VARCHAR(25) NOT NULL,
	telefone VARCHAR(15) NOT NULL
	
	
);

CREATE TABLE Tipo_Quarto(
	id_tipo SERIAL PRIMARY KEY NOT NULL,
	caracteristica VARCHAR(50) NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	capacidade INT NOT NULL,
	preco_noite NUMERIC(5,2) NOT NULL
	
);

CREATE TABLE Quarto(
	id_quarto SERIAL PRIMARY KEY NOT NULL,
	num_quarto INT NOT NULL,
	tipo VARCHAR(25) NOT NULL,
	preco NUMERIC(5,2) NOT NULL,
	id_tipo INT NOT NULL,

CONSTRAINT id_tipoFK FOREIGN KEY (id_tipo)
REFERENCES Tipo_Quarto (id_tipo)
	
);



-- CREATE TABLE DE RELACIONAMENTO
CREATE TABLE Reservas(
	id_reservas SERIAL PRIMARY KEY NOT NULL,
	data_checkin DATE NOT NULL,
	data_checkout DATE NOT NULL,
	status VARCHAR(10) NOT NULL,
	id_hospedes INT NOT NULL,
	id_funcionario INT NOT NULL,
	id_quarto INT NOT NULL,

CONSTRAINT id_hospedesFK FOREIGN KEY (id_hospedes) REFERENCES Hospedes (id_hospedes),
CONSTRAINT id_funcionarioFK FOREIGN KEY (id_funcionario) REFERENCES Funcionarios (id_funcionario),
CONSTRAINT id_quartoFK FOREIGN KEY (id_quarto) REFERENCES Quarto (id_quarto)

);


