package pe.edu.cibertec.backoffice_d.service;

import pe.edu.cibertec.backoffice_d.dto.UserCreateDto;
import pe.edu.cibertec.backoffice_d.dto.UserDetailDto;
import pe.edu.cibertec.backoffice_d.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<UserDto> getAllUsers() throws Exception;

    Optional<UserDetailDto> getDetailUser(int id) throws Exception;

    boolean updateUser(UserDto userDto) throws Exception;

    boolean deleteUser(int id) throws Exception;

    boolean createUser(UserCreateDto userCreateDto) throws Exception;

}
