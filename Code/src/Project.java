public class Project extends Activity{


    public Project(String name) {
        super(15, name);
    }
}

class BasicProject extends Project {
    public BasicProject( String name) {
        super(name);
        setType(types.BASIC);
    }
}

class SubejctModuleProject extends Project {
    public SubejctModuleProject(String name) {
        super(name);
        setType(types.SUBJECT_MODULE);
    }
}

class BachelorProject extends Project {
    public BachelorProject(String name) {
        super(name);
        setType(types.BACHELOR_PROJECT);
    }
}
