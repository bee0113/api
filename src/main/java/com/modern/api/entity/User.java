package com.modern.api.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user", schema = "test")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(name = "account_pw", nullable = false)
    private String accountPw;

    @Column(name = "account_name", length = 8)
    private String accountName;


    @Builder
    public User(String accountId, String accountPw, String accountName) {
        this.accountId = accountId;
        this.accountPw = accountPw;
        this.accountName = accountName;
    }

}
