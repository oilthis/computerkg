package com.kg.model.relationship;

import com.kg.model.entity.KnowledgeUnit;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
@Builder
public class Course2KnowledgeUnit {
    @Id
    @GeneratedValue
    Long id;

    String rel;

    @TargetNode
    KnowledgeUnit knowledgeUnit;
}
