package com.kg.model.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "Major")
@Data
@Builder
public class Major {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "专业名称")
    private String name;

}
