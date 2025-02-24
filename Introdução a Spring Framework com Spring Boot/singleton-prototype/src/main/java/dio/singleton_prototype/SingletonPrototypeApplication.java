package dio.singleton_prototype;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SingletonPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingletonPrototypeApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(SistemaMensagem sistemaMensagem) throws RuntimeException{
		return args -> {
			sistemaMensagem.enviarConfirmacaoCadastro();
			sistemaMensagem.enviarMensagemBoasVindas();
			sistemaMensagem.enviarConfirmacaoCadastro();
		};
	}

}
