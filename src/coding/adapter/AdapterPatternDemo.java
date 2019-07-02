package coding.adapter;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "¾Õ»¨Ì¨");
		audioPlayer.play("mp4", "¶ÏÇÅ²ÐÑ©");
		audioPlayer.play("vlc", "Ñ«ÕÂ");
		audioPlayer.play("avi", "ºìÈÕ");
	}
}
