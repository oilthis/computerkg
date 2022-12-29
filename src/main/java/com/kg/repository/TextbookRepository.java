package com.kg.repository;

import com.kg.model.entity.Textbook;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextbookRepository extends Neo4jRepository<Textbook, Long> {
}
