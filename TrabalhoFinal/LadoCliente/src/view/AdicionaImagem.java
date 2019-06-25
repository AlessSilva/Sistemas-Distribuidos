package view;

import proxy.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdicionaImagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	File file = null;
	Proxy proxy;

	
	public static void main(String[] args) throws IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionaImagem frame = new AdicionaImagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AdicionaImagem() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblImagemLabel = new JLabel("");
		lblImagemLabel.setBounds(12, 83, 349, 299);
		panel.add(lblImagemLabel);
		
		JButton btnAdicionarImagem = new JButton("Adicionar Imagem");
		btnAdicionarImagem.setForeground(Color.BLACK);
		btnAdicionarImagem.setBackground(Color.LIGHT_GRAY);
		btnAdicionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser arquivo = new JFileChooser();
				
				arquivo.setDialogTitle("Selecione a imagem");
				
				arquivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
				
				int opcao = arquivo.showOpenDialog(arquivo);
				
				if( opcao == JFileChooser.APPROVE_OPTION ) {
					
					file = new File("Path");
					
					file = arquivo.getSelectedFile();
					
					String filename = file.getAbsolutePath();
					
					textField.setText(filename);
					
					ImageIcon imagem = new ImageIcon(arquivo.getSelectedFile().getPath());
					
					lblImagemLabel.setIcon( new ImageIcon(imagem.getImage().getScaledInstance( lblImagemLabel.getWidth(), lblImagemLabel.getHeight(), Image.SCALE_DEFAULT)) );
					
				}
				
			}
		});
		btnAdicionarImagem.setBounds(35, 20, 177, 35);
		panel.add(btnAdicionarImagem);
		
		textField = new JTextField();
		textField.setBounds(286, 28, 669, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setForeground(Color.WHITE);
		lblUrl.setBounds(242, 30, 70, 15);
		panel.add(lblUrl);
		
		JLabel labelResult = new JLabel("");
		labelResult.setForeground(Color.RED);
		labelResult.setBounds(373, 83, 349, 299);
		panel.add(labelResult);
	
//----------------------------------------------------------------------------
		JButton btnReconhecerElem = new JButton("Reconhecer Elementos");
		btnReconhecerElem.setForeground(Color.BLACK);
		btnReconhecerElem.setBackground(Color.LIGHT_GRAY);
		btnReconhecerElem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if( file != null ) {			
						
						proxy = new Proxy();
						
						labelResult.setIcon(null);
						
/*Chamando método*/     String path = proxy.ReconhecerElementos(file);
						
						if( path.equals("erro") ) {
							
							labelResult.setText( "Erro no servidor. Tente Novamente" );
							
						}else {
							
							File fileResponse = new File(path);
							
							ImageIcon imagem = new ImageIcon(fileResponse.getPath());
							
							labelResult.setIcon( new ImageIcon(imagem.getImage().getScaledInstance( lblImagemLabel.getWidth(), lblImagemLabel.getHeight(), Image.SCALE_DEFAULT)) );
						
							
						}
						
						proxy.close();

					}else {
						
						labelResult.setText( "imagem inválida" );
					
					}
					
				} catch ( Exception e1) {
					
					System.out.println(e1.getMessage());
					
					e1.printStackTrace();
				}
				
			}
		});
		btnReconhecerElem.setBounds(747, 97, 208, 35);
		panel.add(btnReconhecerElem);
		
		JButton btnAplicarFiltroBW = new JButton("Aplicar Filtro BW");
		btnAplicarFiltroBW.setForeground(Color.BLACK);
		btnAplicarFiltroBW.setBackground(Color.LIGHT_GRAY);
		btnAplicarFiltroBW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if( file != null ) {
						
						proxy = new Proxy();
						
						labelResult.setIcon(null);
						
/*Chamando Método*/		String path = proxy.AplicarFiltroBW(file);
						

						if( path.equals("erro") ) {
							
							labelResult.setText( "Erro no servidor. Tente Novamente" );
							
						}else {
	
							File fileResponse = new File(path);
							
							ImageIcon imagem = new ImageIcon(fileResponse.getPath());
							
							labelResult.setIcon( new ImageIcon(imagem.getImage().getScaledInstance( lblImagemLabel.getWidth(), lblImagemLabel.getHeight(), Image.SCALE_DEFAULT)) );
							
							
						}
						
						proxy.close();
					
					}else {
						
						labelResult.setText( "imagem inválida" );
					
					}
					
				} catch ( Exception e1) {
					
					System.out.println(e1.getMessage());
					
					e1.printStackTrace();
				}
				
			}
		});
		btnAplicarFiltroBW.setBounds(747, 156, 208, 35);
		panel.add(btnAplicarFiltroBW);
	}
}
