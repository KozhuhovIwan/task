package com.example.task.model;

//import com.sun.tools.javac.util.Name;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/** Реализация модульного теста.
    Как я понял, в модульных тестах можно модулировать всякие ситуации,
    которые могут возникнуть при реальной работе программы.
    Причём можно писать как один модуль - один тест, так и на один модуль несколько тестов.

 **/

class ClientTest {

    @Test
    void constr1(){
        Client client = new Client("1", "Iwan");
        assertEquals("1", client.getId(), "Id - test complete");
        assertEquals("Iwan", client.getName(), "Iwan - test complete");
      }
    @Test
    void getId() {
        Client client = new Client ("1", "Iwan");
        assertEquals("1", client.getId(), "test complete");
    }

   @Test
    void setId() {
        Client client = new Client("1", "Iwan");
        client.setId("2");
        assertEquals("1", client.getId(), "test complete");
    }

    @Test
    void getName() {
        Client client = new Client ("1", "Iwan");
        assertEquals("Iwan", client.getName(), "test complete");
    }

    @Test
    void setName() {
        Client client = new Client ("1", "");
        client.setName("Tasha");
        assertEquals("Tasha", client.getName(), "test complete");
    }
}