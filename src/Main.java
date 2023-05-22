import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int numOfCards = 2;
        int cardStartOne;
        int cardStartTwo;

        String end;

        System.out.println("Vítejte v casinu");
        System.out.println("Jsi starší 18-ti let? (ano/ne)");
        String age = sc.nextLine().trim().toLowerCase();

        switch (age) {
            case "ano" -> {
                System.out.println("Kolik peněz u sebe máš?");
                double money = sc.nextDouble();

                System.out.println("Kolik chceš vsadit?");
                double bet = sc.nextDouble();

                sc.nextLine();

                if (money > bet) {
                    cardStartOne = rd.nextInt(5) + 1;
                    System.out.println("Obdržel jsi první kartu s hodnotou: " + cardStartOne);

                    cardStartTwo = rd.nextInt(5) + 1;
                    System.out.println("Obdržel jsi druhou kartu s hodnotou: " + cardStartTwo);

                    int cardValue = cardStartOne + cardStartTwo;

                    System.out.println("Aktuální hodnota tvých karet: " + cardValue);
                    System.out.println("Aktuální počet tvých karet " + numOfCards);

                    System.out.println("Přejete si zahájit hru?");
                    String start = sc.nextLine().trim().toLowerCase();

                    switch (start) {
                        case "ano" -> {
                            System.out.println("Aktuální hodnota tvých karet je: " + cardValue);
                            System.out.println("Aktuální počet tvých karet je: " + numOfCards);

                            do {
                                System.out.println("Vytáhl jste si kartu.");
                                int newCard = rd.nextInt(7) + 1;
                                cardValue += newCard;
                                numOfCards++;

                                System.out.println("Hodnota nové karty: " + newCard);

                                System.out.println("Aktuální hodnota karet: " + cardValue);
                                System.out.println("Aktuální počet karet: " + numOfCards);

                                if (cardValue > 21) {
                                    System.out.println("Bust");
                                    end = "ne";
                                } else if (cardValue == 21) {
                                    System.out.println("Blackjack");
                                    end = "ne";
                                } else {
                                    System.out.println("Chcete další kartu? (ano/ne)");
                                    end = sc.nextLine();
                                }
                            } while (end.equals("ano"));
                        }
                        case "ne" -> System.out.println("Tak třeba příště.");

                        default -> System.out.println("Mluvte zřetelně");
                    }
                }
            }
            case "ne" -> System.out.println("Sem mají přístup jen dospělí.");

            default -> System.out.println("Mluvte zřetelně");
        }
    }
}
