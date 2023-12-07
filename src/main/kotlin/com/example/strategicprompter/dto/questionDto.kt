package com.example.strategicprompter.dto
import java.util.*
import com.example.strategicprompter.entity.questionEntity

data class questionDto(
    val uid: Int = UUID.randomUUID().mostSignificantBits.toInt(),
    val questions: String,
    val givenInfo: String
)

{
    // DTO에서 Entity로 변환하는 함수
    fun toEntity(): questionEntity {
        return questionEntity(
            uid = this.uid,
            questions = this.questions,
            givenInfo = this.givenInfo
        )
    }

    companion object {
        // Entity 객체에서 DTO로 변환하는 함수
        fun fromEntity(entity: questionEntity): questionDto {
            return questionDto(
                uid = entity.uid,
                questions = entity.questions,
                givenInfo = entity.givenInfo
            )
        }
    }
}