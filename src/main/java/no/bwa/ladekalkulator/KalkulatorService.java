package no.bwa.ladekalkulator;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import no.bwa.ladekalkulator.entity.Device;
import no.bwa.ladekalkulator.entity.Historikk;

@Singleton
public class KalkulatorService {
    private static final Logger log = LoggerFactory.getLogger(KalkulatorService.class);	

    @Inject
    private PersistenceService persistenceService;

    
    public KalkulatorService(PersistenceService persistenceService) {
        log.info("KalkulatorService(PersistenceService) initialisert med persistenceService: {}", persistenceService);
        this.persistenceService = persistenceService;
    }
    
    public KalkulatorService() {
        log.info("KalkulatorService() initialisert med CDI default persistenceService");
    }


    public boolean addDevice(String uuid, LocalDateTime expires) {
        return persistenceService.addDevice(uuid, expires);
    }

    public boolean addDevice(Device device) {
        log.info("KalkulatorService: {} persistenceService: {} addDevice", this, persistenceService);
        return persistenceService.addDevice(device);
    }

    public List<Device> getDevices() {
        return persistenceService.getDevices();
    }

    public Device getDevice(String id) {
        return persistenceService.getDevice(id);
    }

    public boolean addHistoric(Historikk historic) {
        persistenceService.addHistorikk(historic);
        log.info("addHistoric ...Done {}", historic);
        return true;
    }

    public boolean test() {
        persistenceService.Test();
        return true;
    }

}
