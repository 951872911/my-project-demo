package com.ping.security.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@TableName("hr")
public class Hr implements UserDetails, Serializable {

    @Setter
    @Getter
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Setter
    @Getter
    private String phone;

    @Setter
    @Getter
    private String telephone;

    @Setter
    @Getter
    private String address;

    @Setter
    @Getter
    private boolean enabled;

    @Setter
    private String username;

    @Setter
    private String password;

    @Setter
    @Getter
    private String remark;

    @Setter
    @Getter
    @TableField(exist = false)
    private List<Role> roles;

    @Setter
    @Getter
    private String userface;


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


}
