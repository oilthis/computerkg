package com.kg.repository;

import com.kg.model.entity.KnowledgeUnit;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeUnitRepository extends Neo4jRepository<KnowledgeUnit, Long> {

    KnowledgeUnit findFirstByName(String name);

    @Query(value = "match p=(s:KnowledgeUnit)-[]-() where s.name={0} return p")
    List<PathValue> getRelationKnowledgeUnitByName(String name);
}
