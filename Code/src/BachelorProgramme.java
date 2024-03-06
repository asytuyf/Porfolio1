import java.util.ArrayList;

/**
 * This is a class that represents a Bachelor programme
 */
public class BachelorProgramme {

    /**
     * Two array lists that keep track of which courses and projects were added
     */
    ArrayList<Course> courses;
    ArrayList<Project> projects;

    public BachelorProgramme(){
        courses = new ArrayList<Course>();
        projects = new ArrayList<Project>();
    }

    /**
     * Validates the bachelor programme based on certain criterias
     *
     * @return False or True
     */
    public boolean valid(){
        if((courses.size() < 16 || courses.size() > 18) && projects.size() != 6){
            return false;
        }
        int totalEcts = 0;

        int totalBasicCourses = 0;
        int totalSubModCourses = 0;
        int totalElectiveCourses = 0;

        int totalBasicProjects = 0;
        int totalSubModProjects = 0;
        int totalBachelorProjects = 0;

        for(Course course : courses){
            if(course.getEcts() != 10 && course.getEcts() != 5){
                return false;
            }
            totalEcts += course.getEcts();
            int dupesFound = 0;
            switch (course.getType()){
                case BASIC -> totalBasicCourses++;
                case SUBJECT_MODULE -> totalSubModCourses++;
                case ELECTIVE -> totalElectiveCourses++;
                default -> {
                    return false;
                }
            }
            for(Course courseCompare : courses){
                if(course.sameActivity(courseCompare)){
                    dupesFound++;
                }
            }
            if(dupesFound > 1){
                return false;
            }
        }
        for(Project project : projects){
            totalEcts += project.getEcts();
            int dupesFound = 0;
            switch (project.getType()){
                case BASIC -> totalBasicProjects++;
                case SUBJECT_MODULE -> totalSubModProjects++;
                case BACHELOR_PROJECT -> totalBachelorProjects++;
                default -> {
                    return false;
                }
            }
            for(Project projectCompare : projects){
                if(project.sameActivity(projectCompare)){
                    dupesFound++;
                }
            }
            if(dupesFound > 1){
                return false;
            }
        }

        boolean coursesInvalid = (totalBasicCourses != 8 || (totalSubModCourses < 6 || totalSubModCourses > 8) || totalElectiveCourses != 2);
        boolean projectsInvalid = (totalBasicProjects != 3 || totalSubModProjects != 2 || totalBachelorProjects != 1);

        if (totalEcts != 180 || coursesInvalid || projectsInvalid){
            return false;
        }
        return true;
    }

    /**
     * Adds course to courses arraylist
     * @param course
     */
    public void addActivity(Course course){
        courses.add(course);
    }

    /**
     * adds project to projects arraylist
     * @param project
     */
    public void addActivity(Project project){
        projects.add(project);
    }

}
