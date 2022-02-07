package com.esanti.backendcash.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esanti.backendcash.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

	@Query(value = "SELECT * FROM tb_loan WHERE user_id = :userId ORDER BY id DESC --#pageable\\n", countQuery = "SELECT count(*) FROM tb_loan WHERE user_id = :userId", nativeQuery = true)
	Page<Loan> findByUserId(@Param("userId") int userId, Pageable pageable);

}
