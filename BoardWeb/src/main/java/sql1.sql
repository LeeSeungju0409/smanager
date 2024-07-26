-- 게시판 (게시글 번호, 제목, 내용, 작성자, 작성일시, 조회수)
CREATE TABLE tbl_board (
    board_no NUMBER,
    title VARCHAR2(100) NOT NULL,
    content VARCHAR2(500) NOT NULL,
    writer VARCHAR2(100) NOT NULL,
    write_date DATE DEFAULT SYSDATE,
    view_cnt NUMBER DEFAULT 0
);

CREATE SEQUENCE board_seq;
ALTER TABLE tbl_board ADD CONSTRAINT board_pk PRIMARY KEY(board_no);

-- user01 웹은 재밌습니다 / html, jsp 공부하고 좋습니다.
INSERT INTO tbl_board (board_no, writer, title, content)
VALUES(board_seq.nextval, 'user01', '웹은 재밌습니다', 'html, jsp 공부하고 좋습니다.');

SELECT *
FROM tbl_board;

INSERT INTO tbl_board (board_no, writer, title, content)
VALUES(board_seq.nextval, 'chacha', 'java도 잼따', 'java도 좋습니다.');

INSERT INTO tbl_board (board_no, writer, title, content)
VALUES(board_seq.nextval, 'test', '글쓰기 test', '잘 써집니다.');

INSERT INTO tbl_board (board_no, writer, title, content)
VALUES(board_seq.nextval, 'user02', 'javascript 좋음.', 'javascript도 좋습니다.');

commit;


-- 1) 페이지당 5건
-- 2) 전체건수 / 5건 => 전체 페이지를 계산.
select b.*
from (select rownum rn, a.*
 from(SELECT * 
    FROM tbl_board
    order by board_no ) a ) b
where b.rn > (:page - 1) * 5
and b.rn <= (:page * 5);


select b.*
from (select rownum rn, a.*
 from(SELECT * 
    FROM tbl_board
    -- where title like '%test%'
    -- where writer like '%test%'
    where title like '%test%' or writer like '%test%'
    order by board_no ) a ) b
where b.rn > (:page - 1) * 5
and b.rn <= (:page * 5);

where rownum >= 0
and rownum <= 5
;
    
commit;

select *
from tbl_board b
where title like '%java%';

select *
from tbl_board b
where writer like '%cha%';

select *
from tbl_board b
where writer like '%test%'
or title like '%test%';

insert into tbl_board (board_no, writer, title, content)
select board_seq.nextval, writer, title, content
from tbl_board;

select b.* from (select rownum rn, a.* from(SELECT * FROM tbl_board where writer like '%'|| 'user' ||'%' order by board_no ) a ) b where b.rn > (1 - 1) * 5 and b.rn <= (1 * 5);

alter table tbl_board add image varchar2(100);




create sequence board_seq;
alter table tbl_board add constraint board_pk primary key(board_no);


-- 사용자 테이블(아이디, 비밀번호, 회원이름, 권한)
create table tbl_member(
    member_id varchar2(30) primary key,
    member_pw varchar2(10) not null,
    member_nm varchar2(50) not null,
    responsibility varchar2(10) default 'User' -- 'Admin'
    );
    
insert into tbl_member (member_id, member_pw, member_nm)
values('user01', '1111', '홍길동');

insert into tbl_member (member_id, member_pw, member_nm)
values('user02', '2222', '권민석');

insert into tbl_member (member_id, member_pw, member_nm)
values('chacha', '1111', '김차차');


select *
from tbl_member;

insert into tbl_member (member_id, member_pw, member_nm, responsibility)
values('admin', '1111', '김관리', 'Admin');


select *
		from  tbl_member
		where responsibility = 'User'
		order by  member_id;



-- 댓글 (댓글번호, 글내용, 작성자, 작성일시, 원본글번호 )
create table tbl_reply(
 reply_no number,
 reply_content VARCHAR2(300) not null,
 replyer VARCHAR2(10) not null,
 reply_date date default sysdate,
 board_no number not null
);

create sequence reply_seq;

alter table tbl_reply add constraint reply_pk primary key(reply_no);

-- user01  148번 댓글등록 "댓글잘봤습니다" 등록
insert into tbl_reply (reply_no, reply_content, replyer, board_no)
values(reply_seq.nextval, '댓글잘봤습니다', 'user01', 148);
insert into tbl_reply (reply_no, reply_content, replyer, board_no)
values(reply_seq.nextval, '저도 댓글잘봤습니다', 'user02', 148);

insert into tbl_reply (reply_no, reply_content, replyer, board_no)
values(reply_seq.nextval, '댓글잘봤습니다', 'user01', 147);
insert into tbl_reply (reply_no, reply_content, replyer, board_no)
values(reply_seq.nextval, '저도 댓글잘봤습니다', 'user02', 147);

-- 댓글목록.
select *
from tbl_reply
where board_no = 144
order by reply_no;

select *
from tbl_reply;

select *
from tbl_board
order by board_no desc;


-- 댓글 삭제
delete from tbl_reply
where reply_no = 4;


-- 댓글 페이징.
select /*+ INDEX_DESC(r reply_pk)*/
from tbl_reply r;

SELECT *
FROM tbl_member;

--힌트사용.
SELECT /*+ INDEX (r reply_pk) */ *
FROM tbl_reply r;

insert into tbl_reply (reply_no, reply_content, replyer, board_no)
select reply_seq.nextval, reply_content, replyer, board_no
from tbl_reply
where board_no = 144;


select b.*
from (select /* + INDEX (r reply_pk) */ rownum rn, r.*
      from tbl_reply r 
      where r.board_no = board_no) b
where b.rn > (:page -1) * 5
and b.rn <= (:page * 5);