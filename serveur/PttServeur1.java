import java.net.*;
import java.io.*;
public class PttServeur1 {
    public static void receiveFile(String pathname,int port) {
        try {
            
            //On attend la connexion d'un client
            ServerSocket ss=new ServerSocket(port);
            Socket serviceSocket = ss.accept();

            Byte[] taillefichier;
            int lu;
            long taille = 0;

            //Création de l'entrée
            InputStream inpute = serviceSocket.getInputStream();
            File i=new File(pathname+"data1.txt");

            OutputStream out = new FileOutputStream(i);

            //Reçoit du client
            BufferedInputStream inBuffer = new BufferedInputStream(inpute);

            //Envoi vers le fichier
            BufferedOutputStream outBuffer = new BufferedOutputStream(out);

            lu = inBuffer.read();

            int compteur = 0;
            while(lu > -1)
            {
                outBuffer.write(lu);
                compteur++;
                lu = inBuffer.read();
            }
           
            outBuffer.write(lu);

            outBuffer.flush();
            outBuffer.close();
            inBuffer.close();

            out.flush();
            out.close();
            inpute.close();
            serviceSocket.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public static void main(String[] args) {
        PttServeur2 f=new PttServeur2();
        f. receiveFile("C:/New Folder/",9874);
        receiveFile("C:/New Folder/",9875);
    }
}
