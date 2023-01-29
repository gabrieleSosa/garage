/**
 * classe che rappresenta un veicolo in generale
 * @author gabriele
 * @version 1
 * */
public class Veicolo {

	protected String nome;
	protected String marca;
	protected String targa;
	protected int oraIngresso;

	/**
	 * costruttore veicolo
	 * */
	public Veicolo(String pNome, String pMarca, String pTarga, int pOraArrivo)
	{
		this.nome = pNome;
		this.marca = pMarca;
		this.targa = pTarga;
		this.oraIngresso = pOraArrivo;
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
	public int getOraIngresso()
	{
		return this.oraIngresso;
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

	public void setOraIngresso(int pOraIngresso)
	{
		this.oraIngresso = pOraIngresso;
	}

}
