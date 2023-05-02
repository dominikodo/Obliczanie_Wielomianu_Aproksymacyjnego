import java.util.Scanner;

public class AproksymacjaTest {

    public static void main(String[] args) {

        boolean wylacz = false;
        while (wylacz==false) {

            Aproksymacja aproksymacja = new Aproksymacja();
            Scanner scanner = new Scanner(System.in);

            String nazwaPliku = new String();

            int m=0;

            System.out.println("Podaj nazwe ścieżkę pliku: ");

            nazwaPliku = scanner.nextLine();


            aproksymacja.odczytZPliku(nazwaPliku);

            System.out.println("Podaj m ");

            m=scanner.nextInt();

            aproksymacja.obliczWzor(m);

            //C:\Users\piese\Desktop\Metody Obliczeniowe\Oblicznie_Wielomianu_Interpolacyjnego\Interpolacja\plik.txt
        }

    }
}
