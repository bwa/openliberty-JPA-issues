package no.bwa.ladekalkulator;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/")
@PermitAll()
@Singleton
public class KalkulatorResource {
	
    private static final Logger log = LoggerFactory.getLogger(KalkulatorResource.class);	

	@Inject
    KalkulatorService service;
    

    public KalkulatorResource() {
        log.debug("KalkulatorResource created ... {}", this);
    }

    @GET
	@Path("/test")
    @PermitAll()

    @Transactional 

	public Response test2(
        @Context HttpServletRequest request
    ) {
        log.info("TEST START");
        service.test();
        log.info("TEST SLUTT");

        return Response
            .ok("Test Ok")
            .build();

    }

    
   



}
