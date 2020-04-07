package com.modern.api.controller.v1;

import com.modern.api.entity.User;
import com.modern.api.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private final UserRepository userRepository;

    @ApiOperation(value = "회원 조회", notes = "모든 회원을 조회한다")
    @GetMapping(value = "/user")
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @ApiOperation(value = "회원 입력", notes = "회원을 입력한다.")
    @PostMapping(value = "/user")
    public User save(@ApiParam(value = "회원아이디", required = true) @RequestParam String accountId,
                     @ApiParam(value = "회원이름", required = true) @RequestParam String accountName) {
        User user = User.builder()
                .accountId(accountId)
                .accountName(accountName)
                .build();
        return userRepository.save(user);
    }
}
