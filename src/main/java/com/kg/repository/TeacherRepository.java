package com.kg.repository;

import com.kg.model.entity.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {
}
