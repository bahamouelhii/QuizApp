package com.project.QuizApp;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public List<Question> getQuestionsByDifficulty(String difficulty) {
        return questionRepository.findByDifficulty(difficulty);
    }

    public String saveQuestion(Question question) {

            // Insertion de la nouvelle question
            questionRepository.save(question);
            return "Question added!";
        }



    public String saveQuestion(int id, Question updatedQuestion) {

        Question existingQuestion = questionRepository.findById(id).orElse(null);

        if (existingQuestion == null) {
            return "Question not found for ID: " + id;
        }
        if (updatedQuestion.getCategory() != null && !updatedQuestion.getCategory().equals(existingQuestion.getCategory())) {
            existingQuestion.setCategory(updatedQuestion.getCategory());
        }

        if (updatedQuestion.getDifficulty() != null && !updatedQuestion.getDifficulty().equals(existingQuestion.getDifficulty())) {
            existingQuestion.setDifficulty(updatedQuestion.getDifficulty());
        }

        if (updatedQuestion.getDifficulty() != null && !updatedQuestion.getDifficulty().equals(existingQuestion.getDifficulty())) {
            existingQuestion.setDifficulty(updatedQuestion.getDifficulty());
        }

        if (updatedQuestion.getOption1() != null && !updatedQuestion.getOption1().equals(existingQuestion.getOption1())) {
            existingQuestion.setOption1(updatedQuestion.getOption1());
        }

        if (updatedQuestion.getOption2() != null && !updatedQuestion.getOption2().equals(existingQuestion.getOption2())) {
            existingQuestion.setOption2(updatedQuestion.getOption2());
        }

        if (updatedQuestion.getOption3() != null && !updatedQuestion.getOption3().equals(existingQuestion.getOption3())) {
            existingQuestion.setOption3(updatedQuestion.getOption3());
        }

        if (updatedQuestion.getOption4() != null && !updatedQuestion.getOption4().equals(existingQuestion.getOption4())) {
            existingQuestion.setOption4(updatedQuestion.getOption4());
        }

        if (updatedQuestion.getQuestionTitle() != null && !updatedQuestion.getQuestionTitle().equals(existingQuestion.getQuestionTitle())) {
            existingQuestion.setQuestionTitle(updatedQuestion.getQuestionTitle());
        }

        if (updatedQuestion.getRightAnswer() != null && !updatedQuestion.getRightAnswer().equals(existingQuestion.getRightAnswer())) {
            existingQuestion.setRightAnswer(updatedQuestion.getRightAnswer());
        }
        questionRepository.save(existingQuestion);
        return "Question updated!";

    }

    public String deleteQuestion(int id) {
        questionRepository.deleteById(id);
        return ("Question deleted");
    }
}

