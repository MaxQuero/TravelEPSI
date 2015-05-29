package travelepsi.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "users", catalog = "TravelEPSI")
public class UserEntity implements Serializable {

    private int id;
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String mail;
    private String phone;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "phone")
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String telephoneNumber) {
        this.phone = telephoneNumber;
    }

    public UserEntity merge(UserEntity o) {
        if (o.login != null && !this.login.equals(o.login)) this.login = o.login;
        if (o.password != null && !this.password.equals(o.password)) this.password = o.password;
        if (o.firstname != null && !this.firstname.equals(o.firstname)) this.firstname = o.firstname;
        if (o.lastname != null && !this.lastname.equals(o.lastname)) this.lastname = o.lastname;
        if (o.birthday != null && !this.birthday.equals(o.birthday)) this.birthday = o.birthday;
        if (o.mail != null && !this.mail.equals(o.mail)) this.mail = o.mail;
        if (o.phone != null && !this.phone.equals(o.phone)) this.phone = o.phone;

        return this;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null)
            return false;

        return true;
    }

}
