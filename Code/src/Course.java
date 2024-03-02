public class Course extends Activity {

    public Course(int ectsPoints, String name) throws Exception{
        super(ectsPoints, name);
        if(ectsPoints != 10 && ectsPoints != 5){
            throw new Exception();
        }
    }

}

class BasicCourse extends Course {
    public BasicCourse(int ectsPoints, String name) throws Exception {
        super(ectsPoints, name);
        setType(types.BASIC);
    }
}

class SubjectModuleCourse extends Course {
    public SubjectModuleCourse(int ectsPoints, String name) throws Exception {
        super(ectsPoints, name);
        setType(types.SUBJECT_MODULE);
    }
}

class ElectiveCourse extends Course {
    public ElectiveCourse(int ectsPoints, String name) throws Exception {
        super(ectsPoints, name);
        setType(types.ELECTIVE);
    }
}
