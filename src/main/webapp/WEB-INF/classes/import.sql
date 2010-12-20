INSERT INTO supplier (supplier_id, supplier_name, description) VALUES(1, 'CV. Arum Sanjaya', 'CV. Arum Sanjaya dari Sumedang, Jawa Barat.');
INSERT INTO supplier (supplier_id, supplier_name, description) VALUES(2, 'CV. Alam Sari', 'CV. Alam Sari dari Malangbong, Garut.');
INSERT INTO supplier (supplier_id, supplier_name, description) VALUES(3, 'CV. Dewi Padi', 'CY. Dewi Padi dari Cianjur, Jawa Barat.');
INSERT INTO supplier (supplier_id, supplier_name, description) VALUES(4, 'CV. Perdana Sari', 'CV Perdana Sari dari Majalengka.');


INSERT INTO good_reception (good_reception_id, reception_date, official_amount, administration_amount, reception_notes, supplier_id) VALUES(1, '2010-05-31', 2000, 1980, '-', 1);
INSERT INTO good_reception (good_reception_id, reception_date, official_amount, administration_amount, reception_notes, supplier_id) VALUES(2, '2010-05-28', 1500, 1610, '-', 1);


INSERT INTO item (item_id, item_name, description) VALUES(1, 'Beras 20 KG', NULL);
INSERT INTO item (item_id, item_name, description) VALUES(2, 'Gabah 20 KG', NULL);
INSERT INTO item (item_id, item_name, description) VALUES(3, 'Beras 50 KG', NULL);
INSERT INTO item (item_id, item_name, description) VALUES(4, 'Gabah 50 KG', NULL);


INSERT INTO item_reception (item_reception_id, amount, good_reception_id, item_id) VALUES(1, 500, 1, 1);
INSERT INTO item_reception (item_reception_id, amount, good_reception_id, item_id) VALUES(2, 500, 1, 2);
INSERT INTO item_reception (item_reception_id, amount, good_reception_id, item_id) VALUES(3, 700, 1, 3);
INSERT INTO item_reception (item_reception_id, amount, good_reception_id, item_id) VALUES(4, 300, 1, 4);
INSERT INTO item_reception (item_reception_id, amount, good_reception_id, item_id) VALUES(5, 400, 2, 2);
INSERT INTO item_reception (item_reception_id, amount, good_reception_id, item_id) VALUES(6, 700, 2, 3);
INSERT INTO item_reception (item_reception_id, amount, good_reception_id, item_id) VALUES(7, 400, 2, 4);