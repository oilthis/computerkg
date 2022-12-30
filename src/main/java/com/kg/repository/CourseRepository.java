package com.kg.repository;

import com.kg.model.entity.Course;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends Neo4jRepository<Course, Long> {
    Course findFirstByName(String name);

    @Query(value = "match p=(s:Course)-[]-() where s.name={0} return p")
    List<PathValue> getRelationCourseByName(String name);

    @Query(value = "match p=(s:Course)-[r:Course2KnowledgeUnit]-() where s.name={0} return p")
    List<PathValue> getCourse2KnowledgeUnitByName(String name);

    @Query(value = "match p=(s:Course)-[r:Course2Major]-() where s.name={0} return p")
    List<PathValue> getCourse2MajorByName(String name);

    @Query(value = "match p=(s:Course)-[r:Course2Teacher]-() where s.name={0} return p")
    List<PathValue> getCourse2TeacherByName(String name);

    @Query(value = "match p=(s:Course)-[r:Course2Textbook]-() where s.name={0} return p")
    List<PathValue> getCourse2TextbookByName(String name);

    @Query(value = "match p=(s:Course)-[r:CourseBeforeCourse]-() where s.name={0} return p")
    List<PathValue> getCourseBeforeCourseByName(String name);

    @Query(value = "match p=(s:Course)-[r:CourseTogetherWithCourse]-() where s.name={0} return p")
    List<PathValue> getCourseTogetherWithCourseByName(String name);
}
