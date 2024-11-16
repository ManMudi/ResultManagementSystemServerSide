package org.result.ResultManagementSystem.repository;

import org.result.ResultManagementSystem.entity.Mark;
import org.result.ResultManagementSystem.entity.MarksProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark,Long> {

    Page<Mark> findAll(Specification<Mark> specification, Pageable pageable);
    Specification<Mark> findByStudentId(Long studentId);
    Specification<Mark> findByTermId(Long termId);
    Specification<Mark> findByExamId(Long examId);
    Specification<Mark> findBySubjectId(String subjectId);
    Specification<Mark> findByMyYearId(Long yearId);
    Specification<Mark> findBySchoolId(String schoolId);
    Specification<Mark> findByStudentIdAndTermIdAndExamIdAndSubjectIdAndMyYearIdAndSchoolId(
            Long StudentId,Long termId,Long examId,String subjectId,Long yearId,String schoolId);

    @Query(value = "SELECT * FROM marks " +
            "where subject_id=:subId AND exam_Id=:eId AND term_id=:tId AND my_year_id=:yearId",nativeQuery = true)
    List<Mark> fetchByAll(@Param("subId") String subjectId , @Param("eId") Long examId,
                             @Param("tId") Long termId, @Param("yearId") Long yearId );

    @Query(value = "SELECT COUNT(*) FROM marks " +
            "where subject_id=:subId AND exam_Id=:eId AND term_id=:tId AND my_year_id=:yearId",nativeQuery = true)
    int countAll(@Param("subId") String subjectId , @Param("eId") Long examId,
                           @Param("tId") Long termId, @Param("yearId") Long yearId );

    @Query("select new  org. result. ResultManagementSystem. entity.MarksProjection" +
            "(s.firstName,s.middleName,s.lastName,m.mark,e.exam,t.term,y.yearValue,sub.subject) from Mark m " +
            "JOIN Student s ON m.student.id = s.id " +
            "JOIN Exam e ON m.exam.id = e.id " +
            "JOIN Term t ON m.term.id = t.id " +
            "JOIN MyYear y ON m.myYear.id = y.id " +
            "JOIN Subject sub ON m.subject.id=sub.id ") // and inner join
    List<MarksProjection> fetchMark();

    @Query(value = "Select m from Mark m where m.id = :id ")
    List<Mark> fetchBySubject(@Param("id") Long id);
}
