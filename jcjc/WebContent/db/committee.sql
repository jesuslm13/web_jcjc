create table jurisdiction_committee(
jurisdiction_committee_code number primary key,
jurisdiction_committee_name varchar2(50)
);

insert into jurisdiction_committee values (1, '국회운영');
insert into jurisdiction_committee values (2, '법제사법');
insert into jurisdiction_committee values (3, '정무');
insert into jurisdiction_committee values (4, '기획재정');
insert into jurisdiction_committee values (5, '교육');
insert into jurisdiction_committee values (6, '과학기술정보방송통신');
insert into jurisdiction_committee values (7, '교육문화체육관광');
insert into jurisdiction_committee values (8, '외교통일');
insert into jurisdiction_committee values (9, '국방');
insert into jurisdiction_committee values (10, '행정안전');
insert into jurisdiction_committee values (11, '문화체육관광');
insert into jurisdiction_committee values (12, '농림축산식품해양수산');
insert into jurisdiction_committee values (13, '산업통상자원중소벤처기업');
insert into jurisdiction_committee values (14, '보건복지');
insert into jurisdiction_committee values (15, '환경노동');
insert into jurisdiction_committee values (16, '국토교통');
insert into jurisdiction_committee values (17, '정보');
insert into jurisdiction_committee values (18, '여성가족');
insert into jurisdiction_committee values (19, '미래창조과학방송통신');
insert into jurisdiction_committee values (20, '산업통상자원');
insert into jurisdiction_committee values (21, '안전행정');
insert into jurisdiction_committee values (22, '예산결산특별');
insert into jurisdiction_committee values (23, '윤리특별');

select * from jurisdiction_committee;