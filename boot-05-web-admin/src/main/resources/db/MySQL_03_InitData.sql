-- 初始化数据
truncate table account_tb1;
replace
into account_tb1(id,user_id,money ) values(1,'1001','10000');
replace
into account_tb1(id,user_id,money ) values(2,'1002','9995');

-- city表
truncate table city;
replace
into city(id,name,state,country ) values(1,'aaa','bbb','ccc');

-- user表
DELETE
FROM user;

INSERT INTO user (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com');