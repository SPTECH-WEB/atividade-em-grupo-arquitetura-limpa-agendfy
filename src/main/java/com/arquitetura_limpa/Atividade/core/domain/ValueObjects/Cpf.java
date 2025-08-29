package com.arquitetura_limpa.Atividade.core.domain.ValueObjects;

import java.util.regex.Pattern;

public class Cpf {
    private static final Pattern CPF_PATTERN = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");
    private final String cpf;

    public Cpf(String cpf) {
        if (cpf == null || !CPF_PATTERN.matcher(cpf).matches()) {
            throw new IllegalArgumentException(
                    "CPF está no formato errado! Deve conter apenas números e formato XXX.XXX.XXX-XX");
        }
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
