/*==============================================================*/
/* DBMS name:      MySQL 8.0                                    */
/* Created on:     2023/07/04 17:58:14                          */
/*==============================================================*/

drop table if exists account_tb1;

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
