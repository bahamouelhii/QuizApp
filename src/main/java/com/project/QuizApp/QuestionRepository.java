package com.project.QuizApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Trouver toutes les questions d'une catégorie donnée
    List<Question> findByCategory(String category);

    // Trouver toutes les questions d'un niveau de difficulté donné
    List<Question> findByDifficulty(String difficulty);

    // Rechercher par catégorie et difficulté
    List<Question> findByCategoryAndDifficulty(String category, String difficulty);
}

