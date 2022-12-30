package com.kg.repository.entityrepo;

import com.kg.model.entity.Major;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends Neo4jRepository<Major, Long> {
}
