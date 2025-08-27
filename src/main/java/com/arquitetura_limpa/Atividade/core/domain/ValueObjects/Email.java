package com.arquitetura_limpa.Atividade.core.domain.ValueObjects;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Email {
    public String email;

    public void validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }

        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
