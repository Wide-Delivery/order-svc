package com.widedelivery.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DriverExtendedDto extends DriverDto {

    private UserDto user;

    @Override
    public String toString() {
        return "DriverExtendedDto{" +
                "user=" + user +
                '}';
    }
}
