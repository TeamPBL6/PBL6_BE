-- Chèn dữ liệu vào bảng users
INSERT INTO users (created_by, created_date, modified_date, modified_by, user_name, email, password, full_name, user_role, phone_number)
VALUES
    ('admin', NOW(), NULL, NULL, 'john_doe', 'john.doe@example.com', 'password123', 'John Doe', 1, '123456789'),
    ('admin', NOW(), NULL, NULL, 'jane_doe', 'jane.doe@example.com', 'password456', 'Jane Doe', 2, '987654321'),
    ('admin', NOW(), NULL, NULL, 'michael_smith', 'michael.smith@example.com', 'password789', 'Michael Smith', 1, '555666777');

-- Chèn dữ liệu vào bảng categories
INSERT INTO categories (category_name)
VALUES
    ('Pop'),
    ('Rock'),
    ('Jazz'),
    ('Classical');

-- Chèn dữ liệu vào bảng musics
INSERT INTO musics (title, full_url, price, is_purchased, category_id)
VALUES
    ('Summer Breeze', 'http://example.com/full1.mp3', 9.99, 0, 1),  -- Pop
    ('Rock Anthem', 'http://example.com/full2.mp3', 12.99, 0, 2),   -- Rock
    ('Smooth Jazz', 'http://example.com/full3.mp3', 7.99, 0, 3),    -- Jazz
    ('Classical Symphony', 'http://example.com/full4.mp3', 14.99, 0, 4); -- Classical

-- Chèn dữ liệu vào bảng purchases
INSERT INTO purchases (purchase_id, user_id, music_id, purchase_date, amount)
VALUES
    (1, 1, 2, NOW(), 12.99),  -- John Doe mua Rock Anthem
    (2, 1, 3, NOW(), 7.99),   -- John Doe mua Smooth Jazz
    (3, 2, 1, NOW(), 9.99);   -- Jane Doe mua Summer Breeze

-- Chèn dữ liệu vào bảng wallets
INSERT INTO wallets (user_id, balance, updated_at)
VALUES
    (1, 100.00, NOW()),  -- Ví của John Doe
    (2, 200.00, NOW()),  -- Ví của Jane Doe
    (3, 50.00, NOW());   -- Ví của Michael Smith

-- Chèn dữ liệu vào bảng wallet_transactions
INSERT INTO wallet_transactions (wallet_id, amount, transaction_type, transaction_date)
VALUES
    (1, 50.00, 'DEPOSIT', NOW()),    -- John Doe nạp 50 vào ví
    (1, 20.00, 'WITHDRAW', NOW()),   -- John Doe rút 20 từ ví
    (2, 100.00, 'DEPOSIT', NOW()),   -- Jane Doe nạp 100 vào ví
    (3, 30.00, 'DEPOSIT', NOW());    -- Michael Smith nạp 30 vào ví
