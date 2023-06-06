import com.knoldus.registration.UserService
import com.knoldus.registration.model.User
import scalafx.application.JFXApp
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.layout._


object GuiApp extends JFXApp {

  // Create the UI components
  private val registerLabel = new Label("Do you want to register?")
  registerLabel.style = "-fx-font-weight: bold; -fx-font-size: 40px;"

  private val registerYesButton = new Button("Yes")
  private val registerNoButton = new Button("No")
  private val statusLabel = new Label()


  // Register Yes button action
  registerYesButton.setOnAction(_ => {
    showRegistrationForm()
  })

  // Register No button action
  registerNoButton.setOnAction(_ => {
    statusLabel.text = "Registration cancelled"
  })

  // Create the UI layout for the registration confirmation page
  private val buttonContainer = new HBox(20, registerYesButton, registerNoButton)
  buttonContainer.setAlignment(Pos.Center) // Align buttons to the center

  private val registerConfirmationForm = new VBox(20,
    registerLabel,
    buttonContainer,
    statusLabel
  )
  registerConfirmationForm.setPadding(Insets(10))
  registerConfirmationForm.setAlignment(Pos.Center) // Align components to the center
  registerConfirmationForm.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #87CEEB, #1E90FF);")

  private val registerConfirmationScene = new Scene(registerConfirmationForm, 900, 800)

  // Create the UI components for the user registration form
  private val firstNameField = new TextField()
  private val lastNameField = new TextField()
  private val emailField = new TextField()
  private val phoneNumberField = new TextField()
  private val registerUserButton = new Button("Register")
  private val registrationStatusLabel = new Label()

  // Create the UI layout for the user registration form
  private val registrationForm = new GridPane()
  registrationForm.setHgap(10)
  registrationForm.setVgap(10)
  registrationForm.setAlignment(Pos.Center)
  registrationForm.setStyle("-fx-background-color: #87CEEB;")

  private val headingStyle = "-fx-font-weight: bold; -fx-font-size: 38px;"

  private val firstNameLabel = new Label("   First Name:")
  firstNameLabel.style = headingStyle
  registrationForm.addRow(0, new Label(""), firstNameLabel, firstNameField)

  private val lastNameLabel = new Label("   Last Name:")
  lastNameLabel.style = headingStyle
  registrationForm.addRow(1, new Label(""), lastNameLabel, lastNameField)

  private val emailLabel = new Label("   Email:")
  emailLabel.style = headingStyle
  registrationForm.addRow(2, new Label(""), emailLabel, emailField)

  private val phoneNumberLabel = new Label("   Phone Number:")
  phoneNumberLabel.style = headingStyle
  registrationForm.addRow(3, new Label(""), phoneNumberLabel, phoneNumberField)

  private val registerUserButtonContainer = new HBox(50, registerUserButton)
  registerUserButtonContainer.setAlignment(Pos.Center) // Align "Register" button to the center

  registrationForm.addRow(4, new Label(""), registerUserButtonContainer)

  registrationForm.addRow(5, new Label(""), registrationStatusLabel)

  private val registrationScene = new Scene(registrationForm, 800, 700)

  // Create the UI layout for the success page
  private val successLabel = new Label("Registration Successful!")
  successLabel.style = "-fx-text-fill: green; -fx-font-size: 48px;"
  private val successPage = new VBox(successLabel)
  successPage.setAlignment(Pos.Center)
  successPage.setStyle("-fx-background-color: #87CEEB;")
  private val successScene = new Scene(successPage, 700, 500)

  // Create the UI layout for the error page
  private val errorLabel = new Label("Registration Failed!")
  errorLabel.style = "-fx-text-fill: red; -fx-font-size: 24px;"
  private val errorMessageLabel = new Label("")
  errorMessageLabel.style = "-fx-text-fill: red; -fx-font-size: 18px;"
  private val errorBox = new VBox(10, errorLabel, errorMessageLabel)
  errorBox.setAlignment(Pos.Center)
  errorBox.setStyle("-fx-background-color: #87CEEB;")
  private val errorScene = new Scene(errorBox, 700, 500)

  private val buttonStyle = "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; -fx-pref-width: 140px; -fx-pref-height: 40px; -fx-font-size: 16px;"
  registerYesButton.style = buttonStyle
  registerNoButton.style = buttonStyle
  registerUserButton.style = buttonStyle

  // Show the user registration form
  private def showRegistrationForm(): Unit = {
    stage.scene = registrationScene
  }

  // Show the success page
  private def showSuccessPage(): Unit = {
    stage.scene = successScene
  }

  // Show the error page
  private def showErrorPage(errorMessage: String): Unit = {
    errorMessageLabel.text = errorMessage
    stage.scene = errorScene
  }

  // Register user button action
  registerUserButton.setOnAction(_ => {
    val firstName = firstNameField.text.value
    val lastName = lastNameField.text.value
    val email = emailField.text.value
    val phoneNumber = phoneNumberField.text.value

    val user = User(firstName, lastName, email, phoneNumber)
    val userService = new UserService(user)
    val result = userService.registerUser(user)

    if (result) {
      registrationStatusLabel.text = "Registration successful"
      registrationStatusLabel.style = "-fx-text-fill: green; -fx-font-size: 30px;"
      showSuccessPage()
      clearFields()
    } else {
      registrationStatusLabel.text = "Registration failed"
      registrationStatusLabel.style = "-fx-text-fill: red; -fx-font-size: 30px;"
      val errorMessage = "An error occurred during registration."
      showErrorPage(errorMessage)
      clearFields()
    }
  })

  // Clear input fields
  private def clearFields(): Unit = {
    firstNameField.text = ""
    lastNameField.text = ""
    emailField.text = ""
    phoneNumberField.text = ""
  }

  // Start the application with the registration confirmation page
  stage = new JFXApp.PrimaryStage {
    title = "User Registration"
    scene = registerConfirmationScene
  }
}
