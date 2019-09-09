create table t_computer (
    id bigint not null auto_increment,
    name varchar(255),
    computer_state int(4) not null,
    create_time timestamp,
    update_time timestamp,
    primary key (id)
);