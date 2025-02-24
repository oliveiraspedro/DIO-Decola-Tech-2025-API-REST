package dio.singleton_prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Diz que essa classe deve ser instânciada e gerenciada automaticamente pelo Spring Container
public class SistemaMensagem {

    @Autowired
    private Remetente noreply;

    @Autowired
    private Remetente techTeam;

    public void enviarConfirmacaoCadastro(){
        System.out.println(noreply);
        System.out.println("Seu cadastrio foi aprovado");
    }

    public void enviarMensagemBoasVindas(){
        techTeam.setEmail("tech@dio.com.br");
        System.out.println(techTeam);
        System.out.println("Boas-Vindas " + techTeam.getNome());
    }
}
