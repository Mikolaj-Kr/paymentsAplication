function checkPass(){
  const password = document.getElementById('password')
  const password2 = document.getElementById('password2')
  const message = document.getElementById('confirmMessage')

  if(password.value === password2.value){
    message.style.color = "green";
    message.innerText = "Hasło prawidłowe"

  } else {
    message.style.color = "red";
    message.innerText = "Hasła różnia się od siebie"
  }




}