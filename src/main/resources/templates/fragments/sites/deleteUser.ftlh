<div class="container-fluid mx-auto d-flex w-100 h-auto flex-column">
    <h3>Czy na pewno chcesz usunąć użytkownika?</h3>
    <h3>${userToDelete.name}</h3>
    <h3>${userToDelete.surname}</h3>
    <form id="delete user confirm" action="/pay-user-delete-user-confirm" method="post">
        <input type="hidden" name="username" value="${userToDelete.username}" >
        <button class="btn-sm btn-danger"> Usuń użytkownika </button>
    </form>
    <a href="/pay-users"> Powrót do listy użytkowników </a>
</div>