package no.bwa.ladekalkulator.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Profile")

public class Profile implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "uuid", length=36)
    private String uuid;   
    
    @Column(name = "navn", length=200)
    private String navn;   

    @Transient
    private List<Device> devices;
    
    public Profile() {

    }

    public Profile(String uuid, String navn, Device device) {
        this.uuid = uuid;
        this.navn = navn;
    }

	@Override
	public String toString() {
		return "Profile [uuid=" + uuid + ", navn=" + navn + ", devices=" + devices + "]";
	}
    
}