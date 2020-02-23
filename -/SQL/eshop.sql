-- 设计网上商城的商品模块：包含商品SPU、SKU、动态属性
-- SPU：产品的某个型号，不涉及具体规格。例：iPhone11，包含一些共有属性，如：CPU、屏幕材质等
-- SKU：具体到规格的具体某个商品，如：128G、黑色、无需合约版的iPhone11
DROP DATABASE IF EXISTS eshop;
CREATE DATABASE eshop CHARACTER SET 'utf8mb4';
USE eshop;

-- ----------------------------
-- Table structure for spu
-- ----------------------------
DROP TABLE IF EXISTS spu;
CREATE TABLE spu  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20)
);

-- ----------------------------
-- Records of spu
-- ----------------------------
INSERT INTO spu VALUES (1, 'iPhone 11');
INSERT INTO spu VALUES (2, 'iPhone 11 Pro');
INSERT INTO spu VALUES (3, '华为P30 Pro');
INSERT INTO spu VALUES (4, '华为Mate20 Pro');

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS sku;
CREATE TABLE sku  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  spu_id int(11),
  CONSTRAINT fk_sku_spu_id FOREIGN KEY (spu_id) REFERENCES spu (id)
);

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO sku VALUES (1, 1);
INSERT INTO sku VALUES (2, 1);
INSERT INTO sku VALUES (3, 1);
INSERT INTO sku VALUES (4, 1);
INSERT INTO sku VALUES (5, 1);
INSERT INTO sku VALUES (6, 1);
INSERT INTO sku VALUES (7, 2);
INSERT INTO sku VALUES (8, 2);
INSERT INTO sku VALUES (9, 2);
INSERT INTO sku VALUES (10, 2);
INSERT INTO sku VALUES (11, 2);
INSERT INTO sku VALUES (12, 2);
INSERT INTO sku VALUES (13, 2);
INSERT INTO sku VALUES (14, 2);
INSERT INTO sku VALUES (15, 2);
INSERT INTO sku VALUES (16, 2);
INSERT INTO sku VALUES (17, 2);
INSERT INTO sku VALUES (18, 2);
INSERT INTO sku VALUES (19, 3);
INSERT INTO sku VALUES (20, 3);
INSERT INTO sku VALUES (21, 3);
INSERT INTO sku VALUES (22, 3);
INSERT INTO sku VALUES (23, 3);
INSERT INTO sku VALUES (24, 3);
INSERT INTO sku VALUES (25, 3);
INSERT INTO sku VALUES (26, 3);
INSERT INTO sku VALUES (27, 3);
INSERT INTO sku VALUES (28, 3);
INSERT INTO sku VALUES (29, 3);
INSERT INTO sku VALUES (30, 3);
INSERT INTO sku VALUES (31, 4);
INSERT INTO sku VALUES (32, 4);
INSERT INTO sku VALUES (33, 4);
INSERT INTO sku VALUES (34, 4);
INSERT INTO sku VALUES (35, 4);
INSERT INTO sku VALUES (36, 4);
INSERT INTO sku VALUES (37, 4);
INSERT INTO sku VALUES (38, 4);
INSERT INTO sku VALUES (39, 4);
INSERT INTO sku VALUES (40, 4);
INSERT INTO sku VALUES (41, 4);
INSERT INTO sku VALUES (42, 4);

-- ----------------------------
-- Table structure for attr_key
-- ----------------------------
DROP TABLE IF EXISTS attr_key;
CREATE TABLE attr_key  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20)
);

-- ----------------------------
-- Records of attr_key
-- ----------------------------
INSERT INTO attr_key VALUES (1, '网络类型');
INSERT INTO attr_key VALUES (2, '机身颜色');
INSERT INTO attr_key VALUES (3, '存储容量');
INSERT INTO attr_key VALUES (4, '套餐类型');
INSERT INTO attr_key VALUES (5, '版本');

-- ----------------------------
-- Table structure for attr_value
-- ----------------------------
DROP TABLE IF EXISTS attr_value;
CREATE TABLE attr_value  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20),
  attr_key_id int(11),
  CONSTRAINT fk_attr_value_attr_key_id FOREIGN KEY (attr_key_id) REFERENCES attr_key (id)
);

