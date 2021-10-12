
import java.io.*;
import java.net.*;

public class Client {
    String nomeServer ="localhost";  //nome del server
    int portaServer = 6789;     //porta del server
    Socket miosocket;       //socket
    BufferedReader tastiera;        //input tastiera
    String stringaUtente;       // stringa dal utente
    String stringaRicevutaDalServer;        //stringa dal server
    DataOutputStream outVersoServer;        //output verso server
    BufferedReader inDalServer;             //input verso server
    
    public Socket connetti(){
        
        System.out.println("2 CLIENT partito in esecuzione ...");
        try
        {
            //per l'input da tastiera
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            // creo un socket
            miosocket = new Socket(nomeServer,portaServer);
            // miosocket = new Socket(inetAdress.getLocalHost(), 6789);
            // associo due oggetti al socket per effettuare la scrittura e la lettura
            outVersoServer = new DataOutputStream(miosocket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader (miosocket.getInputStream()));
        }
        catch (UncheckedIOException e)
        {
            System.err.println("Host sconosciuto");
        }
        catch(Exception e )
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione!");
            System.exit(1);
        }
        return miosocket;
    }

    pubic void comunica ()throws Exception{
            
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputSream(client.getOutputStream());
            
                for(;;){
                    stringaRicevuta = inDalClient.readLine();
                    if(stringaRicevuta == null || strignaRicevuta.equals("FINE")){
                        outVersoClient.writeBytes(stringaRicevuta+" (=>server in chiusura...)" + '\n');
                        System.out.println("Echo sul server in chiusura :" + stringaRicevuta);
                        break;
                    }
                
                
                else{
                    outVersoClient.writeBytes(stringaRicevuta+" (ricevuta e ritrasmessa)" + '\n');
                    System.out.println("6 Echo sul server :" + stringaRicevuta);
                    break;
                    }
                }
                
                outVersoClient.close();
                inDalClient.close();
                System.out.println("9 Chiusura socket" + client);
                client.close();    
        }
    }

