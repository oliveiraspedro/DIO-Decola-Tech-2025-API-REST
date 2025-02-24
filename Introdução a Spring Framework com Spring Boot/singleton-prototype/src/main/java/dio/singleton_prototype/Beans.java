package dio.singleton_prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration //Informa ao Spring que essa classe possui configurações de Beans
public class Beans {

    @Bean
    @Scope("prototype")
    public Remetente remetente(){
        System.out.println("CRIANDO INSATÂNCIA DO OBJETO");
        Remetente remetente = new Remetente();
        remetente.setNome("Digital Innovation One");
        remetente.setEmail("noreply@dio.com.br");
        return remetente;
    }
}
