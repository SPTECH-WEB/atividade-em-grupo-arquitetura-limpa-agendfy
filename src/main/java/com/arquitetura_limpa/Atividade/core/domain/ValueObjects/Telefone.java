package com.arquitetura_limpa.Atividade.core.domain.ValueObjects;

import java.util.regex.Pattern;

public class Telefone {

    private static final Pattern TELEFONE_PATTERN = Pattern.compile("^\\d{10,}$");
    private final String telefone;

    public Telefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio.");
        }
        if (!TELEFONE_PATTERN.matcher(telefone).matches()) {
            throw new IllegalArgumentException("Telefone deve conter apenas números e pelo menos 10 dígitos.");
        }
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

}
