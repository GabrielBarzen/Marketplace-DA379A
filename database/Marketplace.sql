CREATE TABLE "users" (
  "username" varchar PRIMARY KEY,
  "email" varchar,
  "password" varchar,
  "birth_date" date,
  "first_name" varchar,
  "last_name" varchar
);

CREATE TABLE "products" (
  "id" uuid PRIMARY KEY,
  "price" float8,
  "date" date,
  "type" varchar,
  "color" varchar,
  "condition" varchar,
  "status" varchar,
  "seller" varchar
);

CREATE TABLE "orders" (
  "id" uuid PRIMARY KEY,
  "user" varchar,
  "date" date,
  "status" varchar
);

CREATE TABLE "orders_products" (
  "orders_id" uuid,
  "products_id" uuid,
  PRIMARY KEY ("orders_id", "products_id")
);

CREATE TABLE "types" (
  "type" varchar PRIMARY KEY
);

CREATE TABLE "colors" (
  "color" varchar PRIMARY KEY
);

CREATE TABLE "conditions" (
  "condition" varchar PRIMARY KEY
);

CREATE TABLE "notifications" (
  "id" uuid PRIMARY KEY,
  "recipient" varchar,
  "read" boolean,
  "message" varchar
);

CREATE TABLE "subscription" (
  "user" varchar,
  "type" varchar,
  PRIMARY KEY ("user", "type")
);

ALTER TABLE "products" ADD FOREIGN KEY ("seller") REFERENCES "users" ("username");

ALTER TABLE "orders_products" ADD FOREIGN KEY ("orders_id") REFERENCES "orders" ("id");

ALTER TABLE "orders_products" ADD FOREIGN KEY ("products_id") REFERENCES "products" ("id");

ALTER TABLE "orders" ADD FOREIGN KEY ("user") REFERENCES "users" ("username");

ALTER TABLE "products" ADD FOREIGN KEY ("type") REFERENCES "types" ("type");

ALTER TABLE "products" ADD FOREIGN KEY ("color") REFERENCES "colors" ("color");

ALTER TABLE "products" ADD FOREIGN KEY ("condition") REFERENCES "conditions" ("condition");

ALTER TABLE "subscription" ADD FOREIGN KEY ("user") REFERENCES "users" ("username");

ALTER TABLE "subscription" ADD FOREIGN KEY ("type") REFERENCES "types" ("type");

ALTER TABLE "notifications" ADD FOREIGN KEY ("recipient") REFERENCES "users" ("username");
