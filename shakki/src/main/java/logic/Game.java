/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import components.Lauta;
import components.Kuningas;
import components.Sotilas;
import components.Lahetti;
import components.Kuningatar;
import components.Nappula;
import components.Torni;
import components.Ratsu;
import java.util.Scanner;
import java.util.regex.*;
import javax.swing.JLabel;
import ui.*;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import history.*;
import variants.*;

/**
 *
 * @author oemkulma
 */
public class Game {
    private Variant variant;
    private Lauta lauta;
    private TurnHistory historia;
    private Nappula.Puoli vuoro;
    public Game() {
        this.variant = new Standard(); 
        variant.setUp();
        this.lauta = variant.getLauta();
        this.historia = new TurnHistory();
        this.vuoro = variant.getAloittaja();
    }
    
    public Object[] suoritaKomento(JTextField komentoKentta, JTextArea historiaKentta) {
        int[][] startEndPoints = Parser.parseCommand(komentoKentta.getText(), vuoro, lauta);
        if (startEndPoints == null) {
            System.out.println("Laiton siirto");
        } else {
            if (startEndPoints[0] == null) {
                int[] start = {0, 0};
                startEndPoints[0] = start;
                return startEndPoints;
            }
            if (startEndPoints[1] == null) {
                return null;
            }
            if (startEndPoints[0][0] < 8 && startEndPoints[0][0] > -1 && startEndPoints[0][1] < 8 && startEndPoints[0][1] > -1) {
                Nappula nappula = lauta.getNappula(startEndPoints[0]);
                if (nappula.getPuoli() != vuoro) {
                    System.out.println("Ruudussa ei nappulaasi");
                }
                if (Liikkuminen.koitaSiirtya(nappula, startEndPoints[1], lauta)) {
                    if (vuoro == Nappula.Puoli.VALKOINEN) {
                        vuoro = Nappula.Puoli.MUSTA;
                    } else {
                        vuoro = Nappula.Puoli.VALKOINEN;
                    }
                    if (!historia.getList().isEmpty()) {
                        if (historia.getViimeinenVuoro().isComplete()) {
                            historia.addTurn(new Turn(historia.getVuoroNumero(), komentoKentta.getText(), ""));
                        } else {
                            if (historia.getViimeinenVuoro().getWhiteMove().isEmpty()) {
                                historia.getViimeinenVuoro().setWhiteMove(komentoKentta.getText());
                            } else if (historia.getViimeinenVuoro().getBlackMove().isEmpty()) {
                                historia.getViimeinenVuoro().setBlackMove(komentoKentta.getText());
                            }
                        }
                    } else {
                        historia.addTurn(new Turn(historia.getVuoroNumero(), komentoKentta.getText(), ""));
                    }
                } else {
                    System.out.print("(" + startEndPoints[0][0] + "," + startEndPoints[0][1] + ")");
                    System.out.println("-(" + startEndPoints[1][0] + "," + startEndPoints[1][1] + ")");
                    System.out.println("Laiton siirto");
                }
            } else {
                System.out.println("ruutu "
                        + "(koordinaatit {" + startEndPoints[0][0] + ","
                        + startEndPoints[0][1] + "})" + " ei laudalla");
            }
        }
        komentoKentta.setText("");
        historiaKentta.setText(historia.toString());
        Object[] returnVal = {vuoro, historia};
        return returnVal;
    }

    public Lauta getLauta() {
        return lauta;
    }
    public TurnHistory getTurnHistory() {
        return historia;
    }
    public Nappula.Puoli getVuoro() {
        return vuoro;
    }
    public static void main(String[] args) {
        Game peli = new Game();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UI ui = new UI(peli);
                ui.setVisible(true);
                ui.updateUI();
            }
        });
        Nappula.Puoli vuoro = Nappula.Puoli.VALKOINEN;

    }

    public static Object[] suoritaKomento(Lauta lauta, Nappula.Puoli vuoro, JTextField komentoKentta, JTextArea historiaKentta, TurnHistory historia) {
        int[][] startEndPoints = Parser.parseCommand(komentoKentta.getText(), vuoro, lauta);
        if (startEndPoints == null) {
            System.out.println("Laiton siirto");
        } else {
            if (startEndPoints[0] == null) {
                int[] start = {0, 0};
                startEndPoints[0] = start;
                return startEndPoints;
            }
            if (startEndPoints[1] == null) {
                return null;
            }
            if (startEndPoints[0][0] < 8 && startEndPoints[0][0] > -1 && startEndPoints[0][1] < 8 && startEndPoints[0][1] > -1) {
                Nappula nappula = lauta.getNappula(startEndPoints[0]);
                if (nappula.getPuoli() != vuoro) {
                    System.out.println("Ruudussa ei nappulaasi");
                }
                if (Liikkuminen.koitaSiirtya(nappula, startEndPoints[1], lauta)) {
                    if (vuoro == Nappula.Puoli.VALKOINEN) {
                        vuoro = Nappula.Puoli.MUSTA;
                    } else {
                        vuoro = Nappula.Puoli.VALKOINEN;
                    }
                    if (!historia.getList().isEmpty()) {
                        if (historia.getViimeinenVuoro().isComplete()) {
                            historia.addTurn(new Turn(historia.getVuoroNumero(), komentoKentta.getText(), ""));
                        } else {
                            if (historia.getViimeinenVuoro().getWhiteMove().isEmpty()) {
                                historia.getViimeinenVuoro().setWhiteMove(komentoKentta.getText());
                            } else if (historia.getViimeinenVuoro().getBlackMove().isEmpty()) {
                                historia.getViimeinenVuoro().setBlackMove(komentoKentta.getText());
                            }
                        }
                    } else {
                        historia.addTurn(new Turn(historia.getVuoroNumero(), komentoKentta.getText(), ""));
                    }
                } else {
                    System.out.print("(" + startEndPoints[0][0] + "," + startEndPoints[0][1] + ")");
                    System.out.println("-(" + startEndPoints[1][0] + "," + startEndPoints[1][1] + ")");
                    System.out.println("Laiton siirto");
                }
            } else {
                System.out.println("ruutu "
                        + "(koordinaatit {" + startEndPoints[0][0] + ","
                        + startEndPoints[0][1] + "})" + " ei laudalla");
            }
        }
        komentoKentta.setText("");
        historiaKentta.setText(historia.toString());
        Object[] returnVal = {vuoro, historia};
        return returnVal;
    }
    
    public static void setHistory(String string) {
        TurnHistory historia = TurnHistory.parseString(string);
        
    }
}