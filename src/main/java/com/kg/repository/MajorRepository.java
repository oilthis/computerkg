package com.kg.repository;

import com.kg.model.entity.Major;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends Neo4jRepository<Major, Long> {
    Major findFirstByName(String name);

    @Query(value = "match p=(s:Major)-[]-() where s.name={0} return p")
    List<PathValue> getRelationByName(String name);
}
