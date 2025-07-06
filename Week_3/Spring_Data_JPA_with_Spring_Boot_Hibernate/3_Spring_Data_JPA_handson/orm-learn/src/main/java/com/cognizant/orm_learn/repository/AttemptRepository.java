package com.cognizant.orm_learn.repository;

import com.cognizant.orm_learn.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("""
        SELECT DISTINCT a FROM Attempt a
        JOIN FETCH a.user
        JOIN FETCH a.attemptQuestions aq
        JOIN FETCH aq.question q
        JOIN FETCH aq.attemptOptions ao
        JOIN FETCH ao.option o
        WHERE a.atId = :attemptId AND a.user.usId = :userId
    """)
    Attempt getFullAttemptDetails(@Param("userId") int userId, @Param("attemptId") int attemptId);
}

