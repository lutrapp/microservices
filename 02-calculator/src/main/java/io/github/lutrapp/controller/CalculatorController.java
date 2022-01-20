package io.github.lutrapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.lutrapp.exception.UnsuportedOperationException;

@RestController
public class CalculatorController {
	
	@RequestMapping(value="sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Please set a numeric value");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	@RequestMapping(value="subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Please set a numeric value");
		}
		Double subtraction = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return subtraction;
	}
	
	@RequestMapping(value="division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Please set a numeric value");
		}
		Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return division;
	}
	
	@RequestMapping(value="multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Please set a numeric value");
		}
		Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multiplication;
	}
	
	@RequestMapping(value="average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Please set a numeric value");
		}
		Double average = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		return average;
	}
	
	@RequestMapping(value="potentiation/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double potentiation(@PathVariable("numberOne")String numberOne, @PathVariable("numberTwo")String numberTwo) throws Exception {
		if(!isNumeric(numberOne)|| !isNumeric(numberTwo)) {
			throw new UnsuportedOperationException("Please set a numeric value");
		}
		Double potentiation = Math.pow(convertToDouble(numberOne), convertToDouble(numberTwo));
		return potentiation;
	}

	@RequestMapping(value="square/{numberOne}", method = RequestMethod.GET)
	public Double square(@PathVariable("numberOne")String numberOne) throws Exception {
		if(!isNumeric(numberOne)) {
			throw new UnsuportedOperationException("Please set a numeric value");
		}
		Double square = Math.sqrt(convertToDouble(numberOne));
		return square;
	}
	
	
	//exception para analisar se tem dois parâmetros
	@RequestMapping(value="sum/{numberOne}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne")String numberOne) throws Exception {
			throw new UnsuportedOperationException("Please set two parameters");
	}

	private Double convertToDouble(String strNumber) {
		if(strNumber ==null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber ==null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
