create table student
(
    id    int auto_increment
        primary key,
    name  varchar(50)   null,
    age   int           null,
    addr  varchar(1000) null,
    hobby varchar(500)  null
);

create table user
(
    id          bigint      not null comment '主键'
        primary key,
    name        varchar(30) null comment '姓名',
    age         int         null comment '年龄',
    email       varchar(50) null comment '邮箱',
    manager_id  bigint      null comment '直属上级id',
    create_time datetime    null comment '创建时间',
    constraint manager_fk
        foreign key (manager_id) references user (id)
)
    charset = utf8;

