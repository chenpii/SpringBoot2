-- 初始化数据
truncate table account_tb1;
replace into account_tb1(id,user_id,money ) values(1,'1001','10000');
replace into account_tb1(id,user_id,money ) values(2,'1002','9995');

truncate table city;
replace into city(id,name,state,country ) values(1,'aaa','bbb','ccc');