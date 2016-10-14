package serializable;

import  java.io.*;

public class Box implements Serializable{
	private int width;
	private int height;

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return this.width;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return this.height;
	}
}
