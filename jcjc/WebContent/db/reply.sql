drop table reply;

drop sequence seq_reply;

create table reply (
	reply_no number primary key,
	post_no number not null,
	user_id varchar2(20) not null,
	reply_content clob not null,
	reply_date date not null,
	constraint reply_no_const foreign key (post_no) references post(post_no) on delete cascade
);

create sequence seq_reply
increment by 1
start with 1
nocycle
nocache;

insert into reply values(seq_reply.nextval, 1, 'id01', 
'content01','2001-01-01');
insert into reply values(seq_reply.nextval, 1, 'id02', 
'content02','2002-02-02');
insert into reply values(seq_reply.nextval, 1, 'id03', 
'content03','2003-03-03');
insert into reply values(seq_reply.nextval, 1, 'narae', 
'댓글 테스트','2003-03-03');

insert into reply values(seq_reply.nextval, 2, 'id04', 
'content04','2004-04-04');
insert into reply values(seq_reply.nextval, 2, 'id05', 
'content05','2005-05-05');
insert into reply values(seq_reply.nextval, 2, 'id06', 
'content06','2006-06-06');
insert into reply values(seq_reply.nextval, 2, 'id07', 
'content01','2007-07-07');

insert into reply values(seq_reply.nextval, 4, 'id01', 
'content01','2004-04-04');
insert into reply values(seq_reply.nextval, 4, 'id02', 
'content02','2005-05-05');
insert into reply values(seq_reply.nextval, 5, 'id03', 
'content03','2006-06-06');
insert into reply values(seq_reply.nextval, 5, 'id04', 
'content04','2007-07-07');


commit
select * from reply;

insert into reply values(seq_reply.nextval, 8, '454', '454', '2000-01-01');
delete from reply where reply_no =1;
select * from reply order by reply_no;

update reply set reply_content='99999999', reply_date='2020-09-09' where reply_no= 5;

