package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class DarbasSuFailu {

    private static final char SEPARATOR = '|';
    private static final String SEPARATOR_REGEX = "\\|";
    private static final char NEW_LINE = '\n';

    private String _failoVardas = "duomenys.txt";
    private FileReader _in;
    private BufferedReader _bufferis;
    private Scanner _sc;
    private FileWriter _out;

    public void atidarytiFaila() {
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
    }

    public void skaitymasIsFailo() {
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                System.out.println(eilute);
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
    }

    private int gaukFailoEiluciuKieki() {
        atidarytiFaila();
        int rezultatas = 0;
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                rezultatas++;
                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
        return rezultatas;
    }

    public void irasymasIFaila() {
        System.out.println("Iveskite teksta ka rasysite i faila");
        System.out.println("parasius pabaiga irasymas bus nutrauktas");
        _sc = new Scanner(System.in);
        String tekstas = _sc.nextLine();
        try {

            _out = new FileWriter(_failoVardas);
            while (!tekstas.equals("pabaiga")) {
                _out.write(tekstas);
                _out.write('\n');
                tekstas = _sc.nextLine();
            }
            _out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFileContent(int eilutesNumeris) {
        String[] eilutes = new String[gaukFailoEiluciuKieki()];

        try {
            atidarytiFaila();
            for (int i = 0; i < eilutes.length; i++) {
                eilutes[i] = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();

            _out = new FileWriter(_failoVardas);
            for (int i = 0; i < eilutes.length; i++) {
                if (i != eilutesNumeris) {
                    _out.write(eilutes[i]);
                    _out.write('\n');
                }
            }
            _out.close();

        } catch (Exception e) {

        }


    }

    public void pridekEilute(String name, int age, int height, String color) {
        try {

            _out = new FileWriter(_failoVardas, true);
            _out.write(NEW_LINE);
            _out.write(name);
            _out.write(SEPARATOR);
            _out.write("" + age);
            _out.write(SEPARATOR);
            _out.write("" + height);
            _out.write(SEPARATOR);
            _out.write(color);
            _out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void findByColor(String color) {
        atidarytiFaila();
        try {
            String eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split(SEPARATOR_REGEX);

                if (zodziai[3].toLowerCase().equals(color.toLowerCase())) {
                    System.out.println(eilute);
                }

                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
        } catch (Exception e) {

        }
    }

    public void findHighest() {
        atidarytiFaila();
        try {
            String eilute = _bufferis.readLine();
            float maxUgis = Float.MIN_VALUE;
            String eiluteRadom ="";
            while (eilute != null) {
                String[] zodziai = eilute.split(SEPARATOR_REGEX);
                float ugis = Float.parseFloat(zodziai[2]);
                if (ugis > maxUgis) {
                    maxUgis = ugis;
                    eiluteRadom=eilute;
                }

                eilute = _bufferis.readLine();
            }
            _bufferis.close();
            _in.close();
            System.out.println("Auksciausias zmogus: " + eiluteRadom);
        } catch (Exception e) {

        }
    }
}
