package com.kg.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "Teacher")
@Data
@Builder
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "姓名")
    private String name;

}
