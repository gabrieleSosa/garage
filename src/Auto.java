import java.util.Date;

/**
 * classe che rappresenta l'automobile
 * è un estensione della classe veicolo, quindi avrà stessi gli metodi e attributi
 * @author gabriele
 * @version 1
 * */

public class Auto extends Veicolo{
	/**
	 * costruttore auto
	 * */
	public Auto (String nome, String marca, String targa, Date dataArrivo)
	{
		super(nome,marca,targa,dataArrivo);
	}
}
