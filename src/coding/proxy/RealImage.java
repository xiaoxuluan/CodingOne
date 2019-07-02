package coding.proxy;

public class RealImage implements Image{

	private String fileName;
	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}
	private void loadFromDisk(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("Мгдижа.........."+fileName);
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying"+fileName);
	}

	
}
