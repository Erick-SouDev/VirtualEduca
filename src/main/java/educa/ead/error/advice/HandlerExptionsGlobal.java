package educa.ead.error.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerExptionsGlobal extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ DataIntegrityViolationException.class })
	protected ModelAndView handlerExeptionDataIntegri(Exception e) {
		ModelAndView andView = new ModelAndView("aluno");
		ExepetionErroExisteUser erroExisteUser = new ExepetionErroExisteUser();
		
		System.out.println(e.getMessage());
		return andView;
		
	
		
	

	}
}
