package ru.serg.xmlTask.client;

import ru.serg.xmlTask.entity.MessageTask;
import ru.serg.xmlTask.readerWriter.XmlWriter;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static Socket connectToServer() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8000);
            return socket;

        } catch (IOException connectException) {
            if (connectException instanceof ConnectException) {
                System.out.println("Server is not available...");
            }
        }
        return null;
    }

    public static boolean sendMessage(Socket socket, String message) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            MessageTask messageTask = new MessageTask(message);
            String stringXmlMessageTask = XmlWriter.createStringMessage(messageTask);
            writer.write(stringXmlMessageTask);
            writer.newLine();
            writer.flush();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Socket socket = connectToServer();
        if (socket != null) {
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            sendMessage(socket, message);
            sc.close();
            socket.close();
        }
    }
}
