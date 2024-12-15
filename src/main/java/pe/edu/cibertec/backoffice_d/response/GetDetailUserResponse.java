package pe.edu.cibertec.backoffice_d.response;

import pe.edu.cibertec.backoffice_d.dto.UserDetailDto;

public record GetDetailUserResponse(String code,
                                    String error,
                                    UserDetailDto userDetailDto) {

}