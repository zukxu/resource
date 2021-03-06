create table resource_type
(
    id          int auto_increment comment '主键id'
        primary key,
    create_time timestamp  default CURRENT_TIMESTAMP     not null comment '创建时间',
    update_time timestamp  default '0000-00-00 00:00:00' not null on update CURRENT_TIMESTAMP comment '更新时间',
    enable      tinyint(1) default 0                     null comment '逻辑删除值（false删除，true存在）',
    remark      varchar(255)                             null comment '备注',
    type_name   varchar(255)                             not null comment '资源分类名',
    sort        int        default 0                     null comment '排序值（大）',
    pics        varchar(255)                             null comment '图标',
    parent_id   int        default -1                    not null comment '上层父id'
)
    comment '资源分类表';

INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (1, '2020-12-11 16:42:24', '2021-01-26 14:13:02', 0, null, '未分类', 0, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (101, '2021-01-20 17:47:19', '2021-02-01 15:37:38', 0, null, '学习教程', 1, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (102, '2021-01-20 17:47:19', '2021-01-30 15:28:42', 0, null, '书籍网站', 2, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (103, '2021-01-20 17:47:19', '2021-01-30 15:26:08', 0, null, '娱乐网站', 3, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (104, '2021-01-20 16:11:31', '2021-01-30 15:26:08', 0, null, '开发相关', 4, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (105, '2021-01-20 17:47:19', '2021-01-30 15:26:08', 0, null, '壁纸美图', 5, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (106, '2021-01-20 17:47:19', '2021-01-30 15:27:00', 0, null, '插件模板', 6, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (107, '2021-01-22 11:01:08', '2021-01-30 15:37:44', 0, null, '开发教程', 7, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (108, '2021-01-20 17:47:19', '2021-01-30 15:37:44', 0, null, '福利网站', 8, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (109, '2021-01-20 17:47:19', '2021-01-30 15:37:44', 0, null, '导航网站', 9, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (110, '2021-01-20 16:11:31', '2021-01-30 15:37:44', 0, null, '黑客网站', 10, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (111, '2021-01-20 16:11:31', '2021-01-30 15:37:44', 0, null, '项目收集', 11, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (112, '2021-01-21 16:38:40', '2021-01-30 16:45:41', 0, null, '资源收集', 12, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (113, '2021-01-30 15:37:44', '2021-01-30 15:39:19', 0, null, '工具软件', 13, null, -1);
INSERT INTO resource.resource_type (id, create_time, update_time, enable, remark, type_name, sort, pics, parent_id) VALUES (114, '2021-01-30 15:37:44', '2021-01-30 15:39:19', 0, null, '源码学习', 14, null, -1);