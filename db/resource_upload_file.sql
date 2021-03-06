create table upload_file
(
    id          int auto_increment comment '主键id'
        primary key,
    url         varchar(255)                        not null comment '访问路径',
    origin_name varchar(255)                        null comment '原始文件名',
    create_time timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    method      int(4)    default 0                 null comment '文件上传方式（0-本地上传，1-oss，2-minio）',
    remark      varchar(255)                        null comment '备注'
)
    comment '文件上传记录表';

