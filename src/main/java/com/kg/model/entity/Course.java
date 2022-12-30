package com.kg.model.entity;

import com.kg.model.relationship.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node(primaryLabel = "course")
@Data
@Builder
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "name")
    private String name;
    @Property(name = "Course_code")
    private String Course_code;
    @Property(name = "Course_hours")
    private String Course_hours;
    @Property(name = "Course_credit")
    private Double Course_credit;

    @Relationship(type = "contain", direction = Relationship.Direction.OUTGOING)
    private List<Course2KnowledgeUnit> Course2KnowledgeUnits;

    @Relationship(type = "适用专业", direction = Relationship.Direction.OUTGOING)
    private List<Course2Major> Course2Majors;

    @Relationship(type = "teached", direction = Relationship.Direction.OUTGOING)
    private List<Course2Teacher> course2Teachers;

    @Relationship(type = "reference", direction = Relationship.Direction.OUTGOING)
    private List<Course2Textbook> Course2Textbooks;

    @Relationship(type = "先修", direction = Relationship.Direction.OUTGOING)
    private List<CourseBeforeCourse> courseBeforeCourses;

    @Relationship(type = "同修", direction = Relationship.Direction.OUTGOING)
    private List<CourseTogetherWithCourse> CourseTogetherWithCourses;

}
