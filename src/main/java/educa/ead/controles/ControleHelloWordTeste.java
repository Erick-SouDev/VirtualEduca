package educa.ead.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/ead"})
public class ControleHelloWordTeste {

	
	@GetMapping(value = "/helloWord")
	public String testeHelloWord() {
		
		return "";
		
	}
}
