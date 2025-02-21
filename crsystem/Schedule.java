package crsystem;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class Schedule implements Serializable {
    private LinkedList<Rendezvous> sessions;
    private int maxPatientPerDay;
    private Doctor doctor;

    public Schedule(int maxPatientPerDay) {
        this.maxPatientPerDay = maxPatientPerDay;
        this.sessions = new LinkedList<>();
        this.doctor=null;
    }

    public boolean addRendezvous(Patient patient, Date desired_date,Doctor doctor) {
        Calendar desiredCal = Calendar.getInstance();
        desiredCal.setTime(desired_date);

        int count = 0;
        for (Rendezvous r : sessions) {
            Calendar existingCal = Calendar.getInstance();
            existingCal.setTime(r.getDateTime());

            if (existingCal.get(Calendar.YEAR) == desiredCal.get(Calendar.YEAR) &&
                    existingCal.get(Calendar.DAY_OF_YEAR) == desiredCal.get(Calendar.DAY_OF_YEAR)) {
                count++;
            }
        }

        if (count >= maxPatientPerDay) {
            return false;
        }

        Rendezvous newRendezvous = new Rendezvous(desired_date, patient,doctor);
        sessions.add(newRendezvous);
        return true;
    }

    public LinkedList<Rendezvous> getSessions() {
        return sessions;
    }
    
    public void setDoctor(Doctor doctor){
        this.doctor=doctor;
    }
    public int getMaxPatientsPerDay(){
        return maxPatientPerDay;
    }
}