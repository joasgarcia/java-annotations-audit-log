package com.joasgarcia.auditlog

class Customer {

    String name

    @Auditable
    String phone

    Date birthDate

    @Auditable
    String address

    static constraints = {
        name nullable: false
        birthDate nullable: false
        address nullable: true, blank: false
        phone nullable: true, maxSize: 11
    }
}
