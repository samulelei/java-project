/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sound;

public class SoundEffects {
     public static final String SOUNDPATH = "Sounds/";

public static void Sound(String file){
        Sound Sound = new Sound(SOUNDPATH+file);
        Sound.play();
    }
}