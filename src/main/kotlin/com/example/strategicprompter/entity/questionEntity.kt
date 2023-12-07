package com.example.strategicprompter.entity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "questions") // MongoDB 컬렉션 이름 지정
data class questionEntity(
    @Id
    val uid: Int,
    val questions: String,
    val givenInfo: String
)
{

}