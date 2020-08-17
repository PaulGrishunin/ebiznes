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
 "price" DOUBLE NOT NULL,
 FOREIGN KEY(category) references category(id)
);

CREATE TABLE "user" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "login" VARCHAR NOT NULL,
 "password" VARCHAR NOT NULL,
 "email" VARCHAR NOT NULL,
 "admin" BIT NOT NULL
);

CREATE TABLE "order" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "user" INTEGER NOT NULL,
 "product" INTEGER NOT NULL,
 "quantity" INT NOT NULL,
 "price" DOUBLE NOT NULL,
 "date" VARCHAR NOT NULL,
 "completed" BIT NOT NULL,
 FOREIGN KEY(user) references user(id),
 FOREIGN KEY(product) references product(id)
);

CREATE TABLE "basket" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "user" INTEGER NOT NULL,
 "product" INTEGER NOT NULL,
 "quantity" INT NOT NULL,
 FOREIGN KEY(user) references user(id),
 FOREIGN KEY(product) references product(id)
);

CREATE TABLE "payment" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "order" VARCHAR NOT NULL,
 "date" VARCHAR NOT NULL,
 FOREIGN KEY("order") references "order"(id)
);

CREATE TABLE "review" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "product" INTEGER NOT NULL,
 "user" INTEGER NOT NULL,
 "rate" TINYINT NOT NULL,
 "text" TEXT NOT NULL,
 FOREIGN KEY(user) references user(id),
 FOREIGN KEY(product) references product(id)
);

CREATE TABLE "discount" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "product" INTEGER NOT NULL,
 "amount" INTEGER NOT NULL,
 "description" TEXT NOT NULL,
 FOREIGN KEY(product) references product(id)
);

CREATE TABLE "delivery" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "order" INTEGER NOT NULL,
 "address" TEXT NOT NULL,
 FOREIGN KEY("order") references "order"(id)
);

CREATE TABLE "question" (
 "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
 "product" INTEGER NOT NULL,
 "user" INTEGER NOT NULL,
 "content" TEXT NOT NULL,
 "answer" TEXT NULL,
 FOREIGN KEY(user) references user(id),
 FOREIGN KEY(product) references product(id)
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