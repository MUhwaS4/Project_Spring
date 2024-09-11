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