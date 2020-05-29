package Vista;

import Logico.proceso;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GUI extends JFrame implements  ActionListener{
    JButton btnEnviar;
    JTextField caja1s,caja0s;
    JTextArea foto;
    public GUI(){
        getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Examen");
        setSize(450, 450);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        btnEnviar = new JButton("Cargar Imagen");
        btnEnviar.setBounds(10, 10, 120, 20);
        btnEnviar.addActionListener(this);
        add(btnEnviar);

        JLabel lblunos = new JLabel("Patrones de 1's:");
        lblunos.setBounds(150, 10, 100, 20);
        add(lblunos);
        caja1s = new JTextField(10);
        caja1s.setBounds(170, 30, 50, 20);
        add(caja1s);

        JLabel lblceros = new JLabel("Patrones de 0's:");
        lblceros.setBounds(270, 10, 100, 20);
        add(lblceros);
        caja0s = new JTextField(10);
        caja0s.setBounds(290, 30, 50, 20);
        add(caja0s);

        foto = new JTextArea();
        foto.setLineWrap(true);
        foto.setWrapStyleWord(true);
        foto.setBounds(10,70,410,300);
        add(foto);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        proceso a = null;
        try {
            a = new proceso();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if(e.getSource() == btnEnviar){
            //proceso a = new proceso();
            //System.out.println(a.cf1);
            caja1s.setText(String.valueOf(a.cf1));
            caja0s.setText(String.valueOf(a.cf0));
            for(int matriz2[]:a.matriz){
                foto.setText(Arrays.toString(matriz2));
                //System.out.println(Arrays.toString(matriz2));
            }


        }
    }

}
class RunGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });

    }
}
