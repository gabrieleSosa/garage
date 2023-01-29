import java.util.Scanner;

/**
 * classe che rappresenta il garage
 * @author gabriele
 * @version 1
 * */

public class Garage
{
	/**
	 * nPosti --> numero posti totali nel garage
	 * */
	final int nPosti = 25; // Max posti
	/**
	 * nAuto --> numero posti auto nel garage
	 * */
	final int nAuto = 15; // Max numero auto

	/**
	 * nMoto --> numero posti moto nel garage
	 * */
	final int nMoto = 10; // Max numero moto
	Veicolo[] posti = new Veicolo[nPosti];
	/**
	 * costo orario auto --> tariffa oraria per le auto
	 * */
	final int costoOrarioAuto = 2;
	/**
	 * costo orario moto --> tariffa oraria per le moto
	 * */
	final int costoOrarioMoto = 1; //dato inutile?

/**
 * assegna un posto all'automobile, solo se trova che il posto con indice I (quindi quello su cui avverranno i controlli è libero)
 * */
	public int cercaPostoAuto()
	{
		int i;
		boolean flgTrovato = false;
		for (i=0; i< nAuto && !flgTrovato; i++)
		{
			if (posti[i] == null)
			{
				flgTrovato = true;
			}
		}
		if (!flgTrovato)
		{
			i = -1;
		}
		else
		{
			i--;
		}
		return i;
	}

	/**
	 * cercaVeicolo --> in base alla targa che andrà inserita in input alla funzione trova il veicolo corrispondente
	 * @param trg la targa del veicolo
	 * @return i l'indice del veicolo
	 * */

	public int cercaVeicolo(String trg)
	{
		int i;
		boolean flgTrovato = false;
		for (i=0; i< nPosti && !flgTrovato; i++)
		{
			if (posti[i].getTarga().equals(trg) && posti[i].getTarga() != null)
			{
				flgTrovato = true;
			}
		}
		if (!flgTrovato)
		{
			i = -1;
		}
		else
		{
			i--;
		}
		return i;
	}

	/**
	 * stampaVeicolo --> in base alla targa che andrà inserita in input alla funzione verranno stampati gli attributi di quel veicolo
	 * @param trg la targa del veicolo
	 * */
	public void stampaVeicolo(String trg){

		for (int i=0; i < nPosti; i++)
		{
			if (posti[i] != null) {
				if (posti[i].getTarga().equals(trg)) {
					System.out.println("marca: " + posti[i].marca);
					System.out.println("nome: " + posti[i].nome);
					System.out.println("ora ingresso: " + posti[i].oraIngresso);
					System.out.println("targa: " + posti[i].targa);
					System.out.println("tipologia veicolo: " + posti[i].getClass());
				}
			}

		}
	}

	/**
	 * leggiStringa --> metodo che legge una stringa.
	 * Variante del semplice scanner
	 * */
	public String leggiStringa()
	{
		String strOut;
		Scanner sc = new Scanner (System.in);
		strOut = sc.next();
		return strOut;
	}

	/**
	 * pagaParcheggio --> in base al posto e all'ora di uscita verrà fatto pagare il parcheggio al proprietario del veicolo
	 * @param pos il numero del parcheggio del veicolo
	 * @param oraUscita ora di uscita dal garage
	 * */
	public void pagaParcheggio(int pos, int oraUscita)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("che tipo di veicolo sta ritirando? [1] - auto / [2] - moto");
		int scelta;
		int prezzoDaPagare;
		scelta = in.nextInt();
		if (scelta == 1){
			prezzoDaPagare = (oraUscita - posti[pos].oraIngresso) * costoOrarioAuto;
		} else {
			prezzoDaPagare = oraUscita - posti[pos].oraIngresso * costoOrarioMoto;
		}

		System.out.println("prezzoDaPagare = " + prezzoDaPagare);

		int monete;
		System.out.println("inserire banconota...");
		monete = in.nextInt();

		if (monete > prezzoDaPagare){
			System.out.println("il resto restituito è: " + (monete - prezzoDaPagare));
		}

