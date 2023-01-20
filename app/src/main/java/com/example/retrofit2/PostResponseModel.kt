package com.example.retrofit2

class PostResponseModel(private var name: String, private var city: String,
                        private var id: String, private var createdAt: String) {

    override fun toString(): String {
        return "PostResponseModel{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}'
    }
}