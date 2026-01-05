package com.br.tggp.techselect.exception.exceptions;

public class EmailJaCadastradoException extends RuntimeException{
    public EmailJaCadastradoException() {
        super("Email já cadastrado!");
    }
}
