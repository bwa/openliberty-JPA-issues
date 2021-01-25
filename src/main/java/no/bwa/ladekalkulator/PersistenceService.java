package no.bwa.ladekalkulator;

import java.time.LocalDateTime;
import java.util.List;

import no.bwa.ladekalkulator.entity.Device;
import no.bwa.ladekalkulator.entity.Historikk;

public interface PersistenceService {

    public boolean addDevice(String deviceID, LocalDateTime timestamp);
    public boolean addDevice(Device device);

    public List<Device> getDevices();
    public Device getDevice(String id);

    public boolean deleteDevice(String deviceID);

    public boolean addHistorikk(Historikk historikk);

    public boolean Test();
    
}