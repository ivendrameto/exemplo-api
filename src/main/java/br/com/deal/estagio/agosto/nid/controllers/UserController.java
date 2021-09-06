package br.com.deal.estagio.agosto.nid.controllers;

import br.com.deal.estagio.agosto.nid.dto.UserDTO;
import br.com.deal.estagio.agosto.nid.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private final UserService service;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> find() {
        log.info("find");
        return service.find();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable("id") Long id) {
        log.info("findById {}", id);
        return service.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO insert(@RequestBody UserDTO user) {
        log.info("insert {} ", user.getName());
        return service.insert(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO update(@PathVariable("id") Long id,
                          @RequestBody UserDTO user) {
        log.info("update {} {}", id, user);
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    @PatchMapping("/{id}/desbloquear")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO desbloqueia(@PathVariable("id") Long id) {
        log.info("desbloqueia {}", id);
        return service.desbloqueia(id);
    }

    @PatchMapping("/{id}/bloquear")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO bloqueia(@PathVariable("id") Long id) {
        log.info("bloqueia  {}", id);
        return service.bloqueia(id);
    }

}
