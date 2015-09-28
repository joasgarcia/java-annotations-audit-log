package com.joasgarcia.auditlog

class CustomerController {

    static scaffold = true

    def customerService

    def update() {
        customerService.update(params.long("id"), params)

        flash.message = "Cliente alterado com sucesso"

        redirect(controller: "customer", action: "show", id: params.long("id"))
    }
}
