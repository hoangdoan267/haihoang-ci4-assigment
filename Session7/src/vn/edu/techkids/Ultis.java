package vn.edu.techkids;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Trà Đá on 5/13/2016.
 */
public class Ultis {
    public static void playSound(String audioUrl, boolean repeat){

        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(repeat){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }else{
                clip.loop(0);
            }

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
