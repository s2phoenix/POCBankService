CREATE TABLE reborn.transaction_holding (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    transaction_id VARCHAR(100) NOT NULL,
    amount DOUBLE NOT NULL,
    currency VARCHAR(10) NOT NULL,
    payee VARCHAR(255) NOT NULL,
    timestamp datetime NOT NULL,
    status VARCHAR(50) NOT NULL
);