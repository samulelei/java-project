package Sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Sound {

String file;
Media sound;
MediaPlayer player;

public Sound(String file) {
        this.file = file;
        this.sound = new Media(new File(file).toURI().toString());
        this.player = new MediaPlayer(sound);
    }

    public void play(){
        player.play();
    }

    public void stop(){
        player.stop();
    }

    public void setVolume(double value){
        player.setVolume(value);
    }

    public double getVolume(){
        return player.getVolume();
    }
}