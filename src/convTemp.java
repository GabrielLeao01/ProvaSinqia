
import java.util.InputMismatchException;
import java.util.Scanner;
public class convTemp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//try usado para tratar a exceção input.mismatch, que acontece quando é inserido um parâmetro que não pode ser utilizado na variável double
		try {
			
			System.out.println("Bem vindo, favor inserir a quantidade de temperaturas em que deseja transformar");
			int qtdTemp = sc.nextInt();
			double[] tempIni;
			double[] tempFim;
			tempIni = new double[qtdTemp];
			tempFim = new double[qtdTemp];
			//laço para serem lidas todas as temperaturas iniciais
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
				//condicional para conversão de celsius para fahrenheit			
				if(unidOrigem.equals("celsius") && unidFinal.equals("fahrenheit")) {
					for(int i = 0;i<tempFim.length;i++) {
						tempFim[i]=tempIni[i]*1.8+32;
						ind=0;
					}
				}
				else //condicional para conversão de celsius para kelvin
					if(unidOrigem.equals("celsius") && unidFinal.equals("kelvin")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=tempIni[i]+273.15;
							ind=0;
						}
					}
				else //condicional para conversão de fahrenheit para celsius
					if(unidOrigem.equals("fahrenheit") && unidFinal.equals("celsius")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=(tempIni[i]-32)/1.8;
							ind=0;
						}
					}
				else //condicional para conversão de fahrenheit para kelvin
					if(unidOrigem.equals("fahrenheit") && unidFinal.equals("kelvin")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=(tempIni[i]-32)/1.8+273.15;
							ind=0;
						}
					}
				else //condicional para conversão de kelvin para celsius
					if(unidOrigem.equals("kelvin") && unidFinal.equals("celsius")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=tempIni[i]-273.15;
							ind=0;
						}
					}
				else  //condicional para conversão de kelvin para fahrenheit
					if(unidOrigem.equals("kelvin") && unidFinal.equals("fahrenheit")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=(tempIni[i]-273.15)*1.8+32;
							ind=0;
						}
					}
				else
				{	//caso tenha algum erro na escrita, o laço sera repetido
					System.err.printf("Erro: temperatura invalida, confira se você escreveu a unidade igual está nos parenteses\n");
					System.out.println("Insira a unidade de origem (kelvin, celsius, fahrenheit):");
					unidOrigem = sc.next();
					System.out.println("Insira a unidade final(kelvin, celsius, fahrenheit):");
					unidFinal = sc.next();
				}
				}
			//variaveis para calcular média das temperaturas iniciais e finais
			double mediaIni=tempIni[0];
			double mediaFim=tempFim[0];
			// laço para fazer o calculo do somatório das temperaturas
			for(int i=1;i<tempFim.length;i++)
			{
				mediaIni+=tempIni[i];
				mediaFim+=tempFim[i];
			}
			// divisão para fazer o calculo da média
			mediaIni=mediaIni/tempIni.length;
			mediaFim=mediaFim/tempFim.length;
			System.out.printf("Temperatura em %s            Temperatura em %s\n\n ",unidOrigem,unidFinal );
			// laço para imprimir todas temperaturas
			for(int i=0;i<tempFim.length;i++)
			{		
				System.out.printf("%.2f            %.2f\n",tempIni[i],tempFim[i]);
			}
			
			System.out.printf("A media da temperatura inicial é %.2f e a media da temperatura final é %.2f",mediaIni,mediaFim);
			sc.close();
			}
		catch(InputMismatchException e) {
			System.err.printf("Erro, o formato inserido é diferente de double");
		
		}
	
	}
	
}
