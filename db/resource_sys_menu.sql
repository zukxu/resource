create table sys_menu
(
    id          int auto_increment comment '主键id'
        primary key,
    name        varchar(32)                               null comment '菜单名称(英文)',
    path        varchar(256)                              null comment '前端路由标识路径',
    icon        varchar(32)                               null comment '图标',
    title       varchar(50)                               null comment '菜单名称(中文)',
    redirect    varchar(256)                              null comment '前端路由重定向路径',
    sort        int         default 0                     not null comment '排序',
    parent_id   varchar(64) default '-1'                  not null comment '父id',
    create_time timestamp   default CURRENT_TIMESTAMP     not null comment '创建时间',
    create_by   varchar(64)                               null comment '创建人',
    update_time timestamp   default '0000-00-00 00:00:00' not null on update CURRENT_TIMESTAMP comment '更新时间',
    update_by   varchar(64)                               null comment '更新人',
    hidden      tinyint(1)  default 0                     not null comment '是否隐藏菜单'
)
    comment '菜单表';

