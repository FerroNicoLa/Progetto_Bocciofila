/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ferro_bocciofila;

import java.time.LocalDate;

/**
 *
 * @author nicol
 */
public class Bocciofila 
{
    private Tesserato [] tessere;
    private final int N_MAX_TESSERE=100;
    private int nTesserePresenti=0;
    
    
     public Bocciofila()
      {
          tessere=new Tesserato[N_MAX_TESSERE];
      }
     
     
     public int aggiungiTessera(Tesserato tesserato)
    {
        if (nTesserePresenti>N_MAX_TESSERE)
            return -1;      //LA CLASSE HA RAGGIUNTO IL NUMERO MASSIMO DI 
        tessere[nTesserePresenti]=new Tesserato(tesserato.getNome(),tesserato.getCognome(),tesserato.getCodiceFiscale(),tesserato.getTipologia(),tesserato.getAnno(),tesserato.getMese(),tesserato.getGiorno());
        nTesserePresenti++;
        return 0;
    }
      
      
      
       public int rimuoviTessere(int posizione)
    {
        
        try
        {
            if(tessere[posizione]==null)
               return -2;           //posizione vuota
            tessere[posizione]=null;
            return posizione;
        }
        catch(ArrayIndexOutOfBoundsException posizioneNonValida)
        {
            return -1;
        }
        
           
    }
       
    public String tesseratiAnno(LocalDate data)
    {
        String s="";
        
        for(int i=0;i<nTesserePresenti;i++)
        {
      
                if(data.isEqual(tessere[i].getDataEmissione()))
                {
                    s=(tessere[i].getNome()+"-"+tessere[i].getCognome()+"-"+tessere[i].getCodiceFiscale()+"-"+tessere[i].getTipologia());
                }
            
        
        }
        return s;
    }
    
       
       
       
       public String toString()
    {
        Tesserato t;
        String s="";
        for(int i=0;i<N_MAX_TESSERE;i++)
        {
            if(tessere[i]!=null)
            {
                t=tessere[i];
                s=s+"Posizione:  "+i+t.toString()+"\n";
            }   
        }
        return s;
    }
      
     
      
     
     
     
     
     
     
     
     
     
     
     
     
}
