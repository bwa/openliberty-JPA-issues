package no.bwa.ladekalkulator.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
//import javax.persistence.GenerationType;

@Entity
@Table(name = "Device")
@NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d")
@NamedQuery(name = "Device.findDevice", query = "SELECT d FROM Device d WHERE d.id = :id")
public class Device implements Serializable{

 private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id", length=36)
    private String id;    

    @Column(name = "expires", nullable=false)
    private Timestamp expires;

    //             kolonne i fremmedtabell
    //@OneToMany(targetEntity=Historikk.class)
    //@OneToMany(mappedBy="Historikk.deviceId",targetEntity=Historikk.class,fetch=FetchType.EAGER)
    //@OneToMany(mappedBy="Historikk.deviceId", fetch=FetchType.EAGER)
    @OneToMany(fetch=FetchType.EAGER)
    //@Transient
    private Collection<Historikk> historic;

    public Device() {
        this.id = UUID.randomUUID().toString();
        this.expires = Timestamp.valueOf(LocalDateTime.now());

    }

    public Device(String uuid, LocalDateTime timestamp) {
        this.id = uuid;
        this.expires = Timestamp.valueOf(timestamp);

    }

    @Override
	public String toString() {
		return "Device [id=" + id + ", expires=" + expires + ", historic=" + historic + "]";
	}

    public Collection<Historikk> getHistoric() {
        return historic;
    }


    
    
    

    
}