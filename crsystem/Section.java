package crsystem;

import java.io.Serializable;
import java.util.LinkedList;

public class Section implements Serializable {
    private final int id;
    private String name;
    private LinkedList<Doctor> doctors;

    public Section(int id, String name) {
        this.id = id;
        this.name = name;
        this.doctors = new LinkedList<Doctor>();
    }

    public String listDoctors() {
        String all="";
        for (Doctor doctor : doctors) {
            all+=doctor.toString()+"\n";
        }
        return all;
    }

    public Doctor getDoctor(int diploma_id) {
        for (Doctor doctor : doctors) {
            if (doctor.getDiplomaId() == diploma_id) {
                return doctor;
            }
        }
        return null;
    }
    
    public Doctor getDoctor(long national_id) {
        for (Doctor doctor : doctors) {
            if (doctor.getNationalId() == national_id) {
                return doctor;
            }
        }
        return null;
    }
    
    public Doctor getDoctor(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName() == name) {
                return doctor;
            }
        }
        return null;
    }
    
    
    
    public int getDoctorCount(){return doctors.size();}

    public LinkedList<Doctor> getDoctors() {return doctors;}

    public void addDoctor(Doctor doctor) throws DuplicateInfoException {
        int flag=0;
        if (getDoctor(doctor.getDiplomaId()) != null ) {
            flag++;
            throw new DuplicateInfoException("Doctor with diploma ID " + doctor.getDiplomaId() + " already exists");
        }
        if(getDoctor(doctor.getNationalId()) != null){
            flag++;
            throw new DuplicateInfoException("Doctor with national ID " + doctor.getNationalId() + " already exists");   
        }
        
        if (flag==0)
        getDoctors().add(doctor);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return id +"\t" +name +"\t"+ getDoctorCount();
    }
}