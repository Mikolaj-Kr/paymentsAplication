<div class="container-fluid mx-auto d-flex w-100 h-auto flex-column">
    <table class="table table-dark">
        <thead>
        <tr>
            <th>Użytkownik</th>
            <th>E-mail</th>
            <th>Właściwości</th>
        </tr>
        </thead>
        <tbody>
        <#list usersList>
            <#items as user>
                <tr>
                    <th scope="row"> ${user.name} ${user.surname}  </th>
                    <td> ${user.username} </td>
                    <td>
                        <a href="/pay-users-payments?username=${user.username}"> <button class="btn-dark btn-sm"> Zobacz Płatności </button> </a>
                        <button class="btn-danger btn-sm"> Usuń użytkownika </button>
                    </td>
                </tr>
            </#items>
        </#list>

        </tbody>
    </table>
</div>