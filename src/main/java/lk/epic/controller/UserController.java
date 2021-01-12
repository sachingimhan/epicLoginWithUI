package lk.epic.controller;

import lk.epic.dto.LoginHistoryDTO;
import lk.epic.dto.UserDTO;
import lk.epic.service.UserService;
import lk.epic.util.StrandedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(params = {"userName", "passWd"})
    public ResponseEntity userLogin(@RequestParam String userName, @RequestParam String passWd) {
        UserDTO userDTO = userService.loginCheck(userName, passWd);
        if (userDTO != null) {
            return responseGenerate(1, userDTO);
        } else {
            return responseGenerate(4, null);
        }

    }

    @GetMapping(path = "/{userName}/{passWd}")
    public ResponseEntity oldPasswordMatch(@PathVariable String userName, @PathVariable String passWd) {
        UserDTO dto = userService.loginCheck(userName, passWd);
        if (dto != null) {
            return responseGenerate(1, null);
        } else {
            return responseGenerate(2, null);
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity(allUsers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity userRegistration(@RequestBody UserDTO dto) {
        return responseGenerate(userService.addUser(dto), null);
    }

    @PutMapping
    public ResponseEntity userDetailsUpdate(@RequestBody UserDTO dto) {
        return responseGenerate(userService.updateUser(dto), null);
    }

    @DeleteMapping(path = "/{userName}")
    public ResponseEntity userDelete(@PathVariable String userName) {
        return responseGenerate(userService.deleteUser(userName), null);
    }

    @GetMapping(params = {"userName"})
    public ResponseEntity userLoginHistory(@RequestParam("userName") String userName) {
        List<LoginHistoryDTO> userLoginHistory = userService.getUserLoginHistory(userName);
        if (userLoginHistory.size() > 0) {
            return responseGenerate(1, userLoginHistory);
        } else {
            return responseGenerate(4, null);
        }
    }

    private ResponseEntity responseGenerate(int i, Object o) {
        switch (i) {
            case 0:
                return new ResponseEntity(new StrandedResponse(0, "UnSuccess", o), HttpStatus.OK);
            case 1:
                return new ResponseEntity(new StrandedResponse(1, "Success", o), HttpStatus.OK);
            case 2:
                return new ResponseEntity(new StrandedResponse(2, "Miss Match", o), HttpStatus.OK);
            case 3:
                return new ResponseEntity(new StrandedResponse(3, "Already Exists", o), HttpStatus.OK);
            case 4:
                return new ResponseEntity(new StrandedResponse(4, "Not Found", o), HttpStatus.OK);
            default:
                return new ResponseEntity(new StrandedResponse(5, "Error", o), HttpStatus.OK);
        }

    }

}
