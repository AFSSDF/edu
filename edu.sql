create database `edu`;

use edu;

create table clazz
(
id bigint unsigned primary key auto_increment comment "id",
name varchar(20) not null comment "班级名称",
stage varchar(4) comment "阶段",
count int not null comment "人数",
gmt_create datetime,
gmt_modified datetime
)comment='班级信息';

create table room
(
id bigint unsigned primary key auto_increment comment "id",
name varchar(20) not null comment "教室名称",
gmt_create datetime,
gmt_modified datetime
)comment='教室信息';

create table teacher
(
id bigint unsigned primary key auto_increment comment "id",
name varchar(20) not null comment "职员姓名",
email varchar(50) not null comment "邮箱",
is_exist bit not null comment "是否在职",
gmt_create datetime,
gmt_modified datetime
)comment='职员信息';

create table curriculum
(
id bigint unsigned primary key auto_increment comment "id",
stage varchar(4) comment "阶段",
name varchar(20) not null comment "名称",
chapter varchar(50) not null comment "章节",
gmt_create datetime,
gmt_modified datetime
)comment='课程信息';

create table course
(
id bigint unsigned primary key auto_increment comment "id",
clazz_id bigint unsigned not null comment "班级id",
room_id bigint unsigned not null comment "教室id",
curriculum_id bigint unsigned  not null comment "课程id",
teacher_id bigint unsigned  not null comment "职员id",
begin datetime not null comment "上课日期",
period varchar(4) not null comment "上课时段",
gmt_create datetime,
gmt_modified datetime
)comment='排课信息';

alter table room add is_projector bit not null comment "是否有投影仪" after name;