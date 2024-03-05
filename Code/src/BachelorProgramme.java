import java.util.ArrayList;

public class BachelorProgramme {

    ArrayList<Course> courses;
    ArrayList<Project> projects;

    public BachelorProgramme(){
        courses = new ArrayList<Course>();
        projects = new ArrayList<Project>();
    }

    public boolean valid(){
        //A simple size check is done first, because if the programme has too many/too few
        //Courses or projects, we can avoid a lot of computing since we already know it is an invalid programme
        if((courses.size() < 16 || courses.size() > 18) && projects.size() != 6){
            return false;
        }
        //We store total ECTs points for the whole program here
        int totalEcts = 0;

        //We store the count for each course type here
        int totalBasicCourses = 0;
        int totalSubModCourses = 0;
        int totalElectiveCourses = 0;

        //We store the count for each project type here
        int totalBasicProjects = 0;
        int totalSubModProjects = 0;
        int totalBachelorProjects = 0;

        //We iterate through all courses in the programme
        //A complex for loop is chosen to improve readability within the loop
        //An alternative could be storing courses[i] in a Course course variable in the loop
        for(Course course : courses){
            totalEcts += course.getEcts();
            //Variable to count duplicates
            int dupesFound = 0;
            switch (course.getType()){
                case BASIC -> totalBasicCourses++;
                case SUBJECT_MODULE -> totalSubModCourses++;
                case ELECTIVE -> totalElectiveCourses++;
                default -> {
                    return false;
                }
            }
            //We compare the course to every other course to ensure that no two courses are the same
            //A caveat here is that we will inevitably compare the course to itself
            //Therefore, the amount of dupes tolerated are 1, not 0
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

        //Long strings of logic saved to variables for readability
        //We have consistently checked for the negative, so here we also check if the course and project combination is invalid
        boolean coursesInvalid = (totalBasicCourses != 8 || (totalSubModCourses < 6 || totalSubModCourses > 8) || totalElectiveCourses != 2);
        boolean projectsInvalid = (totalBasicProjects != 3 || totalSubModProjects != 2 || totalBachelorProjects != 1);

        if (totalEcts != 180 || coursesInvalid || projectsInvalid){
            return false;
        }
        //Since we consistently check for the negative, we can safely return true here, because the programme has passed every check
        return true;
    }

    //Instead of having a check within the addActivity method to sort the given activity into the courses or projects list
    //we overload the method, saving us an if or switch statement
    public void addActivity(Course course){
        courses.add(course);
    }

    public void addActivity(Project project){
        projects.add(project);
    }

}