		System.out.println("Il parcheggio è stato pagato");
	}

	/**
	 * uscitaVeicolo --> chiede l'orario di uscita dal parcheggio, che servirà alla funzione del pagamento per il calcolo dell'importo da pagare
	 * */
	public void uscitaVeicolo()
	{
		Scanner in = new Scanner(System.in);
		String targa;

		System.out.println("inserire l'orario di uscita del veicolo");

		int oraUscita = in.nextInt();

		System.out.println("Inserire il numero di targa ");
		targa = leggiStringa();

		int pos = cercaVeicolo(targa);
		if (pos!=-1)
		{
			pagaParcheggio(pos, oraUscita);
			posti[pos] = null;
		}
		else
		{
			System.out.println("L'auto non è presente nel garage");
		}

	}

	/**
	 * entrataVeicolo --> chiede se il veicolo è un'auto o un motore.
	 * Se è un'auto, parcheggia in uno dei posti che vanno da 0 a 14, solo se liberi.
	 * Se è una moto, parcheggia in uno dei posti che vanno da 15 a 25, solo se liberi.
	 * */

	public void entrataVeicolo()
	{
		int scelta;
		Scanner sc = new Scanner (System.in);

		do {
			System.out.println("1. Auto");
			System.out.println("2. Moto");
			System.out.println("0. Esci");
			System.out.println("Inserisci la tua scelta ");
			scelta = sc.nextInt();

			switch(scelta)
			{
				case 1: // Ingresso automobile
					int esito = this.cercaPostoAuto();
					if (esito == -1)
					{
						System.out.println("Posti auto esauriti");
					}
					else
					{

						System.out.println("Inserire la marca");
						String marca = sc.next();
						System.out.println("Inserire il nome");
						String nome = sc.next();
						System.out.println("Inserire la targa");
						String targa = sc.next();
						System.out.println("Inserire l'ora di arrivo");
						int ora = sc.nextInt();
						Auto a = new Auto(nome,marca,targa,ora);
						posti[esito] = a;
						System.out.println("L'auto è stata parcheggiata nel posto "+esito);
					}
					break;

				case 2: //ingresso moto
					esito = this.cercaPostoMoto();
					if (esito == -1)
					{
						System.out.println("Posti moto esauriti");
					}
					else
					{

						System.out.println("Inserire la marca");
						String marca = sc.next();
						System.out.println("Inserire il nome");
						String nome = sc.next();
						System.out.println("Inserire la targa");
						String targa = sc.next();
						System.out.println("Inserire l'ora di arrivo");
						int ora = sc.nextInt();
						Moto a = new Moto(nome,marca,targa,ora);
						posti[esito] = a;
						System.out.println("L'auto è stata parcheggiata nel posto " + esito);
					}
					break;

				default:
					System.out.println("inserire un numero corretto...");
					break;
			}
		} while (scelta !=0);
	}

	/**
	 * assegna un posto al motore, solo se trova che il posto con indice I (quindi quello su cui avverranno i controlli è libero)
	 * */
	public int cercaPostoMoto() {
		int i;
		boolean flgTrovato = false;
		for (i=15; i< nMoto+10 && !flgTrovato; i++)
		{
			if (posti[i] == null)
			{
				flgTrovato = true;
			}
		}
		if (!flgTrovato)
		{
			i = -1;
		}
		else
		{
			i--;
		}
		return i;
	}

	/**
	 * fa vedere il numero del parcheggio, quindi il posto, che è occupato da un veicolo
	 * */
	public void visualizzazionePostiOccupati(){

		for (int i=0; i< nPosti; i++)
		{
			if (posti[i] != null)
			{
				System.out.print(i + " - ");
			}
		}

	}

	/**
	 * stampa la marca di tutti i veicoli presenti nel garage
	 * */
	public void stampaMarcaVeicolo(){

		for (int i=0; i< nPosti; i++)
		{
			if (posti[i] != null)
			{
				System.out.println(i + " - " + posti[i].marca);
			}
		}
	}



}