import java.util.Scanner;

/**
 * classe di test del programma
 * qui verrà visualizzato il menù di scelta
 * @author gabriele
 * @version 2.0
 * implementazione delle data --> libreria date.java
 * */

public class TestGarage {
	public static void main(String[] args) throws Exception {

		int scelta;
		Garage europa = new Garage();

		do
		{
			System.out.println("1. Entrata veicolo");
			System.out.println("2. Uscita veicolo");
			System.out.println("3. Visualizzazione veicolo");
			System.out.println("4. Visualizzazione posti occupati");
			System.out.println("5. Stampa marca dei veicoli");
			System.out.println("0. Esci");

			System.out.println("\nInserisci scelta ");
			Scanner sc = new Scanner(System.in);
			scelta = sc.nextInt();

			switch (scelta) {
				case 1 -> europa.entrataVeicolo();
				case 2 -> europa.uscitaVeicolo();
				case 3 -> {
					System.out.println("inserire targa del veicolo che stai cercando...");
					String trg = sc.next();
					europa.stampaVeicolo(trg);
				}
				case 4 -> europa.visualizzazionePostiOccupati();
				case 5 -> europa.stampaMarcaVeicolo();
				case 0 -> System.out.println("uscita");

				default -> System.out.println("inserire numero corretto");
			}
		}while(scelta != 0);
	}
}