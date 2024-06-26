package restAssured;

import ait.phonebook.dto.ContactDto;

public class RegistrationRestAssuredTests {
    ContactDto registrationBody = ContactDto.builder()
            .id(null)
            .name("nameUser")
            .lastName("lastNameUser")
            .phone("1234567890")
            .email("newUser@example.com")
            .description("New User registration")
            .build();
   // @Test
 //   void test1() {
   //     String url = "https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword";


}
