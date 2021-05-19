/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ferro_bocciofila;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author nicol
 */
public class Tesserato 
{
    
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String tipologia;
    LocalDate dataEmissione;
    
    
     public Tesserato(String nome, String cognome,String codiceFiscale,String tipologia,int anno, int mese, int giorno)
    {
        this.nome=nome;  
        this.cognome=cognome;
        this.codiceFiscale=codiceFiscale;
        this.tipologia=tipologia;
        this.dataEmissione=LocalDate.of(anno, mese, giorno);
       
      
    }

     
    public Tesserato(Tesserato t)
    {
       nome=t.nome;
       cognome=t.cognome;
       codiceFiscale=t.codiceFiscale;
       tipologia=t.tipologia;
       dataEmissione=t.dataEmissione;
        
        
    }
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public String getCodiceFiscale()
    {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale)
    {
        this.codiceFiscale = codiceFiscale;
    }

    public String getTipologia() 
    {
        return tipologia;
    }

    public void setTipologia(String tipologia) 
    {
        this.tipologia = tipologia;
    }

    
    public int getAnno()
    {
        return dataEmissione.getYear();
    }
    
    public int getMese()
    {
        return dataEmissione.getMonthValue();
    }
    
            
    public int getGiorno()
    {
        return dataEmissione.getDayOfMonth();
    }

    public LocalDate getDataEmissione()
    {
        return dataEmissione;
    }
    
    public void setData(int giorno,int mese, int anno)
    {
        dataEmissione=dataEmissione.withYear(anno);
        dataEmissione=dataEmissione.withMonth(mese);
        dataEmissione=dataEmissione.withDayOfMonth(giorno);
    }
    
    @Override
    public String toString() {
        return "Tesserato{" + "nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", tipologia=" + tipologia + ", dataEmissione=" + dataEmissione + '}';
    }
    
    
    
    
    
    
}
