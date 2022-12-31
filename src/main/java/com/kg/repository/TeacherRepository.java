package com.kg.repository;

import com.kg.model.entity.Teacher;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {

    Teacher findFirstByName(String name);

    @Query(value = "match p=(s:Teacher)-[]-() where s.name={0} return p")
    List<PathValue> getRelationByName(String name);
}
