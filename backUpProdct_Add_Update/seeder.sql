# admin
insert into admins (firstname, image, lastname, password, username) VALUE
('admin','','admin','$2a$10$AMS.MjbduBnw6WOUYA8juOr3Refat5IFFDHdwgacepuVXwwePLTLm','admin@gmail.com');
# categories
INSERT INTO categories (name,  is_activated,is_deleted) VALUES
                                                            ('AntMiner S', true, false),
                                                            ('AntMiner D', true, false),
                                                            ('AntMiner E', true, false),
                                                            ('AntMiner K', true, false),
                                                            ('AntMiner L', true, false),
                                                            ('AvalonMiner', true, false),
                                                            ('iPollo V', true, false),
                                                            ('iPollo G', true, false),
                                                            ('WhatsMiner D', true, false),
                                                            ('WhatsMiner M', true, false);


# products
INSERT INTO products
    (name, description, cost_price, sale_price, current_quantity, image, category_id,is_activated, is_deleted ) VALUES
                                                                                    ('S19J Pro', '100Th/s, power consumption of 3050W', 30, 40, 1, '', 4, true, false),
                                                                                    ('AntMiner D7', '1.28Th/s, power consumption of 3148W', 1700, 10, 2, '', 5, true, false),
                                                                                    ('E9 Pro', '2.4GH/s, power consumption of 1920W', 8888, 10, 3, '', 6, true, false),
                                                                                    ('KA3', '166Th/s, power consumption of 3154W', 3333, 11, 4, '', 7, true, false),
                                                                                    ('L7(8.8Gh)', '8.8GH/s, power consumption of 3425W', 44445, 2, 5, '', 8, true, false),
                                                                                    ('A1346', '110Th/s, power consumption of 3300W', 6667, 89, 6, '', 9, true, false),
                                                                                    ('V1', '1.15GH/s, power consumption of 1240W', 4555, 32, 7, '', 10, true, false),
                                                                                    ('G1', '36GPS, power consumption of 2800W', 12333, 323, 8, '', 11, true, false),
                                                                                    ('D1', '48Th/s, power consumption of 2200W', 1000, 3, 9, '', 12, true, false),
                                                                                    ('M56', '194Th/s, power consumption of 5550W', 10000, 5, 10, '', 13, true, false);
