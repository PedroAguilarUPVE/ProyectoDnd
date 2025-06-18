package vistas;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Msica {

	public static void main(String[] args) {
		   try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Soporte\\eclipse-workspace\\Swing\\src\\sonido\\Y2meta.mp3").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }

	}

}
