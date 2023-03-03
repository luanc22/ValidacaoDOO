package com.provavalidacao.jogoluan;

import java.util.Random;

/**
 *
 * @author Luan
 */

public class Jogo implements JogoInterface {
    
    public int numero;
    public int tentativas;
    
    @Override
    public void gerarNumeroAleatorio() {
        Random random = new Random();
        numero = random.nextInt(1001);
    }

    @Override
    public void incrementarTentativas() {
        tentativas++;
    }

    @Override
    public String toString() {
        return "Tentativas: " + tentativas;
    }
    
}
