/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import vendingmachineone.main;
import Sound.SoundEffects;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;

public class MainViewController implements Initializable {

    Image pepsi = new Image("Imagez/puolipepsi.png");
    Image vesi = new Image("Imagez/puolivesi.png");
    Image es = new Image("Imagez/puolies.png");
    Image snickers = new Image("Imagez/puolisnickers.png");
    Image broadway = new Image("Imagez/puolibroadway.png");
    Image haribo = new Image("Imagez/puoliharibo.png");
    Image leader = new Image("Imagez/puolileader.png");
    Image jenkki = new Image("Imagez/puolijenkki.png");

    private void disableButtons() {

        textBoxLabel.setText("????????????????");
        textBoxMoney.setText("ERROR 606");
        textBoxMoneyUser.setText("???");
        oneEuroButton.setDisable(true);
        twoEuroButton.setDisable(true);
        twentycentsButton.setDisable(true);
        fiftycentsButton.setDisable(true);
        buttonOne.setDisable(true);
        buttonTwo.setDisable(true);
        buttonThree.setDisable(true);
        buttonFour.setDisable(true);
        buttonFive.setDisable(true);
        buttonSix.setDisable(true);
        buttonSeven.setDisable(true);
        buttonEight.setDisable(true);
        buttonNine.setDisable(true);
        buttonZero.setDisable(true);
        buttonRefund.setDisable(true);
        buttonOk.setDisable(true);
        buttonClear.setDisable(true);
    }

    private void imageSelect(String valinta) {
        if ("1".equals(valinta)) {
            productImage.setImage(pepsi);
        } else if ("2".equals(valinta)) {
            productImage.setImage(vesi);
        } else if ("3".equals(valinta)) {
            productImage.setImage(es);
        } else if ("4".equals(valinta)) {
            productImage.setImage(snickers);
        } else if ("5".equals(valinta)) {
            productImage.setImage(broadway);
        } else if ("6".equals(valinta)) {
            productImage.setImage(haribo);
        } else if ("7".equals(valinta)) {
            productImage.setImage(leader);
        } else if ("8".equals(valinta)) {
            productImage.setImage(jenkki);
        }
    }

    private void clearScreen() {
        setField("");
        textBoxLabel.setText("");
    }

    private void updateMoney() {
        String rahat = String.format("%.2f", main.kone.getMoney());
        textBoxMoney.setText(rahat);
        String käyttäjänrahat = String.format("%.2f", main.käyttäjä.getMoney());
        textBoxMoneyUser.setText(käyttäjänrahat);
    }

    private void insertMoney(double kolikko) {
        double lompakonrahat = main.käyttäjä.getMoney();
        if (lompakonrahat >= kolikko) {
            insertCoinSound();
            main.kone.insertMoney(kolikko);
            main.käyttäjä.removeMoney(kolikko);
            updateMoney();
        } else {
            updateMoney();
        }
    }

    private void refundMoney() {
        double rahat = main.kone.getMoney();
        String palautus = String.format("%.2f", rahat);
        if (rahat > 0) {
            refundSound();
            main.käyttäjä.insertMoney(rahat);
            main.kone.removeMoney(rahat);
            textBoxLabel.setText("Palautettu " + palautus + "€");
            updateMoney();
        } else {
            errorSound();
            textBoxLabel.setText("Ei vaihtorahoja.");
        }
    }

    private void buttonSound() {
        SoundEffects.Sound("buttonPress.mp3");
    }

    private void buySound() {
        SoundEffects.Sound("buySound.mp3");
    }

    private void insertCoinSound() {
        SoundEffects.Sound("insertCoin.mp3");
    }

    private void refundSound() {
        SoundEffects.Sound("coinRefund.mp3");
    }

    private void errorSound() {
        SoundEffects.Sound("errorBeep.mp3");
    }

    private void glassbreakSound() {
        SoundEffects.Sound("glassBreak.mp3");
    }

    private void hornSound() {
        SoundEffects.Sound("dixieHorn.mp3");
    }

