drop table user01;

create table user01 (
	user_id varchar2(20) primary key,
	user_password varchar2(20) not null,
	user_name varchar2(10) not null,
	user_email varchar2(50) not null,
	user_birthdate date not null,
	user_postcode number,
	user_road_address varchar2(200),
	user_jibun_address varchar2(200),
	user_detail_address varchar2(200),
	user_extra_address varchar2(200),
	user_voting_ex char,
	user_prefer_politician number,
	user_support_politician number,
	user_interest number	
);



insert into user01 values('11', '11',
'윤나래', 'narae@email.com', '2019-03-26', 
04999, '도로명 주소1', '지번 주소1', '상세 주소1', '추가 주소1', 
'Y', 001, 001, 001);

insert into user01 values('22', '22',
'박수연', 'sooyeon@email.co.kr', '2018-03-26',
05000, '도로명 주소2', '지번 주소2', '상세 주소2', '추가 주소2', 
'N', 002, 002, 002);

insert into user01 values('33', '33',
'오승룡', 'osr@email.io', '2017-03-26',
05100, '도로명 주소3', '지번 주소3', '상세 주소3', '추가 주소3', 
'Y', 003, 003, 003);

insert into user01 values('44', '44',
'임덕현', 'limdh@email.com', '2016-03-26',
05200, '도로명 주소4', '지번 주소4', '상세 주소4', '추가 주소4', 
'N', 44, 44, 44);

insert into user01 values('55', '55',
'박성아', 'generous.p@email.com', '2015-03-26',
05300, '도로명 주소5', '지번 주소5', '상세 주소5', '추가 주소5', 
'N', 55, 55, 55);

insert into user01 values('66', '66',
'김성민', 'sungmin@email.io', '2014-03-26',
05400, '도로명 주소6', '지번 주소6', '상세 주소6', '추가 주소6', 
'Y', 66, 66, 66);

insert into user01 values('77', '77',
'강태훈', 'taehoon@email.co.kr', '2013-03-26',
05500, '도로명 주소7', '지번 주소7', '상세 주소7', '추가 주소7', 
'Y', 77, 77, 77);

select * from user01;

delete from user01;

commit

select * from user01 where user_id='22' and user_password='22';





