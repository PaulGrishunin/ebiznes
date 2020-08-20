# --- !Ups

INSERT INTO "category"("name") VALUES("Category 1");
INSERT INTO "category"("name") VALUES("Category 2");
INSERT INTO "category"("name") VALUES("Category 3");
INSERT INTO "category"("name") VALUES("Category 4");
INSERT INTO "category"("name") VALUES("Category 5");
INSERT INTO "category"("name") VALUES("Category 6");


INSERT INTO "product"("name", "description", "category", "price") VALUES("Produсt 1",
                                                                         "Description 1", 1, 700.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 2",
                                                                         "Description 2", 2, 50.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 3",
                                                                         "Description 3", 3, 60.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 4",
                                                                         "Description 4", 4, 10.50);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 5",
                                                                         "Description 5", 5, 20.10);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 6",
                                                                         "Description 6", 6, 90.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 7",
                                                                         "Description 7", 2, 10.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 8",
                                                                         "Description 8", 1, 50.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 9",
                                                                         "Description 9", 3, 5.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 10",
                                                                         "Description 10", 5, 2.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 11",
                                                                         "Description 11", 6, 50.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 12",
                                                                         "Description 12", 4, 10.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 13",
                                                                         "Description 13", 5, 40.40);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 14",
                                                                         "Description 14", 6, 3.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 15",
                                                                         "Description 15", 2, 990.00);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 16",
                                                                         "Description 16", 6, 5.50);
INSERT INTO "product"("name", "description", "category", "price") VALUES("Product 17",
                                                                         "Description 17", 1, 55.50);

INSERT INTO "user"("login", "password", "email", "admin") VALUES("admin", "admin", "admin@admin.com", 1);
INSERT INTO "user"("login", "password", "email", "admin") VALUES("paul_gri", "qwerty12345", "paul_gri@mail.ru", 0);


INSERT INTO "review"("product", "user", "rate", "text") VALUES(1,1,5,"Great product! This is the future!");
INSERT INTO "review"("product", "user", "rate", "text") VALUES(2,1,4,"Great brand! Great product! But I would like more distance on one charge.");


INSERT INTO "discount"("product", "amount", "description") VALUES(1,5,"Only until the end of summer!");
INSERT INTO "discount"("product", "amount", "description") VALUES(2,50,"Two for the price of one!");
INSERT INTO "discount"("product", "amount", "description") VALUES(5,20,"Forever!");

INSERT INTO "question"("product", "user", "content", "answer") VALUES(2,2,"Are there any cars in white?","Yes, there is a color white diamond. Waiting for you!");

-- INSERT INTO "delivery"("order_id", "address") VALUES("1",  "Krakow, Bydgoska, 19");
-- INSERT INTO "delivery"("order_id", "address") VALUES("2",  "Krakow, Profesora Lojasiewicza, 11");


-- INSERT INTO "order"("user_id", "product_id", "quantity", "price", "date", "completed") VALUES(1, 1, 1, 700.00, "05.05.2020", 1);
-- INSERT INTO "order"("user_id", "product_id", "quantity", "price", "date", "completed") VALUES(2, 2, 1, 50.00, "10.05.2020", 0);
--
-- INSERT INTO "basket"("user_id", "product_id", "quantity") VALUES(1,2,5);
-- INSERT INTO "basket"("user_id", "product_id", "quantity") VALUES(2,2,10);
--
-- INSERT INTO "payment"("order_id", "date") VALUES(1, "05.05.2020");
-- INSERT INTO "payment"("order_id", "date") VALUES(2, "10.05.2020");

# --- !Downs

DELETE FROM "category";
delete from sqlite_sequence where name='category';
DELETE FROM "product";
delete from sqlite_sequence where name='product';
DELETE FROM "user";
delete from sqlite_sequence where name='user';
DELETE FROM "review";
delete from sqlite_sequence where name='review';
DELETE FROM "discount";
delete from sqlite_sequence where name='discount';


-- DELETE FROM "category" WHERE name="Tesla";
-- DELETE FROM "category" WHERE name="Porshe";
--
-- DELETE FROM "product" WHERE name="Model S";
-- DELETE FROM "product" WHERE name="Taycan Turbo S";
--
-- DELETE FROM "user" WHERE login="admin";
-- DELETE FROM "user" WHERE login="paul_gri";
--
-- DELETE FROM "order" WHERE user_id="1";
-- DELETE FROM "order" WHERE user_id="2";
--
-- DELETE FROM "basket" WHERE user_id="1";
-- DELETE FROM "basket" WHERE user_id="2";
--
-- DELETE FROM "review" WHERE product_id="1";
-- INSERT INTO "order"("user_id", "product_id", "quantity", "price", "date", "completed") VALUES(1, 1, 1, 700.00, "05.05.2020", 1);
-- INSERT INTO "order"("user_id", "product_id", "quantity", "price", "date", "completed") VALUES(2, 2, 1, 50.00, "10.05.2020", 0);
--
-- INSERT INTO "basket"("user_id", "product_id", "quantity") VALUES(1,2,5);
-- INSERT INTO "basket"("user_id", "product_id", "quantity") VALUES(2,2,10);
--
-- INSERT INTO "payment"("order_id", "date") VALUES(1, "05.05.2020");
-- INSERT INTO "payment"("order_id", "date") VALUES(2, "10.05.2020");
-- DELETE FROM "review" WHERE product_id="2";
--
-- DELETE FROM "discount" WHERE product_id="1";
--
-- DELETE FROM "delivery" WHERE order_id="1";
-- DELETE FROM "delivery" WHERE order_id="2";
--
-- DELETE FROM "question" WHERE product_id="2";


