package com.example.task.controller;

import com.example.task.model.Client;
import com.example.task.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController<client> {


    /**
     @RestController — говорит спрингу, что данный класс является REST контроллером.
     Т.е. в данном классе будет реализована логика обработки клиентских запросов
     @Autowired — говорит спрингу, что в этом месте необходимо внедрить зависимость.
     В конструктор передаем интерфейс ClientService. Реализацию данного сервиса
     пометили аннотацией @Service ранее, и теперь спринг сможет передать экземпляр
     этой реализации в конструктор контроллера.
     **/


    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /** Операции CRUD.
    Создаём метод create.
     Внутри тела метода вызываем метод create у ранее созданного сервиса и
     передаем ему принятого в параметрах контроллера клиента.
    **/


    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /** Создаём метод Read
     Внутри метода, с помощью написанного сервиса получаем список всех клиентов.
     Если список не Null возвращается 200 (в Постмане) иначе возвращается 400.
     Если в друг в Постмане при обращении по localhost:8080 будет ошибка, можно попробовать
     через / добавить clients.
    **/


    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /** Реализация поиска по id
     **/


    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


   /** Реализация метода Update.
    **/

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    /** Реализация метода Del.
    **/

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}