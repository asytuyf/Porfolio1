import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//
//        From here on, everything other than what is mentioned should be valid.
//
//        No projects -> invalid
//        No courses  -> invalid
//
//        All below should have the correct amount of ECTs:
//
//        Not enough courses  -> invalid
//
//        No basic courses -> invalid
//        No subject mod courses -> invalid
//        No Elective courses -> invalid
//
//        No basic projects -> invalid
//        No subject mod projects -> invalid
//        No bachelor project -> invalid

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

    @Test
    void duplicateCourse() throws Exception {
        BachelorProgramme programme = new BachelorProgramme();
        programme.addActivity(new BasicCourse(5,"a"));
        programme.addActivity(new BasicCourse(5,"a"));
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
        assertFalse(programme.valid());
    }

    @Test
    void  duplicateProject() throws Exception {
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
        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void NotEnoughECTS() throws Exception {
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

        programme.addActivity(new ElectiveCourse(5,"aaa"));
        programme.addActivity(new ElectiveCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void TooManyECTS() throws Exception {
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
        programme.addActivity(new SubjectModuleCourse(10,"gg"));

        programme.addActivity(new ElectiveCourse(5,"aaa"));
        programme.addActivity(new ElectiveCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void NotEnoughProjects() throws Exception {
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

        programme.addActivity(new ElectiveCourse(5,"aaa"));
        programme.addActivity(new ElectiveCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void TooManyCourses() throws Exception {
        BachelorProgramme programme = new BachelorProgramme();
        programme.addActivity(new BasicCourse(5,"a"));
        programme.addActivity(new BasicCourse(5,"b"));
        programme.addActivity(new BasicCourse(5,"c"));
        programme.addActivity(new BasicCourse(5,"d"));
        programme.addActivity(new BasicCourse(5,"e"));
        programme.addActivity(new BasicCourse(5,"f"));
        programme.addActivity(new BasicCourse(5,"g"));
        programme.addActivity(new BasicCourse(5,"h"));
        programme.addActivity(new BasicCourse(5,"i"));

        programme.addActivity(new SubjectModuleCourse(5,"aa"));
        programme.addActivity(new SubjectModuleCourse(5,"bb"));
        programme.addActivity(new SubjectModuleCourse(5,"cc"));
        programme.addActivity(new SubjectModuleCourse(5,"dd"));
        programme.addActivity(new SubjectModuleCourse(5,"ee"));
        programme.addActivity(new SubjectModuleCourse(5,"ff"));
        programme.addActivity(new SubjectModuleCourse(5,"gg"));
        programme.addActivity(new SubjectModuleCourse(5,"hh"));
        programme.addActivity(new SubjectModuleCourse(5,"ii"));

        programme.addActivity(new ElectiveCourse(5,"aaa"));
        programme.addActivity(new ElectiveCourse(5,"bbb"));
        programme.addActivity(new ElectiveCourse(5,"ccc"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void TooFewCourses() throws Exception {
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
        programme.addActivity(new SubjectModuleCourse(10,"dd"));
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
        assertFalse(programme.valid());
    }

    @Test
    void AllBasicProjects() throws Exception {
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

        programme.addActivity(new BasicProject("aaaaa"));
        programme.addActivity(new BasicProject("bbbbb"));

        programme.addActivity(new BasicProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void AllSubModProjects() throws Exception {
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

        programme.addActivity(new SubejctModuleProject("aaaa"));
        programme.addActivity(new SubejctModuleProject("bbbb"));
        programme.addActivity(new SubejctModuleProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new SubejctModuleProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void AllBachelorProjects() throws Exception {
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

        programme.addActivity(new BachelorProject("aaaa"));
        programme.addActivity(new BachelorProject("bbbb"));
        programme.addActivity(new BachelorProject("cccc"));

        programme.addActivity(new BachelorProject("aaaaa"));
        programme.addActivity(new BachelorProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void AllBasicCourses() throws Exception {
        BachelorProgramme programme = new BachelorProgramme();
        programme.addActivity(new BasicCourse(5,"a"));
        programme.addActivity(new BasicCourse(5,"b"));
        programme.addActivity(new BasicCourse(5,"c"));
        programme.addActivity(new BasicCourse(5,"d"));
        programme.addActivity(new BasicCourse(5,"e"));
        programme.addActivity(new BasicCourse(5,"f"));
        programme.addActivity(new BasicCourse(5,"g"));
        programme.addActivity(new BasicCourse(5,"h"));

        programme.addActivity(new BasicCourse(5,"aa"));
        programme.addActivity(new BasicCourse(5,"bb"));
        programme.addActivity(new BasicCourse(5,"cc"));
        programme.addActivity(new BasicCourse(5,"dd"));
        programme.addActivity(new BasicCourse(5,"ee"));
        programme.addActivity(new BasicCourse(5,"ff"));
        programme.addActivity(new BasicCourse(5,"gg"));
        programme.addActivity(new BasicCourse(5,"hh"));

        programme.addActivity(new BasicCourse(5,"aaa"));
        programme.addActivity(new BasicCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void AllSubModCourses() throws Exception {
        BachelorProgramme programme = new BachelorProgramme();
        programme.addActivity(new SubjectModuleCourse(5,"a"));
        programme.addActivity(new SubjectModuleCourse(5,"b"));
        programme.addActivity(new SubjectModuleCourse(5,"c"));
        programme.addActivity(new SubjectModuleCourse(5,"d"));
        programme.addActivity(new SubjectModuleCourse(5,"e"));
        programme.addActivity(new SubjectModuleCourse(5,"f"));
        programme.addActivity(new SubjectModuleCourse(5,"g"));
        programme.addActivity(new SubjectModuleCourse(5,"h"));

        programme.addActivity(new SubjectModuleCourse(5,"aa"));
        programme.addActivity(new SubjectModuleCourse(5,"bb"));
        programme.addActivity(new SubjectModuleCourse(5,"cc"));
        programme.addActivity(new SubjectModuleCourse(5,"dd"));
        programme.addActivity(new SubjectModuleCourse(5,"ee"));
        programme.addActivity(new SubjectModuleCourse(5,"ff"));
        programme.addActivity(new SubjectModuleCourse(5,"gg"));
        programme.addActivity(new SubjectModuleCourse(5,"hh"));

        programme.addActivity(new SubjectModuleCourse(5,"aaa"));
        programme.addActivity(new SubjectModuleCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }

    @Test
    void AllElectiveCourses() throws Exception {
        BachelorProgramme programme = new BachelorProgramme();
        programme.addActivity(new ElectiveCourse(5,"a"));
        programme.addActivity(new ElectiveCourse(5,"b"));
        programme.addActivity(new ElectiveCourse(5,"c"));
        programme.addActivity(new ElectiveCourse(5,"d"));
        programme.addActivity(new ElectiveCourse(5,"e"));
        programme.addActivity(new ElectiveCourse(5,"f"));
        programme.addActivity(new ElectiveCourse(5,"g"));
        programme.addActivity(new ElectiveCourse(5,"h"));

        programme.addActivity(new ElectiveCourse(5,"aa"));
        programme.addActivity(new ElectiveCourse(5,"bb"));
        programme.addActivity(new ElectiveCourse(5,"cc"));
        programme.addActivity(new ElectiveCourse(5,"dd"));
        programme.addActivity(new ElectiveCourse(5,"ee"));
        programme.addActivity(new ElectiveCourse(5,"ff"));
        programme.addActivity(new ElectiveCourse(5,"gg"));
        programme.addActivity(new ElectiveCourse(5,"hh"));

        programme.addActivity(new ElectiveCourse(5,"aaa"));
        programme.addActivity(new ElectiveCourse(5,"bbb"));

        programme.addActivity(new BasicProject("aaaa"));
        programme.addActivity(new BasicProject("bbbb"));
        programme.addActivity(new BasicProject("cccc"));

        programme.addActivity(new SubejctModuleProject("aaaaa"));
        programme.addActivity(new SubejctModuleProject("bbbbb"));

        programme.addActivity(new BachelorProject("aaaaaa"));
        assertFalse(programme.valid());
    }
}
