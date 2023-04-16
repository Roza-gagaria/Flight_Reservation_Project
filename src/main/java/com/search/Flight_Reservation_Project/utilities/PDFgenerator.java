package com.search.Flight_Reservation_Project.utilities;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import org.springframework.stereotype.Component;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;


import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.search.Flight_Reservation_Project.entity.Reservation;

@Component
public class PDFgenerator {
	
	public void generateItinerary(Reservation reservation,String filePath) {
		Document document = new Document();
	try {
        
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        document.add(generateTable(reservation));
        document.close();
    } catch (FileNotFoundException | DocumentException e) {
        e.printStackTrace();
    }
	
	}

	private PdfPTable generateTable(Reservation reservation) {
		
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepatureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Operating Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDepature().toString());
		
		table.addCell("Departure time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Mobile Number");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
	}
}

	



	 