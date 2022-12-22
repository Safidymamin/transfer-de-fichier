import java.awt.event.*;
import java.io.*;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
public class Listener implements ActionListener {
    File[] fileTosend;
    JLabel jlFileName;
    JButton bout;
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (bout.getText().equals("choose File")) {
            JFileChooser jFileChooser=new JFileChooser();
            jFileChooser.setDialogTitle("choose a file to send");
    
            if (jFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
                fileTosend[0]=jFileChooser.getSelectedFile();
                jlFileName.setText("The file you want to choose is :  " + fileTosend[0].getName()) ;
            }
        }
        if (bout.getText().equals("Send File")) {
            if (fileTosend[0]==null) {
                jlFileName.setText("misafidiana file");
            }else{
                try {     
                    FileInputStream fileInputStream=new FileInputStream(fileTosend[0].getAbsolutePath());
                    Socket socket=new Socket("localhost",1234);

                    DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
                    String filename=fileTosend[0].getName();
                    byte[] filenameBytes=filename.getBytes();
                    byte[] fileContentbyte=new byte[(int)fileTosend[0].length()];
                    fileInputStream.read(fileContentbyte);

                    dataOutputStream.writeInt(filenameBytes.length);
                    dataOutputStream.write(filenameBytes);

                    dataOutputStream.writeInt(fileContentbyte.length);
                    dataOutputStream.write(fileContentbyte);
                } catch (Exception ee) {
                    // TODO: handle exception
                    ee.printStackTrace();
                }
            }
        }
        
    } 
    public Listener(File[] fileTosend, JLabel jlFileName,JButton bout) {
        this.fileTosend = fileTosend;
        this.jlFileName = jlFileName;
        this.bout=bout;
    }
    
    
}
