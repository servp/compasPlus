package ru.serg.xmlTask.dataBase;

import ru.serg.xmlTask.entity.MessageTask;

import java.sql.Timestamp;

public interface DataBaseWorker {
    boolean create(MessageTask messageTask) ;
    MessageTask findByTime(Timestamp timestamp);
    boolean delete(int id);
    boolean update(MessageTask messageTask);
}
