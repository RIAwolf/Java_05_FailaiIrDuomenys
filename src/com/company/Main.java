package com.company;

import java.util.Scanner;

public class Main {
    public static final int ACTION_SHOW_ALL = 1;
    public static final int ACTION_DELETE_ONE = 2;
    public static final int ACTION_ADD_ONE = 3;
    public static final int ACTION_FIND_COLOR = 4;
    public static final int ACTION_FIND_HIGHEST = 5;
    public static final int ACTION_CLOSE = 0;


    public static void main(String[] args) {
        // write your code here

        Main objektas = new Main();
        objektas.run();
    }


    public void pagrindinisMeniu() {
        System.out.println("==========================");
        System.out.println("Iveskite norima veiksma:");
        System.out.println(ACTION_SHOW_ALL + " - parodyti visus irasus");
        System.out.println(ACTION_DELETE_ONE + " - istrinti viena eilute");
        System.out.println(ACTION_ADD_ONE + " - prideti viena irasa");
        System.out.println(ACTION_FIND_COLOR + " - rasti pagal spalva");
        System.out.println(ACTION_FIND_HIGHEST + " - rasti auksciausia");
        System.out.println(ACTION_CLOSE + " - baigti darba");
    }


    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        DarbasSuFailu obj = new DarbasSuFailu();
        while (arTesti == true) {
            pagrindinisMeniu();
            int veiksmas = sc.nextInt();

            switch (veiksmas) {
                case ACTION_SHOW_ALL:
                    obj.atidarytiFaila();
                    obj.skaitymasIsFailo();
                    break;
                case ACTION_DELETE_ONE:
                    System.out.println("Kuria eilute norite trinti?");
                    int eilNr = sc.nextInt();
                    obj.deleteFileContent(eilNr);
                    break;
                case ACTION_ADD_ONE:
                    System.out.println("Koks vardas?");
                    String name= sc.next();
                    System.out.println("Koks amzius?");
                    int age = sc.nextInt();
                    System.out.println("Koks ugis(cm)?");
                    int height = sc.nextInt();
                    System.out.println("Kokia akiu spalva?");
                    String color = sc.next();
                    obj.pridekEilute(name, age, height,color);
                    break;
                case ACTION_FIND_COLOR:
                    System.out.println("Kokios spalvos ieskome?");
                    color= sc.next();
                    obj.findByColor(color);
                    break;
                case ACTION_FIND_HIGHEST:
                    obj.findHighest();
                    break;
                case ACTION_CLOSE:
                    arTesti = false;
                    break;
            }
        }
    }

}
