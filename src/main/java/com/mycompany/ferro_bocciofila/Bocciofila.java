/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ferro_bocciofila;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author nicol
 */
public class Bocciofila implements Serializable
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
       
    public Tesserato[] tesseratiAnno(LocalDate data)
    {
        Tesserato[] tessera=new Tesserato[nTesserePresenti];
        
        Tesserato tesserato;
        
        int x=0;
        
        for(int i=0;i<nTesserePresenti;i++)
        {
      
                if(data.isEqual(tessere[i].getDataEmissione())==true)
                {
                    tesserato=tessere[i];
                    tessera[x]=tesserato;
                    x++;
                }
            
        
        }
        return tessera;
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
      
    public void visualizzaAnniTesseramentoDiUnaPersona(String nome,String cognome)
    {

        
        for (int i=0;i<nTesserePresenti;i++)
        {
            if(tessere[i].getNome().compareToIgnoreCase(nome)==0 && tessere[i].getCognome().compareToIgnoreCase(cognome)==0)
            {
                System.out.println("tesserato per gli anni:"+tessere[i].getAnno());
            }
        }
    }
      
    public int getN_MAX_TESSERE() 
    {
        return N_MAX_TESSERE;
    }
    
    public void salvaTessere(String nomeFile) throws IOException, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Tesserato tesserato;
        for(int i=0;i<nTesserePresenti;i++)
        {
            tesserato=tessere[i];
            if(tesserato!=null)
            {
                f1.toFile(tessere[i].getCognome()+";"+tessere[i].getNome()+";"+tessere[i].getCodiceFiscale()+";"+tessere[i].getTipologia()+";"+tessere[i].getAnno()+";"+tessere[i].getMese()+";"+tessere[i].getGiorno()+"\n");
            }
        }
        f1.close();
    }
      
    private void AggiornaPosizioneTesserati(int posizione)
    {
        for (int i=posizione;i<nTesserePresenti-1;i++)
        {
            tessere[i]=tessere[i+1];
        }
        tessere[nTesserePresenti-1]=null;     
        nTesserePresenti--;
    } 
    
    public Tesserato[] TipologiaOrdineAlfabetico (LocalDate data)
    {
        Tesserato[] tessera=new Tesserato[nTesserePresenti];
        
        Tesserato tesserato;
        
        int x=0;
        
        for(int i=0;i<nTesserePresenti;i++)
        {
      
                if(data.isEqual(tessere[i].getDataEmissione())==true)
                {
                    if(tessere[i].getTipologia().compareToIgnoreCase("simpatizzante")==0)
                    {
                       
                       tesserato=tessere[i];
                       tessera[x]=tesserato;
                       x++;  
                    }
                   
                }
            
        
        }
        tessera=Ordinatore.selectionSortAlfabeticoSimpatizzante(tessera);
        return tessera;
    }
    
    public void salvaTessereBinario(String nomeFile) throws IOException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
     
}
    
  
 
     
     
     
     
     
     
     
     

