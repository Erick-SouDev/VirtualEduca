package educa.ead.controles;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import educa.ead.modelos.Aluno;
import educa.ead.services.ServicesJpaRepositoyAluno;
import educa.ead.util.GerarMatricula;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class ControlerAluno {

	private PasswordEncoder bCryptPasswordEncoder;
	private static Logger LOGGER = Logger.getGlobal();

	public ControlerAluno(PasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Autowired
	private ServicesJpaRepositoyAluno servicesJpaRepositoyAluno;

	@GetMapping("/aluno")
	public ModelAndView pageAluno() {
		ModelAndView modeView = new ModelAndView("aluno");
		modeView.addObject("aluno", new Aluno());
		return modeView;
	}
	@PostMapping("/create")
	public ModelAndView save(@Valid Aluno aluno, BindingResult bindingResult) {
		ModelAndView view = new ModelAndView("aluno");
		String menssagem = "";
		try {
			if (bindingResult.hasErrors()) {return view;}

			aluno.setMatricula(GerarMatricula.generateMatricularAluno());
			Aluno alunoSalvo = servicesJpaRepositoyAluno.saveAluno(aluno);
			if (aluno != null) {menssagem = "Usuario Salvo Com Sucesso!";}

		} catch (DataIntegrityViolationException e) {
			LOGGER.log(Level.INFO , e.getMessage());
			e.printStackTrace();
			menssagem = "Error! Usuario Ja Existe";

		}
		view.addObject("messagem", menssagem);
		view.addObject("aluno", new Aluno());
		return view;
	}
}
