package br.com.deal.estagio.agosto.nid.service;

import br.com.deal.estagio.agosto.nid.dto.UserDTO;
import br.com.deal.estagio.agosto.nid.persistence.entity.User;
import br.com.deal.estagio.agosto.nid.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    public List<UserDTO> find() {
        List<User> listUser = repository.findAll();

        List<UserDTO> listDto = listUser.stream().map(entity ->
                modelMapper.map(entity, UserDTO.class)
        ).collect(Collectors.toList());

        return listDto;
    }

    public UserDTO findById(Long id) {
        User user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO insert(UserDTO user) {
        User entity = modelMapper.map(user, User.class);
        entity.setUserId(null);

        entity = repository.save(entity);

        return modelMapper.map(entity, UserDTO.class);
    }

    public UserDTO update(Long id, UserDTO user) {
        User entity = modelMapper.map(user, User.class);
        entity.setUserId(id);

        entity = repository.save(entity);

        return modelMapper.map(entity, UserDTO.class);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public UserDTO bloqueia(Long id) {
        User entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setBlocked(true);
        entity = repository.save(entity);
        return modelMapper.map(entity, UserDTO.class);
    }

    public UserDTO desbloqueia(Long id) {
        User entity = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        entity.setBlocked(false);
        entity = repository.save(entity);
        return modelMapper.map(entity, UserDTO.class);
    }

}
