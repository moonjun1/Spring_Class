package com.daejinproject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class testService {

    private final testRepository testRepository;

    //전체조회
    public List<testEntity> getAllBoard(){
        return testRepository.findAll();
    }
    //단건 조회
    public testEntity getBoard(Long id){
        return testRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("없는 게시글임"));
    }
    // 저장 생성
    public testEntity addBoard(testEntity board){
        return testRepository.save(board);
    }
    // 수정
    public testEntity updateBoard(Long id, testEntity board){
        testEntity existingBoard = testRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("없는 게시글임"));
        existingBoard.setName(board.getName());
        existingBoard.setPhone(board.getPhone());
        return testRepository.save(existingBoard);
    }

    //삭제
    public void deleteBoard(Long id){
        testRepository.deleteById(id);
    }


}
