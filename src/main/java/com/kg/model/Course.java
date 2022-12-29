package com.kg.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "Course")
@Data
@Builder
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "课程名称")
    private String name;
    @Property(name = "课程代码")
    private String Course_code;
    @Property(name = "学时")
    private String Course_hours;
    @Property(name = "学分")
    private Double Course_credit;

}
