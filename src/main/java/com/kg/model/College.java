package com.kg.model;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "College")
@Data
@Builder
public class College {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;

}
