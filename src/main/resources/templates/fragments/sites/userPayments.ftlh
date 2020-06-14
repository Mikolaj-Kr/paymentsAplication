<div class="container-fluid mx-auto d-flex w-100 h-auto flex-column">
    <h2> ${currentUser.name} ${currentUser.surname} </h2>
    <br>
    <form id="sendRemindMail" action="/pay-user-remind-payment" method="post">
        <input type="hidden" name="username" value="${currentUser.username}">
        <button class="btn-sm btn-info" onclick="confirmSendRemindMail()"> Wyślij przypomnienie o płatności</button>
    </form>
    <span id="confirmMessage"></span>
    <form id="addPaymentForUser" action="/pay-user-add-new-payment" method="post">
        <input type="hidden" name="username" value="${currentUser.username}">
        <button class="btn-sm btn-dark">Dodaj następną płatność</button>

    </form>
    <table class="table table-dark">
        <tbody>
        <#list paymentList>
            <#items as payment>
                <tr>
                    <th scope="row"
                        bgcolor="<#if payment.status == "paid" > #006633 <#elseif payment.status == "unpaid"> #CC6666 <#elseif payment.status == "inProgress"> #6699FF </#if>"> ${payment.monthOfPayment} </th>
                    <td> ${payment.status} <#if payment.status == "paid">
                            <form id="changePayment" action="/pay-user-delete-payment" method="post">
                                <input type="hidden" name="paymentId" value="${payment.id}">
                                <input type="hidden" name="username" value="${currentUser.username}">
                                <button class="btn-sm btn-danger"> Zmień na nieopłaconą</button>
                            </form>
                            <form id="deletePayment" action="/pay-user-finish-payment" method="post">
                                <input type="hidden" name="paymentId" value="${payment.id}">
                                <input type="hidden" name="username" value="${currentUser.username}">
                                <button class="btn-sm btn-success"> Zakończ płatność</button>
                            </form>
                        <#else>
                            <form id="changePaymentToPaid" action="/pay-user-add-payment" method="post">
                                <input type="hidden" name="paymentId" value="${payment.id}">
                                <input type="hidden" name="username" value="${currentUser.username}">
                                <button class="btn-sm btn-dark"> Opłacono</button>
                            </form>
                            <form id="changePaymentToUnpaid" action="/pay-user-delete-payment" method="post">
                                <input type="hidden" name="paymentId" value="${payment.id}">
                                <input type="hidden" name="username" value="${currentUser.username}">
                                <button class="btn-sm btn-danger"> Nieopłacono</button>
                            </form>
                        </#if>
                    </td>
                </tr>
            </#items>
        </#list>
        </tbody>
        <thead>
        <tr>
            <th>Data</th>
            <th>Płatność</th>
        </tr>
        </thead>
    </table>
</div>