    private void fireSound() {
        SoundEffects.Sound("fireSound.mp3");
        SoundEffects.Sound("laugh.mp3");
    }

    private void itemDropSound() {
        SoundEffects.Sound("itemDrop.mp3");
    }

    private String randomChance() {

        int huonotuuri;
        int valinta;
        String lopputulos = "onnistunut";
        huonotuuri = 0 + (int) (Math.random() * 9);
        if (huonotuuri < 3) {
            boolean looppi = true;
            while (looppi == true) {
                valinta = Integer.parseInt(JOptionPane.showInputDialog("Tuote jäi jumiin! Valitse haluamasi toiminta: " + "\n" + "1. jatka elämää"
                        + "\n" + "2. töni laitetta" + "\n" + "3. potkaise laitetta" + "\n"));
                switch (valinta) {
                    case 1:
                        lopputulos = "rahanmenetys";
                        JOptionPane.showMessageDialog(null, "Päätit jatkaa eteenpäin elämässä ja tuote jäi saamatta.");
                        looppi = false;
                        break;
                    case 2:
                        huonotuuri = 0 + (int) (Math.random() * 9);
                        if (huonotuuri < 4) {
                            lopputulos = "onnistunut";
                            JOptionPane.showMessageDialog(null, "Tönäisit laitetta ja tuote tipahti laariin.");
                            looppi = false;
                            break;
                        } else {
                            lopputulos = "rahanmenetys";
                            JOptionPane.showMessageDialog(null, "Tönäisit laitetta, mutta tuote jäi saamatta.");
                            looppi = false;
                            break;
                        }
                    case 3:
                        huonotuuri = 0 + (int) (Math.random() * 9);
                        if (huonotuuri < 5) {
                            lopputulos = "onnistunut";
                            JOptionPane.showMessageDialog(null, "Potkaisit laitetta väkivaltaisesti ja tuote tipahti laariin");
                            looppi = false;
                            break;
                        } else {
                            lopputulos = "gameover";
                            JOptionPane.showMessageDialog(null, "Potkaisit laitetta ja laite hajosi kokonaan, menetit sisällä olevat rahat :-(");
                            looppi = false;
                            break;
                        }
                    default:
                        JOptionPane.showMessageDialog(null, "Virheellinen komento!");
                }
            }
            return lopputulos;
        }
        return lopputulos;
    }

    private void exitGame() {
        System.exit(0);
    }

    private void gameOver() {
        main.kone.removeMoney(main.kone.getMoney());
        updateMoney();
        disableButtons();
    }

    private void buy(String tuote) {
        if (tuote.matches("1|2|3|4|5|6|7|8")) {
            if (main.kone.getMoney() >= main.kone.getPrice(tuote) && main.kone.getStock(tuote) > 0) {
                String tuuri = randomChance();
                if (tuuri == "onnistunut") {
                    buySound();
                    itemDropSound();
                    textBoxLabel.setText("Osto onnistui! ");
                    main.kone.removeStock(tuote);
                    imageSelect(tuote);
                    main.kone.removeMoney(main.kone.getPrice(tuote));
                    main.käyttäjä.putItemi(main.kone.getName(tuote));
                    updateMoney();
                    productImage.setVisible(true);

                } else if (tuuri == "rahanmenetys") {
                    buySound();
                    textBoxLabel.setText("Osto onnistui! ");
                    main.kone.removeStock(tuote);
                    main.kone.removeMoney(main.kone.getPrice(tuote));
                    updateMoney();
                } else {
                    glassbreakSound();
                    krakkiLasi.setVisible(true);
                    gameOver();
                }
            } else if (main.kone.getMoney() < main.kone.getPrice(tuote)) {
                errorSound();
                textBoxLabel.setText("Syötä lisää rahaa");
            } else if (main.kone.getStock(tuote) == 0) {
                errorSound();
                textBoxLabel.setText("Tuote loppu");
            }
        } else if (tuote.matches("666")) {
            if (hellFire.isVisible() == true) {
                hellFire.setVisible(false);
                clearScreen();
            } else {
                fireSound();
                hellFire.setVisible(true);
                clearScreen();
            }
        } else if (tuote.matches("69")) {
            if (explosionGif.isVisible() == true) {
                explosionGif.setVisible(false);
                clearScreen();
            } else {
                hornSound();
                explosionGif.setVisible(true);
                clearScreen();
            }
        } else {
            errorSound();
            textBoxLabel.setText("Virheellinen valinta");
        }
    }

