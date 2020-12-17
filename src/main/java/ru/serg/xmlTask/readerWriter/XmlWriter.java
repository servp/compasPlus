package ru.serg.xmlTask.readerWriter;

import ru.serg.xmlTask.entity.MessageTask;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class XmlWriter {
    private static final String PACKAGE = MessageTask.class.getPackage().getName();
    public static String createStringMessage(MessageTask message) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PACKAGE);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(message,writer);
        String xmlString = writer.toString();
        return xmlString;
    }
}
