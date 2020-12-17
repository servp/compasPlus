package ru.serg.xmlTask.server;

import ru.serg.xmlTask.dataBase.DBWorker;
import ru.serg.xmlTask.entity.MessageTask;
import ru.serg.xmlTask.readerWriter.XmlReader;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {
    public static void main(String[] args) {
        {
            while (true) {
                try (ServerSocket socketServer = new ServerSocket(8000);
                     Socket client = socketServer.accept();
                     BufferedReader reader = new BufferedReader(
                             new InputStreamReader(client.getInputStream()))) {
                    String xmlResponse = reader.readLine();
                    MessageTask messageTask = XmlReader.readStringMessage(xmlResponse);
                    System.out.println(messageTask.toString());
                    DBWorker dbWorker = new DBWorker();
                    dbWorker.create(messageTask);

                } catch (IOException | JAXBException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
