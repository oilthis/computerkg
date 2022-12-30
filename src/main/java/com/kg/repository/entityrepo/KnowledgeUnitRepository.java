package com.kg.repository.entityrepo;

import com.kg.model.entity.KnowledgeUnit;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgeUnitRepository extends Neo4jRepository<KnowledgeUnit, Long> {
}
