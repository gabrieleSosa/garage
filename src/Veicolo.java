import java.util.Date;

/**
 * classe che rappresenta un veicolo in generale
 * @author gabriele
 * @version 1
 * */
public class Veicolo {

	protected String nome;
	protected String marca;
	protected String targa;
	protected Date dataArrivo;

	/**
	 * costruttore veicolo
	 * */
	public Veicolo(String pNome, String pMarca, String pTarga, Date pArrivo)
	{
		this.nome = pNome;
		this.marca = pMarca;
		this.targa = pTarga;
		this.dataArrivo = pArrivo;
	}

	public String getNome()
	{
		return this.nome;
	}

	public String getMarca()
	{
		return this.marca;
	}

	public String getTarga()
	{
		return this.targa;
	}
	public Date getDataArrivo()
	{
		return this.dataArrivo;
	}

	public void setNome(String pNome)
	{
		this.nome = pNome;
	}
	public void setMarca(String pMarca)
	{
		this.marca = pMarca;
	}
	public void setTarga(String pTarga)
	{
		this.targa = pTarga;
	}

	public void setDataArrivo(Date pArrivo)
	{
		this.dataArrivo = pArrivo;
	}

}
