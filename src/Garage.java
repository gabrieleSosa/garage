import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * classe che rappresenta il garage
 * @author gabriele
 * @version 2
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
	 * cercaVeicolo --> in base alla targa che andrà inserita in entrata alla funzione trova il veicolo corrispondente
	 * @param trg la targa del veicolo
	 * @return i l'indice del veicolo
	 * */

	public int cercaVeicolo(String trg)
	{
		int i;
		boolean flgTrovato = false;
		for (i=0; i< nPosti && !flgTrovato; i++)
		{
			if ((posti[i] != null) && posti[i].targa.equals(trg))
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
	 * stampaVeicolo --> in base alla targa che andrà inserita in entrata alla funzione verranno stampati gli attributi di quel veicolo
	 * @param trg la targa del veicolo
	 * */
	public void stampaVeicolo(String trg){ //modificare l'ora d'ingresso in data d'ingresso

		for (int i=0; i < nPosti; i++)
		{
			if (posti[i] != null) {
				if (posti[i].getTarga().equals(trg)) {
					System.out.println("marca: " + posti[i].marca);
					System.out.println("nome: " + posti[i].nome);
					System.out.println("ora ingresso: " + posti[i].dataArrivo);
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
	 * pagaParcheggio --> in base al posto, al tipo di veicolo e al tempo trascorso all'interno del parcheggio verrà fatto pagare il un importo al proprietario del veicolo
	 * @param numOreTrascorse il numero di ore trascorse all'interno del garage
	 * */
	public void pagaParcheggio(double numOreTrascorse)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("che tipo di veicolo sta ritirando? [1] - auto / [2] - moto");
		int scelta;
		double prezzoDaPagare;
		scelta = in.nextInt();
		if (scelta == 1){
			prezzoDaPagare = numOreTrascorse * costoOrarioAuto;
		} else {
			prezzoDaPagare = numOreTrascorse * costoOrarioMoto;
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
	 * uscitaVeicolo --> in base all'orario dell'orologio del pc nella vita reale, verrà calcolato l'importo da pagare
	 * */
	public void uscitaVeicolo()
	{

		String targa;
		Date dataUscita = new Date();
		Date dataArrivo;
		System.out.println("Inserire il numero di targa ");
		targa = leggiStringa();

		double oraArrivo, oraPartenza, tempoTrascorso;

		int pos = cercaVeicolo(targa);
		if (pos!=-1) {

			try {

				dataArrivo = posti[pos].dataArrivo;
				oraArrivo = dataArrivo.getTime();
				oraPartenza = dataUscita.getTime();

				System.out.println("Arrivo : "+dataArrivo);
				System.out.println("Partenza: "+dataUscita);

				tempoTrascorso = oraPartenza-oraArrivo;
				double numOre = tempoTrascorso/3600000;

				numOre = Math.ceil(numOre);
				System.out.println("tempo trascorso in ore arrotondato per eccesso " + numOre);

				pagaParcheggio(numOre);
				posti[pos] = null;
			} catch (Exception e) {
				System.out.println("formato data non corretto");
			}

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

	public void entrataVeicolo() throws ParseException //modificare questo
	{

		int scelta;
		Scanner sc = new Scanner (System.in);

		do {

			for (String s : Arrays.asList("sta entrando un nuovo veicolo? ", "1. Auto", "2. Moto", "0. Esci", "Inserisci la tua scelta ")) {
				System.out.println(s);
			}
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

						try {
							System.out.println("inserire data di arrivo nel formato dd/MM/yyyy");
							String dataArrivoString = sc.next();

							System.out.println("inserire ora di arrivo nel formato HH:mm");
							String oraArrivo = sc.next();
							String dataCompleta = dataArrivoString + " " + oraArrivo;
							SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Date dataArrivo = formato.parse(dataCompleta);

							Auto a = new Auto(nome,marca,targa,dataArrivo);
							posti[esito] = a;
							System.out.println("L'auto è stata parcheggiata nel posto " + esito);
						}catch (ParseException e){
							System.out.println("inserire data nel formato corretto");
						}
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

						try {
							System.out.println("inserire data di arrivo nel formato dd/MM/yyyy");
							String dataArrivoString = sc.next();

							System.out.println("inserire ora di arrivo nel formato HH:mm");
							String oraArrivo = sc.next();
							String dataCompleta = dataArrivoString + " " + oraArrivo;
							SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							Date dataArrivo = formato.parse(dataCompleta);

							Moto a = new Moto(nome,marca,targa,dataArrivo);
							posti[esito] = a;
							System.out.println("La moto è stata parcheggiata nel posto " + esito);
						}catch (ParseException e){
							System.out.println("inserire data nel formato corretto");
						}


					}
					break;

				case 0:
					System.out.println("uscita dal menu");
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