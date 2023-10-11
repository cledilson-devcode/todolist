package com.cledilsondevcode.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.cledilsondevcode.todolist.user.IUserRepository;
import com.cledilsondevcode.todolist.user.UserModel;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {



            //  Pegar a autenticação (Usuário e senha)

            String authorization = request.getHeader("Authorization");
            String authEncoded = authorization.substring("Basic".length()).trim();

            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
            String authString = new String(authDecode);
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // Validar usuário

           UserModel user = this.userRepository.findByUsername(username);
           if (user == null){
               response.sendError(401);
           }else {
            // Validar senha

               BCrypt.Result passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
               if (passwordVerify.verified){
                   // aprovado
                   filterChain.doFilter(request,response);
               }else {
                   response.sendError(401);
               }


           }
    }
}
