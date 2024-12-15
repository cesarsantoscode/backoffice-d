package pe.edu.cibertec.backoffice_d.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.backoffice_d.dto.UserCreateDto;
import pe.edu.cibertec.backoffice_d.dto.UserDetailDto;
import pe.edu.cibertec.backoffice_d.dto.UserDto;
import pe.edu.cibertec.backoffice_d.response.*;
import pe.edu.cibertec.backoffice_d.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class ManageUserApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public GetAllUsersResponse getAllUsers() {

        try {
            List<UserDto> users = manageService.getAllUsers();
            if (!users.isEmpty())
                return new GetAllUsersResponse("01", null, users);
            else
                return new GetAllUsersResponse("02", "Users not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new GetAllUsersResponse("99", "An error occurred, please try again", null);

        }

    }

    @GetMapping("/detail")
    public GetDetailUserResponse getDetailUser(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<UserDetailDto> optional = manageService.getDetailUser(Integer.parseInt(id));
            return optional.map(user ->
                    new GetDetailUserResponse("01", null, user)
            ).orElse(
                    new GetDetailUserResponse("02", "User not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new GetDetailUserResponse("99", "An error occurred, please try again", null);

        }

    }

    @PutMapping("/update")
    public UpdateUserResponse updateUser(@RequestBody UserDto userDto) {

        try {
            if (manageService.updateUser(userDto))
                return new UpdateUserResponse("01", null);
            else
                return new UpdateUserResponse("02", "Update failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateUserResponse("99", "An error occurred, please try again");

        }

    }

    @DeleteMapping("/delete/{id}")
    public DeleteUserResponse deleteUser(@PathVariable String id) {

        try {
            if (manageService.deleteUser(Integer.parseInt(id)))
                return new DeleteUserResponse("01", null);
            else
                return new DeleteUserResponse("02", "Delete failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteUserResponse("99", "An error occurred, please try again");

        }

    }

    @PostMapping("/create")
    public CreateUserResponse createUser(@RequestBody UserCreateDto userCreateDto) {

        try {
            if (manageService.createUser(userCreateDto))
                return new CreateUserResponse("01", null);
            else
                return new CreateUserResponse("02", "Create failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateUserResponse("99", "An error occurred, please try again");

        }

    }


}
