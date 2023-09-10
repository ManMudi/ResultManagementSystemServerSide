package org.result.ResultManagementSystem.mapper;

import org.result.ResultManagementSystem.dto.TermDto;
import org.result.ResultManagementSystem.entity.Term;

public class TermMapper {
    public static TermDto mapToTermDto(Term term){

        return new TermDto(
                term.getId(),
                term.getTerm().toUpperCase(),
                term.getDescription().toUpperCase()
        );
    }

    public static Term mapToTerm(TermDto termDto){
        Term term=new Term();
        term.setId(termDto.getId());
        term.setTerm(termDto.getTerm().toUpperCase());
        term.setDescription(termDto.getDescription());
        return term;
    }
}
