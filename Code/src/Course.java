/**
 * A class that represents a course
 */
public class Course extends Activity {

    public Course(int ectsPoints, String name){
        super(ectsPoints, name);
    }

}

/**
 * A class that represent a basic course
 */
class BasicCourse extends Course {
    public BasicCourse(int ectsPoints, String name){
        super(ectsPoints, name);
        setType(types.BASIC);
    }
}

/**
 * A class that represents a subject module course
 */
class SubjectModuleCourse extends Course {
    public SubjectModuleCourse(int ectsPoints, String name){
        super(ectsPoints, name);
        setType(types.SUBJECT_MODULE);
    }
}

/**
 * A class that represents an Elective Course
 */
class ElectiveCourse extends Course {
    public ElectiveCourse(int ectsPoints, String name){
        super(ectsPoints, name);
        setType(types.ELECTIVE);
    }
}
