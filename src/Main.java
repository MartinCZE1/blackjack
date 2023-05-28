import java.sql.SQLOutput;
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
        String endGame = "ano";
        System.out.println("----------- CASINO -----------");
        System.out.println("Vítejte v casinu!");

        System.out.println("----------- PRAVIDLA -----------");

        System.out.println("Chcete zobrazit pravidla? (ano/ne)");
        String rules = sc.nextLine().trim().toLowerCase();
        if (rules.equals("ano")) {
            String rulesText = """
                    Při příchodu do kasína budete moci vsadit peníze.
                    Poté dostanete dvě karty a uvidíte jejich hodnotu.
                    Až potom se budete moci rozhodnout, jestli opravdu budete chtít zahájit hru. 
                    Pokud nebude chtít hru zahájit, budete moci vsadit znovu a zkusit štěstí s novými kartami.
                    Pokud hru zahájíte, vytáhnete si kartu, podíváte se na její hodnotu a na základě toho si vyberete, zda chcete další kartu.
                    Pokud budete mít štěstí a Vaše hodnota karet bude rovna 21, hra automaticky skončí a Vaše sázka bude zdvojnásobena.
                    Pokud ovšem hodnota Vašich karet přesáhne 21 hra skončí a Vy přijdete o svou sázku.
                    V případě, že hodnota Vašich karet bude menší, bež hodnota karet krupiéra, prohrál jste. 
                    V opačném případě, kdy hodnota Vašich karet bude větší, než hodnota karet krupiéra, vyhrál jste.
                    Pokud budete mít stejně, hra se resetuje a Vaše sázka bude vrácena.
                    Krupiér začíná hrát až po Vaší hře.
                    Hodnoty karet: karty s čísly - hodnota karty je napsána na kartě, A - hodnota karty je jedna, J, Q, K - hodnota karet je 10.
                    Po konci hry se můžete rozhodnout, jestli budete pokračovat ve hře, nebo odejdete. \n
                    UPOZORNĚNÍ:
                    Kasíno neručí za ztracené peníze. Vždy sázejte peníze, které jste připraveni ztratit.
                    Účast na hazardní hře je čistě dobrovolná.
                    Účastí na hazardní hře potvrzujete, že jste starší 18-ti let.
                    """;
            System.out.println(rulesText);
        }

        System.out.println("Jste starší 18-ti let? (ano/ne)");
        String age = sc.nextLine().trim().toLowerCase();

        switch (age) {
            case "ano" -> {
                System.out.println("----------- PENÍZE A SÁZKY -----------");

                System.out.println("Kolik peněz máte u sebe?");
                double money = sc.nextDouble();

                do {
                    System.out.println("Kolik chcete vsadit?");
                    double bet = sc.nextDouble();

                    sc.nextLine();

                    if (bet == 0) {
                        System.out.println("Pro zahájení hry musíte něco vsadit.");
                    } else if (money > bet) {

                        System.out.println("----------- ROZDÁNÍ PRVNÍCH KARET -----------");

                        cardStartOne = rd.nextInt(10) + 5;
                        if (cardStartOne == 11) {
                            System.out.println("Obdržel jste první kartu s hodnotou: J");
                            cardStartOne = 10;
                        } else if (cardStartOne == 12) {
                            System.out.println("Obdržel jste první kartu s hodnotou: Q");
                            cardStartOne = 10;
                        } else if (cardStartOne == 13) {
                            System.out.println("Obdržel jste první kartu s hodnotou: K");
                            cardStartOne = 10;
                        } else if (cardStartOne == 14) {
                            System.out.println("Obdržel jste první kartu s hodnotou: A");
                            cardStartOne = 1;
                        } else {
                            System.out.println("Obdržel jste první kartu s hodnotou: " + cardStartOne);
                        }

                        cardStartTwo = rd.nextInt(4) + 1;
                        System.out.println("Obdržel jste druhou kartu s hodnotou: " + cardStartTwo);

                        System.out.println();

                        int cardValue = cardStartOne + cardStartTwo;

                        System.out.println("Aktuální hodnota Vašich karet: " + cardValue);
                        System.out.println("Aktuální počet Vašich karet " + numOfCards);

                        System.out.println();

                        System.out.println("Přejete si zahájit hru?");
                        String start = sc.nextLine().trim().toLowerCase();

                        switch (start) {
                            case "ano" -> {
                                System.out.println("----------- START HRY -----------");
                                do {
                                    System.out.println("Vytáhl jste si kartu.");
                                    int newCard = rd.nextInt(5) + 5;
                                    if (newCard == 6) {
                                        System.out.println("Hodnota nové karty: J");
                                        newCard = 10;
                                    } else if (newCard == 7) {
                                        System.out.println("Hodnota nové karty: Q");
                                        newCard = 10;
                                    } else if (newCard == 8) {
                                        System.out.println("Hodnota nové karty: K");
                                        newCard = 10;
                                    } else if (newCard == 9) {
                                        System.out.println("Hodnota nové karty: A");
                                        newCard = 1;
                                    } else {
                                        System.out.println("Hodnota nové karty: " + newCard);
                                    }

                                    cardValue += newCard;
                                    numOfCards++;

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

                                System.out.println("----------- START HRY KRUPIÉRA -----------");

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

                                System.out.println("----------- KONEC HRY -----------");

                                if ((cardValue > krupierCardValue) && (cardValue <= 21)) {
                                    System.out.println("Gratulujeme, vyhrál jste. Vaše sázka byla zdvojnásobena.");
                                    money += bet * 2;
                                    System.out.println("Váš aktuální počet peněz: " + money);
                                } else if ((cardValue < krupierCardValue) && (krupierCardValue <= 21)) {
                                    System.out.println("Je nám líto, prohrál jste. Vaše sázka propadla ve prospěch kasínu.");
                                    money -= bet;
                                    System.out.println("Váš aktuální počet peněz: " + money);
                                } else if (cardValue > 21) {
                                    System.out.println("Je nám líto, prohrál jste. Vaše sázka propadla ve prospěch kasínu.");
                                    money -= bet;
                                    System.out.println("Váš aktuální počet peněz: " + money);
                                } else if ((cardValue <= 21 && krupierCardValue > 21)) {
                                    System.out.println("Gratulujeme, vyhrál jste. Vaše sázka byla zdvojnásobena.");
                                    money += bet * 2;
                                    System.out.println("Váš aktuální počet peněz: " + money);
                                } else if ((cardValue > 21 && krupierCardValue > 21) || (cardValue == krupierCardValue)) {
                                    System.out.println("Remíza, sázka byla navrácena.");
                                    System.out.println("Váš aktuální počet peněz: " + money);
                                }
                                System.out.println("Chcete pokračovat ve hře? (ano/ne)");
                                endGame = sc.nextLine();
                                if (endGame.equals("ano")) {
                                    krupierCardValue = 0;
                                    cardValue = 0;
                                } else {
                                    System.out.println("Děkujeme za Vaši věrnost. Nashledanou!");
                                }
                            }
                            case "ne" -> System.out.println("Tak třeba příště.");

                            default -> System.out.println("Mluvte zřetelně");
                        }
                    } else if (money < bet) {
                        System.out.println("Váš obnos peněz není dostačující pro požadovanou sázku.");
                    }
                } while (endGame.equals("ano"));
            }
            case "ne" -> System.out.println("Sem mají přístup jen dospělí.");

            default -> System.out.println("Mluvte zřetelně");
        }
    }
}