package com.hikuley;

import com.hikuley.api.UserApi;
import com.hikuley.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


/**
 * Created by hikuley on 9/6/2017.
 */

@RestController
public class UserRestController implements UserApi {

    @Override
    public ResponseEntity<UserDto> gETUserId(Integer id) {
        UserDto userDto = new UserDto();
        userDto.setNumber(BigDecimal.valueOf(11L));
        userDto.setName("test");
        userDto.setSurname("test");
        return new ResponseEntity<UserDto>(userDto,HttpStatus.OK);
    }

}