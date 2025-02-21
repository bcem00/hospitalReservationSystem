package crsystem;

import java.io.Serializable;
import java.util.Date;


@SuppressWarnings("deprecation")

public class Rendezvous implements Serializable {
    private Date dateTime;
    private Patient patient;
    private Doctor doctor;

    

    public Rendezvous(Date dateTime, Patient patient, Doctor doctor) {
        this.dateTime = dateTime;
        this.patient = patient;
        this.doctor=doctor;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }


    
    @Override
    public String toString(){
        return dateTime.getDay()+"/"+dateTime.getMonth()+"/"+dateTime.getYear() +"\t" + patient.toString() +"\t" + doctor.getName();
    }

  
}
