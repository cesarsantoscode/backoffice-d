package pe.edu.cibertec.backoffice_d.dto;

public record UserCreateDto(String username,
                            String password,
                            String email,
                            String firstName,
                            String lastName,
                            String role) {
}
