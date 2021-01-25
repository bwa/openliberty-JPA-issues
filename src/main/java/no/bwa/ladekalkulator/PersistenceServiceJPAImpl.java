package no.bwa.ladekalkulator;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import no.bwa.ladekalkulator.entity.Device;
import no.bwa.ladekalkulator.entity.Historikk;
import no.bwa.ladekalkulator.entity.Test;

@RequestScoped
@Default // betyr at CDI bruker denne som default impl av  PersistenceService
public class PersistenceServiceJPAImpl implements PersistenceService {

    private static final Logger log = LoggerFactory.getLogger(PersistenceServiceJPAImpl.class);


    @PersistenceContext(name = "jpa-presistenceunit")
    private EntityManager em;

    public PersistenceServiceJPAImpl() {
        log.debug("PersistenceServiceJPAImpl created ... {}", this);
    }

    @Override
    public boolean addDevice(Device device) {
        log.info("addDevice(device) ...{}", device);
        em.persist(device);
        log.info("addDevice(device) ...Done");
        return true;
    }

    @Override
    public boolean addDevice(String uuid, LocalDateTime timestamp) {
        log.info("addDevice ... {} {}", uuid, timestamp);
        em.persist(new Device(uuid, timestamp));
        log.info("addDevice ...Done");
        return true;
    }

    @Override
    public boolean deleteDevice(String deviceID) {
        return false;
    }


    @Override
    public Device getDevice(String id) {
        
        log.info("JPA getDevice {} ...",id);
        try {

            TypedQuery<Device> q = 
                em.createQuery("SELECT d FROM Device d "
                +"WHERE d.id = :id"
                ,Device.class);

            List<Device> _devices =  q
                .setParameter("id", id)
                .getResultList();
            
            log.info("getDevice OK: {}", _devices);
            if(_devices.size()>0)
                return _devices.get(0);
            else 
                return null;
        } catch (NoResultException e) {
            log.warn("ingen device funnet for {}", id);
            return null;
        }

    }


    @Override
    public List<Device> getDevices() {

        log.info("getDevices ... ");
        List<Device> devices = em.createNamedQuery("Device.findAll", Device.class).getResultList();
        log.info("getDevices OK: {}", devices);
        return devices;
    }

    @Override
    public boolean addHistorikk(Historikk historikk) {
        em.persist(historikk);
        log.info("addHistoric ...Done {}", historikk);
        return true;
    }

	@Override
	public boolean Test() {
        log.info("Test2 START");
		
        Test test = new Test();
		 em.persist(test);
        
	    log.info("Test2 result {}", test);
		
        log.info("Test2 done");
		return false;
	}

    
}