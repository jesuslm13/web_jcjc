drop table politician;

drop sequence seq_pol;

create table politician(
	politician_no number,
	politician_num number,
	politician_kor_name varchar2(100) not null,
	politician_hj_name varchar2(100) not null,
	politician_eng_name varchar2(100) not null,
	bth_date date not null,
	poly_name varchar2(100) not null,
	orig_name varchar2(100),
	shrt_name varchar2(500),
	reele_gbn_name varchar2(100),
	election_name varchar2(100),
	assem_tel varchar2(100),
	assem_homep varchar2(100),
	assem_email varchar2(100),
	hbby_cd varchar2(100),
	exam_cd varchar2(100),
	politician_jpg_link varchar2(100)
);

alter table politician modify politician_no primary key;

select * from ALL_CONSTRAINTS where TABLE_NAME = 'POLITICIAN'; 

alter table politician drop constraint SYS_C004476;

create sequence seq_pol
increment by 1
start with 1
nocycle
nocache;


insert into politician
values(0, 0, '윤나래','尹나래','lydia yoon',
'1993-04-28', '무소속', 'ajax마스터', '엔코아',
'당선횟수', '당선대수', 
'010-6311-4096', 'https://github.com/LydiaYoon', 'narae456@gmail.com',
'400 Bad Request', '404 Not Found',
'https://pbs.twimg.com/media/DIAnF29VoAACic1.jpg'); 


insert into politician
values (9770084, '문희상', '文喜相', 'MOON HEESANG',
'1945-0303', '무소속', '경기 의정부시갑', '',
'6선제20대', '14 16 17 18 19 20대',
'02-784-1261', 'http://www.moonhs.net', 'moonhs@assembly.go.kr',
'독서', '특기',
'http://www.assembly.go.kr/photo/9770084.jpg');

select * from bill where proposer='문희상' and proposer_hj='文喜相';

insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'강효상','비례대표','자유한국당'); 
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'권미혁','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김규환','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김삼화','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김성수','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김성태','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김수민','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김순례','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김승희','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김종대','비례대표','정의당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김종석','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김중로','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김현권','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'김현아','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'문진국','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'박경미','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'박선숙','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'박주현','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'송옥주','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'송희경','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'신보라','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'신용현','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'심기준','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'유민봉','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'윤소하','비례대표','정의당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'윤종필','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이동섭','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이상돈','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이수혁','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이용득','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이재정','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이정미','비례대표','정의당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이종명','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이철희','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'이태규','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'임이자','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'임재훈','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'장정숙','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'전희경','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'정춘숙','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'제윤경','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'조훈현','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'채이배','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'최도자','비례대표','바른미래당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'최연혜','비례대표','자유한국당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'최운열','비례대표','더불어민주당');
insert into politician(politician_no,politician_name,politician_type,politician_party) values(seq_pol.nextval, 
'추혜선','비례대표','정의당');


commit

select * from POLITICIAN;

delete from POLITICIAN;