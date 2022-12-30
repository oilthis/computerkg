package com.kg.repository;

import com.kg.model.entity.Textbook;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextbookRepository extends Neo4jRepository<Textbook, Long> {

    Textbook findFirstByName(String name);

    @Query(value = "match p=(s:Textbook)-[]-() where s.name={0} return p")
    List<PathValue> getRelationTextbookByName(String name);
}
