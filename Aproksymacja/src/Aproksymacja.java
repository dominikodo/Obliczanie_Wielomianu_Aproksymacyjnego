import java.io.File;
import java.io.FileNotFoundException;
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

        double sWyznacznik

        double[][] tabSk,tabTk, s, t, sDopalnien, sTransponowana, sOdwrotna;

        tabSk= new double[i][(k+1)];

        for(int j=0; j<=i;  j++){
            for(int l=k; l>=0; l--){

                tabSk[j][l] = Math.pow(listaPunktow.get(j).getX(),l);

            }
        }

        tabTk = new double[i][m];

        for(int j=0; j<=i;  j++){
            for(int l=0; l=2; l++){

                tabTk[j][m] = Math.pow(listaPunktow.get(j).getX(),l);

            }
        }


    }


}
