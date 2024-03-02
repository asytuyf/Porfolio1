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

    public int getEcts(){
        return ectsPoints;
    }

    public String getName(){
        return name;
    }

    public types getType(){
        return type;
    }

}
