create table resource_affair
(
    id            int auto_increment comment '主键id'
        primary key,
    create_time   timestamp  default CURRENT_TIMESTAMP     not null comment '创建时间',
    update_time   timestamp  default '0000-00-00 00:00:00' not null on update CURRENT_TIMESTAMP comment '更新时间',
    enable        tinyint(1) default 0                     null comment '逻辑删除值（false删除，true存在）',
    relation_id   int                                      not null comment '关联资源id',
    type          int(8)     default 0                     not null comment '事务类型（0-新增 1-修改 2-置顶 3-特殊)',
    status        int(8)     default 0                     null comment '事务状态（0-待审核 1-审核通过 2-审核不通过)',
    handle_remark varchar(255)                             null comment '处理意见'
)
    comment '资源审核事务表';

