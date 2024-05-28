package com.example.campusconnect.ui.ebook;

public class EbookData {
    private String name;
    private String pdfUrl;

    // Default constructor
    public EbookData() {
    }

    // Parameterized constructor
    public EbookData(String name, String pdfUrl) {
        this.name = name;
        this.pdfUrl = pdfUrl;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for pdfUrl
    public String getPdfUrl() {
        return pdfUrl;
    }

    // Setter for pdfUrl
    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
