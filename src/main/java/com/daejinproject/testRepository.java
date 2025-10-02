package com.daejinproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface testRepository extends JpaRepository<testEntity, Long> {

    //인터페이스에서 자동 제공되는 메서드
    /*
    save()  저장/ 수정
    findById() id로 조회
    findAll() 전체 조회
    deleteById() id를 삭제
    count() 개수 세는것



     */

}
