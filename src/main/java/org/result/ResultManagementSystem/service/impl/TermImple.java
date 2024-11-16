package org.result.ResultManagementSystem.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.result.ResultManagementSystem.dto.TermDto;
import org.result.ResultManagementSystem.entity.Term;
import org.result.ResultManagementSystem.repository.TermRepository;
import org.result.ResultManagementSystem.service.TermService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TermImple implements TermService {

    private TermRepository termRepository;
    private ModelMapper modelMapper;

    @Override
    public TermDto createTerm(TermDto termDto) {
        Term term= modelMapper.map(termDto,Term.class);
        Term term1=termRepository.save(term);
        return modelMapper.map(term1, TermDto.class);
    }

    @Override
    public TermDto findTermById(Long id) {
        Term term=termRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Term of this Id is not Available"+id));
        return modelMapper.map(term, TermDto.class);
    }

    @Override
    public List<TermDto> getAllTerm() {
        List<Term> terms=termRepository.findAll();
        return terms.stream().map((term)->modelMapper.map(term,TermDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TermDto updateTerm(TermDto termDto, Long id) {
        Term term=termRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Term of this Id is not Available"+id));
        term.setTerm(termDto.getTerm());
        term.setDescription(termDto.getDescription());
        Term term1=termRepository.save(term);
        return modelMapper.map(term1, TermDto.class);
    }

    @Override
    public void deleteTermById(Long id) {
        Term term=termRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Term of this Id is not Available"+id));
        termRepository.deleteById(id);
    }
}
