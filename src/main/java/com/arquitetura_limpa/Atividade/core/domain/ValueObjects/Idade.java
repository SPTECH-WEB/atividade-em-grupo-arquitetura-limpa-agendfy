package com.arquitetura_limpa.Atividade.core.domain.ValueObjects;

import java.time.LocalDate;

public class Idade {
        private LocalDate dataNascimento;
        private Integer idade;

        public Idade(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            if (dataNascimento.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Data de nascimento inválida");
            }
            this.idade = calcularIdade();
        }

    public Integer calcularIdade() {
        LocalDate dataNascimento = this.dataNascimento;
        LocalDate dataAtual = LocalDate.now();
        return this.idade = dataAtual.getYear() - dataNascimento.getYear();

    }


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Integer getIdade() {
        return idade;
    }

}