    private String field = "";
    private String raha;

    @FXML
    private ImageView vendingmachineImage, oneEuroImage, twoEuroImage,
            fiftycentsImage, twentycentsImage, hellFire, exitButton, exitText,
            krakkiLasi, explosionGif, productImage;

    @FXML
    private Label textBoxLabel, textBoxMoney, textBoxMoneyUser;

    @FXML
    private Button buttonOne, buttonTwo, buttonThree,
            buttonFour, buttonFive, buttonSix,
            buttonSeven, buttonEight, buttonNine,
            buttonZero, buttonClear, buttonOk, twentycentsButton,
            fiftycentsButton, oneEuroButton, twoEuroButton, buttonRefund,
            buttonExit;

    @FXML
    private void buttonOneAction(ActionEvent event) {
        buttonSound();
        type("1");
    }

    @FXML
    private void buttonTwoAction(ActionEvent event) {
        buttonSound();
        type("2");
    }

    @FXML
    private void buttonThreeAction(ActionEvent event) {
        buttonSound();
        type("3");
    }

    @FXML
    private void buttonFourAction(ActionEvent event) {
        buttonSound();
        type("4");
    }

    @FXML
    private void buttonFiveAction(ActionEvent event) {
        buttonSound();
        type("5");
    }

    @FXML
    private void buttonSixAction(ActionEvent event) {
        buttonSound();
        type("6");
    }

    @FXML
    private void buttonSevenAction(ActionEvent event) {
        buttonSound();
        type("7");
    }

    @FXML
    private void buttonEightAction(ActionEvent event) {
        buttonSound();
        type("8");
    }

    @FXML
    private void buttonNineAction(ActionEvent event) {
        buttonSound();
        type("9");
    }

    @FXML
    private void buttonZeroAction(ActionEvent event) {
        buttonSound();
        type("0");
    }

    @FXML
    private void buttonClearAction(ActionEvent event) {
        buttonSound();
        clearScreen();
    }

    @FXML
    private void buttonOkAction(ActionEvent event) {
        String valinta = getField();
        setField("");
        buy(valinta);
    }

    @FXML
    private void twentycentsButtonAction(ActionEvent event) {
        insertMoney(0.20);
    }

    @FXML
    private void fiftycentsButtonAction(ActionEvent event) {
        insertMoney(0.50);
    }

    @FXML
    private void oneEuroButtonAction(ActionEvent event) {
        insertMoney(1);
    }

    @FXML
    private void twoEuroButtonAction(ActionEvent event) {
        insertMoney(2);
    }

    @FXML
    private void buttonRefundAction(ActionEvent event) {
        refundMoney();
        setField("");
    }

    @FXML
    private void buttonExitAction(ActionEvent event) {
        exitGame();
    }

    private void type(String symbol) {
        setField(getField() + symbol);
        textBoxLabel.setText(getField());

    }

    private void moneyText(String raha) {
        textBoxMoney.setText(Double.toString(main.kone.getMoney()));
    }

    private void moneyTextUser(String raha) {
        textBoxMoneyUser.setText(Double.toString(main.käyttäjä.getMoney()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // juoksee heti kun ikkuna avautuu
        textBoxLabel.setText("Syötä tuotenumero: ");
        textBoxMoney.setText("Syötetyt rahat");
        updateMoney();
        hellFire.setVisible(false);
        krakkiLasi.setVisible(false);
        explosionGif.setVisible(false);
        productImage.setVisible(false);
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

}
