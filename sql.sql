-- auto-generated definition
create table confirmation_token
(
    token_id           int auto_increment
        primary key,
    confirmation_token varchar(32) null,
    created_date       timestamp   null,
    user_id            mediumtext  null
);

-- auto-generated definition
create table hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

-- auto-generated definition
create table protein_info
(
    id                varchar(32)   not null
        primary key,
    classification    varchar(32)   null comment '分类',
    organism          varchar(64)   null comment '生物体',
    expression_system varchar(64)   null comment '表达系统',
    deposited         varchar(64)   null comment '发布时间',
    deposition_author varchar(32)   null comment '发布作者',
    fasta_sequence    varchar(1000) null comment '氨基酸序列',
    image_url         varchar(500)  null comment '图片地址'
);

-- auto-generated definition
create table user
(
    user_id    int auto_increment
        primary key,
    email      varchar(32) null,
    password   varchar(64) null,
    username   varchar(32) null,
    is_enabled varchar(32) null
);

-- auto-generated definition
create table user_profile
(
    profile_id int auto_increment
        primary key,
    emial      varchar(32) null,
    username   varchar(32) null,
    name       varchar(32) null,
    telephone  varchar(32) null,
    age        int         null,
    job        varchar(32) null,
    path       varchar(32) null
);

INSERT INTO flutter.confirmation_token (token_id, confirmation_token, created_date, user_id) VALUES (2, 'NX47', '2021-04-03 06:45:58', '1');

INSERT INTO flutter.hibernate_sequence (next_val) VALUES (5);

INSERT INTO flutter.protein_info (id, classification, organism, expression_system, deposited, deposition_author, fasta_sequence, image_url) VALUES ('1', '分类一', '生物体一', '表达系统一', '2021-04-11', '张璐瑶', 'anbdsidhsidhsbdf', 'https://longbao.oss-cn-beijing.aliyuncs.com/images/2021/01.jpg');

INSERT INTO flutter.user (user_id, email, password, username, is_enabled) VALUES (3, '1923439579@qq.com', '$2a$12$JnymSTNkJzppqWZZRrvqWO1KEyzjRkcSH.C2xCtmVNgCRmdxTg8jG', 'Xulongbao', '1');

INSERT INTO flutter.user_profile (profile_id, emial, username, name, telephone, age, job, path) VALUES (4, '1923439579@qq.com', 'Xulongbao', null, null, null, null, null);