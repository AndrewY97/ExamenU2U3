package Logico;

import Vista.GUI;

import javax.swing.*;
import java.util.Random;
import java.util.Arrays;

public class proceso {
    public int i,j,c1,cf1,c0,cf0;
    public int[][] matriz = new int [1000][1000];
    class H1 implements Runnable{
        //int i=10000, j=10000;
        @Override
        public void run() {
            //int numero;
            //String numero = (int) (Math.random()*2);
            Random numero= new Random();
            for ( i = 0; i <1000; i++) {
                for (j = 0; j <1000; j++) {
                    //int numero= (int) (Math.random()*2);
                    matriz[i][j] = (int) (Math.random()*2);
                }
            }
            /*for(int matriz2[]:matriz){
                System.out.println(Arrays.toString(matriz2));
            }*/
        }
        //boolean s = new Vista.GUI(cf1);
    }
    class H2 implements Runnable{
        @Override
        public void run() {
            for ( i = 0; i <matriz.length ; i++) {
                for (j = 0; j <matriz[i].length; j++) {
                    //System.out.println(i);
                    try {
                        if((matriz[i][j] == 1)&&(matriz[i+1][j]==1)){
                            c1=c1+1;
                            if(c1==5){
                                cf1+=1;
                                c1=0;
                                //System.out.println("Logrado");
                            }

                        }else{
                            c1=0;
                            //System.out.println("No");
                        }
                    }
                    catch(Exception e){
                        //System.out.println("jajaja");
                    }
                }
            }
            //System.out.println("Patrones de 1's:"+cf1);
        }
    }

    class H3 implements Runnable{
        @Override
        public void run() {
            for ( i = 0; i <matriz.length ; i++) {
                for (j = 0; j <matriz[i].length; j++) {
                    //System.out.println(i);
                    try {
                        if((matriz[i][j] == 0)&&(matriz[i+1][j]==0)){
                            c0=c0+1;
                            if(c0==5){
                                cf0+=1;
                                c0=0;
                                //System.out.println("Logrado");
                            }
                        }else{
                            c0=0;
                            //System.out.println("No");
                        }
                    }
                    catch(Exception e){
                        //System.out.println("jajaja");
                    }
                }
            }
            System.out.println("Patrones de 0's:"+cf0);
        }
    }
    public proceso() throws InterruptedException {
        //System.out.println("Hola");
        Thread h1= new Thread(new H1());
        Thread h2 = new Thread(new H2());
        Thread h3= new Thread(new H3());
        h1.start();

        try {
            h1.join();

        }catch (Exception e){
        }
        h2.start();
        try {
            h2.join();
        }catch(Exception e){
        }
        h3.start();

    }
}

class correproceso {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    new proceso();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}