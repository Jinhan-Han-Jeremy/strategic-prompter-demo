package com.example.strategicprompter.service
import com.example.strategicprompter.dto.questionDto
import com.example.strategicprompter.repository.questionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class questionService @Autowired constructor(private val questionRepository: questionRepository) {
/***
    fun createQuestion(questionDto: questionDto): questionDto
    {
        // questionDto를 questionEntity로 변환
        val questionEntity = questionDto.toEntity()

        // 데이터베이스에 저장
        val savedEntity = questionRepository.save(questionEntity)

        // 저장된 Entity를 다시 questionDto로 변환하여 반환
        //return questionDto.fromEntity(savedEntity)

    }
**/
    fun getQuestionById(uid: Int): questionDto? {
        val questionEntity = questionRepository.findById(uid)

        return if (questionEntity.isPresent) {
            questionDto.fromEntity(questionEntity.get())
        } else {
            null
        }
    }

    fun getAllQuestions(): List<questionDto> {
        val questionEntities = questionRepository.findAll()
        return questionEntities.map { questionDto.fromEntity(it) }
    }

    fun updateQuestion(uid: Int, updatedQuestionDto: questionDto): questionDto? {
        // 데이터베이스에서 해당 엔터티 조회
        val existingEntity = questionRepository.findById(uid)

        if (existingEntity.isPresent) {
            // 엔터티가 존재하는 경우 업데이트 진행
            val updatedEntity = updatedQuestionDto.toEntity()
            val updatedEntityWithUid = updatedEntity.copy(uid = uid) // uid 업데이트
            val savedEntity = questionDto.fromEntity(questionRepository.save(updatedEntityWithUid))
            return savedEntity
        } else {
            // 엔터티가 없는 경우 null 반환
            return null
        }
    }

    fun deleteQuestion(uid: Int) {
        // 데이터베이스에서 해당 엔터티 삭제
        questionRepository.deleteById(uid)
    }

}