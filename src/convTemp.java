
import java.util.InputMismatchException;
import java.util.Scanner;
public class convTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			
		System.out.println("Bem vindo, favor inserir a quantidade de temperaturas em que deseja transformar");
		int qtdTemp = sc.nextInt();
		
		
		double[] tempIni;
		double[] tempFim;
		tempIni = new double[qtdTemp];
		tempFim = new double[qtdTemp];
		
		for(int i = 0;i<tempIni.length;i++) {
			System.out.println("Insira a temperatura");
			tempIni[i]=sc.nextDouble();
		}
		int ind =1;//variavel contida no laço para dar a chance do usuário redigitar a temperatura em caso de erro
		System.out.println("Insira a unidade de origem (kelvin, celsius, fahrenheit):");
		String unidOrigem = sc.next();
		System.out.println("Insira a unidade final(kelvin, celsius, fahrenheit):");
		String unidFinal = sc.next();
		while(ind==1) {
						
			if(unidOrigem.equals("celsius") && unidFinal.equals("fahrenheit")) {
				for(int i = 0;i<tempFim.length;i++) {
					tempFim[i]=tempIni[i]*1.8+32;
					ind=0;
				}
			}
			else
				if(unidOrigem.equals("celsius") && unidFinal.equals("kelvin")) {
					for(int i = 0;i<tempFim.length;i++) {
						tempFim[i]=tempIni[i]+273.15;
						ind=0;
					}
				}
			else
				if(unidOrigem.equals("fahrenheit") && unidFinal.equals("celsius")) {
					for(int i = 0;i<tempFim.length;i++) {
						tempFim[i]=(tempIni[i]-32)/1.8;
						ind=0;
					}
				}
			else
				if(unidOrigem.equals("fahrenheit") && unidFinal.equals("kelvin")) {
					for(int i = 0;i<tempFim.length;i++) {
						tempFim[i]=(tempIni[i]-32)/1.8+273.15;
						ind=0;
					}
				}
			else
				if(unidOrigem.equals("kelvin") && unidFinal.equals("celsius")) {
					for(int i = 0;i<tempFim.length;i++) {
						tempFim[i]=tempIni[i]-273.15;
						ind=0;
					}
				}
			else
				if(unidOrigem.equals("kelvin") && unidFinal.equals("fahrenheit")) {
					for(int i = 0;i<tempFim.length;i++) {
						tempFim[i]=(tempIni[i]-273.15)*1.8+32;
						ind=0;
					}
				}
			else
			{
				System.err.printf("Erro: temperatura invalida, confira se você escreveu a unidade igual está nos parenteses\n");
				System.out.println("Insira a unidade de origem (kelvin, celsius, fahrenheit):");
				unidOrigem = sc.next();
				System.out.println("Insira a unidade final(kelvin, celsius, fahrenheit):");
				unidFinal = sc.next();
			}
			}
		double mediaIni=tempIni[0];
		double mediaFim=tempFim[0];
		for(int i=1;i<tempFim.length;i++)
		{
			mediaIni+=tempIni[i];
			mediaFim+=tempFim[i];
		}
		mediaIni=mediaIni/tempIni.length;
		mediaFim=mediaFim/tempFim.length;
		System.out.printf("Temperatura em %s            Temperatura em %s\n\n ",unidOrigem,unidFinal );
		for(int i=0;i<tempFim.length;i++)
		{
					
			System.out.printf("%.2f            %.2f\n",tempIni[i],tempFim[i]);
		}
		
		System.out.printf("A media da temperatura inicial é %.2f e a media da temperatura final é %.2f",mediaIni,mediaFim);
		sc.close();
		}
		catch(InputMismatchException e) {
			System.err.printf("Erro, formato errado inserido");
		
		}
	}
	
}
