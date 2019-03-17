CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id) 

);


-- adding three categories
INSERT INTO category (name, description,image_url,is_active) VALUES ('Starters', 'Its the best way to start an indian meal!', 'CSlider1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Main courses', 'To fill your crying stomach', 'CSlider2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Desserts', 'Have you thought of an ending?', 'CSlider3.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Chat & Snacks', 'Enjoy your snack!', 'CSlider4.png', true);


CREATE TABLE item (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	food_type VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_item_id PRIMARY KEY (id),
 	CONSTRAINT fk_item_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_item_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);	


-- adding five items
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMABC123DEFX', 'Chicken Steak Broccoli Stir Fry', 'Fry', 'Add to these cubes of chicken some broccoli and other summer vegetable and toss them in with a delicious sauce filled with the goodness of Asian flavours', 140, 10, true, 1, 2, 0, 0 );
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMDEF123DEFX', 'Beijing Paneer Vegetable Stir Fry', 'Fry', 'Our Beijing paneer vegetable stir fry brings together some of the most quintessential Chinese flavours together, replacing tofu with an Indian staple: paneer.', 140, 20, true, 1, 3, 0, 0 );
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMPQR123WGTX', 'Chilli Garlic Chicken Bowl', 'Bowl', 'Juicy chicken pieces batter fried and tossed in a spicy chilli sauce are served with a healthy portion of assorted veggie fried rice!', 132, 20, true, 2, 2, 0, 0 );
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMMNO123PQRX', ' Paneer Butter-Masala n Peas Pulao', 'Bowl', 'Delicious paneer tikka cooked in a rich tomato makhani gravy served on a bed of aromatic coriander pea rice.', 119, 30, true, 2, 2, 0, 0 );
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMABCXYZDEFX', 'Sunrise Smoothie Bowl', 'Smoothie', 'Fresh cream, saffron cream and hung curd are combined to make a creamy topping for a crunchy chopped-fruits base. Garnished with more fruits', 91, 0, true, 3, 3, 0, 0 );
--6th ITEM
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITM23C1D1AC74', 'Peri Peri Grilled Chicken Steak', 'Steak', 'Slices of peri-peri spiced, grilled chicken-breasts are served with peppered, assorted veggies and a basil-flavoured cheese jus! Serves 1', 200, 3, true, 1, 1, 0, 0 );
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITME179915F05', 'Chilli Garlic Potatoes', 'Starter', 'Marinade, stir-fries, sauces and chilli-garlic as a pair has contributed, quite generously, to turning this dish into a star. And our Chilli Garlic Potatoes are epic!', 126, 5, true, 1, 1, 0, 0);
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMC7DA18F6BB', 'Southwestern Fried Chicken Strips', 'Starter', 'Strips of deboned chicken marinated in Cajun-spiced yogurt, are breaded, deep fried and served with a hot, sweet and creamy jalapeño-mango-mayo dip. Serves 2-3.', 146, 4, true, 1, 2, 0,	0);
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMC7417C8A60', 'Shroom Chicken Burger', 'Burger', 'Succulent Chicken mince patty is marinated in a sensational BBQ sauce then lightly pan fried. Served in a fresh burger bun with slaw, this amazing dish will become a quick family favorite.', 112, 3, true, 2, 1, 0, 0);
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITM215723363C', 'Grilled Paneer Teriyaki Salad', 'Salad', 'Diced, grilled paneer, sprouts, bell pepper, zucchini and lettuce are seasoned, served with a rice-wine-vinegar infused teriyaki sauce, for you to do the honors…', 119, 3, true, 1, 1, 0, 0);
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITM8805C8741C', 'Paneer Makhani Wrap', 'Wrap', 'An Indian-inspired tongue tickling and spicy makhani wrap made with fried paneer cubes (tossed in makhani gravy), wrapped in a flour tortilla with pickled veggies and lashings of chilli mayo spread', 98, 13, true, 2, 1, 0, 0);
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITMB3AE24B255', 'Blueberry Galaxy Pastry', 'Pastry', 'Vanilla sponge layered with toasted almond, cream cheese and blueberry compote is rounded up with blueberry glaze, star-shaped chocolate slabs and edible confetti. Serves 1', 100, 10, true, 3, 1, 0, 0);
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITM691C18F454', 'Pepper Masala Chicken Dum Biriyani', 'Biriyani', 'Featuring pepper masala chicken made with our own in-house recipe, flavoured with aromatic ingredients, spiced with black pepper and served with a delicious raita at the side, this is chicken biriyani-bliss reinvented.', 330, 15, true, 2, 1, 0, 0);
INSERT INTO item (code, name, food_type, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('ITM36FF3B6F5F', 'Paneer Bhurji Bunny Chow', 'Snack', 'Bunny chow is essentially a piping hot curry — housed inside a hollow loaf of bread. Eat your way from the top which has paneer bhurji, reaching the delectably curry-soaked pickled veggies and cheese sauce remnants at the bottom', 123, 7, true, 2, 2, 0, 0);

SELECT * FROM CATEGORY ;
SELECT * FROM ITEM ;

DROP TABLE CATEGORY;
DROP TABLE ITEM;

DELETE FROM ITEM WHERE id=14;





CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
	
);


-- adding three users 
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Anita', 'Sri', 'ADMIN', true, '$2y$12$tEW50HtLvl1KtqjpsZ1XNOjGkqrq.2mV8k2kxibua4vpIO/SyM/p2', 'as@gmail.com', '8888888888');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Shahid', 'Kapoor', 'USER', true, '$2a$10$8PQUj4CVQUYkyYF..Q9TvuVDByfJ3XUHAl31JZzxwNa6NuDGbBWL2', 'shka@gmail.com', '1111111111');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Keerthi', 'Das', 'SUPPLIER', true, '$2y$12$icRl6mClcIeZPpbrp8B9t.VT6X8yq3ETiZzw7owzASw/eqZ4Hrdoy', 'kd@gmail.com', '7777777777');



--cart line table
CREATE TABLE cart_line(
id IDENTITY,
card_id int,
total DECIMAL(10,2),
item_id int,
item_count int,
buying_price DECIMAL(10,2),
is_available boolean,
CONSTRAINT fk_cartline_cart_id FOREIGN KEY (cart_id) REFERENCES cart (id),
CONSTRAINT fk_cartline_item_id FOREIGN KEY (item_id) REFERENCES item (id),
CONSTRAINT pk_cartline_id PRIMARY KEY (id),
);



SELECT * FROM CATEGORY ;
SELECT * FROM ITEM ;
SELECT * FROM USER_DETAIL ;