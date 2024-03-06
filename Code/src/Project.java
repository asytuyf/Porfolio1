/**
 * A class that represents a project
 */
public class Project extends Activity{


    public Project(String name) {
        super(15, name);
    }
}

/**
 * A class that represents a Basic project
 */
class BasicProject extends Project {
    public BasicProject( String name) {
        super(name);
        setType(types.BASIC);
    }
}

/**
 * A class that represents a Subject module project
 */
class SubejctModuleProject extends Project {
    public SubejctModuleProject(String name) {
        super(name);
        setType(types.SUBJECT_MODULE);
    }
}

/**
 * A class that represents a Bachelor project
 */
class BachelorProject extends Project {
    public BachelorProject(String name) {
        super(name);
        setType(types.BACHELOR_PROJECT);
    }
}
