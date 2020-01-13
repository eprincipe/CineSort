package gui;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import sorts.BubbleSort;
import sorts.HeapSort;
import sorts.InsertionSort;
import sorts.MergeSort;
import sorts.QuickSort;
import sorts.RadixSort;
import sorts.SelectionSort;
import sorts.Sorter;

import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

public class MainWindow {

	private JFrame frmCinesort;
	private JTextField sizeTextField;
	private JComboBox<String> algorithmComboBox;
	private ArrayList<Integer> elements;
	private ArrayList<ArrayList<Integer>> steps;
	private DrawCanvas drawCanvas;
	private JButton btnNewSet;
	private JButton btnStart;
	private JTextField timeTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmCinesort.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCinesort = new JFrame();
		frmCinesort.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Principe\\eclipse-workspace\\Assignment1\\icon.png"));
		frmCinesort.setTitle("CineSort");
		frmCinesort.setBounds(100, 100, 531, 486);
		frmCinesort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{78, 113, 0, 0};
		gbl_panel.rowHeights = new int[]{14, 20, 20, 23, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblChooseYourAlgorithm = new JLabel("Sort me!");
		GridBagConstraints gbc_lblChooseYourAlgorithm = new GridBagConstraints();
		gbc_lblChooseYourAlgorithm.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblChooseYourAlgorithm.insets = new Insets(0, 0, 5, 5);
		gbc_lblChooseYourAlgorithm.gridx = 1;
		gbc_lblChooseYourAlgorithm.gridy = 0;
		panel.add(lblChooseYourAlgorithm, gbc_lblChooseYourAlgorithm);
		
		JLabel lblSize = new JLabel("Size:");
		GridBagConstraints gbc_lblSize = new GridBagConstraints();
		gbc_lblSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblSize.gridx = 0;
		gbc_lblSize.gridy = 1;
		panel.add(lblSize, gbc_lblSize);
		
		sizeTextField = new JTextField();
		GridBagConstraints gbc_sizeTextField = new GridBagConstraints();
		gbc_sizeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sizeTextField.anchor = GridBagConstraints.NORTH;
		gbc_sizeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_sizeTextField.gridx = 1;
		gbc_sizeTextField.gridy = 1;
		panel.add(sizeTextField, gbc_sizeTextField);
		sizeTextField.setColumns(10);
		
		JCheckBox chckbxAnimate = new JCheckBox("Animate");
		chckbxAnimate.setSelected(true);
		GridBagConstraints gbc_chckbxAnimate = new GridBagConstraints();
		gbc_chckbxAnimate.anchor = GridBagConstraints.WEST;
		gbc_chckbxAnimate.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxAnimate.gridx = 2;
		gbc_chckbxAnimate.gridy = 1;
		panel.add(chckbxAnimate, gbc_chckbxAnimate);
		
		JLabel lblAlgorithm = new JLabel("Algorithm:");
		GridBagConstraints gbc_lblAlgorithm = new GridBagConstraints();
		gbc_lblAlgorithm.anchor = GridBagConstraints.EAST;
		gbc_lblAlgorithm.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlgorithm.gridx = 0;
		gbc_lblAlgorithm.gridy = 2;
		panel.add(lblAlgorithm, gbc_lblAlgorithm);
		
		algorithmComboBox = new JComboBox<String>();
		algorithmComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"SelectionSort", "MergeSort", "QuickSort", "HeapSort",
				"InsertionSort", "BubbleSort", "RadixSort"}));
		algorithmComboBox.setSelectedIndex(0);
		algorithmComboBox.setToolTipText("");
		GridBagConstraints gbc_algorithmComboBox = new GridBagConstraints();
		gbc_algorithmComboBox.anchor = GridBagConstraints.NORTH;
		gbc_algorithmComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_algorithmComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_algorithmComboBox.gridx = 1;
		gbc_algorithmComboBox.gridy = 2;
		panel.add(algorithmComboBox, gbc_algorithmComboBox);
		
		btnNewSet = new JButton("New Set");
		btnNewSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int stf = Integer.parseInt(sizeTextField.getText());
					if (stf <= 0)
						throw new NumberFormatException();
					
					elements = new ArrayList<Integer>(stf);
					for (int i = 1; i <= stf; i++)
						elements.add(i);
					Collections.shuffle(elements);
					
					drawCanvas.setAnimation(0);
					drawCanvas.repaint();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Insert a valid integer.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		timeTextField = new JTextField();
		timeTextField.setText("Time (ms)");
		timeTextField.setEditable(false);
		GridBagConstraints gbc_timeTextField = new GridBagConstraints();
		gbc_timeTextField.insets = new Insets(0, 0, 5, 0);
		gbc_timeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeTextField.gridx = 2;
		gbc_timeTextField.gridy = 2;
		panel.add(timeTextField, gbc_timeTextField);
		timeTextField.setColumns(10);
		GridBagConstraints gbc_btnNewSet = new GridBagConstraints();
		gbc_btnNewSet.anchor = GridBagConstraints.NORTH;
		gbc_btnNewSet.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewSet.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewSet.gridx = 0;
		gbc_btnNewSet.gridy = 3;
		panel.add(btnNewSet, gbc_btnNewSet);
		
		drawCanvas = new DrawCanvas();
		drawCanvas.setBackground(Color.WHITE);
		drawCanvas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frmCinesort.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(drawCanvas, GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(114)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(114, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(drawCanvas, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Sorter sorter = null;
					switch (algorithmComboBox.getSelectedIndex()) {
					case 0:
						sorter = new SelectionSort();
						break;
					case 1:
						sorter = new MergeSort();
						break;
					case 2:
						sorter = new QuickSort();
						break;
					case 3:
						sorter = new HeapSort();
						break;
					case 4:
						sorter = new InsertionSort();
						break;
					case 5:
						sorter = new BubbleSort();
						break;
					case 6:
						sorter = new RadixSort();
						break;
					}
					
					if (elements == null || elements.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Generate a set to be sorted.", "Warning", JOptionPane.WARNING_MESSAGE);
					} else {
						boolean animate = chckbxAnimate.isSelected();
						sorter.generateSteps(animate);
						
						long totalSortingTime = System.currentTimeMillis();
						steps = sorter.sort(elements);
						totalSortingTime = System.currentTimeMillis() - totalSortingTime;
						timeTextField.setText(Long.toString(totalSortingTime) + "ms");

						if(animate) {
							btnNewSet.setEnabled(false);
							btnStart.setEnabled(false);
							drawCanvas.setAnimation(steps.size());
						} else
							drawCanvas.setAnimation(0);
						
						drawCanvas.repaint();
					}
					} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Select a valid algorithm.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 0, 5);
		gbc_btnStart.anchor = GridBagConstraints.NORTH;
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 3;
		panel.add(btnStart, gbc_btnStart);
		
		frmCinesort.getContentPane().setLayout(groupLayout);
	}
	
	private class DrawCanvas extends JPanel implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		private static final int Radius = 4;
		private int frames = 0;
		private int ratio = 1;
		private Timer timer; 
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(frames == 0)
				drawArray(g, elements);
			else {
				drawArray(g, steps.get(steps.size() - frames));
			}
		}
		
		private void drawArray(Graphics g, ArrayList<Integer> arr) {
			if (arr != null && arr.size() > 0) {
				int total = arr.size();
				float xratio = this.getWidth();
				xratio = xratio / total;
				float xinit = xratio / 2;
				float yratio = this.getHeight();
				yratio = yratio / total;
				float yinit = yratio / 2;
				
				for(int i = 0; i < total; i++) {
					int x = Math.round(xinit + i*xratio - Radius);
					int y = Math.round(yinit + (total - arr.get(i))*yratio - Radius);
					g.setColor(Color.LIGHT_GRAY);
					g.fillOval(x, y, Radius, Radius);
					g.setColor(Color.BLACK);
					g.drawOval(x, y, Radius, Radius);
				}
			}
		}
		
		public void setAnimation (int f) {
			this.frames = f;
			if(frames != 0) {
				ratio = f/800;
				ratio = ratio < 1? 1 : ratio;
				timer = new Timer(10, this);
				timer.start();
			}
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frames -= ratio ;
			frames = frames < 0? 0: frames;
			repaint();
			if(frames == 0) {
				timer.stop();
				btnNewSet.setEnabled(true);
				btnStart.setEnabled(true);
			}
		}
	}
}
