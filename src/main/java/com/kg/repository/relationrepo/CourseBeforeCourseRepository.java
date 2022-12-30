package com.kg.repository.relationrepo;

import com.kg.model.relationship.CourseBeforeCourse;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseBeforeCourseRepository extends Neo4jRepository<CourseBeforeCourse, Long> {
}
