package com.elements.elementsapi.api.user;

import com.elements.elementscommon.domain.user.User;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

import static org.mapstruct.MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG;

@Mapper(mappingInheritanceStrategy = AUTO_INHERIT_FROM_CONFIG)
public interface UserMapper {

    UserDto map(User user);

    List<UserDto> map(Collection<User> user);

    User map(UserDto userDto);
}
