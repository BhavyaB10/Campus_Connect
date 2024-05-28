package com.example.campusconnect.ui.notice

class NoticeData {
    var title: String? = null
    var image: String? = null
    var date: String? = null
    var time: String? = null

    constructor() {}
    constructor(title: String?, image: String?, date: String?, time: String?) {
        this.title = title
        this.image = image
        this.date = date
        this.time = time
    }
}