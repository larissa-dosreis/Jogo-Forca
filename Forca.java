import java.util.Scanner;
import java.util.Random;

public class Forca {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		String animal[] = { "guaxinim", "jaguatirica", "capivara","quati","elefante" };
		String fruta[] = { "lichia", "graviola", "jambo","carambola","pitanga" };
		String pais[] = { "suriname", "georgia", "nepal", "argentina", "filipinas" };
		String palavraForca = "", dica = "";
		int categoria = 0, vidas = 6;
		
		System.out.println("+-------------------+");
		System.out.println("|   JOGO DA FORCA   |");
		System.out.println("+-------------------+\n");

		do {
			System.out.println("Escolha uma categoria:");
			System.out.println("1- animal");
			System.out.println("2- fruta");
			System.out.println("3- país");
			categoria = input.nextInt();
			
			if (categoria < 1 || categoria > 3) {
				System.out.println("\nEsta categoria não exite\n");
			}
		} while (categoria < 1 || categoria > 3);

		if (categoria == 1) {
			palavraForca = animal[random.nextInt(animal.length)];
			dica = "ANIMAL \uD83D\uDC31\uD83D\uDC30";
		}
		if (categoria == 2) {
			palavraForca = fruta[random.nextInt(fruta.length)];
			dica = "FRUTA \uD83C\uDF52\uD83C\uDF53";
		}
		if (categoria == 3) {
			palavraForca = pais[random.nextInt(pais.length)];
			dica = "PAÍS \uD83C\uDF0D";
		}
		
		String forca[] = new String [6];
		forca[0]= "\n-----+";
		forca[1]= "\n|    |";
		forca[2]= "\n|    ";
		forca[3]= "\n|   ";
		forca[4]= "\n|   ";
		forca[5]= "\n|       ";
		
		System.out.print(forca[0]+"     "+dica);
		for(int i=1;i<6;i++) {
			System.out.print(forca[i]);
		}
		
		String ocultarPalavra[] = new String[palavraForca.length()];
		for (int i = 0; i < palavraForca.length(); i++) {
			ocultarPalavra[i] = " _ ";
			System.out.print(ocultarPalavra[i]);
		}
		
		System.out.println("\n");
		
		for(int i=0; i<vidas;i++) {
			System.out.print("\u2764\uFE0F");
		}
		System.out.println("\nVIDAS: " + vidas);
		
		char letrasErradas [] = new char[vidas];
        int erros = 0;

		while (true) {

			System.out.println("\nDigite uma letra");
			char letra = input.next().toLowerCase().charAt(0);
			boolean acerto = false;
			
			if (!Character.isLetter(letra)) {
			    System.out.println("Digite apenas letras!");
			    continue;
			}

			for (int i = 0; i < palavraForca.length(); i++) {
				if (palavraForca.charAt(i) == letra) {
					ocultarPalavra[i] = String.valueOf(letra);
					acerto = true;
				}
			}
			if (!acerto) {
				vidas--;
				letrasErradas[erros] = letra;
				erros ++;
			}
			if(vidas==5) {
				forca[2]= "\n|    O";
			}
			if(vidas==4) {
				forca[3]="\n|    |";
			}
			if(vidas==3) {
				forca[3]= "\n|   /|";
			}
			if(vidas==2) {
				forca[3]= "\n|   /|\\";
			}
			if(vidas==1) {
				forca[4]= "\n|   /";
			}
			if(vidas==0) {
				forca[4]= "\n|   / \\";
				forca[2]= "\n|    \uD83D\uDC80";
			}
			
			System.out.print(forca[0]+"     "+dica);
			for(int i=1;i<6;i++) {
				System.out.print(forca[i]);
			}
			
			for (int i = 0; i < palavraForca.length(); i++) {
				System.out.print(ocultarPalavra[i]);
			}
			
			System.out.println("\n");
			
			for(int i=0; i<vidas;i++) {
				System.out.print("\u2764\uFE0F");
			}

			System.out.println("\nVIDAS:" + vidas);
			
			if(erros>=1) {			 
			System.out.print("Letras erradas: ");
	        for (int i = 0; i < erros; i++) {
	        	System.out.print(letrasErradas[i] + " ");
	        }
			System.out.print("\n");
			}

			if (vidas == 0) {
				System.out.println("\nVocê perdeu!");
				System.out.println("A palavra era " + palavraForca);
				break;
			}
			
			if (String.join("", ocultarPalavra).equals(palavraForca)) {
				System.out.println("\nParabéns! \uD83C\uDF89");
				System.out.println("Você adivinhou a palavra " + palavraForca);
				break;
			}
		}
		input.close();
	}
}