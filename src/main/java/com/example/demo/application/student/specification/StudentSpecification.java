package com.example.demo.application.student.specification;

import com.example.demo.domain.student.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentSpecification implements Specification<Student> {

    private final StudentCriteria studentCriteria;
    private final List<Predicate> predicates;

    public StudentSpecification(StudentCriteria studentCriteria) {
        this.studentCriteria = studentCriteria;
        this.predicates = new ArrayList<>();
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        addGpaPredicate(root, criteriaBuilder);
        addLastNamePredicate(root, criteriaBuilder);
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    private void addLastNamePredicate(Root<Student> root, CriteriaBuilder criteriaBuilder) {
        predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + studentCriteria.getLastName() + "%"));
    }

    private void addGpaPredicate(Root<Student> root, CriteriaBuilder criteriaBuilder) {
        predicates.add(criteriaBuilder.equal(root.get("gpa"), studentCriteria.getGpa()));
    }
}
