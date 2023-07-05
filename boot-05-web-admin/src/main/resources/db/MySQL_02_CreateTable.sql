/*==============================================================*/
/* DBMS name:      MySQL 8.0                                    */
/* Created on:     2023/07/04 17:58:14                          */
/*==============================================================*/

drop table if exists account_tb1;
drop table if exists city;

/*==============================================================*/
/* Table: account_tb1                                     */
/*==============================================================*/
CREATE TABLE db_account.account_tb1 (
	id BIGINT auto_increment NOT NULL,
	user_id varchar(100) NOT NULL,
	money INT(100) NOT NULL,
	CONSTRAINT account_tb1_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;


/*==============================================================*/
/* Table: city                                     */
/*==============================================================*/
CREATE TABLE db_account.city (
	id INT auto_increment NOT NULL,
	name varchar(30) NULL,
	state varchar(30) NULL,
	country varchar(100) NULL,
	CONSTRAINT city_PK PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;
