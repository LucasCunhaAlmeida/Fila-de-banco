import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame {
    ArrayList<Integer> numeros = new ArrayList<>();
    private JTextField campoSenha; // Adicione um campo de texto para mostrar a senha
    Fila fila = new Fila();
    private int senhasUsadas = 0;

    public InterfaceGrafica() {
        gerarTela();
        gerarId();
        botaoPCD();
        botaoPrioridade();
        botaoSemPrioridade();
        botaoRemover();
        botaoSair();
        adicionarTextoMenuPrioridade();
        adicionarCampoSenha();
        adicionarCampoLista();
        adicionarTextoSenhasAtivas();
    }

    public void gerarTela() {
        // ***** Gerando a janela do aplicativo. *****
        setTitle("Fila de Banco");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);

        // Cria um painel com degradê
        DegradePanel painelDegrade = new DegradePanel();
        painelDegrade.setLayout(null); // Usar layout nulo para adicionar componentes manualmente

        // Adiciona o painel com degradê ao JFrame
        setContentPane(painelDegrade);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Exibe a janela
        setVisible(true);
    }


    protected void botaoPCD() {
        JButton botao_pcd = new JButton("PCD");
        botao_pcd.setBounds(20, 100, 350, 50);
        botao_pcd.setFont(new Font("Arial", Font.BOLD, 25));
        botao_pcd.setForeground(new Color(255, 255, 255));
        botao_pcd.setBackground(new Color(0xff66c4));
        botao_pcd.setToolTipText("Pessoa com deficiência");
        add(botao_pcd);

        botao_pcd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pegarCodigoPrioridade(0);
                mostrarSenha();
            }
        });
    }

    protected void botaoPrioridade() {
        JButton botao_prioridade = new JButton("Idoso, Gestante, Autista Lactantes, Obesos");
        botao_prioridade.setBounds(20, 170, 350, 50);
        botao_prioridade.setFont(new Font("Arial", Font.BOLD, 25));
        botao_prioridade.setForeground(new Color(255, 255, 255));
        botao_prioridade.setBackground(new Color(0xff66c4));

        botao_prioridade.setToolTipText("Idoso, Gestante, Autista, Lactantes, Obesos, Doadores de sangue," +
                " Pessoa com criança de colo");

        add(botao_prioridade);
        botao_prioridade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pegarCodigoPrioridade(1);
                mostrarSenha();
            }
        });
    }

    protected void botaoSemPrioridade() {
        JButton botao_sem_prioridade = new JButton("Sem prioridade");
        botao_sem_prioridade.setBounds(20, 240, 350, 50);
        botao_sem_prioridade.setFont(new Font("Arial", Font.BOLD, 25));
        botao_sem_prioridade.setForeground(new Color(255, 255, 255));
        botao_sem_prioridade.setBackground(new Color(0xff66c4));
        add(botao_sem_prioridade);

        botao_sem_prioridade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pegarCodigoPrioridade(2);
                mostrarSenha();
            }
        });
    }

    protected void botaoRemover() {
        JButton botao_remover = new JButton("Chamar Senha");
        botao_remover.setBounds(20, 310, 350, 50);
        botao_remover.setFont(new Font("Arial", Font.BOLD, 25));
        botao_remover.setForeground(new Color(255, 255, 255));
        botao_remover.setBackground(new Color(0xff66c4));
        add(botao_remover);

        botao_remover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamarSenha();
            }
        });
    }

    protected void botaoSair() {
        JButton botao_sair = new JButton("Sair");
        botao_sair.setBounds(20, 380, 350, 50);
        botao_sair.setFont(new Font("Arial", Font.BOLD, 25));
        botao_sair.setForeground(new Color(255, 255, 255));
        botao_sair.setBackground(new Color(0xff66c4));
        add(botao_sair);

        botao_sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa?", "Confirmar saída", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resposta == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    protected void adicionarTextoMenuPrioridade() {
        JLabel texto_menu_prioridade = new JLabel("MENU PRIORIDADE", JLabel.CENTER);
        texto_menu_prioridade.setBounds(20, 40, 349, 50);
        texto_menu_prioridade.setFont(new Font("Arial", Font.BOLD, 30));
        texto_menu_prioridade.setForeground(new Color(255, 255, 255));
        texto_menu_prioridade.setBorder(BorderFactory.createLineBorder(Color.white)); // Adiciona uma borda para verificação
        add(texto_menu_prioridade);
    }

    protected void adicionarTextoSenhasAtivas() {
        JLabel texto_Senhas_Ativas = new JLabel("SENHAS ATIVAS", JLabel.CENTER);
        texto_Senhas_Ativas.setBounds(400, 40, 349, 50);
        texto_Senhas_Ativas.setFont(new Font("Arial", Font.BOLD, 30));
        texto_Senhas_Ativas.setForeground(new Color(255, 255, 255));
        texto_Senhas_Ativas.setBorder(BorderFactory.createLineBorder(Color.white)); // Adiciona uma borda para verificação
        add(texto_Senhas_Ativas);
        revalidate();  // Força a revalidação do layout
        repaint();     // Redesenha o componente
    }

    protected void adicionarCampoSenha() {
        campoSenha = new JTextField();
        campoSenha.setBounds(400, 450, 350, 50);
        campoSenha.setFont(new Font("Arial", Font.PLAIN, 25));
        campoSenha.setForeground(Color.BLACK);
        campoSenha.setBackground(Color.WHITE);
        add(campoSenha);
    }

    public void gerarId() {
        int n = 200;
        for (int i = 1; i <= n; i++) {
            numeros.add(i);
        }
    }

    public void mostrarSenha() {
        if (senhasUsadas < numeros.size()) {
            campoSenha.setText("Senha Gerada: " + numeros.get(senhasUsadas));
            senhasUsadas++;
        } else {
            campoSenha.setText("Nenhuma senha disponível.");
        }
    }

    private JTextArea campoLista;

    protected void adicionarCampoLista() {
        campoLista = new JTextArea();
        campoLista.setFont(new Font("Arial", Font.PLAIN, 25));
        campoLista.setForeground(Color.BLACK);
        campoLista.setBackground(Color.WHITE);
        campoLista.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(campoLista);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(400, 100, 350, 330);
        add(scrollPane);
    }

    public void mostrarFila(Fila fila) {
        StringBuilder sb = new StringBuilder();
        NoDuplamenteEncadeado noTemp = fila.getCabeca();
        int posicao = 1;

        while (noTemp != null) {
            sb.append("").append(posicao).append("° Senha : ").append(noTemp.getIndentificador()).append("\n");
            sb.append("__________________________________").append("\n");
            noTemp = noTemp.getProximo();
            posicao++;
        }

        campoLista.setText(sb.toString());
    }

    public void pegarCodigoPrioridade(int codigo) {
        criarNoNaFila(codigo);
    }

    public boolean criarNoNaFila(int codigo) {
        NoDuplamenteEncadeado no = new NoDuplamenteEncadeado(numeros.get(senhasUsadas), codigo);
        if (senhasUsadas < numeros.size()) {
            fila.inserirOrdenado(no);
            mostrarFila(fila);
            return true;
        } else {
            return false;
        }
    }

    public boolean chamarSenha() {

        if (fila.ListaVazia()){
            JOptionPane.showMessageDialog(null, "Não existem nehuma pessoa na fila, " +
                    "impossivel chamar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }else{
            JOptionPane.showMessageDialog(null, "A senha " + fila.getCabeca().getIndentificador() +
                    " foi chamada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            fila.removerInicio();
            mostrarFila(fila);
            return true;
        }

    }
}
