
import java.util.InputMismatchException;
import java.util.Scanner;
public class convTemp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//try usado para tratar a exce��o input.mismatch, que acontece quando � inserido um par�metro que n�o pode ser utilizado na vari�vel double
		try {
			
			System.out.println("Bem vindo, favor inserir a quantidade de temperaturas em que deseja transformar");
			int qtdTemp = sc.nextInt();
			double[] tempIni;
			double[] tempFim;
			tempIni = new double[qtdTemp];
			tempFim = new double[qtdTemp];
			//la�o para serem lidas todas as temperaturas iniciais
			for(int i = 0;i<tempIni.length;i++) {
				System.out.println("Insira a temperatura");
				tempIni[i]=sc.nextDouble();
			}
			int ind =1;//variavel contida no la�o para dar a chance do usu�rio redigitar a temperatura em caso de erro
			System.out.println("Insira a unidade de origem (kelvin, celsius, fahrenheit):");
			String unidOrigem = sc.next();
			System.out.println("Insira a unidade final(kelvin, celsius, fahrenheit):");
			String unidFinal = sc.next();
			while(ind==1) {
				//condicional para convers�o de celsius para fahrenheit			
				if(unidOrigem.equals("celsius") && unidFinal.equals("fahrenheit")) {
					for(int i = 0;i<tempFim.length;i++) {
						tempFim[i]=tempIni[i]*1.8+32;
						ind=0;
					}
				}
				else //condicional para convers�o de celsius para kelvin
					if(unidOrigem.equals("celsius") && unidFinal.equals("kelvin")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=tempIni[i]+273.15;
							ind=0;
						}
					}
				else //condicional para convers�o de fahrenheit para celsius
					if(unidOrigem.equals("fahrenheit") && unidFinal.equals("celsius")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=(tempIni[i]-32)/1.8;
							ind=0;
						}
					}
				else //condicional para convers�o de fahrenheit para kelvin
					if(unidOrigem.equals("fahrenheit") && unidFinal.equals("kelvin")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=(tempIni[i]-32)/1.8+273.15;
							ind=0;
						}
					}
				else //condicional para convers�o de kelvin para celsius
					if(unidOrigem.equals("kelvin") && unidFinal.equals("celsius")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=tempIni[i]-273.15;
							ind=0;
						}
					}
				else  //condicional para convers�o de kelvin para fahrenheit
					if(unidOrigem.equals("kelvin") && unidFinal.equals("fahrenheit")) {
						for(int i = 0;i<tempFim.length;i++) {
							tempFim[i]=(tempIni[i]-273.15)*1.8+32;
							ind=0;
						}
					}
				else
				{	//caso tenha algum erro na escrita, o la�o sera repetido
					System.err.printf("Erro: temperatura invalida, confira se voc� escreveu a unidade igual est� nos parenteses\n");
					System.out.println("Insira a unidade de origem (kelvin, celsius, fahrenheit):");
					unidOrigem = sc.next();
					System.out.println("Insira a unidade final(kelvin, celsius, fahrenheit):");
					unidFinal = sc.next();
				}
				}
			//variaveis para calcular m�dia das temperaturas iniciais e finais
			double mediaIni=tempIni[0];
			double mediaFim=tempFim[0];
			// la�o para fazer o calculo do somat�rio das temperaturas
			for(int i=1;i<tempFim.length;i++)
			{
				mediaIni+=tempIni[i];
				mediaFim+=tempFim[i];
			}
			// divis�o para fazer o calculo da m�dia
			mediaIni=mediaIni/tempIni.length;
			mediaFim=mediaFim/tempFim.length;
			System.out.printf("Temperatura em %s            Temperatura em %s\n\n ",unidOrigem,unidFinal );
			// la�o para imprimir todas temperaturas
			for(int i=0;i<tempFim.length;i++)
			{		
				System.out.printf("%.2f            %.2f\n",tempIni[i],tempFim[i]);
			}
			
			System.out.printf("A media da temperatura inicial � %.2f e a media da temperatura final � %.2f",mediaIni,mediaFim);
			sc.close();
			}
		catch(InputMismatchException e) {
			System.err.printf("Erro, o formato inserido � diferente de double");
		
		}
	
	}
	
}
