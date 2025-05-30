
-- Stock & Distribution
CREATE TABLE IF NOT EXISTS country (
    country_id SMALLINT PRIMARY KEY,
    name VARCHAR(500) NOT NULL,
    is_eu BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS shop (
    shop_id INT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    city VARCHAR(1000) NOT NULL,
    longitude FLOAT NOT NULL,
    latitude FLOAT NOT NULL,
    country_id SMALLINT,
    address_id INT,
    FOREIGN KEY (country_id) REFERENCES country(country_id)
);

-- Sales
CREATE TABLE IF NOT EXISTS date_details (
    date_details_id DATE PRIMARY KEY,
    is_holiday BOOLEAN NOT NULL DEFAULT FALSE,
    week_day SMALLINT NOT NULL
);

CREATE TABLE IF NOT EXISTS customer_category (
    customer_category_id INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY,
    gender VARCHAR(1),
    age_category VARCHAR(8) NOT NULL
);

CREATE TABLE IF NOT EXISTS discount (
    discount_id SMALLINT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    amount NUMERIC(4,2) NOT NULL
);

-- Manufacturing
CREATE TABLE IF NOT EXISTS supplier (
    supplier_id INT GENERATED BY DEFAULT AS IDENTITY (START WITH 3000 INCREMENT BY 1) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product_category (
    product_category_id SMALLINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    product_id UUID PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    supplier_id INT,
    unit VARCHAR(3) NOT NULL,
    unit_price FLOAT NOT NULL,
    product_category_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id),
    FOREIGN KEY (product_category_id) REFERENCES product_category(product_category_id)
);

CREATE TABLE IF NOT EXISTS payment (
    payment_id UUID PRIMARY KEY,
    total_amount MONEY,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    shop_id INT,
    date_details_id DATE,
    customer_category_id INT,
    FOREIGN KEY (shop_id) REFERENCES shop(shop_id),
    FOREIGN KEY (date_details_id) REFERENCES date_details(date_details_id),
    FOREIGN KEY (customer_category_id) REFERENCES customer_category(customer_category_id)
);

CREATE TABLE IF NOT EXISTS payment_detail (
    payment_detail_id UUID PRIMARY KEY,
    quantity NUMERIC(8,2) NOT NULL,
    discount_value MONEY,
    final_value MONEY,
    payment_id UUID,
    discount_id SMALLINT,
    product_id UUID,
    FOREIGN KEY (payment_id) REFERENCES payment(payment_id),
    FOREIGN KEY (discount_id) REFERENCES discount(discount_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);
