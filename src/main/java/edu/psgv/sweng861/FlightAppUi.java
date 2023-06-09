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
	
	private void findFlightsButtonClicked(String startingAirport, String endingAirport, String date, TravelClass travelClass, int tickets, boolean nonStop) {
		AmadeusClient client = new AmadeusClient();
		displayFlightListPanel(client.getFlights(startingAirport, endingAirport, date, travelClass, tickets, nonStop));
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
		errorPanel = new JPanel();
		errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.Y_AXIS));
		JLabel errorPanelLabel = new JLabel("AN ERROR HAS OCCURED");
		errorPanel.add(errorPanelLabel);
		JLabel errorLabel = new JLabel(error);
		errorPanel.add(errorLabel);
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	displayflightSearchPanel();
	          }
	       });
		errorPanel.add(backButton);
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
		JLabel flightDateLabel = new JLabel("Date");
		dataEntryPanel.add(flightDateLabel);
		JComboBox<String> monthComboBox = new JComboBox<String>();
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		monthComboBox.setModel(new DefaultComboBoxModel<String>(months));
		monthComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(monthComboBox);
		JComboBox<String> dayComboBox = new JComboBox<String>();
		String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		dayComboBox.setModel(new DefaultComboBoxModel<String>(days));
		dayComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(dayComboBox);
		JComboBox<String> yearComboBox = new JComboBox<String>();
		String[] years = {"2023", "2024", "2025"};
		yearComboBox.setModel(new DefaultComboBoxModel<String>(years));
		yearComboBox.setMaximumSize(new Dimension(200,30));
		dataEntryPanel.add(yearComboBox);
		
		flightSearchPanel.add(dataEntryPanel);
		
		JButton findFlightsButton = new JButton("Find Flights");
		findFlightsButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 try {
					findFlightsButtonClicked(startingIataCodeField.getText(), endingIataCodeField.getText(), createDateString((String)monthComboBox.getSelectedItem(), (String)dayComboBox.getSelectedItem(), (String)yearComboBox.getSelectedItem()), (TravelClass)travelClassComboBox.getSelectedItem(), (Integer)ticketsComboBox.getSelectedItem(), nonStopCheckBox.isSelected());
				} catch (Exception exception) {
					displayErrorPanel(exception.getMessage());
				}
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
	
	private String createDateString(String month, String day, String year) throws Exception {
		String monthNumber;
		switch(month) {
			case "January":
				monthNumber="01";
				break;
			case "February":
				if(year.equals("2024")) {
					if(day.equals("30") || day.equals("31")) {
						throw new Exception("Please Select a Valid Date");
					}
				} else{
					if(day.equals("29") || day.equals("30") || day.equals("31")) {
						throw new Exception("Please Select a Valid Date");
					}
				}
				monthNumber = "02";
				break;
			case "March":
				monthNumber="03";
				break;
			case "April":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="04";
				break;
			case "May":
				monthNumber="05";
				break;
			case "June":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="06";
				break;
			case "July":
				monthNumber="07";
				break;
			case "August":
				monthNumber="08";
				break;
			case "September":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="09";
				break;
			case "October":
				monthNumber="10";
				break;
			case "November":
				if(day.equals("31")) {
					throw new Exception("Please Select a Valid Date");
				}
				monthNumber="11";
				break;
			default:
				monthNumber="12";
				break;
		}
		
		System.out.println(year + "-" + monthNumber + "-" + day);
		return year + "-" + monthNumber + "-" + day;
	}
}
