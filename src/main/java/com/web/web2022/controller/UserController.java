package com.web.web2022.controller;

import com.web.web2022.controller.resolver.Token;
import com.web.web2022.model.RespBean;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.inbound.InBoundUser;
import com.web.web2022.model.outbound.OutBoundSession;
import com.web.web2022.model.outbound.OutBoundUser;
import com.web.web2022.service.CreditService;
import com.web.web2022.service.SessionService;
import com.web.web2022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private CreditService creditService;

    @PostMapping("/signin")
    public OutBoundSession signin(@Valid @RequestBody InBoundUser user) {
        return new OutBoundSession(userService.signin(user));
    }

    @PostMapping("/signup")
    public OutBoundSession signup(@Valid @RequestBody InBoundUser user) {
        return new OutBoundSession(userService.signup(user));
    }

    @PostMapping("/signOut")
    public void signOut(@Token String token) {
        sessionService.signOut(token);
    }

    @GetMapping("/users/me")
    public OutBoundUser me(@AuthenticationPrincipal User user) {
        return userService.findById(user.getId()).map(OutBoundUser::new).orElseThrow(
                NoSuchElementException::new);
    }

    //签到
    @PostMapping("/clockIn")
    public RespBean signIn(@AuthenticationPrincipal User user) {
        return creditService.clockIn(user.getId());
    }
}
