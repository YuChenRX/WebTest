package com.web.web2022.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.web2022.exception.SignInException;
import com.web.web2022.exception.UsernameAlreadyExistsException;
import com.web.web2022.dao.UserDao;
import com.web.web2022.model.domain.Session;
import com.web.web2022.model.domain.TopUpPlan;
import com.web.web2022.model.domain.User;
import com.web.web2022.model.inbound.InBoundUser;
import com.web.web2022.repo.SessionRepo;
import com.web.web2022.repo.TopUpPlanRepo;
import com.web.web2022.repo.UserRepo;
import com.web.web2022.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SessionRepo sessionRepo;
    @Autowired
    private TopUpPlanRepo topUpPlanRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.find(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(
                        "%s not found",
                        username
                )));
    }

    @Override
    public Session signin(InBoundUser dto) {
        UserDetails userDetails = loadUserByUsername(dto.getUsername().trim());

        if (!passwordEncoder.matches(dto.getPassword(), userDetails.getPassword())) {
            throw new SignInException();
        }

        Session session = new Session();
        session.setOwner((User) userDetails);
        sessionRepo.create(session);

        return session;
    }

    @Override
    public Session signup(InBoundUser dto) {
        userRepo.find(dto.getUsername()).ifPresent(v -> {
            throw new UsernameAlreadyExistsException();
        });

        User model = dto.getModel();
        model.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepo.create(model);

        Session session = new Session();
        session.setOwner(model);
        sessionRepo.create(session);

        return session;
    }

    @Override
    public User topUp(User user, Integer planId) {
        user = userRepo.findById(user.getId()).orElseThrow(NoSuchElementException::new);
        TopUpPlan plan = topUpPlanRepo.findById(planId)
                .orElseThrow(NoSuchElementException::new);
        user.setBalance(user.getBalance().add(plan.total()));
        user.setToppedUpAmount(user.getToppedUpAmount().add(plan.total()));

        userRepo.modify(user);

        return user;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

}
