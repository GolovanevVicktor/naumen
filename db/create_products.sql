CREATE TABLE products (
  id INTEGER NOT NULL PRIMARY KEY IDENTITY,
  name varchar(255),
  description varchar(255)
);
CREATE INDEX products_description ON products(name);