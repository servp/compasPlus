package ru.serg.xmlTask.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name ="message")
public class MessageTask {



    @XmlAttribute
    private Date date;

    @XmlElement
    private String text;

    public MessageTask() {
    }

    public MessageTask(String text) {
        this.date = new Date();
        this.text = text;
    }

    public MessageTask(Date date, String text) {
        this.date = date;
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "MessageTask{" +
                "date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
