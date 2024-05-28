package com.example.campusconnect.ui.faculty

class TeacherData {
    var name: String? = null
    var email: String? = null
    var post: String? = null
    var image: String? = null
    private var key: String? = null

    constructor()
    constructor(name: String?, email: String?, post: String?, image: String?, key: String?) {
        this.name = name
        this.email = email
        this.post = post
        this.image = image
        this.key = key
    }

}