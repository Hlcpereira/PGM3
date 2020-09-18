/*
 * Copyright 2020 - Henrique Pereira
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 */

/* 
 * Código baseado no código exemplo feito em video aula.
 * Autor original: Hylson Vescovi <hvescovi@gmail.com>
 */
package AV3.org.ifc.pgm3.view; 

import AV3.org.ifc.pgm3.model.Pe;
import AV3.org.ifc.pgm3.dao.PeDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class Tela extends JFrame {

    // Props
    private JTable tablePes;
    
	private DefaultTableModel dadosTabela;
    private PeDAO dao = new PeDAO();
    
	public Tela() {
		// Configs da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 307);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		// Título
		JLabel labelCadastroDePes = new JLabel("Cadastro de Pés de Frutas");
		labelCadastroDePes.setFont(new Font("Dialog", Font.BOLD, 19));
		labelCadastroDePes.setBounds(119, 12, 239, 15);
		contentPane.add(labelCadastroDePes);
		
		// Config geral da tabela/grid
		dadosTabela = new DefaultTableModel(
			new String[][] { },
			new String[] { "Nome", "Cor", "Citricidade", "Quantidade" }
		);

		tablePes = new JTable(dadosTabela);
		tablePes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePes.setModel(dadosTabela);
		tablePes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tablePes.setBounds(30, 38, 387, 116);

		JScrollPane scrollPane = new JScrollPane(tablePes);
		scrollPane.setLocation(28, 39);
		scrollPane.setSize(390,125);
		contentPane.add(scrollPane);

		// rótulos
		JLabel labelNome = new JLabel("Nome da Fruta:");
		labelNome.setBounds(26, 184, 70, 15);
		getContentPane().add(labelNome);
		
		JLabel labelCor = new JLabel("Cor da Fruta:");
		labelCor.setBounds(26, 211, 70, 15);
		getContentPane().add(labelCor);
		
		JLabel labelCitricidade = new JLabel("Cítrica? (true ou false):");
		labelCitricidade.setBounds(26, 238, 70, 15);
		getContentPane().add(labelCitricidade);

		JLabel labelQuantidade = new JLabel("Quantidade:");
		labelQuantidade.setBounds(26, 265, 70, 15);
		getContentPane().add(labelQuantidade);
		
		// caixas de texto
		JTextField textNome = new JTextField();
		textNome.setText("Nome Fruta");
		textNome.setColumns(10);
		textNome.setBounds(99, 182, 279, 19);
		getContentPane().add(textNome);
		
		JTextField textCor = new JTextField();
		textCor.setText("Cor Fruta");
		textCor.setColumns(10);
		textCor.setBounds(99, 209, 209, 19);
		getContentPane().add(textCor);
		
		JTextField textCitricidade = new JTextField();
		textCitricidade.setText("true ou false");
		textCitricidade.setColumns(10);
		textCitricidade.setBounds(99, 236, 135, 19);
		getContentPane().add(textCitricidade);

		JTextField textQuantidade = new JTextField();
		textQuantidade.setText("Quantidade de Frutas");
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(99, 263, 279, 19);
		getContentPane().add(textQuantidade);

		// Botão de adicionar
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(389, 206, 100, 25);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obter informações inseridas
				String nome = textNome.getText();
				String cor = textCor.getText();
				boolean citricidade = Boolean.getBoolean(textCitricidade.getText());
				int quantidade = Integer.parseInt(textQuantidade.getText());

				Pe p = new Pe();
				p.setFrutaPe(citricidade, cor, nome, quantidade);
				
				// Adicionar no DAO
				dao.incluirPe(p);

				// Resetar os inputs
				textNome.setText("");
				textCor.setText("");
				textCitricidade.setText("");
				textQuantidade.setText("");
			};
		});
		getContentPane().add(btnAdicionar);

		// Botão de exibir
		JButton btnExibir = new JButton("Exibir");
		btnExibir.setBounds(389, 250, 100, 25);
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Pe p : dao.retornarPes()) {
					dadosTabela.addRow(new String[] {p.getFrutaPe().getFrutaNome(), p.getFrutaPe().getCor(), String.valueOf(p.getFrutaPe().getCitrica()), String.valueOf(p.getQuantidade())});
				};
			};
		});
		getContentPane().add(btnExibir);
	}
}
