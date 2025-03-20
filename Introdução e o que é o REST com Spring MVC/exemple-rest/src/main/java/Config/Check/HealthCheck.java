package Config.Check;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class HealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        try{
            InetAddress address= InetAddress.getByName("localhostsdsa");
            if (address.isReachable(10000)){
                return Health.up().build();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            return Health.down().withDetail("Motivo", e.getMessage()).build();
        }
        return Health.down().withDetail("Motivo", "Motivo desconhecido").build();
    }
}
