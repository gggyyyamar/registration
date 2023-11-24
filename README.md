# registration
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| cat                |
| cattwo             |
| goods              |
| kimathi            |
| mysql              |
| test               |
| tral               |
| trial              |
| vehicle            |
+--------------------+
10 rows in set (0.01 sec)
mysql> use cattwo;
Database changed
mysql> show tables;
Empty set (0.01 sec)

mysql> create table registration(
    -> Name varchar(20) primary key,
    -> Username varchar(20),
    -> Password varchar(20),
    -> Email varchar(20),
    -> Phone varchar(10),
    -> Address varchar(30));
Query OK, 0 rows affected (0.05 sec)
mysql> desc registration;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| Name     | varchar(20) | NO   | PRI | NULL    |       |
| Username | varchar(20) | YES  |     | NULL    |       |
| Password | varchar(20) | YES  |     | NULL    |       |
| Email    | varchar(20) | YES  |     | NULL    |       |
| Phone    | varchar(10) | YES  |     | NULL    |       |
| Address  | varchar(30) | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
