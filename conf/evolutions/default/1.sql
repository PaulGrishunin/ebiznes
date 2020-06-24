# --- !Ups
        
CREATE TABLE "category" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "name" VARCHAR NOT NULL
);

CREATE TABLE "product" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "name" VARCHAR NOT NULL,
 "description" TEXT NOT NULL,
 "category" INT NOT NULL,
 FOREIGN KEY(category) references category(id)
);

CREATE TABLE "user" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "login" VARCHAR NOT NULL,
 "password" VARCHAR NOT NULL,
 "email" VARCHAR NOT NULL
);

CREATE TABLE "order" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "user_id" INTEGER NOT NULL,
 "product_id" INTEGER NOT NULL,
 "quantity" INT NOT NULL,
 "completed" BOOLEAN NOT NULL,
 FOREIGN KEY(user_id) references user(id),
 FOREIGN KEY(product_id) references product(id)
);

CREATE TABLE "basket" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "user_id" INTEGER NOT NULL,
 "product_id" INTEGER NOT NULL,
 "quantity" INT NOT NULL,
 FOREIGN KEY(user_id) references user(id),
 FOREIGN KEY(product_id) references product(id)
);

CREATE TABLE "payment" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "pay_name" VARCHAR NOT NULL,
 "description" TEXT NOT NULL
);

CREATE TABLE "review" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "product_id" INTEGER NOT NULL,
 "user_id" INTEGER NOT NULL,
 "content" TEXT NOT NULL,
 "rate" TINYINT NOT NULL,
 FOREIGN KEY(user_id) references user(id),
 FOREIGN KEY(product_id) references product(id)
);

CREATE TABLE "discount" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "product_id" INTEGER NOT NULL,
 "name" VARCHAR NOT NULL,
 "description" TEXT NOT NULL,
 FOREIGN KEY(product_id) references product(id)
);

CREATE TABLE "delivery" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "order_id" INTEGER NOT NULL,
 "address" TEXT NOT NULL,
 FOREIGN KEY(order_id) references order(id)
);

CREATE TABLE "question" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "product_id" INTEGER NOT NULL,
 "user_id" INTEGER NOT NULL,
 "content" TEXT NOT NULL,
 "answer" TEXT NULL,
 FOREIGN KEY(user_id) references user(id),
 FOREIGN KEY(product_id) references product(id)
);

# --- !Downs

DROP TABLE "category"
DROP TABLE "product"
DROP TABLE "user"
DROP TABLE "order"
DROP TABLE "basket"
DROP TABLE "payment"
DROP TABLE "review"
DROP TABLE "discount"
DROP TABLE "delivery"
DROP TABLE "question"