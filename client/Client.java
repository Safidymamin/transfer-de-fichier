import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Client
 */
public class Client {
    public static void main(String[] args) {

         final File[] fileTosend=new File[1];

        JFrame jframe=new JFrame("Client");
        jframe.setSize(450,450);
        jframe.setLayout(new BoxLayout(jframe.getContentPane(), BoxLayout.Y_AXIS));
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel jlTitle=new JLabel("File Sender");
        jlTitle.setFont(new Font("Arial",Font.BOLD,25));
        jlTitle.setBorder(new EmptyBorder(20,0,10,0));
        jlTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel jlFileName=new JLabel("choose a file to send");
        jlFileName.setFont(new Font("Arial",Font.BOLD,20));
        jlFileName.setBorder(new EmptyBorder(50,0,0,0));
        jlFileName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel jpButton=new JPanel();
        jpButton.setBorder(new EmptyBorder(75, 0, 10, 0));

        JButton jbsendFile=new JButton("Send File");
        jbsendFile.setPreferredSize(new Dimension(150,75));
        jbsendFile.setFont(new Font("Arial",Font.BOLD,20));

        JButton jbchooseFile=new JButton("choose File");
        jbchooseFile.setPreferredSize(new Dimension(150,75));
        jbchooseFile.setFont(new Font("Arial",Font.BOLD,20));

        jpButton.add(jbsendFile);
        jpButton.add(jbchooseFile);


        jbchooseFile.addActionListener(new Listener(fileTosend, jlFileName,jbchooseFile));
        jbsendFile.addActionListener(new Listener(fileTosend, jlFileName, jbsendFile));
        
        jframe.add(jlTitle);
        jframe.add(jlFileName);
        jframe.add(jpButton);
        jframe.setVisible(true);

    }
    
}