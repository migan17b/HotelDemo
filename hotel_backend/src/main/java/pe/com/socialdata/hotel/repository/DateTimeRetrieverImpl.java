package pe.com.socialdata.hotel.repository;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;



/**
 * Avoids problems caused by diferences in time between server(s) and database
 */
@Service
public class DateTimeRetrieverImpl implements DateTimeRetriever {

    @Override
    public Date currentTime() {
        return new Timestamp(System.currentTimeMillis()); //TODO JCM implement ofr time sync betwen servers
    }
}
