package edu.psgv.sweng861;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.MaskFormatter;

public class FlightAppUi {

	private JFrame applicationFrame;
	private JPanel flightSearchPanel;
	private JPanel flightDisplayPanel;
	private JPanel errorPanel;
	
	public FlightAppUi() {
		applicationFrame = new JFrame();
		applicationFrame.setSize(1000, 1000);
		try {
			initializeFlightSearchPanel();
			initializeErrorPanel();
			initializeFlightDisplayPanel();
			applicationFrame.add(flightSearchPanel);
		} catch (ParseException e) {
			
		}
		applicationFrame.setVisible(true);
	}
	
	private void findFlightsButtonClicked(String startingAirport, String endingAirport, TravelClass travelClass, int tickets, boolean nonStop) {
		AmadeusClient client = new AmadeusClient();
		displayFlightListPanel(client.getFlights(startingAirport, endingAirport, "2023-11-01", travelClass, tickets, nonStop));
	}
	
	private void displayflightSearchPanel() {
		flightSearchPanel.setVisible(true);
		errorPanel.setVisible(false);
		flightDisplayPanel.setVisible(false);
	}
	
	private void displayFlightListPanel(AmadeusFlightOffersResponse flightOffersResponse) {

		if(flightOffersResponse == null) {
			displayErrorPanel("Error Retriving Flight Information");
		} else {
			applicationFrame.remove(flightDisplayPanel);
			flightDisplayPanel = new JPanel();
			flightDisplayPanel.setLayout(new BoxLayout(flightDisplayPanel, BoxLayout.Y_AXIS));
			JLabel flightDisplayPanelLabel = new JLabel("Flights Found");
			flightDisplayPanel.add(flightDisplayPanelLabel);
			JPanel scrollingPanel = new JPanel();
			scrollingPanel.setLayout(new BoxLayout(scrollingPanel, BoxLayout.Y_AXIS));
			JScrollPane scrollPane = new JScrollPane(scrollingPanel);
			for(AmadeusFlightOffer flightOffer: flightOffersResponse.getData()) {
				scrollingPanel.add(formatFlightInfoButton(flightOffer));
			}
			flightDisplayPanel.add(scrollPane);
			JButton newSearchButton = new JButton("New Search");
			newSearchButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	displayflightSearchPanel();
		          }
		       });
			flightDisplayPanel.add(newSearchButton);
			applicationFrame.add(flightDisplayPanel);
			errorPanel.setVisible(false);
			flightSearchPanel.setVisible(false);
			flightDisplayPanel.setVisible(true);
			System.out.println("Displaying FlightListPanel");
		}
	}
	
	private JButton formatFlightInfoButton(AmadeusFlightOffer flightOffer) {
		JButton flightButton = new JButton(flightOffer.toString());
		return flightButton;
	}
	
	private void displayErrorPanel(String error) {
		applicationFrame.remove(errorPanel);
		JLabel errorLabel = new JLabel(error);
		errorPanel = new JPanel();
		errorPanel.add(errorLabel);
		applicationFrame.add(errorPanel);
		flightSearchPanel.setVisible(false);
		flightDisplayPanel.setVisible(false);
		errorPanel.setVisible(true);
	}
	
	private void initializeFlightSearchPanel() throws ParseException {
		flightSearchPanel = new JPanel();
		flightSearchPanel.setLayout(new BoxLayout(flightSearchPanel, BoxLayout.Y_AXIS));
		JLabel flightSearchPanelLabel = new JLabel("Find Flights");
		flightSearchPanel.add(flightSearchPanelLabel);
		JPanel dataEntryPanel = new JPanel();
		dataEntryPanel.setLayout(new BoxLayout(dataEntryPanel, BoxLayout.X_AXIS));
		JLabel startingIataCodeLabel = new JLabel("Starting Airport IATA Code");
		dataEntryPanel.add(startingIataCodeLabel);
		final JFormattedTextField startingIataCodeField = new JFormattedTextField(new MaskFormatter("UUU"));
		startingIataCodeField.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(startingIataCodeField);
		JLabel endingIataCodeLabel = new JLabel("Ending Airport IATA Code");
		dataEntryPanel.add(endingIataCodeLabel);
		final JFormattedTextField endingIataCodeField = new JFormattedTextField(new MaskFormatter("UUU"));
		endingIataCodeField.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(endingIataCodeField);
		JLabel travelClassLabel = new JLabel("Class");
		dataEntryPanel.add(travelClassLabel);
		JComboBox<TravelClass> travelClassComboBox = new JComboBox<TravelClass>();
		travelClassComboBox.setModel(new DefaultComboBoxModel<TravelClass>(TravelClass.values()));
		travelClassComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(travelClassComboBox);
		JLabel ticketsLabel = new JLabel("Tickets");
		dataEntryPanel.add(ticketsLabel);
		JComboBox<Integer> ticketsComboBox = new JComboBox<Integer>();
		Integer[] ticketArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}; 
		ticketsComboBox.setModel(new DefaultComboBoxModel<Integer>(ticketArray));
		ticketsComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(ticketsComboBox);
		JLabel nonStopLabel = new JLabel("Nonstop Flight");
		dataEntryPanel.add(nonStopLabel);
		JCheckBox nonStopCheckBox = new JCheckBox();
		dataEntryPanel.add(nonStopCheckBox);
		
		flightSearchPanel.add(dataEntryPanel);
		
		JButton findFlightsButton = new JButton("Find Flights");
		findFlightsButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 findFlightsButtonClicked(startingIataCodeField.getText(), endingIataCodeField.getText(), (TravelClass)travelClassComboBox.getSelectedItem(), (Integer)ticketsComboBox.getSelectedItem(), nonStopCheckBox.isSelected());
	          }
	       });
		flightSearchPanel.add(findFlightsButton);
	}
	
	private void initializeErrorPanel() {
		errorPanel = new JPanel();
	}
	
	private void initializeFlightDisplayPanel() {
		flightDisplayPanel = new JPanel();
	}
}
