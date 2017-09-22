package org.carrito.exception;
import static org.carrito.exception.ExceptionConstants.PARAMETER_VALUE_EXCEPTION;
public class ParameterException extends GenericException{

	private static final long serialVersionUID = 1L;

	public ParameterException (String error) {

		super(PARAMETER_VALUE_EXCEPTION);
		getExceptionBean().setMessage(String.format(PARAMETER_VALUE_EXCEPTION.getMessage(), error));


	}


}
