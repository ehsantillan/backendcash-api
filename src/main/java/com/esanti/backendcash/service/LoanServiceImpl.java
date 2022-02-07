package com.esanti.backendcash.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.esanti.backendcash.dto.LoanDTO;
import com.esanti.backendcash.dto.PageDTO;
import com.esanti.backendcash.exception.LoanException;
import com.esanti.backendcash.model.Loan;
import com.esanti.backendcash.repository.LoanRepository;
import com.esanti.backendcash.util.UtilMapper;

@Service
public class LoanServiceImpl implements LoanService {
	
	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());	
	
	private LoanRepository loanRepository;	
		
	
	private UtilMapper mapper;
	
	public LoanServiceImpl(@Autowired final LoanRepository loanRepository, @Autowired final UtilMapper modelMapper) {
		this.loanRepository = loanRepository;
		this.mapper = modelMapper;

	}
	

	@Override
	public Map<String, Object> getAllLoans(int page, int size, int userId) throws LoanException {
		Map<String, Object> result = new HashMap<>();
		List<Loan> Loans = new ArrayList<Loan>();
		Pageable paging = PageRequest.of(page, size,Sort.by(Sort.Direction.ASC, "id"));
		Page<Loan> pageLoans;

		if (userId == 0) {
			pageLoans = loanRepository.findAll(paging);
		} else {
			pageLoans = loanRepository.findByUserId(userId, paging);
		}
		if(pageLoans == null || pageLoans.getContent().isEmpty()) {
			LOGGER.log(Level.INFO,"Error findAll loan page:"+page+" ,size"+size+" ,userId"+userId);
			throw LoanException.ofNotFoundLoan();
		}
		Loans = pageLoans.getContent();
		List<LoanDTO> loansDto = mapper.mapAll(Loans, LoanDTO.class);

		PageDTO pageDto = new PageDTO();
		pageDto.setPage(page);
		pageDto.setSize(size);
		pageDto.setTotal(pageLoans.getTotalElements());		
		
		result.put("items", loansDto);
		result.put("paging", pageDto);

		return result;
	}
	


}
