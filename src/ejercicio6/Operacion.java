package ejercicio6;

public class Operacion {
	private String operacion = "";
	private String operador = "";
	private double operNums;
	
	public String dameResultado(String calc) {
		operacion = calc;
		String[] numeros;
		
			if(calc.contains("+")) {
				operador = "+";
				numeros = calc.split(" \\+ ");
				operNums = Double.parseDouble(numeros[0]) + Double.parseDouble(numeros[1]);
				return " = " + String.valueOf(operNums);
			
			}else if(calc.contains("-")) {
				operador = "-";
				numeros = calc.split(" \\- ");
				operNums = Double.parseDouble(numeros[0]) - Double.parseDouble(numeros[1]);
				return " = " + String.valueOf(operNums);
			}
			else if(calc.contains("*")) {
				operador = "*";
				numeros = calc.split(" \\* ");
				operNums = Double.parseDouble(numeros[0]) * Double.parseDouble(numeros[1]);
				return " = " + String.valueOf(operNums);
			}
			else if(calc.contains("/")) {
				operador = "/";
				numeros = calc.split(" \\/ ");
				operNums = Double.parseDouble(numeros[0]) / Double.parseDouble(numeros[1]);
				return " = " + String.valueOf(operNums);
			}else {
				return operacion.replace("+", "").replace("-", "").replace("*", "").replace("/", "");
			}
		
		
	}

	public String getOperador() {
		return operador;
	}
	
	public void vaciarOperador() {
		operador = "";
	}

	public String getOperacion() {
		return operacion;
	}
}
