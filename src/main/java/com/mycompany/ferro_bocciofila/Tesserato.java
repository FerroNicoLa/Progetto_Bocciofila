/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ferro_bocciofila;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;


/**
 * La classe Tesserato rappresenta la tessera di abbonamento della Boccifila di Darfo Boario Terme
 * Una tessera è formata dal nome del tesserato, il cognome del tesserato, il codice fiscale del tesserato
 * la tipologia che può essere simpatizzante o socio e la data di emissione della tessera.
 * @author nicol
 */
public class Tesserato implements Serializable
{
    
    public String nome;
    public String cognome;
    public String codiceFiscale;
    public String tipologia;
    LocalDate dataEmissione;
    
    /**
     * Permette di istanziare un oggetto di classe Tessersto (costruttore)
     * @param nome nome del tesserato
     * @param cognome cognome del tesserato
     * @param codiceFiscale codice fiscale del tesserato
     * @param tipologia tipologia (simpatizzante o socio)
     * @param anno anno in cui è stata emessa la tessera
     * @param mese mese in cui è stata emessa la tessera
     * @param giorno giorno in cui è stata emessa la tessera
     */
     public Tesserato(String nome, String cognome,String codiceFiscale,String tipologia,int anno, int mese, int giorno)
    {
        this.nome=nome;  
        this.cognome=cognome;
        this.codiceFiscale=codiceFiscale;
        this.tipologia=tipologia;
        this.dataEmissione=LocalDate.of(anno, mese, giorno);
       
      
    }

     /**
      * Permette di istanziare una copia di un oggetto 
      * di classe Tesserato (costruttore di copia)
      * @param t istanza della classe Tesserato che si vuole copiare
      */
    public Tesserato(Tesserato t)
    {
       nome=t.nome;
       cognome=t.cognome;
       codiceFiscale=t.codiceFiscale;
       tipologia=t.tipologia;
       
        
        
    }

    
    /**
     * istanzia un oggetto vuoto della classe Tesserato (costruttore vuoto)
     */
    public Tesserato()
    {
        this.nome=null;    
        this.cognome=null;
        this.codiceFiscale=null;
        this.tipologia=null;
        dataEmissione=null;
        
    }

    /**
     * restituisce il nome di un tesserato
     * @return nome 
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * istanzia il nome del tesserato
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    /**
     * restituisce il cognome del tesserato
     * @return cognome
     */
    public String getCognome()
    {
        return cognome;
    }
    /**
     * istanzia il cognome del tesserato
     * @param cognome 
     */
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    /**
     * restituisce il codice fiscale del tesserato
     * @return codiceFiscale
     */
    
    public String getCodiceFiscale()
    {
        return codiceFiscale;
    }

    /**
     * istanzia il codice fiscale del tesserato
     * @param codiceFiscale 
     */
    public void setCodiceFiscale(String codiceFiscale)
    {
        this.codiceFiscale = codiceFiscale;
    }
    /**
     * restituisce la tipologia del tesserato
     * @return tipologia
     */
    public String getTipologia() 
    {
        return tipologia;
    }
    /**
     * istanzia la tipologia del tesserato
     * @param tipologia 
     */
    public void setTipologia(String tipologia) 
    {
        this.tipologia = tipologia;
    }

    /**
     * restituisce l'anno di tesseramento di un socio
     * @return dataEmissione
     */
    public int getAnno()
    {
        return dataEmissione.getYear();
    }
    
    /**
     * restituisce il mese di tesseramento di un socio
     * @return dataEmissione
     */
    public int getMese()
    {
        return dataEmissione.getMonthValue();
    }
    
    /**
     * restituisce il giorno di tesseramento di un socio
     * @return dataEmissione
     */        
    public int getGiorno()
    {
        return dataEmissione.getDayOfMonth();
    }

    /**
     * restituisce la data di tesseramento di un socio
     * @return dataEmissione
     */
    public LocalDate getDataEmissione()
    {
        return dataEmissione;
    }

    /**
     * istanzia la data di emissione di una tessera di un socio
     * @param giorno giorno della data di emissione
     * @param mese  giorno della data di emissione
     * @param anno giorno della data di emissione
     */
    public void setDataEmissione(int giorno,int mese, int anno) 
    {
        this.dataEmissione = LocalDate.of(anno, mese, giorno);

    }
    
    
    /**
     * Traduce in una stringa un istanza della classe Tesserato
     * @return una string con le informazione di un istanza della classe Tesserato
     */
    @Override
    public String toString() {
        return "Tesserato{" + "nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", tipologia=" + tipologia + ", dataEmissione=" + dataEmissione + '}';
    }
    
    
    
    
    
    
}
