package com.elements.elementsapi.api.system.user;

import com.elements.elementscommon.domain.user.User;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {

    UserDto map(User user);

    List<UserDto> map(Collection<User> user);

    User map(UserDto userDto);
}
