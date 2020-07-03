# --- !Ups

INSERT INTO "category"("name") VALUES("Tesla");
INSERT INTO "category"("name") VALUES("Porshe");

INSERT INTO "product"("name", "description", "category") VALUES("Model S",
"Range: 402 mi, From 0-60 mph: 2.3 s", "Tesla");
INSERT INTO "product"("name", "description", "category") VALUES("Taycan Turbo S",
"Range: 412 km, From 0-100 kmph: 2.8 s", "Porshe");

INSERT INTO "user"("login", "password", "email") VALUES("admin", "admin", "admin@admin.com");
INSERT INTO "user"("login", "password", "email") VALUES("paul_gri", "qwerty12345", "paul_gri@mail.ru");

INSERT INTO "order"("user_id", "product_id", "quantity", "completed") VALUES("1", "1", "1", "true");
INSERT INTO "order"("user_id", "product_id", "quantity", "completed") VALUES("2", "2", "1", "false");

INSERT INTO "basket"("user_id", "product_id", "quantity") VALUES("1", "2", "5");
INSERT INTO "basket"("user_id", "product_id", "quantity") VALUES("2", "2", "10");

INSERT INTO "payment"("pay_name", "description") VALUES("Cash. Stock.",
"Payment in cash upon receipt of goods at the warehouse. When paying in cash, a cashier''s check will be issued.");
INSERT INTO "payment"("pay_name", "description") VALUES("Bank transfer", "Payment by bank transfer to the account of "EVMotors" company
 payment details:
Beneficiary’s Account (EURO): PL12 3456 7890 1234 5678 9012 34
Beneficiary’s Account (USD): PL 23 1750 0000 0000 0000 0000 0000
Beneficiary’s Account (PLN): PL 56 0000 0000 0000 0000 0000 0000
Beneficiary’s Bank: Raiffeisen Bank Polska S.A.
Bank Adress:  ul. Oleska 6, Opole Poland
SWIFT: RCBWPLPW");

INSERT INTO "review"("product_id", "user_id", "content", "rate") VALUES("1", "1", "Great car! Electricity is the future!", "5");
INSERT INTO "review"("product_id", "user_id", "content", "rate") VALUES("2", "1", "Great brand! Great car! But I would like more distance on one charge.", "4");

INSERT INTO "discount"("product_id", "name", "discription") VALUES("1", "Tesla Model S price - 10% ",
 "Only until the end of summer, the legendary Tesla Model C is 10% cheaper!");

INSERT INTO "delivery"("order_id", "address") VALUES("1",  "Krakow, Bydgoska, 19");
INSERT INTO "delivery"("order_id", "address") VALUES("2",  "Krakow, Profesora Lojasiewicza, 11");

INSERT INTO "question"("product_id", "user_id", "content", "answer") VALUES("2", "2", "Are there any cars in white?", "Yes, there is a color white diamond. Waiting for you!");


# --- !Downs

DELETE FROM "category" WHERE name="Tesla";
DELETE FROM "category" WHERE name="Porshe";

DELETE FROM "product" WHERE name="Model S";
DELETE FROM "product" WHERE name="Taycan Turbo S";

DELETE FROM "user" WHERE login="admin";
DELETE FROM "user" WHERE login="paul_gri";

DELETE FROM "order" WHERE user_id="1";
DELETE FROM "order" WHERE user_id="2";

DELETE FROM "basket" WHERE user_id="1";
DELETE FROM "basket" WHERE user_id="2";

DELETE FROM "review" WHERE product_id="1";
DELETE FROM "review" WHERE product_id="2";

DELETE FROM "discount" WHERE name="Tesla Model S price - 10%";

DELETE FROM "delivery" WHERE order_id="1";
DELETE FROM "delivery" WHERE order_id="2";

DELETE FROM "question" WHERE product_id="2";