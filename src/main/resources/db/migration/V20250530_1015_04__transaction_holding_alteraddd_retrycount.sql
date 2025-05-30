ALTER TABLE reborn.transaction_holding
ADD COLUMN retry_count INT DEFAULT 0;