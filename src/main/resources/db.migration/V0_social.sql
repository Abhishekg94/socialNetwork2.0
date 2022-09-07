use
test1;

    -- drop table post_like;

create table user_profile
(
    id         int(11) not null auto_increment,
    name       varchar(20) default null,
    email      varchar(50) not null unique,
    mobile_no  varchar(12) not null unique,
    password   varchar(20) default null,
    dob        datetime    not null,
    created_at datetime    not null,
    primary key (id)
);

create table friend_ship
(
    id              int not null auto_increment,
    profile_request int,
    profile_accept  int,
    status          int not null,
    primary key (id),
    foreign key (profile_request) references user_profile (id),
    foreign key (profile_accept) references user_profile (id)
);


create table user_post
(
    id         int      not null auto_increment,
    profile_id int,
    write_text text         default null,
    media_path varchar(100) default null,
    created_at datetime not null,
    primary key (id),
    foreign key (profile_id) references user_profile (id)
);

create table post_like
(
    id         int not null auto_increment,
    post_id    int,
    profile_id int,
    primary key (id),
    foreign key (post_id) references user_post (id),
    foreign key (profile_id) references user_profile (id)
);

create table post_comment
(
    id         int not null auto_increment,
    post_id    int,
    profile_id int,
    comment    varchar(250) default null,
    primary key (id),
    foreign key (post_id) references user_post (id),
    foreign key (profile_id) references user_profile (id)
);