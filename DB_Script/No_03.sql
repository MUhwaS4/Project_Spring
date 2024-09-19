select
        m1_0.no,
        m1_0.text 
    from
        tbl_memo m1_0
        -- tbl_memo는 TABLE 이름
        -- m1_0은 JPA가 생성하는 별칭
    where
        m1_0.no=1;
        -- 스프링에서는 m1_0.NO=?로 작성됨
        -- 이를 그대로 DB에서 불러오고 싶다면 [?] 부분에 원하는 PK값을 입력해야 함
        
-- 페이징처리
select
        m1_0.no,
        m1_0.text 
    from
        tbl_memo m1_0 
    limit
        10, 10;
        -- 스프링에서는 LIMIT ?, ?라고 작성됨
       	-- 이를 DB에서 테스트할 때는 실제 숫자를 입력해야 함
       
       
-- 정렬조건추가하기
select
        m1_0.no,
        m1_0.text 
    from
        tbl_memo m1_0 
    order by
        m1_0.no desc -- 역정렬
    limit
        0, 10;
        

-- 번호가_10와20사이인_데이터검색
select
        m1_0.no,
        m1_0.text 
    from
        tbl_memo m1_0 
    where
        m1_0.no between 10 and 20;
        
       
-- 번호가10보다작은_데이터검색
select
        m1_0.no,
        m1_0.text 
    from
        tbl_memo m1_0 
    where
        m1_0.no<10;
       
       
-- 텍스트가null이아닌_데이터검색
    select
        m1_0.no,
        m1_0.text 
    from
        tbl_memo m1_0 
    where
        m1_0.text is not null
       
       
-- 텍스트가null인_데이터검색
    select
        m1_0.no,
        m1_0.text 
    from
        tbl_memo m1_0 
    where
        m1_0.text is NULL
        

-- 메모의 번호를 기준으로 역정렬
SELECT *
FROM tbl_memo
ORDER BY NO DESC;

SELECT * FROM TBL_MEMO ORDER BY NO DESC;


-- 메모 삭제
DELETE 
FROM tbl_memo 
WHERE NO = 6;

DELETE FROM tbl_memo WHERE NO = 6;


-- 메모 수정
UPDATE tbl_memo
SET `text` = '변경~'
WHERE NO = 7;

UPDATE tbl_memo SET `text` = '변경~' WHERE NO = 7;
        
       
       
-- 실행 시 WHERE 값의 데이터가 null이 됨
UPDATE bootex.tbl_memo
SET `text`=NULL
WHERE `no`=6;


-- Q5. BookRepository 순수한 sql 사용 문제
SELECT * FROM tbl_book WHERE TBL_BOOK.TITLE = "자바프로그래밍입문";
SELECT * FROM tbl_book WHERE TBL_BOOK.PUBLISHER = "남가람북스" AND TBL_BOOK.PRICE >= 30000;
SELECT * FROM tbl_book WHERE TBL_BOOK.PUBLISHER = "한빛출판사" OR PUBLISHER = "이지스퍼블리싱";

-- Q6. GiftRepository 순수한 sql 사용 문제
SELECT * FROM tbl_gift WHERE TBL_GIFT.PRICE >= 50000;
SELECT * FROM tbl_gift WHERE TBL_GIFT.NAME LIKE '%세트';
SELECT * FROM tbl_gift WHERE TBL_GIFT.PRICE <= 40000 AND TBL_GIFT.`TYPE` = "생활용품";

-- Q7. OrderRepository 순수한 sql 사용 문제
SELECT * FROM tbl_order WHERE TBL_ORDER.SHIP_ADDRESS LIKE "%인천%";
SELECT * FROM tbl_order WHERE TBL_ORDER.CREATED_DATE = '2023-07-03';

-- Q8. MemberRepository 순수한 sql 사용 문제
SELECT * FROM tbl_member WHERE TBL_MEMBER.USER_ID LIKE "user%";
SELECT * FROM tbl_member WHERE TBL_MEMBER.GRADE = "관리자";