package ru.serg.xmlTask.readerWriter;

import ru.serg.xmlTask.entity.MessageTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlReader {
    public static MessageTask readStringMessage(String message) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MessageTask.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(message);
        StringWriter writer = new StringWriter();
        MessageTask messageTask = (MessageTask)unmarshaller.unmarshal(reader);
        return messageTask;
    }
}
