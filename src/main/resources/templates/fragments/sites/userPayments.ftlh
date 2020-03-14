<div class="container-fluid mx-auto d-flex w-100 h-auto flex-column">
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Data</th>
            <th>Płatność</th>
        </tr>
        </thead>
        <tbody>
        <#list paymentList>
            <#items as payment>
                <tr>
                    <th scope="row"> ${payment.dateOfPayment} </th>
                    <td> ${payment.regulated?c} </td>
                </tr>
            </#items>
        </#list>

        </tbody>
    </table>
</div>