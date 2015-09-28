package com.joasgarcia.auditlog

class CustomerHistory {

    Customer customer

    String fieldName

    String oldValue

    String newValue

    static constraints = {
        customer nullable: false
        fieldName nullable: false
        oldValue nullable: false
        newValue nullable: false
    }
}
