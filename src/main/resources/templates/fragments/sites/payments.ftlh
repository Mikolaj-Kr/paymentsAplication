<table class="table table-dark">
  <thead>
  <tr>
    <th>Miesiąc</th>
    <th>Płatność</th>
  </tr>
  </thead>
  <tbody>
<#list paymentsList>
  <#items as payment>
    <tr>
      <th scope="row"> ${payment.monthOfPayment} </th>
      <td> ${payment.isRegulated} </td>
    </tr>
  </#items>
</#list>

  </tbody>
</table>