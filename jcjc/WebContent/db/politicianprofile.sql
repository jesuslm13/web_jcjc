drop table politician_profile;

delete from politician_profile;

create table politician_profile(
politician_kor_name varchar2(1000),
politician_hj_name varchar2(1000),
politician_eng_name varchar2(1000),
bth_date date,
poly_name varchar2(1000),
orig_name varchar2(1000),
shrt_name varchar2(1000),
reele_gbn_name varchar2(1000),
election_name varchar2(1000),
assem_tel varchar2(1000),
assem_homep varchar2(1000),
assem_email varchar2(1000),
hbby_cd varchar2(1000),
exam_cd varchar2(1000),
primary key(politician_kor_name, politician_hj_name)
);

insert into politician_profile
values ('윤나래', '尹나래', 'lydia yoon', '1993-04-28', 
'무소속', '엔코아', 'ajax마스터', 'ㅎㅎ', 'ㅋㅋ', '010-6311-4096', 
'https://github.com/LydiaYoon', 'narae456@gmail.com',
'프로젝트 조지기', '프로젝트 터트리기');

select * from politician_profile;
