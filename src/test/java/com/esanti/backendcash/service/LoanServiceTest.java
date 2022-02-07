package com.esanti.backendcash.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import com.esanti.backendcash.exception.LoanException;
import com.esanti.backendcash.model.Loan;
import com.esanti.backendcash.repository.LoanRepository;
import com.esanti.backendcash.util.UtilMapper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest 
public class LoanServiceTest {

	@Mock
	private LoanRepository loanRepository;

	private LoanService loanService;

	@Autowired
	private UtilMapper mapper;

	@BeforeEach
	public void init() {
		loanService = new LoanServiceImpl(loanRepository, mapper);
	}

	@Test
	public void testGetAllLoansThenReturnAllLoans() throws LoanException {
		final List<Loan> loanMock = new ArrayList<>();
		final Loan loan1 = mock(Loan.class);
		loan1.setUserId(1);
		final Loan loan2 = mock(Loan.class);
		loan1.setUserId(1);
		loanMock.add(loan1);
		loanMock.add(loan2);		
		final Pageable paging =  PageRequest.of(1, 3, Sort.by(Sort.Direction.ASC, "id"));		
		when(loanRepository.findAll(paging)).thenReturn(new PageImpl<>(loanMock));
		final Map<String, Object> mapLoans = loanService.getAllLoans(1, 3, 0);
		assertNotNull(mapLoans);
		assertFalse(mapLoans.isEmpty());
		assertEquals(loanMock.size(), mapLoans.size());
		verify(loanRepository, times(1)).findAll(paging);

	}
	
	@Test
	public void testGetAllLoansThenReturnAllLoansException() throws LoanException{		
		final LoanException exception = assertThrows(LoanException.class, () -> loanService.getAllLoans(1, 3, 1));
		assertEquals("loan_not_found", exception.getError());
		assertEquals("Invalid or not found loan", exception.getMessage());
		assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());

	}
	
	


}
