package com.asvin.MrFix1.PdfGen;


import com.asvin.MrFix1.Model.Complaint;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Pdf {
//    public static void main(String[] args) throws FileNotFoundException {
//        generatePdf();
//    }
        public static void generatePdf(List<Complaint> all) throws FileNotFoundException {
        String pdfPath="C:\\pdfgen\\sample.pdf";
        PdfWriter writer = new PdfWriter(pdfPath);
           System.out.println("Entered");
        // Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Adding a new page
        pdfDoc.addNewPage();


        // Creating a Document
        Document document = new Document(pdfDoc);
        document.setHeight(740);
        document.setWidth(560);
        Table table = new Table(new float[]{80,80,190,150});
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);
        table.addHeaderCell(new Cell().add(getCell("Complaint ID", TextAlignment.CENTER)));
        table.addHeaderCell(new Cell().add(getCell("Complainant", TextAlignment.CENTER)));
        table.addHeaderCell(new Cell().add(getCell("Issue", TextAlignment.CENTER)));
        table.addHeaderCell(new Cell().add(getCell("Location", TextAlignment.CENTER)));
//        List<List<String>> dataSet = new ArrayList<List<String>>();
//        ///dataSet.add(new ArrayList<>(Arrays.asList("1","Akilan","mouse","SF-02")));
//        dataSet.add(new ArrayList<>(Arrays.asList("2","Asvin","monitor","HCL lab")));
//        dataSet.add(new ArrayList<>(Arrays.asList("3","Dilli","keyboard","SF-05")));
//        dataSet.add(new ArrayList<>(Arrays.asList("4","Fayaz","Wifi","AI Robo Space")));
        for(Complaint list : all) {
        	System.out.println(list.getComplainant()+" "+list.getComplainant()+" "+list.getIssues()+" " +list.getLocation());
        }
        for(Complaint list : all) {
               String sr="";
                   if(list.getComplainant()!=null) {
                    table.addCell(new Cell().add(getCell((Integer.toString(list.getComplaintId())), TextAlignment.CENTER)));
                    
                    table.addCell(new Cell().add(new Paragraph(list.getComplainant())));
                    table.addCell(new Cell().add(new Paragraph(list.getIssues())));
                    table.addCell(new Cell().add(new Paragraph(list.getLocation())));
                   }
                    
                    
        }
        document.add(table);

        // Closing the document
        document.close();
        System.out.println("PDF Created");
    }
    public static Cell getCell(String text, TextAlignment alignment) {
        Cell cell = new Cell().add(new Paragraph(text));
        cell.setPadding(0);
        cell.setTextAlignment(alignment);
        cell.setBorder(Border.NO_BORDER);
        return cell;
    }
}
