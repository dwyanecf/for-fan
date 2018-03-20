package com.fanchen.clear.mind;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class PrinterTest {
	
	public static void main(String[] args) { 
    	Socket client = null;
    	PrintWriter oStream = null;
    	 try {
 			client = new Socket("10.8.32.50", 9100);
 			oStream = new PrintWriter((new OutputStreamWriter(client.getOutputStream(),"UTF-8")),true);
 			/*//居中
 			oStream.write(27);
 			oStream.write(97);
 			oStream.write(1);
 			oStream.flush();
 			oStream.println("Tickets");
 			//取消居中
 			oStream.write(27);
 			oStream.write(97);
 			oStream.write(0);
 			oStream.flush();
 			
 			oStream.print("Fan test 1 \n");
 			oStream.print("Phone: 469-111-4563 \n");
 			oStream.print("Address: 1106 Blue Lake Circle");*/
 			oStream.flush();
 			for (int i = 0; i < getCutPaperByte().length; i++) {
// 				oStream.write(getCutPaperByte()[i]);
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}finally {
			try{
				if(oStream!=null){
					System.out.println(oStream.checkError());
					oStream.close();
				}
				if(client!=null){
					client.close();	
				}
			}catch(Exception e){
			}
		}
    } 

    /**切纸命令*/
	public static byte[] getCutPaperByte(){
		byte [] buffer = new byte[5];
		buffer[0]='\n';//命令必须是单行
		buffer[1]=29;
		buffer[2]=86;
		buffer[3]=66;
		buffer[4]=1;
		return buffer;
	}

}
