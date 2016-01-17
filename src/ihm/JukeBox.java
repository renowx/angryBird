package ihm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class JukeBox {
	
	static HashMap<String, Clip> clips;
	private static int gap;
	public static boolean mute = false;
	private static String currentMusic;
	
	/**
	 * Initialise la hashmap
	 */
	public static void init() {
		clips = new HashMap<String, Clip>();
		gap = 0;
	}
	
	/**
	 * charge la musique
	 * @param s Le chemin de la musique
	 * @param n Le nom dans la hashMap
	 */
	public static void load(File f, String n) {

		URL input = null;
		try {
			System.out.println("file:" + f.getAbsolutePath()+" enregistré");
			input = new URL("file:" + f.getAbsolutePath());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
		if(clips.get(n) != null) return;
		Clip clip;
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(input);
//			JukeBox.class.getResourceAsStream(url)
			
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(
				AudioFormat.Encoding.PCM_SIGNED,
				baseFormat.getSampleRate(),
				16,
				baseFormat.getChannels(),
				baseFormat.getChannels() * 2,
				baseFormat.getSampleRate(),
				false
			);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			clips.put(n, clip);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Joue une musique
	 * @param s
	 */
	public static void play(String s) {
		System.out.println("son joué : "+s);
		play(s, gap);
	}
	
	public static void play(String s, int i) {
		if(mute) return;
		Clip c = clips.get(s);
		if(c == null) return;
		if(c.isRunning()) c.stop();
		c.setFramePosition(i);
		while(!c.isRunning()) c.start();
		currentMusic = s;
	}
	
	public static void stop(String s) {
		System.out.println("Musique arrêtée : "+s);
		if(clips.get(s) == null) return;
		if(clips.get(s).isRunning()) clips.get(s).stop();
		currentMusic = "";
	}
	
	public static void resume(String s) {
		System.out.println("Musique redémarrée : "+s);
		if(mute) return;
		if(clips.get(s).isRunning()) return;
		clips.get(s).start();
		currentMusic = s;
	}
	
	public static void loop(String s) {
		loop(s, gap, gap, clips.get(s).getFrameLength() - 1);
		System.out.println("Musique en cours : "+s);
	}
	
	public static boolean isRunning(String c) {
		return clips.get(c).isRunning();
	}
	
	
	public static void loop(String s, int frame) {
		loop(s, frame, gap, clips.get(s).getFrameLength() - 1);
	}
	
	public static void loop(String s, int start, int end) {
		loop(s, gap, start, end);
	}
	
	public static void loop(String s, int frame, int start, int end) {
		stop(s);
		if(mute) return;
		clips.get(s).setLoopPoints(start, end);
		clips.get(s).setFramePosition(frame);
		clips.get(s).loop(Clip.LOOP_CONTINUOUSLY);
		currentMusic = s;
	}
	
	public static void setPosition(String s, int frame) {
		clips.get(s).setFramePosition(frame);
	}
	
	public static int getFrames(String s) { return clips.get(s).getFrameLength(); }
	public static int getPosition(String s) { return clips.get(s).getFramePosition(); }
	
	/**
	 * Stop et LibÃ¨re la musique
	 * @param s
	 */
	public static void close(String s) {
		stop(s);
		System.err.println("Son fermé : "+s);
		clips.get(s).close();
		currentMusic = "";
	}
	
}
