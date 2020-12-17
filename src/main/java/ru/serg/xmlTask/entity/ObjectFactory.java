package ru.serg.xmlTask.entity;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {
    private final static QName Q_NAME = new QName(XMLConstants.NULL_NS_URI,"message");

    @XmlElementDecl(name = "message")
    public JAXBElement<MessageTask> createMessage(MessageTask messageTask){
        return new JAXBElement<MessageTask>(Q_NAME,MessageTask.class,null,messageTask);
    }
}
