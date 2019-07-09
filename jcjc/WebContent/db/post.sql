drop table post;

drop sequence seq_post;

create table post(
   post_no number primary key,
   commitment_no number not null,
   user_id varchar2(20) not null,
   post_score number(1) not null,
   post_title varchar2(50) not null,
   post_content clob not null,
   post_date date not null,
   constraint post_no_const foreign key (commitment_no) references commitment(commitment_no) on delete cascade
);

create sequence seq_post
increment by 1
start with 1
nocycle
nocache;


insert into post values(seq_post.nextval, 1, 'narae', 1, 
'게시물 제목 1번', 
'우리조 프로젝트 무사히 끝낼 수 있을까??', 
to_date('2001-01-01 00:00:01', 'yyyy-mm-dd hh24:mi:ss'));

insert into post values(seq_post.nextval, 1, 'suyeon01', 5, 
'게시물 제목 2번', 
'부정적인 생각 노노!', 
to_date('2002-02-02 00:00:02', 'yyyy-mm-dd hh24:mi:ss'));

insert into post values(seq_post.nextval, 1, 'osr401', 1, 
'게시물 제목 3번', 
'오승룡님이 미쳐날뛰고있습니다!', 
to_date('2003-03-03 00:00:03', 'yyyy-mm-dd hh24:mi:ss'));

insert into post values(seq_post.nextval, 1, 'dukhyeun', 2,
'게시물 제목 3번', 
'임덕현님이 폭주하고있습니다!', 
to_date('2004-04-04 00:04:04', 'yyyy-mm-dd hh24:mi:ss'));

insert into post values(seq_post.nextval, 2, 'ryoung17', 3,
'게시물 제목 4번', 
'멜로우 가자', 
to_date('2005-05-05 00:00:05', 'yyyy-mm-dd hh24:mi:ss'));

insert into post values(seq_post.nextval, 2, 'lydia.yoon', 4,
'게시물 제목 5번', 
'죽겠다', 
to_date('2006-06-06 00:00:06', 'yyyy-mm-dd hh24:mi:ss'));

insert into post values(seq_post.nextval, 2, 'user_id', 5,
'게시물 제목 6번', 
'이것도 너프해보시지', 
to_date('2007-07-07 00:00:07', 'yyyy-mm-dd hh24:mi:ss'));

insert into post values(seq_post.nextval, 2, 'date_type', 5,
'게시물 제목 7번', 
'데이트 타입 테스트', 
to_date('2018-09-09 11:11:11', 'yyyy-mm-dd hh24:mi:ss'));

select * from post;

delete from post;

select post_no, commitment_no, user_id, post_score, post_title, post_content, 
to_char(post_date, 'yyyy-mm-dd hh24:mi:ss') as post_date 
from post order by post_no;

select commitment_no, avg(post_score) from post group by commitment_no order by commitment_no;
select commitment_no, avg(post_score) as post_score from post group by commitment_no order by commitment_no;

select round(nvl(avg(post_score), 0), 2) as avg_score from post where commitment_no = 3;
