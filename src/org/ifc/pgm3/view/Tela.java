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
package AV2.org.ifc.pgm3.view; 

import AV2.org.ifc.pgm3.model.Pe;
import AV2.org.ifc.pgm3.dao.PeDAO;

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

		// Inicializadores/Includers de valores para objetos a serem apresentados na tela
		Pe p1 = new Pe();
		Pe p2 = new Pe();

		p1.setFrutaPe(false, "vermelha", "Maçã", 20);
		p2.setFrutaPe(true, "verde", "Limão", 20);

		dao.incluirPe(p1);
		dao.incluirPe(p2);

		for (Pe p : dao.retornarPes()) {
			dadosTabela.addRow(new String[] {p.getFrutaPe().getFrutaNome(), p.getFrutaPe().getCor(), String.valueOf(p.getFrutaPe().getCitrica()), String.valueOf(p.getQuantidade())});
		}
	}
}
