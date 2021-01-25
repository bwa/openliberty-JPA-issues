package no.bwa.ladekalkulator.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Historikk")

public class Historikk implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length=36)
    private String id;   
    
    @Column(length=36)
    public String deviceId;   

    double batteriKapasitet; //kW
    double ladeHastighet; //kW/h
    int startSOC; //prosent heltall
    int sluttSOC; //prosent heltall 
    int ladetid; // i sekunder

    @ManyToOne
//    @ManyToOne(optional=false)
//    @JoinColumn(name="deviceId",referencedColumnName="deviceId")

//    @JoinColumn(name="id",referencedColumnName="deviceId")
//    @JoinColumn(name="deviceId")
    public Device device;

    
    public Historikk() {

    }

    public Historikk(
        Device device,
        String deviceId, // uuid
        double batteriKapasitet, //kW
        double ladeHastighet, //kW/h
        int startSOC, //prosent heltall
        int sluttSOC, //prosent heltall 
        int ladetid) {
        this.device = device;
        this.id = UUID.randomUUID().toString();
        this.deviceId = deviceId;
        this.batteriKapasitet = batteriKapasitet;
        this.ladeHastighet = ladeHastighet;
        this.startSOC = startSOC;
        this.sluttSOC = sluttSOC;
        this.ladetid = ladetid;

    }

    @Override
	public String toString() {
		return "Historikk [id=" + id + ", deviceId=" + deviceId + ", batteriKapasitet=" + batteriKapasitet
				+ ", ladeHastighet=" + ladeHastighet + ", startSOC=" + startSOC + ", sluttSOC=" + sluttSOC
				+ ", ladetid=" + ladetid + ", device=" + device + "]";
	}
    
}