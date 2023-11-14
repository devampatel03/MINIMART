set character_set_client=utf8mb4;


create table all_customer_details 
(Cust_Id char(2) not null unique primary key , 
Name char(20) not null, 
Address char(20),
Pincode integer,
Ph_No bigint,
Email_Id char(20));



create table Items_List
(Item_No integer not null unique,
Item_Name text(1000) not null,
Price integer,
primary key(Item_No));

insert into Items_List
values(1,'Amul Butter (200g)                 ',50);

insert into Items_List
values(2,'Amul Gold Milk (1L)                ',30);

insert into Items_List
values(3,'Malkist Cheese Biscuits (100g)     ',100);

insert into Items_List
values(4,'Amul Mozorella Cheese (200g)       ',190);

insert into Items_List
values(5,'Tata Salt (500g)                   ',50);

insert into Items_List
values(6,'WheatKart Whole Wheat Flour (10Kg) ',550);

