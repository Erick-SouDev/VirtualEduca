package educa.ead.handler.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HandlerExptionsGlobalError extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {

		ModelAndView view = new ModelAndView("error");
		view.addObject("exception", ex + HttpStatus.INTERNAL_SERVER_ERROR.name());
		return view;
	}

}
