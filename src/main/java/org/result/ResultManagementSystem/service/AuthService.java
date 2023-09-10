package org.result.ResultManagementSystem.service;

import org.result.ResultManagementSystem.dto.LoginDto;
import org.result.ResultManagementSystem.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
