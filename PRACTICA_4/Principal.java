package PRACTICA_4;
import java.util.*;
public class Principal {

	public static void main(String[] args) {
		Scanner lector=new Scanner(System.in);
		
		System.out.println("¿Cuantas contraseñas vas a generar?: ");
		int tamañoPassword=lector.nextInt();
		
		Password[] Passwords=new Password[tamañoPassword];
		
		System.out.println("Ingrese la longitud de las contraseñas generar: ");
		int longitud=lector.nextInt();
		
		boolean [] fuerteContra=new boolean[tamañoPassword];
		
		for(int i=0;i<Passwords.length;i++) {
			Passwords[i]=new Password(longitud);
			fuerteContra[i]=Passwords[i].esFuerte();
			System.out.println(Passwords[i].getContraseña()+" #"+(1+i)+" ¿es fuerte?____"+fuerteContra[i]);
		}
		lector.close();
	}
}