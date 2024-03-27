package educa.ead.util;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerarMatricula {
	
	
	private static Logger LOGGER = Logger.getGlobal();

	public static String generateMatricularAluno() {
		Random random = new Random();
		long numeroAleatorio = 0;
		try {
		 numeroAleatorio = (long) random.nextLong(100000000);
		}catch (RuntimeException e) {
			// TODO: handle exception
			LOGGER.log(Level.INFO, " ERRO NA CRIAÇÃO DA MATRICULA " + e);
		}
		return String.valueOf(numeroAleatorio);
	}

}
