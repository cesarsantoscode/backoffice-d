package pe.edu.cibertec.backoffice_d.response;

import pe.edu.cibertec.backoffice_d.dto.UserDto;

import java.util.List;

public record GetAllUsersResponse(String code,
                                  String error,
                                  List<UserDto> users) {

}