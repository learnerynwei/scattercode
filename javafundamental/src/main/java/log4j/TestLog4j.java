package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.RootLogger;

public class TestLog4j{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestLog4j testLog4j = new TestLog4j();

	}
	
	public TestLog4j(){
		System.setProperty("filename", "test");
		Logger logger = Logger.getLogger(TestLog4j.class);
		logger.info("test log classs!");
//		Logger loggers = Logger.getLogger("rootLogger");
//		LogThread logThread[] = new LogThread[9];
//
//		for( int i = 0; i < 9; ++i){
//			//System.setProperty("fileName", "log.log");
//			logThread[i] = new LogThread("log"+ i, i);
//			logThread[i].start();
//		}
	}

	private class LogThread extends Thread{
		String logName;
		int startNum;
		Logger logger;

		public LogThread(String name,int num){
			super();
			this.logName = name;
			this.startNum = num;
			System.setProperty("fileName", logName);
			logger = Logger.getLogger(this.logName);
		}

		public void run(){

			for(int i=1; i < 1000; ++i){
				this.logger.info("The "+ this.logName+ ": "+startNum);
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
