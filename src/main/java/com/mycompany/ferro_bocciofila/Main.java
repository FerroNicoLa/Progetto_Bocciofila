/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ferro_bocciofila;

//import eccezioni.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nicol
 */
public class Main implements Serializable
{
    public static void main(String[] args)
    {
        Bocciofila b1=new Bocciofila();
        String[] vociMenu=new String[9];
        Scanner tastiera=new Scanner(System.in);
        int sceltaUtente=0;
        Tesserato tesserato;
        int giorno=0,mese=0,anno=0;
        int posizione;
        LocalDate data;
        String nomeFile="tesserati.txt";
        
        
        

        vociMenu[0]="Esci";
        vociMenu[1]="Inserisci una nuova tessera";
        vociMenu[2]="Elimina una tessera";
        vociMenu[3]="Visualizza Tesserati in base all' anno al mese e al giorno";
        vociMenu[4]="Dato nome e cognome, visualizza per quali anni è stato tesserato";
        vociMenu[5]="Visualizza tutti i tesserati con tessera simpatizzante di un determinato anno,mese,giorno in ordine alfabetico";
        vociMenu[6]="Salva dati su file binario";
        vociMenu[7]="Esporta in formato CSV tutte le tessere";
        vociMenu[8]="Visualizza tutti i Tesserati";
        
        try
        {
            FileInputStream f1=new FileInputStream("tesserati.bin");
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {
                b1=(Bocciofila)reader.readObject();
                reader.close();
                System.out.println("\nLettura da file avvevuta correttamente");

            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file");
        }
        Menu menu=new Menu(vociMenu);

        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
                
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione e' stata chiusa");
                    break;
                }
                case 1:
                {
                    tesserato=new Tesserato();
                    
                    tastiera.nextLine();
                    System.out.println("Premi un tasto per continuare");
                    System.out.println("Nome-->");
                    tesserato.setNome(tastiera.nextLine());
                    
                    System.out.println("Cognome-->");
                    tesserato.setCognome(tastiera.nextLine());

                    
                    System.out.println("Codice Fiscale-->");
                    tesserato.setCodiceFiscale(tastiera.nextLine());
                    
                    System.out.println("Tipologia (simpatizzante o socio)-->");
                    tesserato.setTipologia(tastiera.nextLine());
                    

                    
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    tesserato.setDataEmissione(giorno,mese,anno);
                    

                    b1.aggiungiTessera(tesserato);
                    
                    System.out.println(b1.toString());
                    break;
        
                }
                case 2:
                {
                    System.out.println("Inserisci la posizione della tessera da eliminare");
                    System.out.println("Posizione-->");
                    posizione=tastiera.nextInt();
                    

                    tastiera.nextLine();

         
                    b1.rimuoviTessere(posizione);
                    b1.aggiornaPosizioneTesserati(posizione);
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    
                    
                    System.out.println(b1.toString());
                    break;
                }
                case 3:
                {
                    Tesserato[] t1;
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    
                    data=LocalDate.of(anno,mese,giorno);
                    t1=b1.tesseratiAnno(data);
                    for(int i=0;i<t1.length;i++)
                    {
                        if(t1[i]!=null)
                            System.out.println(t1[i]);
                    }
                    break;
                }
                case 4:
                {
                    String nome,cognome;
                    tastiera.nextLine();
                    System.out.println("Nome-->");
                    nome=tastiera.nextLine();

                    System.out.println("Cognome-->");
                    cognome=tastiera.nextLine();

                    b1.visualizzaAnniTesseramentoDiUnaPersona(nome,cognome);

                    System.out.println("premi un pulsante per continuare");
                   
                    break;
                }
                case 5:
                {
                    Tesserato[] t1;
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    
                    data=LocalDate.of(anno,mese,giorno);
                    t1=b1.TipologiaOrdineAlfabetico(data);
                    for(int i=0;i<t1.length;i++)
                    {
                        if(t1[i]!=null)
                            System.out.println(t1[i]);
                    }
                    break;
                }
                case 6:
                {
                   try
                    {
                      b1.salvaTessereBinario("tesserati.bin");  
                        System.out.println("Salvataggio avvenuto correttamente");
                    }
                    catch(IOException e1)
                    {
                        System.out.println("Impossibile accedere al file. Le tessere non sono state salvate");
                    }
                   /* catch (FileException e2)
                    {
                        System.out.println(e2.toString());
                    }*/
                    break;
                }
                case 7:
                {
                    try
                    {
                      b1.salvaTessere(nomeFile);  
                        System.out.println("Salvataggio avvenuto correttamente");
                    }
                    catch(IOException e1)
                    {
                        System.out.println("Impossibile accedere al file. Le tessere non sono stati salvati");
                    }
                    catch (FileException e2)
                    {
                        System.out.println(e2.toString());
                    }
                    break;
                }
                case 8:
                {
                    System.out.println("I tesserati sono:");
                    System.out.println(b1.toString());
                }
                
            }
                
         }
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
        
        
        }while(sceltaUtente!=0);
    }
            
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       /* 
        Tesserato t1=new Tesserato("giovanni", "mucciacia", "abcd", "socio", 2020, 4, 1);
        Tesserato t2=new Tesserato("ales", "fa", "efgh", "simpatizzante", 2020, 3, 1);
        Tesserato t3=new Tesserato("davide", "to", "ijkl", "socio", 2020, 1, 3);
        Tesserato t4=new Tesserato("samuele", "co", "mnop", "simpatizzante", 2021, 4, 4);
        
        System.out.println(t1.toString());
        
        
        
        
        b.aggiungiTessera(t1);
        b.aggiungiTessera(t2);
        b.aggiungiTessera(t3);
        b.aggiungiTessera(t4);
        
       System.out.println(b1.toString());
        
        b1.rimuoviTessere(2);
        
        System.out.println(b1.toString());
        
       
        
        */
        
        
    
    

