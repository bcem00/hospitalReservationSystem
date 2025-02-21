package crsystem;

import java.io.Serializable;
import java.util.LinkedList;

public class Hospital implements Serializable {
    private final int id;
    private String name;
    private LinkedList<Section> sections;

    public Hospital(int id, String name) {
        this.id = id;
        this.name = name;
        this.sections = new LinkedList<>();
    }
    
    public String listSections(){
        String all="";
        for(Section a: sections){
            all+=a.toString();
            all+="\n";
        }
        
        return all;          
    }

    public Section getSection(int id) {
        for (Section section : sections) {
            if (section.getId() == id) {
                return section;
            }
        }
        throw new IDException("Section with ID " + id + " not found");
    }

    public Section getSection(String name) {
        for (Section section : sections) {
            if (section.getName().equals(name)) {
                return section;
            }
        }
        throw new IDException("Section with name " + name + " not found");
    }

    public LinkedList<Section> getSections() {return sections;}

    public int getId() {return id;}

    public String getName() {return name;}

    public void addSection(Section section) {
        int flag=0;
        for(Section s: sections){
            if(s.getId()==section.getId()){
                flag++;
                throw new DuplicateInfoException("Section already exists");
            }
        }
        
        if(flag==0){
            sections.add(section);
        }else{
            section=null;
        }
        
        
    }

    public String toString() {return id  + "\t" +  name +"\t\t" +sections.size() ;}
}