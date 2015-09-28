package com.joasgarcia.auditlog

class Customer {

    String name

    @Auditable
    String phone

    Date birthDate

    @Auditable
    String address

    static constraints = {
    }
}
