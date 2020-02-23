DROP DATABASE IF EXISTS ebook;
CREATE DATABASE ebook CHARACTER SET 'utf8mb4';
USE ebook;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS category;
CREATE TABLE category  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20)
);

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO category VALUES (1, '历史');
INSERT INTO category VALUES (2, '艺术');
INSERT INTO category VALUES (3, '计算机');
INSERT INTO category VALUES (4, '数学');
INSERT INTO category VALUES (5, '小说');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS student;
CREATE TABLE student  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20)
);

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO student VALUES (1, '王昭君');
INSERT INTO student VALUES (2, '李白');
INSERT INTO student VALUES (3, '貂蝉');
INSERT INTO student VALUES (4, '小乔');
INSERT INTO student VALUES (5, '韩信');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS book;
CREATE TABLE book  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20),
  author varchar(20),
  price decimal(10, 2),
  category_id int(11),
  CONSTRAINT fk_book_category_id FOREIGN KEY (category_id) REFERENCES category (id)
);
-- CONSTRAINT fk_book_category_id：设置外键名称为fk_book_category_id，不加数据库会默认指定一个名称

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO book VALUES (1, '深入理解Java虚拟机', '周志明', 57.90, 3);
INSERT INTO book VALUES (2, '西游记', '吴承恩', 30.68, 5);
INSERT INTO book VALUES (3, '儒林外史', '吴敬梓', 18.80, 5);
INSERT INTO book VALUES (4, '聊斋志异', '蒲松龄', 21.00, 5);
INSERT INTO book VALUES (5, '史记', '司马迁', 278.20, 1);
INSERT INTO book VALUES (6, '资治通鉴', '司马光', 524.00, 1);
INSERT INTO book VALUES (7, 'Java核心技术 卷I：基础知识', 'Cay S. Horstmann', 92.50, 3);
INSERT INTO book VALUES (8, 'Java核心技术卷II：高级特性', 'Cay S. Horstmann', 111.20, 3);
INSERT INTO book VALUES (9, 'Java多线程编程核心技术', '高洪岩', 47.50, 3);
INSERT INTO book VALUES (10, '诗经', '孔子', 22.00, 2);
INSERT INTO book VALUES (11, '唐诗三百首', '蘅塘居士', 49.30, 2);
INSERT INTO book VALUES (12, '唐诗三百首', '蘅塘居士', 55.00, 2);
INSERT INTO book VALUES (13, '西游记', '吴承恩', 47.50, 5);
INSERT INTO book VALUES (14, '唐诗三百首', '蘅塘居士', 56.50, 2);

-- ----------------------------
-- Table structure for borrow_info
-- ----------------------------
DROP TABLE IF EXISTS borrow_info;
CREATE TABLE borrow_info  (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  book_id int(11),
  student_id int(11),
  start_time timestamp null,
  end_time timestamp null,
  CONSTRAINT fk_borrow_info_book_id FOREIGN KEY (book_id) REFERENCES book (id),
  CONSTRAINT fk_borrow_info_student_id FOREIGN KEY (student_id) REFERENCES student (id)
);

-- ----------------------------
-- Records of borrow_info
-- ----------------------------
INSERT INTO borrow_info VALUES (1, 1, 1, '2018-11-07 18:50:43', '2018-12-07 18:51:01');
INSERT INTO borrow_info VALUES (2, 7, 1, '2019-07-10 10:21:00', '2019-09-10 10:21:00');
INSERT INTO borrow_info VALUES (3, 8, 1, '2019-09-10 10:21:00', '2019-10-10 10:21:00');
INSERT INTO borrow_info VALUES (4, 2, 2, '2019-03-02 16:37:00', '2019-04-02 16:37:00');
INSERT INTO borrow_info VALUES (5, 4, 2, '2019-03-12 14:25:00', '2019-04-12 14:25:00');
INSERT INTO borrow_info VALUES (6, 10, 2, '2019-07-13 16:21:00', '2019-10-13 16:21:00');
INSERT INTO borrow_info VALUES (7, 11, 2, '2019-06-09 09:40:00', '2019-07-09 09:40:00');
INSERT INTO borrow_info VALUES (8, 13, 2, '2019-01-03 15:11:00', '2019-04-03 15:11:00');
INSERT INTO borrow_info VALUES (9, 7, 3, '2019-05-15 13:13:00', '2019-06-15 13:13:00');
INSERT INTO borrow_info VALUES (10, 8, 3, '2019-04-27 13:53:00', '2019-05-27 13:53:00');
INSERT INTO borrow_info VALUES (11, 9, 3, '2019-06-01 11:32:00', '2019-07-01 11:32:00');
INSERT INTO borrow_info VALUES (12, 3, 4, '2019-07-01 09:40:00', '2019-08-01 09:40:00');
INSERT INTO borrow_info VALUES (13, 4, 4, '2019-06-19 11:40:00', '2019-07-19 11:40:00');
INSERT INTO borrow_info VALUES (14, 5, 4, '2019-06-25 09:23:00', '2019-09-25 09:23:00');
INSERT INTO borrow_info VALUES (15, 10, 4, '2019-08-27 15:30:00', '2019-09-27 15:30:00');
INSERT INTO borrow_info VALUES (16, 5, 5, '2019-01-23 14:20:00', '2019-04-23 14:20:00');
INSERT INTO borrow_info VALUES (17, 6, 5, '2019-03-09 10:45:00', '2019-04-09 10:45:00');
INSERT INTO borrow_info VALUES (18, 10, 5, '2019-06-17 11:32:00', '2019-09-17 11:32:00');