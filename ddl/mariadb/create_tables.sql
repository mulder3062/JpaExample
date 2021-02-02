create table todo
(
    todo_id bigint auto_increment primary key,
    title varchar(255) null,
    user_id varchar(32) null,
    status varchar(20) null,
    last_modified_date datetime null,
    created_date datetime null,
    constraint fk_user_todo foreign key (user_id) references user (user_id)
) engine=InnoDB charset=utf8mb4 collate=utf8mb4_unicode_ci comment 'TODO';

create table user
(
    user_id varchar(32) not null primary key,
    name varchar(255) null,
    last_modified_date datetime null,
    created_date datetime null
) engine=InnoDB charset=utf8mb4 collate=utf8mb4_unicode_ci comment '사용자';

