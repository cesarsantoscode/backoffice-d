package pe.edu.cibertec.backoffice_d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.backoffice_d.dto.UserCreateDto;
import pe.edu.cibertec.backoffice_d.dto.UserDetailDto;
import pe.edu.cibertec.backoffice_d.dto.UserDto;
import pe.edu.cibertec.backoffice_d.entity.User;
import pe.edu.cibertec.backoffice_d.repository.UserRepository;
import pe.edu.cibertec.backoffice_d.service.ManageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() throws Exception {

        List<UserDto> users = new ArrayList<UserDto>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(user -> {
            users.add(new UserDto(user.getId(),
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName()));
        });
        return users;

    }

    @Override
    public Optional<UserDetailDto> getDetailUser(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> new UserDetailDto(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()));

    }

    @Override
    public boolean updateUser(UserDto userDto) throws Exception {

        Optional<User> optional = userRepository.findById(userDto.id());
        return optional.map(user -> {
            user.setEmail(userDto.email());
            user.setFirstName(userDto.firstName());
            user.setLastName(userDto.lastName());
            user.setUpdatedAt(new Date());
            userRepository.save(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteUser(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean createUser(UserCreateDto userCreateDto) throws Exception {

        User user = new User();
        user.setUsername(userCreateDto.username());
        user.setPassword(userCreateDto.password());
        user.setEmail(userCreateDto.email());
        user.setFirstName(userCreateDto.firstName());
        user.setLastName(userCreateDto.lastName());
        user.setRole(userCreateDto.role());
        user.setCreatedAt(new Date());
        userRepository.save(user);
        return true;

    }

}
