package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {


	public static void write(){
		Box myBox = new Box();
		myBox.setWidth(50);
		myBox.setHeight(50);
		System.out.println("Start Serialization the Object....");
		System.out.println("Box width is: " + myBox.getWidth());
		System.out.println("Box height is: " + myBox.getHeight());

		try{
			FileOutputStream fs = new FileOutputStream("foo.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(myBox);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Serialization the Object Complete!");
	}

	public static Box read() throws ClassNotFoundException, IOException{
		ObjectInputStream ois;
		ois = new ObjectInputStream(new FileInputStream(new File("foo.ser")));
		Box myBox = (Box)ois.readObject();
		System.out.println("Box width is: " + myBox.getWidth());
		System.out.println("Box height is: " + myBox.getHeight());
		System.out.println("Box对象反序列化成功！");
		ois.close();
		return myBox;
	}

	public static void main(String[] argc){
		Serialization.write();
		try {
			Serialization.read();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
