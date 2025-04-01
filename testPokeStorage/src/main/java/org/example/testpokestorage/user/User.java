package org.example.testpokestorage.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    //db constraints

    @Id
    private String id;
    private String username;
    private String email;
    private String password;

    //public String getUsername() { return username; }
    //public void setUsername(String username) { this.username = username; }
    //public String getEmail() { return email; }
    //public void setEmail(String email) { this.email = email; }
    //public String getPassword() { return password; }
    //public void setPassword(String password) { this.password = password; }
}
