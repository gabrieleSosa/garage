import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class provaData
{
	public static void main(String[] args)
	{
		Date d1=null,d2=null;
		double oraArrivo, oraPartenza, tempoTrascorso, oraAttuale;

//vettore con le costanti degli stili disponibili
//int formati[] = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL};
//crea la data di arrivo
		String d1Str = "04/02/2023 08:00";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy HH:mm");

		try{
			d1 = formato.parse(d1Str);
			oraArrivo = d1.getTime();

			d2 = new Date();
			oraAttuale = d2.getTime();

			//visualizza la data non formattata (sfruttando implicitamente il metodo toString dell'oggetto)
			System.out.println("Arrivo : "+d1);
			System.out.println("Partenza: "+d2);
			tempoTrascorso = oraAttuale-oraArrivo;
			double numOre = tempoTrascorso/3600000;
			System.out.println("tempo trascorso in ore "+numOre);
			numOre = Math.ceil(numOre);
			System.out.println("tempo trascorso in ore (arr.) "+numOre);
		}
		catch (ParseException e) {
			System.out.println("Formato data non valido.");
		}
	}
}