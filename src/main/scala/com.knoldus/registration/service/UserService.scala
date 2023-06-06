package com.knoldus.registration
import com.knoldus.registration.model.User

class UserService(user: User) {

def registerUser(user: User): Boolean = {
  UsersTable.createUserTable()
  val emailValid = UsersTable.validateEmail(user.email)
  val phoneNumberValid = UsersTable.validatePhoneNUmber(user.phoneNumber)

  if (emailValid && phoneNumberValid) {
    UsersTable.insertUser(user)
    true
  } else {
    println("Invalid email address or phone number")
    false
  }
}
}
