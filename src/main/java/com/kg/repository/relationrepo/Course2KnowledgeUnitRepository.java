package com.kg.repository.relationrepo;

import com.kg.model.relationship.Course2KnowledgeUnit;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Course2KnowledgeUnitRepository extends Neo4jRepository<Course2KnowledgeUnit, Long> {
}
