package com.example.strategicprompter.controller

import com.example.strategicprompter.dto.questionDto
import com.example.strategicprompter.service.questionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/questions")
class questionController @Autowired constructor(private val questionService: questionService) {

    @PostMapping
    fun createQuestion(@RequestBody questionDto: questionDto): questionDto {
        return questionService.createQuestion(questionDto)
    }

    @GetMapping("/{uid}")
    fun getQuestionById(@PathVariable uid: Int): questionDto? {
        return questionService.getQuestionById(uid)
    }

    @GetMapping
    fun getAllQuestions(): List<questionDto> {
        return questionService.getAllQuestions()
    }

    @PutMapping("/{uid}")
    fun updateQuestion(
        @PathVariable uid: Int,
        @RequestBody updatedQuestionDto: questionDto
    ): questionDto? {
        return questionService.updateQuestion(uid, updatedQuestionDto)
    }

    @DeleteMapping("/{uid}")
    fun deleteQuestion(@PathVariable uid: Int) {
        questionService.deleteQuestion(uid)
    }
}