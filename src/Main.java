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

        System.out.println("Chcete zobrazit pravidla? (ano/ne)");
        String rules = sc.nextLine().trim().toLowerCase();
        if (rules.equals("ano")) {
            String rulesText = """
                    Při příchodu do kasína budete moci vsadit nějaké peníze.
                    Poté dostanete dvě karty a uvidíte jejich hodnotu.
                    Až potom se budete moci rozhodnout, jestli opravdu budete chtít zahájit hru.
                    Pokud ano, vytáhnete si kartu, podíváte se na její hodnotu a na základě toho si vyberete, zda chcete další kartu.
                    Pokud budete mít štěstí a Vaše hodnota karet bude rovna 21, hra automaticky zkončí a Vaše sázka bude zdvojnásobena.
                    Pokud ovšem hodnota Vašich karet přesáhne 21 hra zkončí a Vy přijdete o svou sázku.
                    Hned po Vaší hře odehraje svou hru krupiér.
                    Pokud budete mít více než krupiér, vyhrál jste.
                    Pokud budete mít méně než krupiér, prohrál jste.
                    Pokud budete mít stejně, hra se resetuje a Vaše sázka bude vrácena.""";
            System.out.println(rulesText);
        }
        System.out.println();
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

                    System.out.println();

                    int cardValue = cardStartOne + cardStartTwo;

                    System.out.println("Aktuální hodnota tvých karet: " + cardValue);
                    System.out.println("Aktuální počet tvých karet " + numOfCards);

                    System.out.println();

                    System.out.println("Přejete si zahájit hru?");
                    String start = sc.nextLine().trim().toLowerCase();

                    switch (start) {
                        case "ano" -> {
                            System.out.println("Aktuální hodnota tvých karet je: " + cardValue);
                            System.out.println("Aktuální počet tvých karet je: " + numOfCards);

                            System.out.println();

                            do {
                                System.out.println("Vytáhl jste si kartu.");
                                int newCard = rd.nextInt(7) + 1;
                                cardValue += newCard;
                                numOfCards++;

                                System.out.println("Hodnota nové karty: " + newCard);
                                System.out.println("Aktuální hodnota karet: " + cardValue);
                                System.out.println("Aktuální počet karet: " + numOfCards);

                                System.out.println();

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
                            System.out.println("Nyní začíná hrát krupiér.");

                            int krupierCardOne = rd.nextInt(11) + 4;
                            int krupierCardTwo = rd.nextInt(11) + 4;
                            int krupierCardValue = krupierCardOne + krupierCardTwo;

                            System.out.println("Hodnota karet krupiéra: " + krupierCardValue);

                            if (krupierCardValue > 21) {
                                System.out.println("Bust");
                                krupierCardValue = 0;
                            } else if (krupierCardValue == 21) {
                                System.out.println("Blackjack");
                                cardValue = 0;
                            }

                            if (cardValue > krupierCardValue) {
                                System.out.println("Gratulujeme, vyhrál jste.");
                                bet *= 2;
                            } else if (cardValue < krupierCardValue) {
                                System.out.println("Je nám líto, prohrál jste.");
                                money -= bet;
                            }
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

