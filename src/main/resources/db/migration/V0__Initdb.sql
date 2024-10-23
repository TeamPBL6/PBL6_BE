CREATE DATABASE IF NOT EXISTS PBL6;

CREATE TABLE users
(
    user_id       BIGINT AUTO_INCREMENT NOT NULL,
    created_by    VARCHAR(255)          NULL,
    created_date  datetime              NULL,
    modified_date datetime              NULL,
    modified_by   VARCHAR(255)          NULL,
    user_name     VARCHAR(255)          NOT NULL,
    email         VARCHAR(255)          NOT NULL,
    password      VARCHAR(255)          NOT NULL,
    full_name     VARCHAR(255)          NOT NULL,
    user_role     SMALLINT              NOT NULL,
    phone_number  VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT uc_users_user_name UNIQUE (user_name);

CREATE TABLE categories
(
    category_id   BIGINT AUTO_INCREMENT NOT NULL,
    category_name VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (category_id)
);

CREATE TABLE musics
(
    music_id     BIGINT AUTO_INCREMENT NOT NULL,
    title        VARCHAR(255)          NOT NULL,
    full_url     VARCHAR(255)          NOT NULL,
    price        DECIMAL               NOT NULL,
    is_purchased BIT(1)                NOT NULL,
    category_id  BIGINT                NULL,
    CONSTRAINT pk_musics PRIMARY KEY (music_id)
);

ALTER TABLE musics
    ADD CONSTRAINT FK_MUSICS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (category_id);

CREATE TABLE purchases
(
    purchase_id   BIGINT   NOT NULL,
    user_id       BIGINT   NOT NULL,
    music_id      BIGINT   NOT NULL,
    purchase_date datetime NOT NULL,
    amount        DECIMAL  NOT NULL,
    CONSTRAINT pk_purchases PRIMARY KEY (purchase_id)
);

ALTER TABLE purchases
    ADD CONSTRAINT uc_92cdb7e65736f9b80a090a011 UNIQUE (music_id);

ALTER TABLE purchases
    ADD CONSTRAINT FK_PURCHASES_ON_MUSIC FOREIGN KEY (music_id) REFERENCES musics (music_id);

ALTER TABLE purchases
    ADD CONSTRAINT FK_PURCHASES_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);

CREATE TABLE wallets
(
    wallet_id  BIGINT AUTO_INCREMENT NOT NULL,
    user_id    BIGINT                NOT NULL,
    balance    DOUBLE                NOT NULL,
    updated_at datetime              NOT NULL,
    CONSTRAINT pk_wallets PRIMARY KEY (wallet_id)
);

ALTER TABLE wallets
    ADD CONSTRAINT uc_wallets_user UNIQUE (user_id);

ALTER TABLE wallets
    ADD CONSTRAINT FK_WALLETS_ON_USER FOREIGN KEY (user_id) REFERENCES users (user_id);

CREATE TABLE wallet_transactions
(
    wallet_transaction_id BIGINT AUTO_INCREMENT NOT NULL,
    wallet_id             BIGINT                NOT NULL,
    amount                DOUBLE                NOT NULL,
    transaction_type      VARCHAR(255)          NOT NULL,
    transaction_date      datetime              NOT NULL,
    CONSTRAINT pk_wallet_transactions PRIMARY KEY (wallet_transaction_id)
);

ALTER TABLE wallet_transactions
    ADD CONSTRAINT FK_WALLET_TRANSACTIONS_ON_WALLET FOREIGN KEY (wallet_id) REFERENCES wallets (wallet_id);