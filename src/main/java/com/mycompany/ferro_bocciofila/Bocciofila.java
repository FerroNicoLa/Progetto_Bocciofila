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
 *La classe rappresenta un softwere per registrare i tesserati alla Bocciofila
 *La classe contiene tutti i metodi per effettuare operazioni sugli oggetti 
 *di classe Bocciofila, contenuti in un arrey
 *gli attributi sono:
 * N_MAX_TESSERE: attributo statico, è una costante che rappresenta il numero massimo delle tessere che è 100
 * tessere: arrey di oggetti di classe Revisione
 * nTesserePresenti: variabile che tiene il conto degli elementi presenti nell'Arrey
 * @author nicol
 */
public class Bocciofila implements Serializable
{
    private Tesserato [] tessere;
    private final int N_MAX_TESSERE=100;
    private int nTesserePresenti=0;
    
    
    
    /**
     * Costruttore della classe Bocciofila
     * Consente di istanziare una nuova bocciofila
     * e formato da N_MAX_TESSERE
     */
     public Bocciofila()
      {
          tessere=new Tesserato[N_MAX_TESSERE];
      }
     
     
     /**
      *Metodo aggungi tessera all'arrey
      *Permette di aggungere una nuova tessera all'arrey di classe Bocciofila 
      * @param tesserato oggetto che verrà aggunto all'arrey 
      * @return 0 se l'aggunta è andata a buon fine
      * @return -1 se l'arrey è gia pieno
      */
     public int aggiungiTessera(Tesserato tesserato)
    {
        if (nTesserePresenti>N_MAX_TESSERE)
            return -1;      //LA CLASSE HA RAGGIUNTO IL NUMERO MASSIMO DI 
        tessere[nTesserePresenti]=new Tesserato(tesserato.getNome(),tesserato.getCognome(),tesserato.getCodiceFiscale(),tesserato.getTipologia(),tesserato.getAnno(),tesserato.getMese(),tesserato.getGiorno());
        nTesserePresenti++;
        return 0;
    }
      
    /**
     * Metodo che ci permette di eliminare una tessera dall'arrey in base alla posizione 
     * @param posizione è la posizione dell oggetto all'interno dell'arrey
     * @return -2 se la posizione è vuota
     * @return -1 se la posizione non è valida
     */  
      
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
      
       
       
    /**
     * Metodo che ci permette di visualizzare i tesserati di un determinato anno,mese,giorno
     * @param data data da inserire per ricercare il tesserato
     * @return tessera restistuisce i/il tesserati/o
     */
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
    
       
    /**
     * Metodo che ci permette di visualizzare tutti gli elementi dell'arrey 
     * @return s restituisce la stringa del tesserto 
     */   
       
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
    
    
    /**
     * Metodo getter dell'arrey di classe Bocciofila tessere
     * Ci permette di visualizzare il numero massimo di tessere
     * 
     * @return N_MAX_TESSERE
     */
    public int getN_MAX_TESSERE() 
    {
        return N_MAX_TESSERE;
    }
    
    
    /**
     * Metodo che salva tutti i tesserati dell'arrey su file CSV
     * @param nomeFile nome del file CSV su cui vogliamo salvare i tesserati
     * @throws IOException
     * @throws FileException 
     */
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
    
    
    /**
     * Metodo che aggiorna la posizione degli oggetti nell'arrey dopo l'eliminazione di uno di questi
     * sposta gli elementi dell'arrey in modo da non lasciare spazi 
     * @param posizione  è la posizione dell oggetto all'interno dell'arrey
     */
    public void aggiornaPosizioneTesserati(int posizione)
    {
        for (int i=posizione;i<nTesserePresenti-1;i++)
        {
            tessere[i]=tessere[i+1];
        }
        tessere[nTesserePresenti-1]=null;     
        nTesserePresenti--;
    } 
    
    
    /**
     * Metodo che ci permette di vidualizzare tutti i tesserati con tipologia simpatizzantre
     * in ordine alfabetico in base all anno,mese,giorno 
     * @param data data da inserire per ricercare il tesserato
     * @return tessera restistuisce i/il tesserati/o 
     */
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
    
    
    /**
     *  Metodo che salva tutte le tessere su file binario 
     * @param nomeFile  nome del file binario su cui vogliamo salvare i dati
     * @throws IOException 
     */
    public void salvaTessereBinario(String nomeFile) throws IOException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
     
}
    
  
 
     
     
     
     
     
     
     
     

