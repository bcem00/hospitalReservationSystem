package crsystem;

public class Doctor extends Person {
    private final int diploma_id;
    private Schedule schedule;

    public Doctor(String name, long national_id, int diploma_id) {
        super(name, national_id);
        this.diploma_id = diploma_id;
        this.schedule = new Schedule(20);
    }

    public int getDiplomaId() {
        return diploma_id;
    }

    public Schedule getSchedule() {
        return schedule;
    }
    
    public void setSchedule(Schedule schedule){
        this.schedule=schedule;
    }

    @Override
    public String toString() {
        return super.toString() + "\t"+  diploma_id;
    }


}
