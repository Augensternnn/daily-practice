1.查询重复图书信息
SELECT
	* 
FROM
	book 
WHERE
	( NAME, author ) IN ( SELECT NAME, author FROM book GROUP BY NAME, author HAVING count( 0 ) > 1 );

2.查询某个分类下的图书借阅信息
SELECT
	bk.NAME book_name,
	bk.author book_author,
	s.NAME student_name,
	bi.start_time,
	bi.end_time
FROM
	borrow_info bi
	JOIN book bk ON bi.book_id = bk.id
	JOIN category c ON bk.category_id = c.id
	JOIN student s ON bi.student_id = s.id 
WHERE
	c.NAME = '计算机';

3.查询图书借阅周期在某个时间范围内的图书借阅信息。
SELECT
	bk.NAME book_name,
	bk.author book_author,
	s.NAME student_name,
	bi.start_time,
	bi.end_time
FROM
	borrow_info bi
	JOIN book bk ON bi.book_id = bk.id
	JOIN category c ON bk.category_id = c.id
	JOIN student s ON bi.student_id = s.id 
WHERE
	bi.start_time<'2019-08-11 00:00:00' and bi.end_time>'2019-07-10 00:00:00';