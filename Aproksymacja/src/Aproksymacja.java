import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Aproksymacja {

    private ArrayList<Punkt> listaPunktow;

    Aproksymacja(){

        listaPunktow=new ArrayList<>();



    }

    void odczytZPliku (String nazwaPliku){

        File file = new File(nazwaPliku);//tworzenie obiektu file
        //System.out.println("test");

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextDouble()) {

                Punkt punkt=new Punkt();

                //System.out.println("test");

                punkt.setLocation(scanner.nextDouble(), scanner.nextDouble());
                listaPunktow.add(punkt);

                //System.out.println("punkt"+ scanner.nextDouble()+","+scanner.nextDouble());
                System.out.println("punkt: ("+punkt.getX()+","+punkt.getY()+")");
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku lub nie da się otworzyć");
            System.exit(0);
        }
        catch (InputMismatchException e) {
            System.out.println("Dane w pliku nie są liczbami");
            System.exit(0);
        }
        //System.out.println(listaPunktow);
    }
    void obliczWzor(int m){//chwilowo w tym repozytorium bo drugiego nie wypushowałem

        int k=m*2;
        int i = listaPunktow.size();

        double sWyznacznik;

        double[] sumaSk, sumaTk;

        double[][] tabSk,tabTk, s, t, sDopelnien, sTransponowana, sOdwrotna;



        tabSk= new double[i][(k+1)];//tablka wartosci Sk
        System.out.println("Tabelka s:");

        for(int j=0; j<i;  j++){
            for(int l=k; l>=0; l--){

                tabSk[j][l] = Math.pow(listaPunktow.get(j).getX(),l);
                System.out.printf("%f ",tabSk[j][l]);

            }
            System.out.printf("\n");
        }


        System.out.println("\nTabelka t:");

        tabTk = new double[i][m+1];//tablka wartosci Tk
        for(int j=0; j<i;  j++){
            for(int l=m; l>=0; l--){

                tabTk[j][l] = tabSk[j][l] *listaPunktow.get(j).getY();
                System.out.printf("%f ",tabTk[j][l]);
            }
            System.out.printf("\n");
        }

        sumaSk = new double[k+1];

        for(int j=0; j<k+1;  j++){
            for(int l=0; l<i; l++){

                sumaSk[j] += tabSk[l][j];

            }
            //System.out.println("sumaSk "+sumaSk[j]);
        }

        sumaTk = new double[m+1];

        for(int j=0; j<m+1;  j++){
            for(int l=0; l<i; l++){

                sumaTk[j] += tabTk[l][j];

            }
            //System.out.println("sumaTk "+sumaTk[j]);
        }


        s = new double[m+1][m+1];
        System.out.println("\nMacierz s:");

        for(int j=0; j<m+1;  j++){
            for(int l=0; l<m+1; l++){

                s[j][l]= sumaSk[j+l];

                System.out.printf("%f ",s[j][l]);

            }
            System.out.printf("\n");

        }

        sWyznacznik=obliczWyznacznik(m+1,s);

        System.out.println("\nWyznacznik s: "+sWyznacznik);

        /*
        sDopelnien = new double[m+1]][m+1];
        for(int j=0; j<m+1;  j++){
            for(int l=0; l<m+1; l++){

                sDopelnien[][]= Math.pow((-1),j+l)*obliczWyznacznik(m+1,s[][]);

            }
        } */



    }
    double obliczWyznacznik(int stopien, double[][] tab){

        double wyznacznik=0;

            if(stopien==1){

                wyznacznik=tab[0][0];


            }
            else if(stopien==2){

                wyznacznik=tab[0][0]*tab[1][1]-tab[0][1]*tab[1][0];

            }
            else if(stopien==3){

                wyznacznik= tab[0][0]*tab[1][1]*tab[2][2] + tab[0][1]*tab[1][2]*tab[2][0] + tab[0][2]*tab[1][0]*tab[2][1]
                        - tab[0][2]*tab[1][1]*tab[2][0] - tab[0][1]*tab[1][0]*tab[2][2] - tab[0][0]*tab[1][2]*tab[2][1];


            }
            else if (stopien>3){

                wyznacznik=0;


            }


        return wyznacznik;
    }

}
