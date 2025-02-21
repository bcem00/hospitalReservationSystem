package crsystem;

import java.io.*;
import java.util.*;

public class CRS implements Serializable {
    private static final long serialVersionUID=99;
    private HashMap<Long, Patient> patients;
    private LinkedList<Rendezvous> rendezvous;
    private HashMap<Integer, Hospital> hospitals;

    public CRS() {
        this.patients = new HashMap<Long,Patient>();
        this.rendezvous = new LinkedList<Rendezvous>();
        this.hospitals = new HashMap<Integer,Hospital>();
    }

    public boolean makeRendezvous(int hospitalID, long nationalId, int sectionId, int diplomaId, Date desiredDate) {
        Patient patient = patients.get(nationalId);
        if (patient == null) {
            throw new IDException("Patient with National ID " + nationalId + " not found");
        }
        
        
        Hospital hospital= hospitals.get(hospitalID);
        if (hospital == null) {
            throw new IDException("Hospital with ID " + hospitalID + " not found");
        }

        Section section = hospitals.get(hospitalID).getSection(sectionId);
        Doctor doctor = section.getDoctor(diplomaId);
        if (doctor == null) {
            throw new IDException("Doctor with Diploma ID " + diplomaId + " not found");
        }

        if (doctor.getSchedule().addRendezvous(patient, desiredDate ,doctor)) {
            Rendezvous newRendezvous = new Rendezvous(desiredDate, patient, doctor);
            rendezvous.add(newRendezvous);
            return true;
        }
        
        
        return false;
    }

    public void addPatient(Patient patient) {
        int flag=0;
        for (Patient p: patients.values()){
            if(p.getNationalId()==patient.getNationalId()){
                flag++;
                throw new DuplicateInfoException("Patient with ID " + p.getNationalId() + " already exists");
            }
        }
        
        if(flag==0){
            patients.put(patient.getNationalId(), patient);
        }
        
    }

    public void addHospital(Hospital hospital) {
        for (Hospital h : hospitals.values()) {
            if (h.getId() == hospital.getId()) {
                throw new DuplicateInfoException("Hospital with ID " + hospital.getId() + " already exists");
            }
        }
        hospitals.put(hospital.getId(), hospital);
    }
    
    public Hospital getHospital(String name) {
        for (Hospital hospital : hospitals.values()) {
            if (hospital.getName().equals(name)) {
                return hospital;
            }
        }
        throw new IDException("Hospital with the name "+ name + " not found");
    }


    public Hospital getHospital(int id) {
        for (Hospital hospital : hospitals.values()) {
            if (hospital.getId() == id) {
                return hospital;
            }
        }
        throw new IDException("Hospital with ID " + id + " not found");
    }


    public void saveToFile(String fullPath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullPath))) {
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String fullPath) throws ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fullPath))) {
            CRS crs=(CRS)ois.readObject();
            
            patients=crs.getPatients();
            rendezvous=crs.getRendezvous();
            hospitals=crs.getHospitals();
            
        } catch (IOException e) {
            throw new RuntimeException("Error loading from file: " + e.getMessage());
        }
    }

    public HashMap<Integer,Hospital> getHospitals() {
        return hospitals;
    }
    
    public String listHospitals(){
        String all = "";
        
        for(Hospital h: hospitals.values()){
            all+=h.getId()+"\t"+h.getName()+"\t\t"+h.getSections().size()+"\n";
        }
        
        return all;
        
    }
    
    public Patient getPatient(long id){
        for(Patient p: getPatients().values()){
            if(p.getNationalId()==id){
                return p;
            }
        }
        return null;
    }
    
    public int getHospitalSize(){
        return hospitals.size();
    }

    public HashMap<Long, Patient> getPatients() {
        return patients;
    }

    public LinkedList<Rendezvous> getRendezvous() {
        return rendezvous;
    }
}