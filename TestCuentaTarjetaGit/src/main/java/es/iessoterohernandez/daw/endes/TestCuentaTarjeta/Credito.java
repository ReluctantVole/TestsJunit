package es.iessoterohernandez.daw.endes.TestCuentaTarjeta;

import java.util.Vector;
import java.util.Date;

public class Credito extends Tarjeta
{
	protected double mCredito;
	protected Vector mMovimientos;

	public Credito(String numero, String titular, Date fechaCaducidad, double credito)
	{
		super(numero, titular, fechaCaducidad);
		mCredito=credito;
		mMovimientos=new Vector();
	}
	
	public void retirar(double x) throws Exception 
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Retirada en cajero automatico");
		x=(x*0.05<3.0 ? 3 : x*0.05);  // Añadimos una comision de un 5%, minimo de 3 euros.
		m.setImporte(x);
		mMovimientos.addElement(m);
		if (x>getCreditoDisponible())
			throw new Exception("Credito insuficiente");
	}
	
	public void ingresar(double x) throws Exception 
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Ingreso en cuenta asociada (cajero automatico)");
		m.setImporte(x);
		mMovimientos.addElement(m);
		mCuentaAsociada.ingresar(x);
	}
	
	public void pagoEnEstablecimiento(String datos, double x) throws Exception 
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Compra a credito en: " + datos);
		m.setImporte(x);
		mMovimientos.addElement(m);
	}
	
	public double getSaldo() 
	{
		double r=0.0;
		for (int i=0; i<this.mMovimientos.size(); i++) 
		{
			Movimiento m=(Movimiento) mMovimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}
	
	public double getCreditoDisponible() 
	{
		return mCredito-getSaldo();
	}
	
	public void liquidar(int mes, int anio) 
	{
		Movimiento liq=new Movimiento();
		liq.setConcepto("Liquidacion de operaciones tarj. credito, " + (mes+1) + " de " + (anio+1900));
		double r=0.0;
		for (int i=0; i<this.mMovimientos.size(); i++) 
		{
			Movimiento m=(Movimiento) mMovimientos.elementAt(i);
			if (m.getFecha().getMonth()+1==mes && m.getFecha().getYear()+1900==anio)
				r+=m.getImporte();
		}
		liq.setImporte(r);
		if (r!=0)
			mCuentaAsociada.addMovimiento(liq);
	}
}