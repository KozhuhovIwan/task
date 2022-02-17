package com.example.task.model;

//import com.sun.tools.javac.util.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/** Реализация модульного теста.
    Как я понял, в модульных тестах можно модулировать всякие ситуации,
    которые могут возникнуть при реальной работе программы.
    Причём можно писать как один модуль - один тест, так и на один модуль несколько тестов.

    При написании тестов использовал  assertEquals, но не нашёл как там сравнивать String, при написании
 тестов, мне идея предложила заменить String на int, я попробовал заменить и тут у меня всё посыпалось...

 **/

class ClientTest {

    @Test
    void constr1(){
        Client client = new Client("1", "Iwan");
        assertEquals("1", client.getId(), "Id - test complete");
        assertEquals("Iwan", client.getName(), "Iwan - test complete");
      }

/*
    @Test
    void setId() {
        Client client = new Client("1");
        client.setId("2");
        assertEquals("2", client.setId());
    }

    @Test
    void getName() {
        Client client = new Client ("Iwan");
        assertEquals("Iwan", client.getName());
    }

    @Test
    void setName() {
        Client client = new Client ("Iwan");
        client.setName("Tasha");
        assertEquals("Tasha", client.setName());
    } */
}