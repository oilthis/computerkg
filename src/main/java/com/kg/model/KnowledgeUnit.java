package com.kg.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "KnowledgeUnit")
@Data
@Builder
public class KnowledgeUnit {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "知识单元名称")
    private String name;

}
