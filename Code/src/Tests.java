import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    @Test
    void emptyProgrammeTest(){
        BachelorProgramme programme = new BachelorProgramme();
        assertFalse(programme.valid());
    }

    @Test
    void validProgrammeTest1() throws Exception {
        BachelorProgramme programme = new BachelorProgramme();
        programme.addActivity(new BasicCourse(5,"a"));
        programme.addActivity(new BasicCourse(5,"b"));
        programme.addActivity(new BasicCourse(5,"c"));
        programme.addActivity(new BasicCourse(5,"d"));
        programme.addActivity(new BasicCourse(5,"e"));
        programme.addActivity(new BasicCourse(5,"f"));
        programme.addActivity(new BasicCourse(5,"g"));
        programme.addActivity(new BasicCourse(5,"h"));

        programme.addActivity(new SubjectModuleCourse(5,"aa"));
        programme.addActivity(new SubjectModuleCourse(5,"bb"));
        programme.addActivity(new SubjectModuleCourse(5,"cc"));
        programme.addActivity(new SubjectModuleCourse(5,"dd"));
        programme.addActivity(new SubjectModuleCourse(5,"ee"));
        programme.addActivity(new SubjectModuleCourse(5,"ff"));
        programme.addActivity(new SubjectModuleCourse(5,"gg"));
        programme.addActivity(new SubjectModuleCourse(5,"hh"));

        programme.addActivity(new ElectiveCourse(5,"aaa"));
        programme.addActivity(new ElectiveCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertTrue(programme.valid());
    }

    @Test
    void validProgrammeTest2() throws Exception {
        BachelorProgramme programme = new BachelorProgramme();
        programme.addActivity(new BasicCourse(5,"a"));
        programme.addActivity(new BasicCourse(5,"b"));
        programme.addActivity(new BasicCourse(5,"c"));
        programme.addActivity(new BasicCourse(5,"d"));
        programme.addActivity(new BasicCourse(5,"e"));
        programme.addActivity(new BasicCourse(5,"f"));
        programme.addActivity(new BasicCourse(5,"g"));
        programme.addActivity(new BasicCourse(5,"h"));

        programme.addActivity(new SubjectModuleCourse(5,"aa"));
        programme.addActivity(new SubjectModuleCourse(5,"bb"));
        programme.addActivity(new SubjectModuleCourse(5,"cc"));
        programme.addActivity(new SubjectModuleCourse(5,"dd"));
        programme.addActivity(new SubjectModuleCourse(10,"ee"));
        programme.addActivity(new SubjectModuleCourse(10,"ff"));

        programme.addActivity(new ElectiveCourse(5,"aaa"));
        programme.addActivity(new ElectiveCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertTrue(programme.valid());
    }

}
