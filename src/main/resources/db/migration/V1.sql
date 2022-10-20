create table browse
(
    id   int unsigned auto_increment comment '浏览记录id'
        primary key,
    uid  int unsigned    not null comment '用户id',
    mid  int unsigned    not null comment '商品id',
    time bigint unsigned not null comment '时间'
)
    collate = utf8mb4_unicode_ci;

create table carousel
(
    id         int auto_increment
        primary key,
    url        text not null,
    product_id int  not null
)
    collate = utf8mb4_unicode_ci;

create table credit
(
    id   int auto_increment
        primary key,
    time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create table favourite
(
    id         int auto_increment
        primary key,
    product_id int not null,
    user_id    int not null
);

create table merchandise
(
    mid        int unsigned auto_increment comment '商品id'
        primary key,
    name       varchar(255)            not null comment '商品名称',
    price      decimal(10, 2) unsigned not null comment '商品单价',
    score      int                     not null comment '积分',
    `describe` varchar(255)            null comment '商品描述',
    browse_num int unsigned default 0  null comment '浏览量',
    sales_num  int unsigned default 0  null comment '销售量',
    type_id    int unsigned            null comment '商品所属类型id',
    time       bigint unsigned         null comment '商品上架时间',
    sku        json                    null
)
    collate = utf8mb4_unicode_ci;

create table merchandise_type
(
    tid       int unsigned auto_increment comment '类型id'
        primary key,
    name      varchar(255)  not null comment '类型名称',
    belong_id int unsigned  null comment '父类型id',
    url       varchar(8000) null comment '分类对应的图片url'
)
    collate = utf8mb4_unicode_ci;

create table `order`
(
    id    int unsigned auto_increment comment '订单id'
        primary key,
    mid   int unsigned     null comment '商品id',
    state tinyint unsigned not null comment '订单状态 1.待付款 2.待发货 3.待收货 4.待评价 5.已完成',
    uid   int unsigned     not null comment '所属用户'
)
    collate = utf8mb4_unicode_ci;

create table product
(
    id            int auto_increment
        primary key,
    title         varchar(255)                        not null,
    price         decimal                             not null,
    credit        int                                 null,
    description   text                                null,
    visited_times int       default 0                 not null,
    sold_count    int       default 0                 not null,
    category_id   int                                 null,
    specification json                                null,
    created_at    timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP
);

create table sku
(
    id         int auto_increment
        primary key,
    product_id int(11) unsigned not null,
    indexes    varchar(255)     not null,
    title      varchar(255)     not null,
    price      decimal(9, 2)    not null,
    stock      int unsigned     not null,
    image      text             null,
    constraint sku_ibfk_1
        foreign key (product_id) references merchandise (mid)
)
    collate = utf8mb4_unicode_ci;

create index product_id
    on sku (product_id);

create table sys_banner
(
    id         int auto_increment
        primary key,
    image      text not null,
    product_id int  null
)
    collate = utf8mb4_unicode_ci;

create table sys_top_up_plan
(
    min   decimal not null,
    extra decimal not null,
    id    int auto_increment
        primary key
);

create table top_up_plan
(
    id    int auto_increment
        primary key,
    min   decimal(9, 2) not null,
    extra decimal(9, 2) not null
)
    collate = utf8mb4_unicode_ci;

create table user
(
    id               int auto_increment
        primary key,
    username         varchar(255)      not null,
    password         varchar(255)      not null,
    name             varchar(255)      null,
    balance          decimal(9, 2)     not null,
    credit           decimal(9, 2)     not null,
    topped_up_amount decimal(9, 2)     not null,
    expenditure      decimal default 0 null
)
    collate = utf8mb4_unicode_ci;

create table address
(
    id             int auto_increment
        primary key,
    name           varchar(255) not null,
    phone_number   varchar(11)  not null,
    province       varchar(255) not null,
    city           varchar(255) not null,
    address_line_1 varchar(255) not null,
    address_line_2 varchar(255) null,
    def            tinyint(1)   not null,
    area_code      varchar(255) not null,
    owner_id       int          not null,
    constraint address_ibfk_1
        foreign key (owner_id) references user (id)
            on delete cascade
)
    collate = utf8mb4_unicode_ci;

create index owner_id
    on address (owner_id);

create table session
(
    id        int auto_increment
        primary key,
    token     varchar(255)                        not null,
    expire_at timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    owner_id  int                                 not null,
    constraint token
        unique (token),
    constraint session_ibfk_1
        foreign key (owner_id) references user (id)
            on delete cascade
)
    collate = utf8mb4_unicode_ci;

create index owner_id
    on session (owner_id);

create table shopping_cart
(
    id         int auto_increment
        primary key,
    product_id int unsigned not null,
    sku_id     int          not null,
    user_id    int          not null,
    amount     int unsigned not null,
    constraint product_id
        unique (product_id, sku_id, user_id),
    constraint shopping_cart_ibfk_1
        foreign key (product_id) references merchandise (mid),
    constraint shopping_cart_ibfk_2
        foreign key (sku_id) references sku (id),
    constraint shopping_cart_ibfk_3
        foreign key (user_id) references user (id)
)
    collate = utf8mb4_unicode_ci;


