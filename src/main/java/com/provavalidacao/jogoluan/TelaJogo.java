package com.provavalidacao.jogoluan;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan
 */

public class TelaJogo extends javax.swing.JFrame {
    
    protected Jogo jogo = new Jogo();
    protected int numeroDaTentativa;

    public TelaJogo() {
        initComponents();
        // Gera o numero a ser acertado
        jogo.gerarNumeroAleatorio();
        // Esconde os botoes de sair e de tentar novamente
        btnJogarNovamente.setVisible(false);
        btnSair.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChute = new javax.swing.JLabel();
        btnChute = new javax.swing.JButton();
        txtChute = new javax.swing.JTextField();
        lblDistancia = new javax.swing.JLabel();
        btnJogarNovamente = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblTentativas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adivinhe o número!");
        setResizable(false);

        lblChute.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblChute.setText("Entre com seu chute:");

        btnChute.setText("Chutar!");
        btnChute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuteActionPerformed(evt);
            }
        });

        lblDistancia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDistancia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDistancia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnJogarNovamente.setText("Jogar Novamente");
        btnJogarNovamente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarNovamenteActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblTentativas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTentativas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTentativas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtChute)
                            .addComponent(btnChute, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnJogarNovamente)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(lblChute))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTentativas, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblChute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtChute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTentativas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnJogarNovamente)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuteActionPerformed
        try{
            // Converte o chute para numero, se nao conseguir conversao gera exception
            numeroDaTentativa = Integer.parseInt(txtChute.getText());
            
            // Verificar se o numero esta entre 0-1000, se nao conseguir gera exception
            if(numeroDaTentativa < 0 || numeroDaTentativa > 1000) {
                throw new NumberFormatException();
            }
            
            // Gera a tentativa
            jogo.incrementarTentativas();
            
            // Faz validacao de numero
            if(numeroDaTentativa < jogo.numero){
                getContentPane().setBackground(Color.cyan);
                lblDistancia.setText("O número correto está acima!");
            }
            else if(numeroDaTentativa > jogo.numero){
                getContentPane().setBackground(Color.red);
                lblDistancia.setText("O número correto está abaixo!");
            }
            else{
                getContentPane().setBackground(Color.green);
                // Bloqueia a area de texto e o botao
                txtChute.setEnabled(false);
                btnChute.setEnabled(false);
                lblDistancia.setText("Parabéns, você acertou!!");
                // Define a quantidade de tentativas ao acertar
                lblTentativas.setText(jogo.toString());
                // Mostra as opcoes de sair e de jogar novamente
                btnJogarNovamente.setVisible(true);
                btnSair.setVisible(true);
            }
        }
        catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnChuteActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // Termina o programa
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnJogarNovamenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarNovamenteActionPerformed
        // Destroi essa tela desse jogo
        dispose();
        
        // Chama a tela de jogo novamente para resetar o jogo
        TelaJogo segundaTela = new TelaJogo();
        segundaTela.setLocationRelativeTo(null);  
        segundaTela.setVisible(true);
    }//GEN-LAST:event_btnJogarNovamenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChute;
    private javax.swing.JButton btnJogarNovamente;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel lblChute;
    private javax.swing.JLabel lblDistancia;
    private javax.swing.JLabel lblTentativas;
    private javax.swing.JTextField txtChute;
    // End of variables declaration//GEN-END:variables
}
