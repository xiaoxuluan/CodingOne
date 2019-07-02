package coding.adapter;

public class AudioPlayer implements MediaPlayer{

	MediaAdapter mediaAdapter;
	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		if(audioType.equalsIgnoreCase("mp3")) {
			System.out.println("播放mp3文件 "+fileName);
		}else if(audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else {
			System.out.println("无效文件类型 "+audioType+" 格式不支持");
		}
	}

}
