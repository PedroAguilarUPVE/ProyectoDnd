package vistas;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class audio {

	public static void main(String args[]) {

		try {
			final JFrame f = new JFrame();
			File yourFile;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			final Clip clip;
			yourFile = new File("C:\\Users\\PTC-ISC\\eclipse-workspace\\BaseDatosVistas\\src\\sonido\\alarma.wav");

			stream = AudioSystem.getAudioInputStream(yourFile);
			format = stream.getFormat();
			final long frames = stream.getFrameLength();
			final double durationInSeconds = (frames + 0.0) / format.getFrameRate();
			final JSlider slider = new JSlider(0, (int) Math.round(durationInSeconds), 0);
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();

			f.add(slider);
			f.pack();
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			TimerTask timerTask = new TimerTask() {

				@Override
				public void run() {
// TODO Auto-generated method stub
					{
						double timeNow = (durationInSeconds * clip.getFramePosition()) / frames;
						slider.setValue((int) Math.round(timeNow));
						f.repaint();
					}

				}
			};
			Timer timer = new Timer("MyTimer");// create a new Timer

			timer.scheduleAtFixedRate(timerTask, 30, 30);// this line starts the timer at the same time its executed

		}

		catch (Exception e) {
			System.out.println(e);
		}

	}
}