package educa.ead.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import educa.ead.modelos.Aluno;
import educa.ead.modelos.Professor;

@Controller

public class ControlerLogin {

	@GetMapping("/")
	public ModelAndView pageInicial() {
		ModelAndView modeView = new ModelAndView("login");
		return modeView;
	}
	


	
}