-- ----------------------------
-- Records of attr_value
-- ----------------------------
INSERT INTO attr_value VALUES (1, '4G全网通', 1);
INSERT INTO attr_value VALUES (2, '无需合约版', 1);
INSERT INTO attr_value VALUES (3, '宝石蓝', 2);
INSERT INTO attr_value VALUES (4, '亮黑色', 2);
INSERT INTO attr_value VALUES (5, '极光色', 2);
INSERT INTO attr_value VALUES (6, '翡冷翠', 2);
INSERT INTO attr_value VALUES (7, '天空之境', 2);
INSERT INTO attr_value VALUES (8, '嫣紫色', 2);
INSERT INTO attr_value VALUES (9, '珠光贝母', 2);
INSERT INTO attr_value VALUES (10, '深空灰色', 2);
INSERT INTO attr_value VALUES (11, '银色', 2);
INSERT INTO attr_value VALUES (12, '金色', 2);
INSERT INTO attr_value VALUES (13, '白色', 2);
INSERT INTO attr_value VALUES (14, '黑色', 2);
INSERT INTO attr_value VALUES (15, '绿色', 2);
INSERT INTO attr_value VALUES (16, '黄色', 2);
INSERT INTO attr_value VALUES (17, '紫色', 2);
INSERT INTO attr_value VALUES (18, '红色', 2);
INSERT INTO attr_value VALUES (19, '64GB', 3);
INSERT INTO attr_value VALUES (20, '128GB', 3);
INSERT INTO attr_value VALUES (21, '256GB', 3);
INSERT INTO attr_value VALUES (22, '512GB', 3);
INSERT INTO attr_value VALUES (23, '8+128GB', 3);
INSERT INTO attr_value VALUES (24, '8+256GB', 3);
INSERT INTO attr_value VALUES (25, '8+512GB', 3);
INSERT INTO attr_value VALUES (26, '6+128GB', 3);
INSERT INTO attr_value VALUES (27, '官方标配', 4);
INSERT INTO attr_value VALUES (28, 'iPhone 11 Pro', 5);
INSERT INTO attr_value VALUES (29, 'iPhone 11 Pro Max', 5);

-- ----------------------------
-- Table structure for sku_attr_value
-- ----------------------------
DROP TABLE IF EXISTS sku_attr_value;
CREATE TABLE sku_attr_value  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  sku_id int(11),
  attr_value_id int(11),
  CONSTRAINT fk_sku_attr_value_attr_value_id FOREIGN KEY (attr_value_id) REFERENCES attr_value (id),
  CONSTRAINT fk_sku_attr_value_sku_id FOREIGN KEY (sku_id) REFERENCES sku (id)
);

