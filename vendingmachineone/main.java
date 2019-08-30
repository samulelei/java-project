/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachineone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Controllers.*;

public class main extends Application {

    public static VendingMachineUser käyttäjä;
    public static VendingMachine kone;

    public static void setKone(VendingMachine kone) {
        main.kone = kone;
    }

    public static VendingMachine getKone() {
        return kone;
    }

    public static void setKäyttäjä(VendingMachineUser käyttäjä) {
        main.käyttäjä = käyttäjä;
    }

    public static VendingMachineUser getKäyttäjä() {
        return käyttäjä;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Controllers/MainView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VendingMachine uusikone = new VendingMachine();
        VendingMachineUser uusikäyttäjä = new VendingMachineUser(20);
        setKäyttäjä(uusikäyttäjä);
        setKone(uusikone);
        launch(args);
    }
}
