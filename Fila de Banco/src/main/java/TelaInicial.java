import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame{

    public TelaInicial() {
        // Configurações da janela
        setTitle("Tela Inicial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);

        // Cria um painel com degradê
        DegradePanel painelDegrade = new DegradePanel();
        painelDegrade.setLayout(null); // Usar layout nulo para adicionar componentes manualmente
        setContentPane(painelDegrade); // Define o painel com degradê como o painel de conteúdo

        // Adiciona o texto ao painel com degradê
        adicionarTextoTelaInicial(painelDegrade);
        rodape(painelDegrade);

        // Botão
        JButton botao_iniciar = new JButton("INICIAR");
        botao_iniciar.setBounds(275, 300, 250, 50);
        botao_iniciar.setFont(new Font("Arial", Font.BOLD, 25));
        botao_iniciar.setForeground(new Color(255, 255, 255));
        botao_iniciar.setBackground(new Color(0xff66c4));
        painelDegrade.add(botao_iniciar); // Adiciona o botão ao painel com degradê

        botao_iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a tela inicial
                dispose();

                // Abrir a tela principal
                new InterfaceGrafica();
            }
        });

        // Calcula a posição centralizada da janela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        // Torna a janela visível
        setVisible(true);
    }

    public void adicionarTextoTelaInicial(JPanel painel) {
        JLabel texto_menu_prioridade = new JLabel("GERENCIADOR DE FILA DE BANCO", JLabel.CENTER);
        texto_menu_prioridade.setBounds(45, 50, 700, 100); // Ajuste as coordenadas conforme necessário
        texto_menu_prioridade.setFont(new Font("Arial", Font.BOLD, 40));
        texto_menu_prioridade.setForeground(new Color(255, 255, 255));
        texto_menu_prioridade.setBorder(BorderFactory.createLineBorder(Color.white)); // Adiciona uma borda para verificação
        painel.add(texto_menu_prioridade);
    }

    public void rodape(JPanel painel) {
        // Cria um painel para o fundo
        JPanel painelFundo = new JPanel();
        painelFundo.setBounds(0, 510, 800, 100); // Ajuste as coordenadas e o tamanho conforme necessário
        painelFundo.setBackground(new Color(0, 0, 0, 137)); // Cor de fundo sólida (preto)
        painelFundo.setLayout(new BoxLayout(painelFundo, BoxLayout.Y_AXIS)); // Layout vertical para empilhar os textos

        // Cria um painel centralizador para os textos
        JPanel painelCentralizado = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Layout para centralizar os componentes
        painelCentralizado.setOpaque(false); // Define o painel como transparente

        // Cria o JLabel com o primeiro texto
        JLabel texto_menu_prioridade = new JLabel("Criado por Lucas Almeida | Lorena Nascimento | Vivian Oliveira | Felipe Souza", JLabel.CENTER);
        texto_menu_prioridade.setFont(new Font("Arial", Font.BOLD, 15));
        texto_menu_prioridade.setForeground(new Color(255, 255, 255)); // Cor do texto

        // Cria o JLabel com o segundo texto
        JLabel texto_disciplina = new JLabel("Disciplina: Estrutura de Dados I", JLabel.CENTER);
        texto_disciplina.setFont(new Font("Arial", Font.BOLD, 15));
        texto_disciplina.setForeground(new Color(255, 255, 255)); // Cor do texto

        // Adiciona os JLabels ao painel centralizador
        painelCentralizado.add(texto_menu_prioridade);
        painelCentralizado.add(Box.createVerticalStrut(10)); // Espaço entre os textos
        painelCentralizado.add(texto_disciplina);

        // Adiciona o painel centralizado ao painel de fundo
        painelFundo.add(painelCentralizado);

        // Adiciona o painel de fundo ao painel principal
        painel.add(painelFundo);
    }

}