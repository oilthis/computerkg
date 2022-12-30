package com.kg.repository.relationrepo;

import com.kg.model.relationship.Course2Textbook;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Course2TextbookRepository extends Neo4jRepository<Course2Textbook, Long> {
}
