/**
 * A class to represent an activity
 */
public abstract class Activity {

    int ectsPoints;
    String name;

    types type;


    public Activity(int ectsPoints, String name){
        this.ectsPoints = ectsPoints;
        this.name = name;
    }

    public void setType(types type){
        this.type = type;
    }
    public enum types {
        BASIC,
        SUBJECT_MODULE,
        ELECTIVE,
        BACHELOR_PROJECT
    }

    public boolean sameActivity(Activity otherActivityName){
        return name.equals(otherActivityName.getName());
    }

    /**
     * Returns number of ects
     * @return number of ects
     */
    public int getEcts(){
        return ectsPoints;
    }

    /**
     * Returns name of the the course or project
     * @return name of the the course or project
     */
    public String getName(){
        return name;
    }

    /**
     * Returns type of project or course
     * @return type of project or course
     */
    public types getType(){
        return type;
    }

}
