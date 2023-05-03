import java.util.Scanner;

/**
 * Program liczący wielomian aproksymacyjny
 * Z pliku odczytuje punkty i na ich podstawie liczy wielomian aproksymacyjny
 * Stopien wielomianu aproksymacyjnego jest podawany przez użytkownika
 *
 * @version 1.0 2023-05-03
 * @author Dominik Odo
 */
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

            //C:\Users\piese\Desktop\Metody Obliczeniowe\Obliczanie_Wielomianu_Aproksymacyjnego\Aproksymacja\plik.txt
        }

    }
}
