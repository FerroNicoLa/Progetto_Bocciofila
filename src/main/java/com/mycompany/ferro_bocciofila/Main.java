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
public class Main 
{
    public static void main(String[] args) 
    {
        LocalDate data;
        data=LocalDate.ofYearDay(2020, 1);
        Tesserato t1=new Tesserato("giovanni", "mucciacia", "abcd", "socio", 2020, 4, 1);
        Tesserato t2=new Tesserato("ales", "fa", "efgh", "simpatizzante", 2020, 3, 1);
        Tesserato t3=new Tesserato("davide", "to", "ijkl", "socio", 2020, 1, 3);
        Tesserato t4=new Tesserato("samuele", "co", "mnop", "simpatizzante", 2021, 4, 4);
        
        /*System.out.println(t1.toString());*/
        
        
        Bocciofila b=new Bocciofila();
        
        b.aggiungiTessera(t1);
        b.aggiungiTessera(t2);
        b.aggiungiTessera(t3);
        b.aggiungiTessera(t4);
        
       /* System.out.println(b1.toString());
        
        b1.rimuoviTessere(2);
        
        System.out.println(b1.toString());*/
        
       
        
        System.out.println(b.tesseratiAnno(data));
        
        
    }
    
}
