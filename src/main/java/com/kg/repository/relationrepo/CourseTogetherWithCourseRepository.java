package com.kg.repository.relationrepo;

import com.kg.model.relationship.CourseTogetherWithCourse;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTogetherWithCourseRepository extends Neo4jRepository<CourseTogetherWithCourse, Long> {
}
