create schema if not exists resource collate utf8_general_ci;

create table if not exists resource_affair
(
	id int auto_increment comment '主键id'
		primary key,
	create_time timestamp not null on update CURRENT_TIMESTAMP comment '创建时间',
	update_time datetime null comment '更新时间',
	enable tinyint(1) default 0 null comment '逻辑删除值（false删除，true存在）',
	relation_id int not null comment '关联资源id',
	type int(8) default 0 not null comment '事务类型（0-新增 1-修改 2-置顶 3-特殊)',
	status int(8) default 0 null comment '事务状态（0-待审核 1-审核失败 2-审核成功)',
	handle_remark varchar(255) null comment '处理意见'
)
comment '资源审核事务表';

create table if not exists resource_type
(
	id int auto_increment comment '主键id'
		primary key,
	create_time timestamp not null on update CURRENT_TIMESTAMP comment '创建时间',
	update_time datetime null comment '更新时间',
	enable tinyint(1) default 0 null comment '逻辑删除值（false删除，true存在）',
	remark varchar(255) null comment '备注',
	type_name varchar(255) not null comment '资源分类名',
	sort int default 0 null comment '排序值（大）'
)
comment '资源分类表';

create table if not exists resources
(
	id int auto_increment comment '主键id'
		primary key,
	name varchar(255) not null comment '资源名',
	content varchar(255) not null comment '资源内容',
	type_id int default 1 not null comment '资源分类Id',
	create_time timestamp not null on update CURRENT_TIMESTAMP comment '创建时间',
	update_time datetime null comment '更新时间',
	enable tinyint(1) default 0 null comment '逻辑删除值,是否删除',
	remark varchar(255) null comment '备注'
)
comment '资源表';

create table if not exists sys_menu
(
	id int auto_increment comment '主键id'
		primary key,
	name varchar(32) null comment '菜单名称(英文)',
	path varchar(256) null comment '前端路由标识路径',
	icon varchar(32) null comment '图标',
	title varchar(50) null comment '菜单名称(中文)',
	redirect varchar(256) null comment '前端路由重定向路径',
	sort int default 0 not null comment '排序',
	parent_id varchar(64) default '-1' not null comment '父id',
	create_time timestamp not null on update CURRENT_TIMESTAMP comment '创建时间',
	create_by varchar(64) null comment '创建人',
	update_time datetime null comment '更新时间',
	update_by varchar(64) null comment '更新人',
	hidden tinyint(1) default 0 not null comment '是否隐藏菜单'
)
comment '菜单表';

create table if not exists upload_file
(
	id int auto_increment comment '主键id'
		primary key,
	url varchar(255) not null comment '访问路径',
	origin_name varchar(255) null comment '原始文件名',
	create_time timestamp not null on update CURRENT_TIMESTAMP comment '创建时间',
	method int(4) default 0 null comment '文件上传方式（0-本地上传，1-oss，2-minio）',
	remark varchar(255) null comment '备注'
)
comment '文件上传记录表';

