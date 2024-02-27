CREATE TABLE users
(
    user_id           SERIAL PRIMARY KEY,
    role              VARCHAR(20)         NOT NULL, -- Роль пользователя (например, заказчик, исполнитель)
    email             VARCHAR(100) UNIQUE NOT NULL,
    phone_number      VARCHAR(20),
    first_name        VARCHAR(50),
    last_name         VARCHAR(50),
    username          VARCHAR(50) UNIQUE,
    password          VARCHAR(100),                 -- Пароль пользователя
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login        TIMESTAMP,
    is_active         BOOLEAN   DEFAULT TRUE,       -- Флаг активности пользователя
    is_verified       BOOLEAN   DEFAULT FALSE       -- Флаг подтверждения учетной записи
);

CREATE TABLE food_categories
(
    category_id SERIAL PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL,
    description TEXT
);


CREATE TABLE dishes
(
    dish_id          SERIAL PRIMARY KEY,                           -- Уникальный идентификатор блюда
    name             VARCHAR(100) NOT NULL,                        -- Название блюда
    image_url        TEXT,                                         -- URL изображения блюда
    description      TEXT,                                         -- Описание блюда
    category_id      INT REFERENCES food_categories (category_id), -- Идентификатор категории блюда
    rating           NUMERIC(3, 2) DEFAULT 0,                      -- Рейтинг блюда
    price            DECIMAL(10, 2),                               -- Цена блюда
    serving_size     INT,                                          -- Размер порции
    preparation_time INTERVAL,                                     -- Время приготовления
    cook_id          INT REFERENCES users (user_id)                -- Идентификатор пользователя, который приготовил блюдо
);

CREATE TABLE orders
(
    order_id    SERIAL PRIMARY KEY,                  -- Уникальный идентификатор заказа
    user_id     INT REFERENCES users (user_id),      -- Идентификатор пользователя, сделавшего заказ
    dish_id     INT REFERENCES dishes (dish_id),     -- Идентификатор блюда в заказе
    quantity    INT NOT NULL,                        -- Количество заказанных порций
    order_date  TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Дата и время размещения заказа
    status      VARCHAR(50),                         -- Статус заказа (например, "обрабатывается", "выполнен" и т.д.)
    total_price DECIMAL(10, 2)                       -- Общая стоимость заказа
);

