package com.knoldus.registration
import model.User
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {

    println("Welcome to User Registration")

    println("Enter your first name: ")
    val firstName = StdIn.readLine()
    println("Enter your last name: ")
    val lastName = StdIn.readLine()
    println("Please provide emailId: ")
    val email = StdIn.readLine()
    println("Enter your phone number: ")
    val phoneNumber = StdIn.readLine()

    //Create new User
    val user = User(firstName, lastName, email, phoneNumber)

    //Register the user
    val userService = new UserService(user)
    val registered = userService.registerUser(user)

    if (registered) {
      println(s"Registration successful. User details $user")
    }
    else {
      println("Invalid email address or phone number , Registration failed")
      println("Please provide correct details....")

    }

  }

}
