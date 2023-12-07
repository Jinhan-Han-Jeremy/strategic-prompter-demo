package com.example.strategicprompter.repository
import com.example.strategicprompter.entity.questionEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface questionRepository : MongoRepository<questionEntity, Int> {
    // 사용자 정의 쿼리 메서드 등을 추가할 수 있음
}