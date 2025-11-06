CREATE DATABASE loja_api;

USE loja_api;

CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefone VARCHAR(20)
);


CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10,2),
    estoque INT
);


CREATE TABLE pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    data_pedido DATE,
    status VARCHAR(20),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);


CREATE TABLE pedido_produto (
    id_pedido INT,
    id_produto INT,
    quantidade INT,
    preco_unitario DECIMAL(10,2),
    PRIMARY KEY (id_pedido, id_produto),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);


INSERT INTO cliente (nome, email, telefone) VALUES
('João Silva', 'joao@email.com', '11999999999'),
('Maria Souza', 'maria@email.com', '11988888888');

INSERT INTO produto (nome, descricao, preco, estoque) VALUES
('Notebook', 'Notebook Dell Inspiron 15', 3500.00, 10),
('Mouse', 'Mouse sem fio Logitech', 120.00, 50),
('Teclado', 'Teclado mecânico RGB', 250.00, 30);

INSERT INTO pedido (id_cliente, data_pedido, status) VALUES
(1, '2025-11-05', 'PENDENTE');

INSERT INTO pedido_produto (id_pedido, id_produto, quantidade, preco_unitario) VALUES
(1, 1, 1, 3500.00),
(1, 2, 2, 120.00);