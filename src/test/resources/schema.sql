CREATE TABLE IF NOT EXISTS product (
                         product_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         category_name VARCHAR(255),
                         is_green BOOLEAN DEFAULT FALSE,
                         product_name VARCHAR(255),
                         detail VARCHAR(255),
                         average_rating FLOAT,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                         maker_name VARCHAR(255),
                         serving_size DOUBLE,
                         kcal DOUBLE,
                         carbohydrate DOUBLE,
                         protein DOUBLE,
                         fat DOUBLE,
                         sodium DOUBLE,
                         cholesterol DOUBLE,
                         saturated_fat DOUBLE,
                         trans_fat DOUBLE,
                         sugar DOUBLE,
                         score DOUBLE,
                         image VARCHAR(255),
                         nut_image VARCHAR(255),
                         nut_score DOUBLE,
                         product_link VARCHAR(255)
);
