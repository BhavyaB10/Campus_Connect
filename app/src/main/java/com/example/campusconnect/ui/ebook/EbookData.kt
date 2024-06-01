package com.example.campusconnect.ui.ebook

class EbookData {
    // Setter for name
    // Getter for name
    var pdfTitle: String? = null

    // Setter for pdfUrl
    // Getter for pdfUrl
    var pdfUrl: String? = null

    // Default constructor
    constructor() {}

    // Parameterized constructor
    constructor(name: String?, pdfUrl: String?) {
        this.pdfTitle = name
        this.pdfUrl = pdfUrl
    }


}