import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.println("Vítejte v casinu");
        System.out.println("Jsi starší 18-ti let? (ano/ne)");
        String age = sc.nextLine().trim().toLowerCase();
//start
        switch (age) {
            case "ano" -> {
                System.out.println("Kolik máš u sebe peněz");
                int money = sc.nextInt();

                System.out.println("Kolik chceš vsadit?");
                int bet = sc.nextInt();

                int numOfCards;
                int cardStartOne;
                int cardStartTwo;

                if (money < bet) {
                    System.out.println("Hodnota tvého mění nestačí na požadovanou sázku.");
                } else if (bet == 0) {
                    System.out.println("Musíte něco přeci vsadit");
                } else if (money > bet) {
                    cardStartOne = rd.nextInt(5);
                    System.out.println("Obdržel jsi první kartu s hodnotou: " + cardStartOne);

                    cardStartTwo = rd.nextInt(5);
                    System.out.println("Obdržel jsi druhou kartu s hodnotou: " + cardStartTwo);

                    System.out.println("Chcete opravdu zahájit hru? (ano/ne)");
                    String start = sc.nextLine().trim().toLowerCase();

                    if (start.equals("ano")) {
                        int cardValue = cardStartOne + cardStartTwo;
                        numOfCards = 2;
                        System.out.println("Aktuální hodnota tvých karet je: " + cardValue);
                        System.out.println("Aktuální počet tvých karet je: " + numOfCards);
                    } else {
                        System.out.println("Tak snad příště. Mějte se.");
                    }
                }
            }
            case "ne" -> System.out.println("Sem mohou pouze osoby starší 18-ti let.");
        }
    }
}
