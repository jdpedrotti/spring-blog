package com.codeup.springblog.utils;

import com.codeup.springblog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {

    public static long currentUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

}
