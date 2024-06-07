package com.widedelivery.order.mapper;

import com.widedelivery.auth.proto.UserDTO;
import com.widedelivery.order.entity.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserDto parseFromGrpcMessage(UserDTO userFromGrpc) {
        UserDto user = new UserDto();
        user.setId(userFromGrpc.getId());
        user.setName(userFromGrpc.getName());
        user.setEmail(userFromGrpc.getEmail());
        user.setPhone(userFromGrpc.getPhoneNumber());
        user.setRole(userFromGrpc.getRole());
        return user;
    }
}
