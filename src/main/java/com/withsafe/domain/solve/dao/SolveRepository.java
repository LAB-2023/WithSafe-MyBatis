package com.withsafe.domain.solve.dao;

import com.withsafe.domain.solve.domain.Solve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolveRepository extends JpaRepository<Solve, Long> {
}
