package PRACTICA_4;

import java.util.Random;

public class Password {
	private final int LONGITUD_DEFECTO=8;
	private int longitud;
	private String contraseña;
	
	public Password(int longitud) {
		this.longitud = longitud > 0 ? longitud : LONGITUD_DEFECTO;
		contraseña=generarPassword(this.longitud);
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public String getContraseña() {
		return contraseña;
	}
	
	private String generarPassword(int longitud) {
		Random random=new Random();
		String Password="";
		
		//1 LETRAS MINUSCULAS  2 LET. MAYUSCULAS   3 NUMEROS
		for(int i=0;i<longitud;i++) {
			//ELIGIR ALEATORIAMENTE LOS CARACTER O NUMEROS
			int numeroRandom=1+random.nextInt(3);
			if(numeroRandom==1) {
				//ELIGE DEL O AL 26
				int minusRandom = random.nextInt(26);
				//PARA ENTENDER ESTO LE SUMA LA LETRA CON EL NUMERO TECLADO INGLES TIENE 26 CARCATER
				char letraMinus=(char)('a'+minusRandom);
				Password+=letraMinus;
			}
			else if(numeroRandom==2) {
				int mayusRandom = random.nextInt(26);
				char letraMayus=(char)('A'+mayusRandom);
				Password+=letraMayus;
			}
			else {
				int numerosRandom=0+random.nextInt(9);
				Password+=numerosRandom;
			}
		}
		return Password;
	}

	public boolean esFuerte() {
		int contadorNumeros=0;
		int contadorPalabrasMayu=0;
		int contadorPalabrasMinus=0;
		
		for(int i=0;i<contraseña.length();i++) {
			//VERIFICA SI EL CARACTER ESTA ENTRE LOS VALORES ASCII
			if(contraseña.charAt(i)>=97 && contraseña.charAt(i)<=122) {
				contadorPalabrasMinus+=1;
			}
			else if(contraseña.charAt(i)>=65 && contraseña.charAt(i)<=90){
					contadorPalabrasMayu+=1;
			}
			else {
				contadorNumeros+=1;
			}
		}
		return (contadorPalabrasMayu>=2 && contadorPalabrasMinus>=1 && contadorNumeros>=5)?true:false;
	}
}