-- ----------------------------
-- Records of sku_attr_value
-- ----------------------------
INSERT INTO sku_attr_value VALUES (1, 1, 13);
INSERT INTO sku_attr_value VALUES (2, 1, 2);
INSERT INTO sku_attr_value VALUES (3, 1, 19);
INSERT INTO sku_attr_value VALUES (4, 2, 13);
INSERT INTO sku_attr_value VALUES (5, 2, 2);
INSERT INTO sku_attr_value VALUES (6, 2, 20);
INSERT INTO sku_attr_value VALUES (7, 3, 13);
INSERT INTO sku_attr_value VALUES (8, 3, 2);
INSERT INTO sku_attr_value VALUES (9, 3, 21);
INSERT INTO sku_attr_value VALUES (10, 4, 14);
INSERT INTO sku_attr_value VALUES (11, 4, 2);
INSERT INTO sku_attr_value VALUES (12, 4, 19);
INSERT INTO sku_attr_value VALUES (13, 5, 14);
INSERT INTO sku_attr_value VALUES (14, 5, 2);
INSERT INTO sku_attr_value VALUES (15, 5, 20);
INSERT INTO sku_attr_value VALUES (16, 6, 14);
INSERT INTO sku_attr_value VALUES (17, 6, 2);
INSERT INTO sku_attr_value VALUES (18, 6, 21);
INSERT INTO sku_attr_value VALUES (19, 7, 28);
INSERT INTO sku_attr_value VALUES (20, 7, 2);
INSERT INTO sku_attr_value VALUES (21, 7, 10);
INSERT INTO sku_attr_value VALUES (22, 7, 19);
INSERT INTO sku_attr_value VALUES (23, 8, 28);
INSERT INTO sku_attr_value VALUES (24, 8, 2);
INSERT INTO sku_attr_value VALUES (25, 8, 10);
INSERT INTO sku_attr_value VALUES (26, 8, 21);
INSERT INTO sku_attr_value VALUES (27, 9, 28);
INSERT INTO sku_attr_value VALUES (28, 9, 2);
INSERT INTO sku_attr_value VALUES (29, 9, 10);
INSERT INTO sku_attr_value VALUES (30, 9, 22);
INSERT INTO sku_attr_value VALUES (31, 10, 28);
INSERT INTO sku_attr_value VALUES (32, 10, 2);
INSERT INTO sku_attr_value VALUES (33, 10, 11);
INSERT INTO sku_attr_value VALUES (34, 10, 19);
INSERT INTO sku_attr_value VALUES (35, 11, 28);
INSERT INTO sku_attr_value VALUES (36, 11, 2);
INSERT INTO sku_attr_value VALUES (37, 11, 11);
INSERT INTO sku_attr_value VALUES (38, 11, 21);
INSERT INTO sku_attr_value VALUES (39, 12, 28);
INSERT INTO sku_attr_value VALUES (40, 12, 2);
INSERT INTO sku_attr_value VALUES (41, 12, 11);
INSERT INTO sku_attr_value VALUES (42, 12, 22);
INSERT INTO sku_attr_value VALUES (43, 13, 29);
INSERT INTO sku_attr_value VALUES (44, 13, 2);
INSERT INTO sku_attr_value VALUES (45, 13, 10);
INSERT INTO sku_attr_value VALUES (46, 13, 19);
INSERT INTO sku_attr_value VALUES (47, 14, 29);
INSERT INTO sku_attr_value VALUES (48, 14, 2);
INSERT INTO sku_attr_value VALUES (49, 14, 10);
INSERT INTO sku_attr_value VALUES (50, 14, 21);
INSERT INTO sku_attr_value VALUES (51, 15, 29);
INSERT INTO sku_attr_value VALUES (52, 15, 2);
INSERT INTO sku_attr_value VALUES (53, 15, 10);
INSERT INTO sku_attr_value VALUES (54, 15, 22);
INSERT INTO sku_attr_value VALUES (55, 16, 29);
INSERT INTO sku_attr_value VALUES (56, 16, 2);
INSERT INTO sku_attr_value VALUES (57, 16, 11);
INSERT INTO sku_attr_value VALUES (58, 16, 19);
INSERT INTO sku_attr_value VALUES (59, 17, 29);
INSERT INTO sku_attr_value VALUES (60, 17, 2);
INSERT INTO sku_attr_value VALUES (61, 17, 11);
INSERT INTO sku_attr_value VALUES (62, 17, 21);
INSERT INTO sku_attr_value VALUES (63, 18, 29);
INSERT INTO sku_attr_value VALUES (64, 18, 2);
INSERT INTO sku_attr_value VALUES (65, 18, 11);
INSERT INTO sku_attr_value VALUES (66, 18, 22);
INSERT INTO sku_attr_value VALUES (67, 19, 1);
INSERT INTO sku_attr_value VALUES (68, 19, 4);
INSERT INTO sku_attr_value VALUES (69, 19, 27);
INSERT INTO sku_attr_value VALUES (70, 19, 23);
INSERT INTO sku_attr_value VALUES (71, 20, 1);
INSERT INTO sku_attr_value VALUES (72, 20, 4);
INSERT INTO sku_attr_value VALUES (73, 20, 27);
INSERT INTO sku_attr_value VALUES (74, 20, 24);
INSERT INTO sku_attr_value VALUES (75, 21, 1);
INSERT INTO sku_attr_value VALUES (76, 21, 4);
INSERT INTO sku_attr_value VALUES (77, 21, 27);
INSERT INTO sku_attr_value VALUES (78, 21, 25);
INSERT INTO sku_attr_value VALUES (79, 22, 1);
INSERT INTO sku_attr_value VALUES (80, 22, 5);
INSERT INTO sku_attr_value VALUES (81, 22, 27);
INSERT INTO sku_attr_value VALUES (82, 22, 23);
INSERT INTO sku_attr_value VALUES (83, 23, 1);
INSERT INTO sku_attr_value VALUES (84, 23, 5);
INSERT INTO sku_attr_value VALUES (85, 23, 27);
INSERT INTO sku_attr_value VALUES (86, 23, 24);
INSERT INTO sku_attr_value VALUES (87, 24, 1);
INSERT INTO sku_attr_value VALUES (88, 24, 5);
INSERT INTO sku_attr_value VALUES (89, 24, 27);
INSERT INTO sku_attr_value VALUES (90, 24, 25);
INSERT INTO sku_attr_value VALUES (91, 25, 1);
INSERT INTO sku_attr_value VALUES (92, 25, 7);
INSERT INTO sku_attr_value VALUES (93, 25, 27);
INSERT INTO sku_attr_value VALUES (94, 25, 23);
INSERT INTO sku_attr_value VALUES (95, 26, 1);
INSERT INTO sku_attr_value VALUES (96, 26, 7);
INSERT INTO sku_attr_value VALUES (97, 26, 27);
INSERT INTO sku_attr_value VALUES (98, 26, 24);
INSERT INTO sku_attr_value VALUES (99, 27, 1);
INSERT INTO sku_attr_value VALUES (100, 27, 7);
INSERT INTO sku_attr_value VALUES (101, 27, 27);
INSERT INTO sku_attr_value VALUES (102, 27, 25);
INSERT INTO sku_attr_value VALUES (103, 28, 1);
INSERT INTO sku_attr_value VALUES (104, 28, 9);
INSERT INTO sku_attr_value VALUES (105, 28, 27);
INSERT INTO sku_attr_value VALUES (106, 28, 23);
INSERT INTO sku_attr_value VALUES (107, 29, 1);
INSERT INTO sku_attr_value VALUES (108, 29, 9);
INSERT INTO sku_attr_value VALUES (109, 29, 27);
INSERT INTO sku_attr_value VALUES (110, 29, 24);
INSERT INTO sku_attr_value VALUES (111, 30, 1);
INSERT INTO sku_attr_value VALUES (112, 30, 9);
INSERT INTO sku_attr_value VALUES (113, 30, 27);
INSERT INTO sku_attr_value VALUES (114, 30, 25);
INSERT INTO sku_attr_value VALUES (115, 31, 1);
INSERT INTO sku_attr_value VALUES (116, 31, 3);
INSERT INTO sku_attr_value VALUES (117, 31, 27);
INSERT INTO sku_attr_value VALUES (118, 31, 23);
INSERT INTO sku_attr_value VALUES (119, 32, 1);
INSERT INTO sku_attr_value VALUES (120, 32, 3);
INSERT INTO sku_attr_value VALUES (121, 32, 27);
INSERT INTO sku_attr_value VALUES (122, 32, 24);
INSERT INTO sku_attr_value VALUES (123, 33, 1);
INSERT INTO sku_attr_value VALUES (124, 33, 3);
INSERT INTO sku_attr_value VALUES (125, 33, 27);
INSERT INTO sku_attr_value VALUES (126, 33, 26);
INSERT INTO sku_attr_value VALUES (127, 34, 1);
INSERT INTO sku_attr_value VALUES (128, 34, 4);
INSERT INTO sku_attr_value VALUES (129, 34, 27);
INSERT INTO sku_attr_value VALUES (130, 34, 23);
INSERT INTO sku_attr_value VALUES (131, 35, 1);
INSERT INTO sku_attr_value VALUES (132, 35, 4);
INSERT INTO sku_attr_value VALUES (133, 35, 27);
INSERT INTO sku_attr_value VALUES (134, 35, 24);
INSERT INTO sku_attr_value VALUES (135, 36, 1);
INSERT INTO sku_attr_value VALUES (136, 36, 4);
INSERT INTO sku_attr_value VALUES (137, 36, 27);
INSERT INTO sku_attr_value VALUES (138, 36, 26);
INSERT INTO sku_attr_value VALUES (139, 37, 1);
INSERT INTO sku_attr_value VALUES (140, 37, 5);
INSERT INTO sku_attr_value VALUES (141, 37, 27);
INSERT INTO sku_attr_value VALUES (142, 37, 23);
INSERT INTO sku_attr_value VALUES (143, 38, 1);
INSERT INTO sku_attr_value VALUES (144, 38, 5);
INSERT INTO sku_attr_value VALUES (145, 38, 27);
INSERT INTO sku_attr_value VALUES (146, 38, 24);
INSERT INTO sku_attr_value VALUES (147, 39, 1);
INSERT INTO sku_attr_value VALUES (148, 39, 5);
INSERT INTO sku_attr_value VALUES (149, 39, 27);
INSERT INTO sku_attr_value VALUES (150, 39, 26);
INSERT INTO sku_attr_value VALUES (151, 40, 1);
INSERT INTO sku_attr_value VALUES (152, 40, 6);
INSERT INTO sku_attr_value VALUES (153, 40, 27);
INSERT INTO sku_attr_value VALUES (154, 40, 23);
INSERT INTO sku_attr_value VALUES (155, 41, 1);
INSERT INTO sku_attr_value VALUES (156, 41, 6);
INSERT INTO sku_attr_value VALUES (157, 41, 27);
INSERT INTO sku_attr_value VALUES (158, 41, 24);
INSERT INTO sku_attr_value VALUES (159, 42, 1);
INSERT INTO sku_attr_value VALUES (160, 42, 6);
INSERT INTO sku_attr_value VALUES (161, 42, 27);
INSERT INTO sku_attr_value VALUES (162, 42, 26);