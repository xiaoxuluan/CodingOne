package coding.adapter;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		
		AudioPlayer audioPlayer = new AudioPlayer();
		audioPlayer.play("mp3", "�ջ�̨");
		audioPlayer.play("mp4", "���Ų�ѩ");
		audioPlayer.play("vlc", "ѫ��");
		audioPlayer.play("avi", "����");
	}
}
