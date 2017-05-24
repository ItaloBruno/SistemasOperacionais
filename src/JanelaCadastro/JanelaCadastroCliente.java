package JanelaCadastro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JanelaCadastroCliente extends JFrame
{
	//Atributos da Classe
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField tfNomeCliente = new JTextField();
	private JTextField tfTempoNoBar = new JTextField();
	private JTextField tfTempoEmCasa = new JTextField();
	
	private JLabel lblNomeCliente = new JLabel("Nome do Cliente");
	private JLabel lblTempoNoBar = new JLabel("Tempo no Bar");
	private JLabel lblTempoEmCasa = new JLabel("Tempo em Casa");
	private JLabel lblConfirmarCadastro = new JLabel("Confirmar Cadastro?");
	
	private JButton botaoNao = new JButton("N\u00E3o");
	private JButton botaoSim = new JButton("Sim");
	
	//Aplicacao Que chama a Janela de Cadastro de Clientes
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					JanelaCadastroCliente frame = new JanelaCadastroCliente();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	//Criando a JANELA
	public JanelaCadastroCliente()
	{
		//Configurando Janela
		setTitle("Janela de Cadastro");
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//====================================================================================
		//Configurando os textFiels
		tfNomeCliente.setBounds(124, 105, 86, 20);
		contentPane.add(tfNomeCliente);
		tfNomeCliente.setColumns(40);
		
		tfTempoNoBar.setBounds(266, 105, 86, 20);
		contentPane.add(tfTempoNoBar);
		tfTempoNoBar.setColumns(5);
		
		tfTempoEmCasa.setBounds(396, 105, 86, 20);
		contentPane.add(tfTempoEmCasa);
		tfTempoEmCasa.setColumns(5);
		
		//====================================================================================
		//Configurando botoes
		botaoNao.setBounds(214, 239, 89, 23);
		contentPane.add(botaoNao);
		
		botaoSim.setBounds(327, 239, 89, 23);
		contentPane.add(botaoSim);
		//====================================================================================
		//Configurando as Labels
		lblNomeCliente.setBounds(124, 80, 104, 14);
		contentPane.add(lblNomeCliente);
		
		lblTempoNoBar.setBounds(266, 80, 104, 14);
		contentPane.add(lblTempoNoBar);
		 
		lblTempoEmCasa.setBounds(396, 80, 104, 14);
		contentPane.add(lblTempoEmCasa);
	
		lblConfirmarCadastro.setBounds(266, 214, 137, 14);
		contentPane.add(lblConfirmarCadastro);
		
		//=====================================================================================
		//Acao dos botoes Sim e Nao
		botaoNao.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Fecha a janela
				System.exit(0);
			}
		});
		
		botaoSim.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//String msg1 = "Nome: " + tfNomeCliente.getText() + "\n";
				//String msg2 = "Tempo no Bar: " + tfTempoNoBar.getText() + "\n";
				//String msg3 = "Tempo em Casa: " + tfTempoEmCasa.getText() + "\n";
				//String msgF = msg1 + msg2 + msg3;
				//System.out.println(msgF);
				//JOptionPane.showMessageDialog(null, msgF);
				new CadastroCliente();
			}
		});
	
	}
}
