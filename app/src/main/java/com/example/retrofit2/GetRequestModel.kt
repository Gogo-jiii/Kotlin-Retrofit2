package com.example.retrofit2

class GetRequestModel(
    private var name: String, private var realName: String, private var team: String, private var firstappearance: String,
    private var createdby: String, private var publisher: String, private var imageurl: String, private var job: String
) {

    override fun toString(): String {
        return "GetRequestModel{" +
                "name='" + name + '\'' +
                ", realName='" + realName + '\'' +
                ", team='" + team + '\'' +
                ", firstappearance='" + firstappearance + '\'' +
                ", createdby='" + createdby + '\'' +
                ", publisher='" + publisher + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", job='" + job + '\'' +
                '}'
    }
}