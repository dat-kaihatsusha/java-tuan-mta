select * from items;
update items set name = "laptop" where id = 1;
update items set name = "tv" where id = 2;
update items set name = "tablet" where id = 3;
insert into items(id, name) values (4, "macbook"), (5, "book");
alter table items add user_id int;
update items set user_id = 1 where id = 1;
update items set user_id = 1 where id = 2;
update items set user_id = 2 where id = 3;
update items set user_id = 2 where id = 4;
update items set user_id = 3 where id = 5;

CREATE TABLE users (
    id int,
    name varchar(256),
    PRIMARY KEY (id)
);
insert into users(id, name) values(1, "dat"), (2, "minh"), (3, "duc anh"), (4, "hieu");
select * from users;

ALTER TABLE items 
ADD CONSTRAINT prk_1
FOREIGN KEY (user_id) 
REFERENCES users(id);

select * from items inner join users on items.user_id = users.id;

select * from users;
select * from items;