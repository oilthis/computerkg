package com.kg.model.entity;

import com.kg.model.relationship.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

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

    @Relationship(type = "Course2KnowledgeUnit", direction = Relationship.Direction.OUTGOING)
    private List<Course2KnowledgeUnit> Course2KnowledgeUnits;

    @Relationship(type = "Course2Major", direction = Relationship.Direction.OUTGOING)
    private List<Course2Major> Course2Majors;

    @Relationship(type = "Course2Teacher", direction = Relationship.Direction.OUTGOING)
    private List<Course2Teacher> course2Teachers;

    @Relationship(type = "Course2Textbook", direction = Relationship.Direction.OUTGOING)
    private List<Course2Textbook> Course2Textbooks;

    @Relationship(type = "CourseBeforeCourse", direction = Relationship.Direction.OUTGOING)
    private List<CourseBeforeCourse> courseBeforeCourses;

    @Relationship(type = "CourseTogetherWithCourse", direction = Relationship.Direction.OUTGOING)
    private List<CourseTogetherWithCourse> CourseTogetherWithCourses;

}
